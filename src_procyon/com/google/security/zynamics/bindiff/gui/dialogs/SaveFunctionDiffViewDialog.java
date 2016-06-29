package com.google.security.zynamics.bindiff.gui.dialogs;

import javax.swing.event.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.gui.components.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;

public class SaveFunctionDiffViewDialog extends BaseDialog
{
    private static Color NORMAL_COLOR;
    private static Color OVERRIDE_COLOR;
    private static int DLGWIDTH;
    private static int DLGHEIGHT;
    private static final String FUNCTION_DIFF_VIEWS_DIRECTORY_NAME = "Function Diff Views";
    private final JFormattedTextField diffDatabaseFileName;
    private final JFormattedTextField primaryExportFileName;
    private final JFormattedTextField secondaryExportFileName;
    private final JCheckBox diffDatabaseOverwrite;
    private final JCheckBox primaryExportOverwrite;
    private final JCheckBox secondaryExportOverwrite;
    private final JButton okButton;
    private final JButton cancelButton;
    private final DocumentListener documentListener;
    private final ActionListener checkBoxListener;
    private final ActionListener buttonListener;
    private boolean okPressed;
    private final MainWindow window;
    private final Workspace workspace;
    private final Diff diff;
    private File destinationDir;
    private final Map exportFilePathToMd5;
    
    public SaveFunctionDiffViewDialog(final MainWindow window, final String s, final Workspace workspace, final Diff diff) {
        super((Window)Preconditions.checkNotNull(window), s);
        this.diffDatabaseFileName = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
        this.primaryExportFileName = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
        this.secondaryExportFileName = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
        this.diffDatabaseOverwrite = new JCheckBox("Overwrite");
        this.primaryExportOverwrite = new JCheckBox("Overwrite");
        this.secondaryExportOverwrite = new JCheckBox("Overwrite");
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.documentListener = new SaveFunctionDiffViewDialog$InternalDocumentListener(this, null);
        this.checkBoxListener = new SaveFunctionDiffViewDialog$InternalCheckboxListener(this, null);
        this.buttonListener = new SaveFunctionDiffViewDialog$InternalButtonListener(this, null);
        this.okPressed = false;
        this.destinationDir = null;
        this.exportFilePathToMd5 = new HashMap();
        this.window = window;
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
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(7, 5, 5, 10));
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(this.okButton);
        panel2.add(this.cancelButton);
        panel.add(panel2, "East");
        return panel;
    }
    
    private boolean createDestinationDirectory() {
        final DiffMetaData metaData = this.diff.getMetaData();
        String s = String.format("%s vs %s", metaData.getImageName(ESide.PRIMARY), metaData.getImageName(ESide.SECONDARY));
        final String format = String.format("%s-%s", metaData.getImageHash(ESide.PRIMARY), metaData.getImageHash(ESide.SECONDARY));
        final int n = s.length() + " - ".length() + format.length();
        if (n > 254) {
            s = s.substring(0, s.length() - 1 - (n - 254));
        }
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(this.destinationDir.getPath()));
        final String value2 = String.valueOf(String.format("%s%s%s", s, " - ", format));
        this.destinationDir = new File((value2.length() != 0) ? value.concat(value2) : new String(value));
        return this.destinationDir.exists() || this.destinationDir.mkdir();
    }
    
    private JPanel createFilenameLinePanel(final String s, final JFormattedTextField formattedTextField, final String s2, final JCheckBox checkBox) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JLabel label = new JLabel(s);
        label.setPreferredSize(new Dimension(150, 25));
        label.setMaximumSize(new Dimension(150, 25));
        panel2.add(label, "West");
        formattedTextField.setPreferredSize(new Dimension(250, 25));
        panel2.add(formattedTextField, "Center");
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JLabel label2 = new JLabel(s2);
        label2.setPreferredSize(new Dimension(65, 25));
        label2.setMaximumSize(new Dimension(65, 25));
        panel3.add(label2, "West");
        panel3.add(checkBox, "Center");
        panel2.add(panel3, "East");
        panel.add(panel2, "North");
        return panel;
    }
    
    private JPanel createFilenamePanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("")));
        final JPanel panel2 = new JPanel(new GridLayout(3, 1, 5, 5));
        panel2.add(this.createFilenameLinePanel("Diff Name:", this.diffDatabaseFileName, ".BinDiff", this.diffDatabaseOverwrite));
        panel2.add(this.createFilenameLinePanel("Primary Export Name:", this.primaryExportFileName, ".BinExport", this.primaryExportOverwrite));
        panel2.add(this.createFilenameLinePanel("Secondary Export Name:", this.secondaryExportFileName, ".BinExport", this.secondaryExportOverwrite));
        panel.add(panel2, "North");
        return panel;
    }
    
    private boolean createSingleViewsDirectory() {
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(this.workspace.getWorkspaceFile().getParentFile().getPath()));
        final String value2 = String.valueOf("Function Diff Views");
        this.destinationDir = new File((value2.length() != 0) ? value.concat(value2) : new String(value));
        return this.destinationDir.exists() || this.destinationDir.mkdir();
    }
    
    private void loadWorkspace() {
        if (!this.workspace.isLoaded()) {
            final String defaultWorkspace = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
            boolean b = false;
            if (new File(defaultWorkspace).exists()) {
                final int showYesNoCancelQuestion = MessageBox.showYesNoCancelQuestion(this.getParent(), "A workspace has to be loaded to save a function diff view. Load the default workspace?");
                if (showYesNoCancelQuestion == 0) {
                    final File file = new File(defaultWorkspace);
                    final WorkspaceLoader workspaceLoader = new WorkspaceLoader(file, this.workspace);
                    try {
                        ProgressDialog.show((Window)this.getParent(), String.format("Loading Workspace '%s'", file.getName()), workspaceLoader);
                    }
                    catch (Exception ex) {
                        Logger.logException(ex, String.format("Load default workspace failed. '%s'", file.getPath()));
                        MessageBox.showError(this.getParent(), String.format("Faild to load the current default workspace.\n'%s'", file.getPath()));
                    }
                }
                else if (showYesNoCancelQuestion == 1) {
                    b = true;
                }
            }
            if (b || !new File(defaultWorkspace).exists()) {
                if (!new File(defaultWorkspace).exists() && MessageBox.showYesNoQuestion(this.window, "A workspace has to be loaded to save a function diff view. Load workspace?") == 1) {
                    return;
                }
                try {
                    this.window.getController().getTabPanelManager().getWorkspaceTabPanel().getController().loadWorkspace();
                }
                catch (Exception ex2) {
                    Logger.logException(ex2, "Load workspace failed.");
                    MessageBox.showError(this.window, "Load workspace failed.");
                }
            }
        }
    }
    
    private void setDefaultNames() {
        this.setDefaultText(this.diffDatabaseFileName, ((TabPanel)this.window.getController().getTabPanelManager().getTabbedPane().getSelectedComponent()).getTitle());
        this.setDefaultText(this.primaryExportFileName, CFileUtils.forceFilenameEndsNotWithExtension(this.diff.getExportFile(ESide.PRIMARY).getName(), "BinExport"));
        this.setDefaultText(this.secondaryExportFileName, CFileUtils.forceFilenameEndsNotWithExtension(this.diff.getExportFile(ESide.SECONDARY).getName(), "BinExport"));
        this.updateOnExistanceChanged();
    }
    
    private void setDefaultText(final JFormattedTextField formattedTextField, final String s) {
        String s2 = "";
        for (int i = 0; i < s.length(); ++i) {
            final String text = formattedTextField.getText();
            String text2;
            if (text.equals("")) {
                final String s3 = s2;
                text2 = new StringBuilder(1 + String.valueOf(s3).length()).append(s3).append(s.charAt(i)).toString();
            }
            else {
                final String value = String.valueOf(text);
                text2 = new StringBuilder(1 + String.valueOf(value).length()).append(value).append(s.charAt(i)).toString();
            }
            formattedTextField.setText(text2);
            if (!formattedTextField.getText().equals("")) {
                s2 = text2;
            }
        }
    }
    
    private void updateOnExistanceChanged() {
        final boolean exists = this.getMatchesDatabaseTargetFile().exists();
        this.diffDatabaseFileName.setBackground(exists ? SaveFunctionDiffViewDialog.OVERRIDE_COLOR : SaveFunctionDiffViewDialog.NORMAL_COLOR);
        this.diffDatabaseOverwrite.setEnabled(exists);
        final boolean enabled = this.getExportBinaryTargetFile(ESide.PRIMARY).exists() && !this.validateExportName(ESide.PRIMARY);
        this.primaryExportFileName.setBackground(enabled ? SaveFunctionDiffViewDialog.OVERRIDE_COLOR : SaveFunctionDiffViewDialog.NORMAL_COLOR);
        this.primaryExportOverwrite.setEnabled(enabled);
        this.primaryExportOverwrite.setSelected(enabled && this.primaryExportOverwrite.isSelected());
        final boolean enabled2 = this.getExportBinaryTargetFile(ESide.SECONDARY).exists() && !this.validateExportName(ESide.SECONDARY);
        this.secondaryExportFileName.setBackground(enabled2 ? SaveFunctionDiffViewDialog.OVERRIDE_COLOR : SaveFunctionDiffViewDialog.NORMAL_COLOR);
        this.secondaryExportOverwrite.setEnabled(enabled2);
        this.secondaryExportOverwrite.setSelected(enabled2 && this.secondaryExportOverwrite.isSelected());
    }
    
    private boolean validateDiffName() {
        return !this.getMatchesDatabaseTargetFile().exists() || this.diffDatabaseOverwrite.isSelected();
    }
    
    private boolean validateExportName(final ESide eSide) {
        final File exportBinaryTargetFile = this.getExportBinaryTargetFile(eSide);
        if (exportBinaryTargetFile.exists()) {
            final String binExportMD5 = this.diff.getBinExportMD5(eSide);
            String calcMD5 = this.exportFilePathToMd5.get(exportBinaryTargetFile.getPath());
            if (calcMD5 == null) {
                calcMD5 = FileUtils.calcMD5(exportBinaryTargetFile);
                this.exportFilePathToMd5.put(exportBinaryTargetFile.getPath(), calcMD5);
            }
            if (!calcMD5.equals(binExportMD5)) {
                if (eSide == ESide.PRIMARY && !this.primaryExportOverwrite.isSelected()) {
                    return false;
                }
                if (eSide == ESide.SECONDARY && !this.secondaryExportOverwrite.isSelected()) {
                    return false;
                }
            }
        }
        return true;
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
        if (!this.validateExportName(ESide.SECONDARY)) {
            MessageBox.showError(this, String.format("There is alreay a secondary BinExport file named '%s'\nexisting with different content. Rename or select the checkbox for override.", this.getExportBinaryTargetFile(ESide.SECONDARY).getName()));
            return false;
        }
        return true;
    }
    
    private boolean validateViewWithSameNameIsAlreadyOpen() {
        for (final Diff diff : this.workspace.getDiffList()) {
            if (diff.getMatchesDatabase().equals(this.getMatchesDatabaseTargetFile()) && this.diff != diff) {
                return diff.getViewManager().getFlowgraphViewsData().size() == 0;
            }
        }
        return true;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.add(this.createFilenamePanel(), "North");
        panel.add(this.createButtonPanel(), "South");
        this.add(panel, "Center");
        this.pack();
        this.setPreferredSize(new Dimension(SaveFunctionDiffViewDialog.DLGWIDTH, SaveFunctionDiffViewDialog.DLGHEIGHT));
        this.setMinimumSize(new Dimension(SaveFunctionDiffViewDialog.DLGWIDTH, SaveFunctionDiffViewDialog.DLGHEIGHT));
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
    
    public File getExportBinaryTargetFile(final ESide eSide) {
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(this.destinationDir.getPath()));
        final String value2 = String.valueOf((eSide == ESide.PRIMARY) ? this.primaryExportFileName.getText() : this.secondaryExportFileName.getText());
        return new File(CFileUtils.forceFilenameEndsWithExtension((value2.length() != 0) ? value.concat(value2) : new String(value), "BinExport"));
    }
    
    public String getFunctionDiffName() {
        return CFileUtils.forceFilenameEndsNotWithExtension(this.getMatchesDatabaseTargetFile().getName(), "BinDiff");
    }
    
    public File getMatchesDatabaseTargetFile() {
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(this.destinationDir.getPath()));
        final String value2 = String.valueOf(this.diffDatabaseFileName.getText());
        return new File(CFileUtils.forceFilenameEndsWithExtension((value2.length() != 0) ? value.concat(value2) : new String(value), "BinDiff"));
    }
    
    public boolean isOkPressed() {
        return this.okPressed;
    }
    
    public boolean isOverrideExportBinary(final ESide eSide) {
        if (!this.okPressed) {
            return false;
        }
        if (eSide == ESide.PRIMARY) {
            return this.primaryExportOverwrite.isSelected();
        }
        return this.secondaryExportOverwrite.isSelected();
    }
    
    @Override
    public void setVisible(final boolean visible) {
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
        catch (IOException ex) {
            Logger.logSevere("Save function diff view failed. Couldn't calculate source BinExport MD5.", new Object[0]);
            MessageBox.showError(this.window, "Save function diff view failed. Couldn't calculate source BinExport MD5.");
            return;
        }
        if (visible) {
            this.okPressed = false;
        }
        super.setVisible(visible);
    }
    
    static {
        SaveFunctionDiffViewDialog.NORMAL_COLOR = new JFormattedTextField().getBackground();
        SaveFunctionDiffViewDialog.OVERRIDE_COLOR = new Color(233, 200, 200);
        SaveFunctionDiffViewDialog.DLGWIDTH = 650;
        SaveFunctionDiffViewDialog.DLGHEIGHT = 190;
    }
}
