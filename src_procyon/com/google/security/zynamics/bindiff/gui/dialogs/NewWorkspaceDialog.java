package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.security.zynamics.zylib.system.*;
import javax.swing.text.*;
import com.google.security.zynamics.bindiff.config.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

public class NewWorkspaceDialog extends BaseDialog
{
    private static final int LABEL_WIDTH = 100;
    private static final int ROW_HEIGHT = 25;
    private static final int DIALOG_WIDTH = 445;
    private static final int DIALOG_HEIGHT = 190;
    private final JFormattedTextField workspaceName;
    private final FileChooserPanel workspaceDirectoryPanel;
    private final JCheckBox createDirectory;
    private final JCheckBox defaultWorkspace;
    private final JButton ok;
    private final JButton cancel;
    private final NewWorkspaceDialog$InternalActionListener actionListener;
    private boolean okPressed;
    
    public NewWorkspaceDialog(final Window window, final String s) {
        super(window, s, 445, 190);
        this.createDirectory = new JCheckBox("Create directory for workspace");
        this.defaultWorkspace = new JCheckBox("Use this as default workspace");
        this.ok = new JButton("Ok");
        this.cancel = new JButton("Cancel");
        this.actionListener = new NewWorkspaceDialog$InternalActionListener(this, null);
        (this.workspaceName = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory()))))).setText("BinDiff Workspace");
        String s2 = BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory();
        if ("".equals(s2) || s2 == null) {
            s2 = SystemHelpers.getUserDirectory();
        }
        this.workspaceDirectoryPanel = new FileChooserPanel(s2, this.actionListener, "...", 0, 25, 0);
        this.createDirectory.setSelected(true);
        this.ok.addActionListener(this.actionListener);
        this.cancel.addActionListener(this.actionListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private boolean validateValues() {
        final String workspaceName = this.getWorkspaceName();
        if ("".equals(workspaceName) || workspaceName == null) {
            CMessageBox.showInformation(this, "A workspace need a name.");
            return false;
        }
        final File file = new File(this.getWorkspacePath());
        if (!file.exists()) {
            boolean newFile = false;
            try {
                newFile = file.createNewFile();
            }
            catch (IOException ex) {
                CMessageBox.showError(this, String.format("Could create workspace directory. '%s'", file.getAbsolutePath()));
                return false;
            }
            finally {
                if (newFile) {
                    file.delete();
                }
            }
            return newFile;
        }
        if (!file.isDirectory()) {
            CMessageBox.showInformation(this, "The specified workspace is not a directory.");
            return false;
        }
        if (file.list().length != 0) {
            CMessageBox.showInformation(this, "The specified workspace directory is not empty.");
            return false;
        }
        return true;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(3, 1, 5, 5));
        panel2.setBorder(new TitledBorder(""));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Name:", 100, this.workspaceName, 25));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("Location:", 100, this.workspaceDirectoryPanel, 25));
        panel2.add(GuiUtils.createHorizontalNamedComponentPanel("", 96, this.createDirectory, 25));
        panel.add(panel2, "North");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel4.add(this.ok);
        panel4.add(this.cancel);
        panel3.add(this.defaultWorkspace, "West");
        panel3.add(panel4, "East");
        panel.add(panel3, "South");
        this.add(panel, "Center");
    }
    
    public String getWorkspaceName() {
        return this.workspaceName.getText();
    }
    
    public String getWorkspacePath() {
        if (this.createDirectory.isSelected()) {
            String text = this.workspaceDirectoryPanel.getText();
            if (!text.endsWith(File.separator)) {
                final String value = String.valueOf(text);
                final String value2 = String.valueOf(File.separator);
                text = ((value2.length() != 0) ? value.concat(value2) : new String(value));
            }
            final String value3 = String.valueOf(text);
            final String value4 = String.valueOf(this.workspaceName.getText());
            return (value4.length() != 0) ? value3.concat(value4) : new String(value3);
        }
        return this.workspaceDirectoryPanel.getText();
    }
    
    public boolean isDefaultWorkspace() {
        return this.defaultWorkspace.isSelected();
    }
    
    public boolean isOkPressed() {
        return this.okPressed;
    }
}
