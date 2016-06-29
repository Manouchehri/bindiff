/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
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
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceLoader;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class SaveFunctionDiffViewDialog
extends BaseDialog {
    private static Color NORMAL_COLOR = new JFormattedTextField().getBackground();
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
    private final DocumentListener documentListener;
    private final ActionListener checkBoxListener;
    private final ActionListener buttonListener;
    private boolean okPressed;
    private final MainWindow window;
    private final Workspace workspace;
    private final Diff diff;
    private File destinationDir;
    private final Map exportFilePathToMd5;

    public SaveFunctionDiffViewDialog(MainWindow mainWindow, String string, Workspace workspace, Diff diff) {
        super((Window)Preconditions.checkNotNull(mainWindow), string);
        this.documentListener = new SaveFunctionDiffViewDialog$InternalDocumentListener(this, null);
        this.checkBoxListener = new SaveFunctionDiffViewDialog$InternalCheckboxListener(this, null);
        this.buttonListener = new SaveFunctionDiffViewDialog$InternalButtonListener(this, null);
        this.okPressed = false;
        this.destinationDir = null;
        this.exportFilePathToMd5 = new HashMap();
        this.window = mainWindow;
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
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
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(7, 5, 5, 10));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel2.add(this.okButton);
        jPanel2.add(this.cancelButton);
        jPanel.add((Component)jPanel2, "East");
        return jPanel;
    }

    private boolean createDestinationDirectory() {
        DiffMetaData diffMetaData = this.diff.getMetaData();
        String string = String.format("%s vs %s", diffMetaData.getImageName(ESide.PRIMARY), diffMetaData.getImageName(ESide.SECONDARY));
        String string2 = " - ";
        String string3 = String.format("%s-%s", diffMetaData.getImageHash(ESide.PRIMARY), diffMetaData.getImageHash(ESide.SECONDARY));
        int n2 = string.length() + " - ".length() + string3.length();
        if (n2 > 254) {
            int n3 = n2 - 254;
            string = string.substring(0, string.length() - 1 - n3);
        }
        String string4 = FileUtils.ensureTrailingSlash(this.destinationDir.getPath());
        String string5 = String.valueOf(string4);
        String string6 = String.valueOf(String.format("%s%s%s", string, " - ", string3));
        string4 = string6.length() != 0 ? string5.concat(string6) : new String(string5);
        this.destinationDir = new File(string4);
        if (this.destinationDir.exists()) return true;
        return this.destinationDir.mkdir();
    }

    private JPanel createFilenameLinePanel(String string, JFormattedTextField jFormattedTextField, String string2, JCheckBox jCheckBox) {
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel(string);
        jLabel.setPreferredSize(new Dimension(150, 25));
        jLabel.setMaximumSize(new Dimension(150, 25));
        jPanel2.add((Component)jLabel, "West");
        jFormattedTextField.setPreferredSize(new Dimension(250, 25));
        jPanel2.add((Component)jFormattedTextField, "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JLabel jLabel2 = new JLabel(string2);
        jLabel2.setPreferredSize(new Dimension(65, 25));
        jLabel2.setMaximumSize(new Dimension(65, 25));
        jPanel3.add((Component)jLabel2, "West");
        jPanel3.add((Component)jCheckBox, "Center");
        jPanel2.add((Component)jPanel3, "East");
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    private JPanel createFilenamePanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("")));
        JPanel jPanel2 = new JPanel(new GridLayout(3, 1, 5, 5));
        jPanel2.add(this.createFilenameLinePanel("Diff Name:", this.diffDatabaseFileName, ".BinDiff", this.diffDatabaseOverwrite));
        jPanel2.add(this.createFilenameLinePanel("Primary Export Name:", this.primaryExportFileName, ".BinExport", this.primaryExportOverwrite));
        jPanel2.add(this.createFilenameLinePanel("Secondary Export Name:", this.secondaryExportFileName, ".BinExport", this.secondaryExportOverwrite));
        jPanel.add((Component)jPanel2, "North");
        return jPanel;
    }

    private boolean createSingleViewsDirectory() {
        String string = this.workspace.getWorkspaceFile().getParentFile().getPath();
        string = FileUtils.ensureTrailingSlash(string);
        String string2 = String.valueOf(string);
        String string3 = String.valueOf("Function Diff Views");
        string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        this.destinationDir = new File(string);
        if (this.destinationDir.exists()) return true;
        return this.destinationDir.mkdir();
    }

    private void loadWorkspace() {
        File file;
        String string;
        int n2;
        block10 : {
            if (this.workspace.isLoaded()) return;
            string = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
            boolean bl2 = false;
            if (new File(string).exists()) {
                n2 = MessageBox.showYesNoCancelQuestion(this.getParent(), "A workspace has to be loaded to save a function diff view. Load the default workspace?");
                if (n2 == 0) {
                    file = new File(string);
                    WorkspaceLoader workspaceLoader = new WorkspaceLoader(file, this.workspace);
                    try {
                        ProgressDialog.show((Window)this.getParent(), String.format("Loading Workspace '%s'", file.getName()), workspaceLoader);
                    }
                    catch (Exception var6_8) {
                        Logger.logException(var6_8, String.format("Load default workspace failed. '%s'", file.getPath()));
                        MessageBox.showError(this.getParent(), String.format("Faild to load the current default workspace.\n'%s'", file.getPath()));
                    }
                } else if (n2 == 1) {
                    bl2 = true;
                }
                if (bl2) break block10;
            }
            if (new File(string).exists()) return;
        }
        if (!new File(string).exists() && (n2 = MessageBox.showYesNoQuestion(this.window, "A workspace has to be loaded to save a function diff view. Load workspace?")) == 1) {
            return;
        }
        try {
            TabPanelManager tabPanelManager = this.window.getController().getTabPanelManager();
            file = tabPanelManager.getWorkspaceTabPanel();
            file.getController().loadWorkspace();
            return;
        }
        catch (Exception var3_5) {
            Logger.logException(var3_5, "Load workspace failed.");
            MessageBox.showError(this.window, "Load workspace failed.");
        }
    }

    private void setDefaultNames() {
        String string = ((TabPanel)this.window.getController().getTabPanelManager().getTabbedPane().getSelectedComponent()).getTitle();
        this.setDefaultText(this.diffDatabaseFileName, string);
        String string2 = this.diff.getExportFile(ESide.PRIMARY).getName();
        string2 = CFileUtils.forceFilenameEndsNotWithExtension(string2, "BinExport");
        this.setDefaultText(this.primaryExportFileName, string2);
        String string3 = this.diff.getExportFile(ESide.SECONDARY).getName();
        string3 = CFileUtils.forceFilenameEndsNotWithExtension(string3, "BinExport");
        this.setDefaultText(this.secondaryExportFileName, string3);
        this.updateOnExistanceChanged();
    }

    private void setDefaultText(JFormattedTextField jFormattedTextField, String string) {
        String string2 = "";
        int n2 = 0;
        while (n2 < string.length()) {
            char c2;
            String string3;
            String string4 = jFormattedTextField.getText();
            if (string4.equals("")) {
                string3 = string2;
                c2 = string.charAt(n2);
                string4 = new StringBuilder(1 + String.valueOf(string3).length()).append(string3).append(c2).toString();
            } else {
                string3 = String.valueOf(string4);
                c2 = string.charAt(n2);
                string4 = new StringBuilder(1 + String.valueOf(string3).length()).append(string3).append(c2).toString();
            }
            jFormattedTextField.setText(string4);
            if (!jFormattedTextField.getText().equals("")) {
                string2 = string4;
            }
            ++n2;
        }
    }

    private void updateOnExistanceChanged() {
        boolean bl2 = this.getMatchesDatabaseTargetFile().exists();
        this.diffDatabaseFileName.setBackground(bl2 ? OVERRIDE_COLOR : NORMAL_COLOR);
        this.diffDatabaseOverwrite.setEnabled(bl2);
        bl2 = this.getExportBinaryTargetFile(ESide.PRIMARY).exists() && !this.validateExportName(ESide.PRIMARY);
        this.primaryExportFileName.setBackground(bl2 ? OVERRIDE_COLOR : NORMAL_COLOR);
        this.primaryExportOverwrite.setEnabled(bl2);
        this.primaryExportOverwrite.setSelected(!bl2 ? false : this.primaryExportOverwrite.isSelected());
        bl2 = this.getExportBinaryTargetFile(ESide.SECONDARY).exists() && !this.validateExportName(ESide.SECONDARY);
        this.secondaryExportFileName.setBackground(bl2 ? OVERRIDE_COLOR : NORMAL_COLOR);
        this.secondaryExportOverwrite.setEnabled(bl2);
        this.secondaryExportOverwrite.setSelected(!bl2 ? false : this.secondaryExportOverwrite.isSelected());
    }

    private boolean validateDiffName() {
        File file = this.getMatchesDatabaseTargetFile();
        if (!file.exists()) return true;
        if (this.diffDatabaseOverwrite.isSelected()) return true;
        return false;
    }

    private boolean validateExportName(ESide eSide) {
        File file = this.getExportBinaryTargetFile(eSide);
        if (!file.exists()) return true;
        String string = null;
        string = this.diff.getBinExportMD5(eSide);
        String string2 = (String)this.exportFilePathToMd5.get(file.getPath());
        if (string2 == null) {
            string2 = FileUtils.calcMD5(file);
            this.exportFilePathToMd5.put(file.getPath(), string2);
        }
        if (string2.equals(string)) return true;
        if (eSide == ESide.PRIMARY && !this.primaryExportOverwrite.isSelected()) {
            return false;
        }
        if (eSide != ESide.SECONDARY) return true;
        if (this.secondaryExportOverwrite.isSelected()) return true;
        return false;
    }

    private boolean validateInput() {
        if (!this.validateViewWithSameNameIsAlreadyOpen()) {
            MessageBox.showError(this, "There is already another view with the same diff name open. Close open view first or rename diff.");
            return false;
        }
        if (!this.validateDiffName()) {
            MessageBox.showError(this, String.format("There is alreay a BinDiff file with the name '%s' existing.\nRename or select the checkbox to override.", this.getMatchesDatabaseTargetFile().getName()));
            return false;
        }
        if (!this.validateExportName(ESide.PRIMARY)) {
            MessageBox.showError(this, String.format("There is alreay a primary BinExport file named '%s'\nexisting with different content. Rename or select the checkbox for override.", this.getExportBinaryTargetFile(ESide.PRIMARY).getName()));
            return false;
        }
        if (this.validateExportName(ESide.SECONDARY)) return true;
        MessageBox.showError(this, String.format("There is alreay a secondary BinExport file named '%s'\nexisting with different content. Rename or select the checkbox for override.", this.getExportBinaryTargetFile(ESide.SECONDARY).getName()));
        return false;
    }

    private boolean validateViewWithSameNameIsAlreadyOpen() {
        Diff diff;
        Iterator iterator = this.workspace.getDiffList().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (!(diff = (Diff)iterator.next()).getMatchesDatabase().equals(this.getMatchesDatabaseTargetFile()) || this.diff == diff);
        if (diff.getViewManager().getFlowgraphViewsData().size() != 0) return false;
        return true;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel.add((Component)this.createFilenamePanel(), "North");
        jPanel.add((Component)this.createButtonPanel(), "South");
        this.add((Component)jPanel, "Center");
        this.pack();
        this.setPreferredSize(new Dimension(DLGWIDTH, DLGHEIGHT));
        this.setMinimumSize(new Dimension(DLGWIDTH, DLGHEIGHT));
        GuiHelper.centerChildToParent(this.getParent(), this, true);
    }

    @Override
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

    public File getExportBinaryTargetFile(ESide eSide) {
        String string = FileUtils.ensureTrailingSlash(this.destinationDir.getPath());
        String string2 = String.valueOf(string);
        String string3 = String.valueOf(eSide == ESide.PRIMARY ? this.primaryExportFileName.getText() : this.secondaryExportFileName.getText());
        string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        string = CFileUtils.forceFilenameEndsWithExtension(string, "BinExport");
        return new File(string);
    }

    public String getFunctionDiffName() {
        return CFileUtils.forceFilenameEndsNotWithExtension(this.getMatchesDatabaseTargetFile().getName(), "BinDiff");
    }

    public File getMatchesDatabaseTargetFile() {
        String string = FileUtils.ensureTrailingSlash(this.destinationDir.getPath());
        String string2 = String.valueOf(string);
        String string3 = String.valueOf(this.diffDatabaseFileName.getText());
        string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        string = CFileUtils.forceFilenameEndsWithExtension(string, "BinDiff");
        return new File(string);
    }

    public boolean isOkPressed() {
        return this.okPressed;
    }

    public boolean isOverrideExportBinary(ESide eSide) {
        if (!this.okPressed) {
            return false;
        }
        if (eSide != ESide.PRIMARY) return this.secondaryExportOverwrite.isSelected();
        return this.primaryExportOverwrite.isSelected();
    }

    @Override
    public void setVisible(boolean bl2) {
        this.loadWorkspace();
        if (!this.workspace.isLoaded()) {
            this.dispose();
            return;
        }
        if (!this.createSingleViewsDirectory()) {
            Logger.logSevere("Save function diff view failed. Couldn't create 'Function Diffs' directory'.", new Object[0]);
            MessageBox.showError(this.window, "Save function diff view failed. Couldn't create 'Function Diffs' directory'.");
            this.dispose();
            return;
        }
        if (!this.createDestinationDirectory()) {
            Logger.logSevere("Save function diff view failed. Couldn't create destination directory.", new Object[0]);
            MessageBox.showError(this.window, "Save function diff view failed. Couldn't create destination directory.");
            this.dispose();
            return;
        }
        try {
            this.setDefaultNames();
        }
        catch (IOException var2_2) {
            Logger.logSevere("Save function diff view failed. Couldn't calculate source BinExport MD5.", new Object[0]);
            MessageBox.showError(this.window, "Save function diff view failed. Couldn't calculate source BinExport MD5.");
            return;
        }
        if (bl2) {
            this.okPressed = false;
        }
        super.setVisible(bl2);
    }

    static /* synthetic */ JButton access$300(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        return saveFunctionDiffViewDialog.okButton;
    }

    static /* synthetic */ boolean access$400(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        return saveFunctionDiffViewDialog.validateInput();
    }

    static /* synthetic */ boolean access$502(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog, boolean bl2) {
        saveFunctionDiffViewDialog.okPressed = bl2;
        return saveFunctionDiffViewDialog.okPressed;
    }

    static /* synthetic */ JCheckBox access$600(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        return saveFunctionDiffViewDialog.primaryExportOverwrite;
    }

    static /* synthetic */ JCheckBox access$700(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        return saveFunctionDiffViewDialog.secondaryExportOverwrite;
    }

    static /* synthetic */ void access$800(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        saveFunctionDiffViewDialog.updateOnExistanceChanged();
    }
}

