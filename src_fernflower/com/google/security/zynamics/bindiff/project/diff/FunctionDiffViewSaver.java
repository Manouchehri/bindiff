package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class FunctionDiffViewSaver extends CEndlessHelperThread {
   private final ViewTabPanelFunctions controller;
   private final Window parent;
   private final File primaryExportFileTarget;
   private final File secondaryExportFileTarget;
   private final File binDiffFileTarget;
   private final boolean overridePrimaryExport;
   private final boolean overrideSecondaryExport;
   private boolean cleanupPrimaryExportFile = false;
   private boolean cleanupSecondaryExportFile = false;
   private boolean cleanupBinDiffFile = false;
   private final Diff diffToSave;
   private Diff savedDiff;
   private boolean addSavedDiffToWorkspace = false;

   public FunctionDiffViewSaver(ViewTabPanelFunctions var1, File var2, File var3, File var4, boolean var5, boolean var6) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.parent = var1.getMainWindow();
      this.diffToSave = var1.getGraphs().getDiff();
      this.primaryExportFileTarget = (File)Preconditions.checkNotNull(var2);
      this.secondaryExportFileTarget = (File)Preconditions.checkNotNull(var3);
      this.binDiffFileTarget = (File)Preconditions.checkNotNull(var4);
      this.overridePrimaryExport = var5;
      this.overrideSecondaryExport = var6;
   }

   private void cleanUp() {
      String var1 = "";
      if(this.primaryExportFileTarget != null && this.primaryExportFileTarget.exists() && this.cleanupPrimaryExportFile && !this.primaryExportFileTarget.delete()) {
         var1 = String.format("Failed to delete \'%\'.\n", new Object[]{this.primaryExportFileTarget.getPath()});
      }

      if(this.secondaryExportFileTarget != null && this.secondaryExportFileTarget.exists() && this.cleanupSecondaryExportFile && !this.secondaryExportFileTarget.delete()) {
         var1 = String.format("Failed to delete \'%\'.\n", new Object[]{this.secondaryExportFileTarget.getPath()});
      }

      if(this.binDiffFileTarget != null && this.binDiffFileTarget.exists() && this.cleanupBinDiffFile && !this.binDiffFileTarget.delete()) {
         var1 = String.format("Failed to delete \'%s\'.\n", new Object[]{this.binDiffFileTarget.getPath()});
      }

      File var2 = this.binDiffFileTarget.getParentFile();
      if(var2.list().length == 0 && !var2.delete()) {
         var1 = String.format("Failed to delete \'%s\'.\n", new Object[]{var2.getPath()});
      }

      if(!"".equals(var1)) {
         var1 = var1.substring(0, var1.length() - 2);
         Logger.logWarning(var1, new Object[0]);
         MessageBox.showWarning(this.parent, var1);
      }

   }

   private void cloneDiffObjectOnSaveAs() {
      FlowGraphViewData var1 = (FlowGraphViewData)this.diffToSave.getViewManager().getFlowgraphViewsData().get(0);
      if(this.binDiffFileTarget.exists() && !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase()) && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
         this.diffToSave.willOverwriteDiff(this.binDiffFileTarget.getPath());
         this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, var1);
      } else if(!this.binDiffFileTarget.exists() && this.diffToSave.getMatchesDatabase().getParent().equals(this.binDiffFileTarget.getParent())) {
         this.savedDiff = this.diffToSave.cloneDiffObjectOnSaveAs(this.binDiffFileTarget, this.primaryExportFileTarget, this.secondaryExportFileTarget, var1);
      } else {
         this.addSavedDiffToWorkspace = !this.binDiffFileTarget.equals(this.diffToSave.getMatchesDatabase());
         this.savedDiff = this.diffToSave;
      }

      this.addSavedDiffToWorkspace = this.addSavedDiffToWorkspace || this.savedDiff != this.diffToSave;
   }

   private boolean copyBinDiffFile() {
      File var1 = this.diffToSave.getMatchesDatabase();
      if(var1.getPath().equals(this.binDiffFileTarget.getPath())) {
         this.savedDiff = this.diffToSave;
         return true;
      } else {
         this.cleanupBinDiffFile = !this.binDiffFileTarget.exists();
         FileInputStream var2 = null;
         FileOutputStream var3 = null;

         boolean var5;
         try {
            this.cloneDiffObjectOnSaveAs();
            var2 = new FileInputStream(var1);
            var3 = new FileOutputStream(this.binDiffFileTarget);
            ByteStreams.copy((InputStream)var2, (OutputStream)var3);
            return true;
         } catch (FileNotFoundException var22) {
            Logger.logException(var22, "Save function diff view failed. Couldn\'t copy BinDiff file into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn\'t copy BinDiff file into workspace.");
            var5 = false;
            return var5;
         } catch (IOException var23) {
            Logger.logException(var23, "Save function diff view failed. Couldn\'t copy BinExport files into workspace.");
            MessageBox.showError(this.parent, "Save function diff view failed. Couldn\'t copy BinExport files into workspace.");
            var5 = false;
         } finally {
            if(var2 != null) {
               try {
                  var2.close();
               } catch (IOException var21) {
                  Logger.logWarning((Exception)var21, (String)"Couldn\'t close file input stream.");
               }
            }

            if(var3 != null) {
               try {
                  var3.close();
               } catch (IOException var20) {
                  Logger.logWarning((Exception)var20, (String)"Couldn\'t close file output stream.");
               }
            }

         }

         return var5;
      }
   }

   private boolean copyExportFile(ESide var1) {
      File var2 = this.diffToSave.getExportFile(var1);
      File var3 = var1 == ESide.PRIMARY?this.primaryExportFileTarget:this.secondaryExportFileTarget;
      if(!var3.exists() || (var1 != ESide.PRIMARY || this.overridePrimaryExport) && (var1 != ESide.SECONDARY || this.overrideSecondaryExport)) {
         if(var2.getPath().equals(var3.getPath())) {
            return true;
         } else {
            if(var1 == ESide.PRIMARY) {
               this.cleanupPrimaryExportFile = !var3.exists();
            } else {
               this.cleanupSecondaryExportFile = !var3.exists();
            }

            try {
               FileInputStream var4 = null;
               FileOutputStream var5 = null;

               try {
                  var4 = new FileInputStream(var2);
                  var5 = new FileOutputStream(var3);
                  ByteStreams.copy((InputStream)var4, (OutputStream)var5);
               } finally {
                  if(var4 != null) {
                     try {
                        var4.close();
                     } catch (IOException var17) {
                        Logger.logWarning((Exception)var17, (String)"Couldn\'t close file input stream.");
                     }
                  }

                  if(var5 != null) {
                     try {
                        var5.close();
                     } catch (IOException var16) {
                        Logger.logWarning((Exception)var16, (String)"Couldn\'t close file output stream.");
                     }
                  }

               }

               return true;
            } catch (FileNotFoundException var19) {
               Logger.logException(var19, "Save function diff view failed. Couldn\'t copy BinExport files.");
               MessageBox.showError(this.parent, "Save function diff view failed. Couldn\'t copy BinExport files.");
               return false;
            } catch (IOException var20) {
               Logger.logException(var20, "Save function diff view failed. Couldn\'t copy BinExport files.");
               MessageBox.showError(this.parent, "Save function diff view failed. Couldn\'t copy BinExport files.");
               return false;
            }
         }
      } else {
         return true;
      }
   }

   private void saveView() {
      this.controller.writeComments();
      this.controller.writeFlowgraphMatches();
   }

   private boolean updateDiff() {
      try {
         this.savedDiff.setMatchesDatabase(this.binDiffFileTarget);
         this.savedDiff.setExportFile(this.primaryExportFileTarget, ESide.PRIMARY);
         this.savedDiff.setExportFile(this.secondaryExportFileTarget, ESide.SECONDARY);
         return true;
      } catch (UnsupportedOperationException var2) {
         Logger.logException(var2, "Save function diff view failed. Couldn\'t update diff object.");
         MessageBox.showError(this.parent, "Save function diff view failed. Couldn\'t update diff object.");
         return false;
      }
   }

   private boolean updateMatchesDatabase() {
      // $FF: Couldn't be decompiled
   }

   private void updateWorkspace() {
      if(this.addSavedDiffToWorkspace) {
         this.controller.getWorkspace().addDiff(this.savedDiff);
      }

   }

   protected void runExpensiveCommand() {
      this.setDescription("Copying primary BinExport file...");
      if(!this.copyExportFile(ESide.PRIMARY)) {
         this.cleanUp();
      } else {
         this.setDescription("Copying secondary BinExport file...");
         if(!this.copyExportFile(ESide.SECONDARY)) {
            this.cleanUp();
         } else {
            this.setDescription("Copying BinDiff file...");
            if(!this.copyBinDiffFile()) {
               this.cleanUp();
            } else {
               this.setDescription("Updating BinDiff database...");
               if(!this.updateMatchesDatabase()) {
                  this.cleanUp();
               } else {
                  this.setDescription("Updating Diff...");
                  if(!this.updateDiff()) {
                     this.cleanUp();
                  } else {
                     this.setDescription("Saving comments and changed matches...");
                     this.saveView();
                     this.setDescription("Updating Workspace...");
                     this.updateWorkspace();
                     this.setDescription("Completed successfully.");

                     try {
                        Thread.sleep(300L);
                     } catch (InterruptedException var2) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
