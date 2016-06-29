package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public final class NewDiffImplementation extends CEndlessHelperThread {
   private final MainWindow parentWindow;
   private final Workspace workspace;
   private File primaryBinExportFile;
   private File secomndaryBinExportFile;
   private final File primaryIDBFile;
   private final File secondaryIDBFile;
   private final File destinationDirectory;
   private String matchedPath;

   public NewDiffImplementation(MainWindow var1, Workspace var2, File var3, File var4, File var5, File var6, File var7) {
      this.parentWindow = (MainWindow)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
      this.destinationDirectory = (File)Preconditions.checkNotNull(var7, "Destination directorycannot be null");
      this.primaryIDBFile = var3;
      this.secondaryIDBFile = var4;
      this.primaryBinExportFile = var5;
      this.secomndaryBinExportFile = var6;
   }

   private String createUniqueExportFileName(ESide var1) {
      String var2 = "";
      if(this.primaryBinExportFile != null) {
         var2 = this.primaryBinExportFile.getName();
      } else if(this.primaryIDBFile != null) {
         var2 = this.primaryIDBFile.getName();
      }

      var2 = CFileUtils.removeFileExtension(var2);
      String var3 = "";
      if(this.secomndaryBinExportFile != null) {
         var3 = this.secomndaryBinExportFile.getName();
      } else if(this.secondaryIDBFile != null) {
         var3 = this.secondaryIDBFile.getName();
      }

      var3 = CFileUtils.removeFileExtension(var3);
      if(var2.equals(var3)) {
         var2 = String.valueOf(var2).concat("_primary");
         var3 = String.valueOf(var3).concat("_secondary");
      }

      var2 = CFileUtils.forceFilenameEndsWithExtension(var2, "BinExport");
      var3 = CFileUtils.forceFilenameEndsWithExtension(var3, "BinExport");
      return var1 == ESide.PRIMARY?var2:var3;
   }

   protected void runExpensiveCommand() {
      this.newDiff();
   }

   public String createNewDiff() {
      try {
         this.setDescription("Creating destination directory...");
         if(!this.destinationDirectory.isDirectory() && !this.destinationDirectory.mkdirs()) {
            Logger.logSevere("Could not create destination directory.", new Object[0]);
            CMessageBox.showError(this.parentWindow, "Could not create destination directory.");
            return null;
         } else {
            String var1 = this.createUniqueExportFileName(ESide.PRIMARY);
            String var2 = this.createUniqueExportFileName(ESide.SECONDARY);
            File var3;
            String var4;
            String var18;
            if(this.primaryIDBFile != null) {
               try {
                  var18 = String.valueOf(this.primaryIDBFile.getPath());
                  var4 = String.valueOf(this.destinationDirectory.getPath());
                  Logger.logInfo((new StringBuilder(32 + String.valueOf(var18).length() + String.valueOf(var4).length())).append("- Exporting primary IDB \'").append(var18).append("\' to \'").append(var4).append("\'").toString(), new Object[0]);
                  this.setDescription("Exporting primary IDB...");
                  var3 = ExternalAppUtils.getIdaExe(this.primaryIDBFile);
                  if(var3 == null || !var3.canExecute()) {
                     var4 = "Can\'t start disassembler. Please set correct path in the main settings first.";
                     Logger.logSevere("Can\'t start disassembler. Please set correct path in the main settings first.", new Object[0]);
                     CMessageBox.showError(this.parentWindow, "Can\'t start disassembler. Please set correct path in the main settings first.");
                     return null;
                  }

                  ExportProcess.startExportProcess(var3, this.destinationDirectory, this.primaryIDBFile, var1);
               } catch (BinExportException var16) {
                  Logger.logException(var16, var16.getMessage());
                  CMessageBox.showError(this.parentWindow, var16.getMessage());

                  try {
                     CFileUtils.deleteDirectory(this.destinationDirectory);
                  } catch (IOException var10) {
                     Logger.logException(var10, String.format("Couldn\'t delete diff folder \'%s\' after diffing failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                     CMessageBox.showWarning(this.parentWindow, String.format("Couldn\'t delete diff folder \'%s\' after diffing failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                  }

                  return null;
               }
            } else if(this.primaryBinExportFile != null) {
               try {
                  var3 = new File(String.format("%s%s%s", new Object[]{this.destinationDirectory.getPath(), File.separator, var1}));
                  if(!var3.exists()) {
                     this.setDescription("Copying primary BinExport binary...");
                     ByteStreams.copy((InputStream)(new FileInputStream(this.primaryBinExportFile)), (OutputStream)(new FileOutputStream(var3)));
                  }

                  this.primaryBinExportFile = var3;
               } catch (IOException var14) {
                  Logger.logException(var14, "New Diff failed. Couldn\'t copy already exported primary binaries into the new diff directory.");
                  CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn\'t copy already exported primary binaries into the new diff directory.");

                  try {
                     CFileUtils.deleteDirectory(this.destinationDirectory);
                  } catch (IOException var9) {
                     Logger.logException(var9, String.format("Couldn\'t delete diff folder \'%s\' after diffing failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                     CMessageBox.showWarning(this.parentWindow, String.format("Couldn\'t delete diff folder \'%s\' after diffing failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                  }

                  return null;
               }
            }

            if(this.secondaryIDBFile != null) {
               try {
                  var18 = String.valueOf(this.secondaryIDBFile.getPath());
                  var4 = String.valueOf(this.destinationDirectory.getPath());
                  Logger.logInfo((new StringBuilder(34 + String.valueOf(var18).length() + String.valueOf(var4).length())).append("- Exporting secondary IDB \'").append(var18).append("\' to \'").append(var4).append("\'").toString(), new Object[0]);
                  this.setDescription("Exporting secondary IDB...");
                  var3 = ExternalAppUtils.getIdaExe(this.secondaryIDBFile);
                  if(var3 == null || !var3.canExecute()) {
                     var4 = "Can\'t start disassembler. Please set correct path in the main settings first.";
                     Logger.logSevere("Can\'t start disassembler. Please set correct path in the main settings first.", new Object[0]);
                     CMessageBox.showError(this.parentWindow, "Can\'t start disassembler. Please set correct path in the main settings first.");
                     return null;
                  }

                  ExportProcess.startExportProcess(var3, this.destinationDirectory, this.secondaryIDBFile, var2);
               } catch (BinExportException var15) {
                  Logger.logException(var15, var15.getMessage());
                  CMessageBox.showError(this.parentWindow, var15.getMessage());

                  try {
                     CFileUtils.deleteDirectory(this.destinationDirectory);
                  } catch (IOException var7) {
                     Logger.logException(var7, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                     CMessageBox.showWarning(this.parentWindow, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                  }

                  return null;
               }
            } else if(this.secomndaryBinExportFile != null) {
               try {
                  var3 = new File(String.format("%s%s%s", new Object[]{this.destinationDirectory.getPath(), File.separator, var2}));
                  if(!var3.exists()) {
                     this.setDescription("Copying primary BinExport binary...");
                     ByteStreams.copy((InputStream)(new FileInputStream(this.secomndaryBinExportFile)), (OutputStream)(new FileOutputStream(var3)));
                  }

                  this.secomndaryBinExportFile = var3;
               } catch (IOException var13) {
                  Logger.logException(var13, "New Diff failed. Couldn\'t copy secondary BinExport binaries into the new diff directory.");
                  CMessageBox.showError(this.parentWindow, "New Diff failed. Couldn\'t copy secondary BinExport binaries into the new diff directory.");

                  try {
                     CFileUtils.deleteDirectory(this.destinationDirectory);
                  } catch (IOException var8) {
                     Logger.logException(var8, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                     CMessageBox.showWarning(this.parentWindow, String.format("Couldn\'t delete diff folder \'%s\' after exporting failed.\nPlease delete this folder manually.", new Object[]{this.destinationDirectory.getPath()}));
                  }

                  return null;
               }
            }

            try {
               var18 = ExternalAppUtils.getCommandLineDiffer();
               var4 = "";
               if(this.primaryIDBFile != null) {
                  var4 = ExportProcess.getExportedFileName(var1, this.destinationDirectory);
               } else {
                  var4 = this.primaryBinExportFile.getPath();
               }

               String var5 = "";
               if(this.secondaryIDBFile != null) {
                  var5 = ExportProcess.getExportedFileName(var2, this.destinationDirectory);
               } else {
                  var5 = this.secomndaryBinExportFile.getPath();
               }

               String var6 = String.valueOf(this.destinationDirectory.getName());
               Logger.logInfo((new StringBuilder(18 + String.valueOf(var6).length())).append("- Start Diffing \'").append(var6).append("\'").toString(), new Object[0]);
               this.setDescription("Diffing...");
               DiffProcess.startDiffProcess(var18, var4, var5, this.destinationDirectory);
               var6 = DiffProcess.getBinDiffFileName(var4, var5);
               Logger.logInfo("- Diffing done successfully.\'", new Object[0]);
               return var6;
            } catch (BinExportException var11) {
               Logger.logException(var11, var11.getMessage());
               CMessageBox.showError(this.parentWindow, var11.getMessage());
            } catch (DifferException var12) {
               Logger.logException(var12, var12.getMessage());
               CMessageBox.showError(this.parentWindow, var12.getMessage());
            }

            return null;
         }
      } catch (Exception var17) {
         Logger.logException(var17, "New Diff failed..");
         CMessageBox.showError(this.parentWindow, "New Diff failed.");
         return null;
      }
   }

   public String getMatchesPath() {
      return this.matchedPath;
   }

   public void newDiff() {
      // $FF: Couldn't be decompiled
   }
}
