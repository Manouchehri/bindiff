package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.processes.DiffProcess;
import com.google.security.zynamics.bindiff.processes.ExportProcess;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.bindiff.utils.ExternalAppUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryDiffImplementation extends CEndlessHelperThread {
   private final List diffingErrorMessages = new ArrayList();
   private final List openingDiffErrorMessages = new ArrayList();
   private final MainWindow parentWindow;
   private final Workspace workspace;
   private final String primarySourcePath;
   private final String secondarySourcePath;
   private final List idbPairs;

   public DirectoryDiffImplementation(MainWindow var1, Workspace var2, String var3, String var4, List var5) {
      this.parentWindow = (MainWindow)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
      this.primarySourcePath = (String)Preconditions.checkNotNull(var3);
      this.secondarySourcePath = (String)Preconditions.checkNotNull(var4);
      this.idbPairs = (List)Preconditions.checkNotNull(var5);
   }

   private String createUniqueExportFileName(File var1, File var2, ESide var3) {
      String var4 = var1.getName();
      var4 = CFileUtils.removeFileExtension(var4);
      String var5 = var2.getName();
      var5 = CFileUtils.removeFileExtension(var5);
      if(var4.equals(var5)) {
         var4 = String.valueOf(var4).concat("_primary");
         var5 = String.valueOf(var5).concat("_secondary");
      }

      var4 = CFileUtils.forceFilenameEndsWithExtension(var4, "BinExport");
      var5 = CFileUtils.forceFilenameEndsWithExtension(var5, "BinExport");
      return var3 == ESide.PRIMARY?var4:var5;
   }

   private void deleteDirectory(MainWindow var1, File var2) {
      try {
         CFileUtils.deleteDirectory(var2);
      } catch (IOException var4) {
         Logger.logException(var4, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{var2.getPath()}));
         CMessageBox.showWarning(var1, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{var2.getPath()}));
      }

   }

   private List directoryDiff() {
      ArrayList var1 = new ArrayList();
      String var2 = ExternalAppUtils.getCommandLineDiffer();
      String var3;
      if(!(new File(var2)).exists()) {
         var3 = String.format("Can\'t start directory diff. Couldn\'t find engine at \'%s\'", new Object[]{var2});
         Logger.logSevere(var3, new Object[0]);
         CMessageBox.showError(this.parentWindow, var3);
         return var1;
      } else {
         var3 = this.primarySourcePath;
         String var4 = this.secondarySourcePath;
         Logger.logInfo((new StringBuilder(29 + String.valueOf(var3).length() + String.valueOf(var4).length())).append("Start Directory Diff \'").append(var3).append("\' vs \'").append(var4).append("\'").toString(), new Object[0]);
         var3 = this.workspace.getWorkspaceDir().getPath();
         List var22 = this.idbPairs;
         Iterator var5 = var22.iterator();

         while(true) {
            while(true) {
               while(var5.hasNext()) {
                  DiffPairTableData var6 = (DiffPairTableData)var5.next();
                  String var7 = String.format("%s%s%s", new Object[]{var3, File.separator, var6.getDestinationDirectory()});
                  String var8 = String.format("%s%s%s%s%s", new Object[]{this.primarySourcePath, File.separator, var6.getIDBLocation(), File.separator, var6.getIDBName()});
                  String var9 = String.format("%s%s%s%s%s", new Object[]{this.secondarySourcePath, File.separator, var6.getIDBLocation(), File.separator, var6.getIDBName()});
                  this.setDescription(String.format("%s vs %s", new Object[]{var6.getIDBName(), var6.getIDBName()}));
                  File var10 = new File(var8);
                  File var11 = new File(var9);
                  String var12 = this.createUniqueExportFileName(var10, var11, ESide.PRIMARY);
                  String var13 = this.createUniqueExportFileName(var10, var11, ESide.SECONDARY);
                  File var14 = new File(var7);
                  String var15;
                  if(!var14.exists()) {
                     var14.mkdir();
                     if(var14.exists()) {
                        String var16;
                        File var25;
                        try {
                           Logger.logInfo((new StringBuilder(39 + String.valueOf(var8).length() + String.valueOf(var7).length())).append(" - Start exporting primary IDB \'").append(var8).append("\' to \'").append(var7).append("\'").toString(), new Object[0]);
                           var25 = ExternalAppUtils.getIdaExe(var10);
                           if(var25 == null || !var25.canExecute()) {
                              var16 = "Can\'t start disassembler. Please set correct path in the main settings first.";
                              Logger.logSevere("Can\'t start disassembler. Please set correct path in the main settings first.", new Object[0]);
                              CMessageBox.showError(this.parentWindow, "Can\'t start disassembler. Please set correct path in the main settings first.");
                              this.deleteDirectory(this.parentWindow, var14);
                              return var1;
                           }

                           ExportProcess.startExportProcess(var25, var14, var10, var12);
                           Logger.logInfo((new StringBuilder(56 + String.valueOf(var8).length() + String.valueOf(var7).length())).append(" - Finished exporting primary IDB \'").append(var8).append("\' to \'").append(var7).append("\' successfully.").toString(), new Object[0]);
                        } catch (BinExportException var21) {
                           Logger.logInfo(" - Exporting primary \'%s\' to \'%s\' failed. Reason: %s", new Object[]{var8, var7, var21.getMessage()});
                           var16 = String.format("Exporting primary \'%s\' failed. Reason: %s", new Object[]{var8, var21.getMessage()});
                           this.diffingErrorMessages.add(var16);
                           this.deleteDirectory(this.parentWindow, var14);
                           continue;
                        }

                        try {
                           Logger.logInfo((new StringBuilder(41 + String.valueOf(var9).length() + String.valueOf(var7).length())).append(" - Start exporting secondary IDB \'").append(var9).append("\' to \'").append(var7).append("\'").toString(), new Object[0]);
                           var25 = ExternalAppUtils.getIdaExe(var11);
                           if(var25 == null || !var25.canExecute()) {
                              var16 = "Can\'t start disassembler. Please set correct path in the main settings first.";
                              Logger.logSevere("Can\'t start disassembler. Please set correct path in the main settings first.", new Object[0]);
                              CMessageBox.showError(this.parentWindow, "Can\'t start disassembler. Please set correct path in the main settings first.");
                              return var1;
                           }

                           ExportProcess.startExportProcess(var25, var14, var11, var13);
                           Logger.logInfo((new StringBuilder(58 + String.valueOf(var9).length() + String.valueOf(var7).length())).append(" - Finished exporting secondary IDB \'").append(var9).append("\' to \'").append(var7).append("\' successfully.").toString(), new Object[0]);
                        } catch (BinExportException var20) {
                           Logger.logInfo(" - Exporting secondary \'%s\' to \'%s\' failed. Reason: %s", new Object[]{var9, var7, var20.getMessage()});
                           var16 = String.format("Exporting secondary \'%s\' failed. Reason: %s", new Object[]{var9, var20.getMessage()});
                           this.diffingErrorMessages.add(var16);
                           this.deleteDirectory(this.parentWindow, var14);
                           continue;
                        }

                        try {
                           var15 = ExportProcess.getExportedFileName(var12, var14);
                           var16 = ExportProcess.getExportedFileName(var13, var14);
                           String var17 = String.valueOf(var14.getName());
                           Logger.logInfo((new StringBuilder(19 + String.valueOf(var17).length())).append(" - Start Diffing \'").append(var17).append("\'").toString(), new Object[0]);
                           DiffProcess.startDiffProcess(var2, var15, var16, var14);
                           var17 = DiffProcess.getBinDiffFileName(var15, var16);
                           Logger.logInfo(" - Diffing \'%s\' done successfully.", new Object[]{var14.getName()});
                           var1.add(var17);
                        } catch (BinExportException var18) {
                           Logger.logInfo(" - Diffing \'%s\' failed. Reason: %s", new Object[]{var14.getName(), var18.getMessage()});
                           var16 = String.format("Diffing \'%s\' failed. Reason: %s", new Object[]{var6.getDestinationDirectory(), var18.getMessage()});
                           this.diffingErrorMessages.add(var16);
                        } catch (DifferException var19) {
                           Logger.logInfo(" - Diffing \'%s\' failed. Reason: %s", new Object[]{var14.getName(), var19.getMessage()});
                           var16 = String.format("Diffing \'%s\' failed. Reason: %s", new Object[]{var6.getDestinationDirectory(), var19.getMessage()});
                           this.diffingErrorMessages.add(var16);
                        }
                     } else {
                        var15 = String.format("\'%s\' failed. Reason: Destination folder cannot be created.", new Object[]{var6.getDestinationDirectory()});
                        this.diffingErrorMessages.add(var15);
                     }
                  } else {
                     var15 = String.format("\'%s\' failed. Reason: Destination folder already exists.", new Object[]{var6.getDestinationDirectory()});
                     this.diffingErrorMessages.add(var15);
                  }
               }

               String var23;
               String var24;
               if(this.diffingErrorMessages.size() == 0) {
                  var23 = this.primarySourcePath;
                  var24 = this.secondarySourcePath;
                  Logger.logInfo((new StringBuilder(46 + String.valueOf(var23).length() + String.valueOf(var24).length())).append("Finished Directory Diff \'").append(var23).append("\' vs \'").append(var24).append("\' successfully.").toString(), new Object[0]);
               } else {
                  var23 = this.primarySourcePath;
                  var24 = this.secondarySourcePath;
                  Logger.logInfo((new StringBuilder(45 + String.valueOf(var23).length() + String.valueOf(var24).length())).append("Finished Directory Diff \'").append(var23).append("\' vs \'").append(var24).append("\' with errors.").toString(), new Object[0]);
               }

               return var1;
            }
         }
      }
   }

   protected void runExpensiveCommand() {
      List var1 = this.directoryDiff();
      if(var1.size() > 0) {
         this.setGeneralDescription("Preloading diffs...");
      }

      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(var3 != null) {
            File var4 = new File(var3);

            try {
               this.setDescription(String.format("Loading \'%s\'", new Object[]{var4.getName()}));
               if(var4.exists()) {
                  DiffMetaData var5 = DiffLoader.preloadDiffMatches(var4);
                  this.workspace.addDiff(var4, var5, false);
               }
            } catch (Exception var7) {
               String var6 = String.format("Could not load \'%s\' into workspace.", new Object[]{var4.getName()});
               this.openingDiffErrorMessages.add(var6);
            }
         }
      }

   }

   public List getDiffingErrorMessages() {
      return this.diffingErrorMessages;
   }

   public List getOpeningDiffErrorMessages() {
      return this.openingDiffErrorMessages;
   }
}
