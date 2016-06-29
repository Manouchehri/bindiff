package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ProgressDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$InternalCheckboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$InternalDocumentListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceLoader;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;

public class SaveFunctionDiffViewDialog extends BaseDialog {
   private static Color NORMAL_COLOR = (new JFormattedTextField()).getBackground();
   private static Color OVERRIDE_COLOR = new Color(233, 200, 200);
   private static int DLGWIDTH = 650;
   private static int DLGHEIGHT = 190;
   private static final String FUNCTION_DIFF_VIEWS_DIRECTORY_NAME = "Function Diff Views";
   private final JFormattedTextField diffDatabaseFileName = new JFormattedTextField(new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
   private final JFormattedTextField primaryExportFileName = new JFormattedTextField(new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
   private final JFormattedTextField secondaryExportFileName = new JFormattedTextField(new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
   private final JCheckBox diffDatabaseOverwrite = new JCheckBox("Overwrite");
   private final JCheckBox primaryExportOverwrite = new JCheckBox("Overwrite");
   private final JCheckBox secondaryExportOverwrite = new JCheckBox("Overwrite");
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final DocumentListener documentListener = new SaveFunctionDiffViewDialog$InternalDocumentListener(this, (SaveFunctionDiffViewDialog$1)null);
   private final ActionListener checkBoxListener = new SaveFunctionDiffViewDialog$InternalCheckboxListener(this, (SaveFunctionDiffViewDialog$1)null);
   private final ActionListener buttonListener = new SaveFunctionDiffViewDialog$InternalButtonListener(this, (SaveFunctionDiffViewDialog$1)null);
   private boolean okPressed = false;
   private final MainWindow window;
   private final Workspace workspace;
   private final Diff diff;
   private File destinationDir = null;
   private final Map exportFilePathToMd5 = new HashMap();

   public SaveFunctionDiffViewDialog(MainWindow var1, String var2, Workspace var3, Diff var4) {
      super((Window)Preconditions.checkNotNull(var1), var2);
      this.window = var1;
      this.workspace = (Workspace)Preconditions.checkNotNull(var3);
      this.diff = (Diff)Preconditions.checkNotNull(var4);
      this.init();
      this.diffDatabaseOverwrite.setEnabled(false);
      this.primaryExportOverwrite.setEnabled(false);
      this.secondaryExportOverwrite.setEnabled(false);
      this.diffDatabaseFileName.getDocument().addDocumentListener(this.documentListener);
      this.primaryExportFileName.getDocument().addDocumentListener(this.documentListener);
      this.secondaryExportFileName.getDocument().addDocumentListener(this.documentListener);
      this.diffDatabaseOverwrite.addActionListener(this.checkBoxListener);
      this.primaryExportOverwrite.addActionListener(this.checkBoxListener);
      this.secondaryExportOverwrite.addActionListener(this.checkBoxListener);
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
   }

   private JPanel createButtonPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(7, 5, 5, 10));
      JPanel var2 = new JPanel(new GridLayout(1, 2, 5, 5));
      var2.add(this.okButton);
      var2.add(this.cancelButton);
      var1.add(var2, "East");
      return var1;
   }

   private boolean createDestinationDirectory() {
      // $FF: Couldn't be decompiled
   }

   private JPanel createFilenameLinePanel(String var1, JFormattedTextField var2, String var3, JCheckBox var4) {
      JPanel var5 = new JPanel(new BorderLayout());
      JPanel var6 = new JPanel(new BorderLayout());
      JLabel var7 = new JLabel(var1);
      var7.setPreferredSize(new Dimension(150, 25));
      var7.setMaximumSize(new Dimension(150, 25));
      var6.add(var7, "West");
      var2.setPreferredSize(new Dimension(250, 25));
      var6.add(var2, "Center");
      JPanel var8 = new JPanel(new BorderLayout());
      JLabel var9 = new JLabel(var3);
      var9.setPreferredSize(new Dimension(65, 25));
      var9.setMaximumSize(new Dimension(65, 25));
      var8.add(var9, "West");
      var8.add(var4, "Center");
      var6.add(var8, "East");
      var5.add(var6, "North");
      return var5;
   }

   private JPanel createFilenamePanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("")));
      JPanel var2 = new JPanel(new GridLayout(3, 1, 5, 5));
      var2.add(this.createFilenameLinePanel("Diff Name:", this.diffDatabaseFileName, ".BinDiff", this.diffDatabaseOverwrite));
      var2.add(this.createFilenameLinePanel("Primary Export Name:", this.primaryExportFileName, ".BinExport", this.primaryExportOverwrite));
      var2.add(this.createFilenameLinePanel("Secondary Export Name:", this.secondaryExportFileName, ".BinExport", this.secondaryExportOverwrite));
      var1.add(var2, "North");
      return var1;
   }

   private boolean createSingleViewsDirectory() {
      // $FF: Couldn't be decompiled
   }

   private void loadWorkspace() {
      if(!this.workspace.isLoaded()) {
         String var1 = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
         boolean var2 = false;
         int var3;
         if((new File(var1)).exists()) {
            var3 = MessageBox.showYesNoCancelQuestion(this.getParent(), "A workspace has to be loaded to save a function diff view. Load the default workspace?");
            if(var3 == 0) {
               File var4 = new File(var1);
               WorkspaceLoader var5 = new WorkspaceLoader(var4, this.workspace);

               try {
                  ProgressDialog.show((Window)this.getParent(), String.format("Loading Workspace \'%s\'", new Object[]{var4.getName()}), (CEndlessHelperThread)var5);
               } catch (Exception var8) {
                  Logger.logException(var8, String.format("Load default workspace failed. \'%s\'", new Object[]{var4.getPath()}));
                  MessageBox.showError(this.getParent(), String.format("Faild to load the current default workspace.\n\'%s\'", new Object[]{var4.getPath()}));
               }
            } else if(var3 == 1) {
               var2 = true;
            }
         }

         if(var2 || !(new File(var1)).exists()) {
            if(!(new File(var1)).exists()) {
               var3 = MessageBox.showYesNoQuestion(this.window, "A workspace has to be loaded to save a function diff view. Load workspace?");
               if(var3 == 1) {
                  return;
               }
            }

            try {
               TabPanelManager var9 = this.window.getController().getTabPanelManager();
               WorkspaceTabPanel var10 = var9.getWorkspaceTabPanel();
               var10.getController().loadWorkspace();
            } catch (Exception var7) {
               Logger.logException(var7, "Load workspace failed.");
               MessageBox.showError(this.window, "Load workspace failed.");
            }
         }
      }

   }

   private void setDefaultNames() {
      String var1 = ((TabPanel)this.window.getController().getTabPanelManager().getTabbedPane().getSelectedComponent()).getTitle();
      this.setDefaultText(this.diffDatabaseFileName, var1);
      String var2 = this.diff.getExportFile(ESide.PRIMARY).getName();
      var2 = CFileUtils.forceFilenameEndsNotWithExtension(var2, "BinExport");
      this.setDefaultText(this.primaryExportFileName, var2);
      String var3 = this.diff.getExportFile(ESide.SECONDARY).getName();
      var3 = CFileUtils.forceFilenameEndsNotWithExtension(var3, "BinExport");
      this.setDefaultText(this.secondaryExportFileName, var3);
      this.updateOnExistanceChanged();
   }

   private void setDefaultText(JFormattedTextField var1, String var2) {
      String var3 = "";

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         String var5 = var1.getText();
         char var7;
         if(var5.equals("")) {
            var7 = var2.charAt(var4);
            var5 = (new StringBuilder(1 + String.valueOf(var3).length())).append(var3).append(var7).toString();
         } else {
            String var6 = String.valueOf(var5);
            var7 = var2.charAt(var4);
            var5 = (new StringBuilder(1 + String.valueOf(var6).length())).append(var6).append(var7).toString();
         }

         var1.setText(var5);
         if(!var1.getText().equals("")) {
            var3 = var5;
         }
      }

   }

   private void updateOnExistanceChanged() {
      boolean var1 = this.getMatchesDatabaseTargetFile().exists();
      this.diffDatabaseFileName.setBackground(var1?OVERRIDE_COLOR:NORMAL_COLOR);
      this.diffDatabaseOverwrite.setEnabled(var1);
      var1 = this.getExportBinaryTargetFile(ESide.PRIMARY).exists() && !this.validateExportName(ESide.PRIMARY);
      this.primaryExportFileName.setBackground(var1?OVERRIDE_COLOR:NORMAL_COLOR);
      this.primaryExportOverwrite.setEnabled(var1);
      this.primaryExportOverwrite.setSelected(!var1?false:this.primaryExportOverwrite.isSelected());
      var1 = this.getExportBinaryTargetFile(ESide.SECONDARY).exists() && !this.validateExportName(ESide.SECONDARY);
      this.secondaryExportFileName.setBackground(var1?OVERRIDE_COLOR:NORMAL_COLOR);
      this.secondaryExportOverwrite.setEnabled(var1);
      this.secondaryExportOverwrite.setSelected(!var1?false:this.secondaryExportOverwrite.isSelected());
   }

   private boolean validateDiffName() {
      File var1 = this.getMatchesDatabaseTargetFile();
      return !var1.exists() || this.diffDatabaseOverwrite.isSelected();
   }

   private boolean validateExportName(ESide var1) {
      File var2 = this.getExportBinaryTargetFile(var1);
      if(var2.exists()) {
         String var3 = null;
         var3 = this.diff.getBinExportMD5(var1);
         String var4 = (String)this.exportFilePathToMd5.get(var2.getPath());
         if(var4 == null) {
            var4 = FileUtils.calcMD5(var2);
            this.exportFilePathToMd5.put(var2.getPath(), var4);
         }

         if(!var4.equals(var3)) {
            if(var1 == ESide.PRIMARY && !this.primaryExportOverwrite.isSelected()) {
               return false;
            }

            if(var1 == ESide.SECONDARY && !this.secondaryExportOverwrite.isSelected()) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean validateInput() {
      if(!this.validateViewWithSameNameIsAlreadyOpen()) {
         MessageBox.showError(this, "There is already another view with the same diff name open. Close open view first or rename diff.");
         return false;
      } else if(!this.validateDiffName()) {
         MessageBox.showError(this, String.format("There is alreay a BinDiff file with the name \'%s\' existing.\nRename or select the checkbox to override.", new Object[]{this.getMatchesDatabaseTargetFile().getName()}));
         return false;
      } else if(!this.validateExportName(ESide.PRIMARY)) {
         MessageBox.showError(this, String.format("There is alreay a primary BinExport file named \'%s\'\nexisting with different content. Rename or select the checkbox for override.", new Object[]{this.getExportBinaryTargetFile(ESide.PRIMARY).getName()}));
         return false;
      } else if(!this.validateExportName(ESide.SECONDARY)) {
         MessageBox.showError(this, String.format("There is alreay a secondary BinExport file named \'%s\'\nexisting with different content. Rename or select the checkbox for override.", new Object[]{this.getExportBinaryTargetFile(ESide.SECONDARY).getName()}));
         return false;
      } else {
         return true;
      }
   }

   private boolean validateViewWithSameNameIsAlreadyOpen() {
      Iterator var1 = this.workspace.getDiffList().iterator();

      Diff var2;
      do {
         if(!var1.hasNext()) {
            return true;
         }

         var2 = (Diff)var1.next();
      } while(!var2.getMatchesDatabase().equals(this.getMatchesDatabaseTargetFile()) || this.diff == var2);

      return var2.getViewManager().getFlowgraphViewsData().size() == 0;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      var1.add(this.createFilenamePanel(), "North");
      var1.add(this.createButtonPanel(), "South");
      this.add(var1, "Center");
      this.pack();
      this.setPreferredSize(new Dimension(DLGWIDTH, DLGHEIGHT));
      this.setMinimumSize(new Dimension(DLGWIDTH, DLGHEIGHT));
      GuiHelper.centerChildToParent(this.getParent(), this, true);
   }

   public void dispose() {
      this.diffDatabaseFileName.getDocument().removeDocumentListener(this.documentListener);
      this.primaryExportFileName.getDocument().removeDocumentListener(this.documentListener);
      this.secondaryExportFileName.getDocument().removeDocumentListener(this.documentListener);
      this.diffDatabaseOverwrite.removeActionListener(this.checkBoxListener);
      this.primaryExportOverwrite.removeActionListener(this.checkBoxListener);
      this.secondaryExportOverwrite.removeActionListener(this.checkBoxListener);
      this.okButton.removeActionListener(this.buttonListener);
      this.cancelButton.removeActionListener(this.buttonListener);
      super.dispose();
   }

   public File getExportBinaryTargetFile(ESide var1) {
      // $FF: Couldn't be decompiled
   }

   public String getFunctionDiffName() {
      return CFileUtils.forceFilenameEndsNotWithExtension(this.getMatchesDatabaseTargetFile().getName(), "BinDiff");
   }

   public File getMatchesDatabaseTargetFile() {
      // $FF: Couldn't be decompiled
   }

   public boolean isOkPressed() {
      return this.okPressed;
   }

   public boolean isOverrideExportBinary(ESide var1) {
      return !this.okPressed?false:(var1 == ESide.PRIMARY?this.primaryExportOverwrite.isSelected():this.secondaryExportOverwrite.isSelected());
   }

   public void setVisible(boolean var1) {
      this.loadWorkspace();
      if(!this.workspace.isLoaded()) {
         this.dispose();
      } else if(!this.createSingleViewsDirectory()) {
         Logger.logSevere("Save function diff view failed. Couldn\'t create \'Function Diffs\' directory\'.", new Object[0]);
         MessageBox.showError(this.window, "Save function diff view failed. Couldn\'t create \'Function Diffs\' directory\'.");
         this.dispose();
      } else if(!this.createDestinationDirectory()) {
         Logger.logSevere("Save function diff view failed. Couldn\'t create destination directory.", new Object[0]);
         MessageBox.showError(this.window, "Save function diff view failed. Couldn\'t create destination directory.");
         this.dispose();
      } else {
         try {
            this.setDefaultNames();
         } catch (IOException var3) {
            Logger.logSevere("Save function diff view failed. Couldn\'t calculate source BinExport MD5.", new Object[0]);
            MessageBox.showError(this.window, "Save function diff view failed. Couldn\'t calculate source BinExport MD5.");
            return;
         }

         if(var1) {
            this.okPressed = false;
         }

         super.setVisible(var1);
      }
   }

   // $FF: synthetic method
   static JButton access$300(SaveFunctionDiffViewDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static boolean access$400(SaveFunctionDiffViewDialog var0) {
      return var0.validateInput();
   }

   // $FF: synthetic method
   static boolean access$502(SaveFunctionDiffViewDialog var0, boolean var1) {
      return var0.okPressed = var1;
   }

   // $FF: synthetic method
   static JCheckBox access$600(SaveFunctionDiffViewDialog var0) {
      return var0.primaryExportOverwrite;
   }

   // $FF: synthetic method
   static JCheckBox access$700(SaveFunctionDiffViewDialog var0) {
      return var0.secondaryExportOverwrite;
   }

   // $FF: synthetic method
   static void access$800(SaveFunctionDiffViewDialog var0) {
      var0.updateOnExistanceChanged();
   }
}
