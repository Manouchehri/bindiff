/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$InternalActionListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;

public class NewWorkspaceDialog
extends BaseDialog {
    private static final int LABEL_WIDTH = 100;
    private static final int ROW_HEIGHT = 25;
    private static final int DIALOG_WIDTH = 445;
    private static final int DIALOG_HEIGHT = 190;
    private final JFormattedTextField workspaceName;
    private final FileChooserPanel workspaceDirectoryPanel;
    private final JCheckBox createDirectory = new JCheckBox("Create directory for workspace");
    private final JCheckBox defaultWorkspace = new JCheckBox("Use this as default workspace");
    private final JButton ok = new JButton("Ok");
    private final JButton cancel = new JButton("Cancel");
    private final NewWorkspaceDialog$InternalActionListener actionListener;
    private boolean okPressed;

    public NewWorkspaceDialog(Window window, String string) {
        super(window, string, 445, 190);
        this.actionListener = new NewWorkspaceDialog$InternalActionListener(this, null);
        CFilenameFormatter cFilenameFormatter = new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory()));
        this.workspaceName = new JFormattedTextField(new DefaultFormatterFactory(cFilenameFormatter));
        this.workspaceName.setText("BinDiff Workspace");
        String string2 = BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory();
        if ("".equals(string2) || string2 == null) {
            string2 = SystemHelpers.getUserDirectory();
        }
        this.workspaceDirectoryPanel = new FileChooserPanel(string2, this.actionListener, "...", 0, 25, 0);
        this.createDirectory.setSelected(true);
        this.ok.addActionListener(this.actionListener);
        this.cancel.addActionListener(this.actionListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean validateValues() {
        String string = this.getWorkspaceName();
        if ("".equals(string) || string == null) {
            CMessageBox.showInformation(this, "A workspace need a name.");
            return false;
        }
        File file = new File(this.getWorkspacePath());
        if (file.exists()) {
            if (!file.isDirectory()) {
                CMessageBox.showInformation(this, "The specified workspace is not a directory.");
                return false;
            }
            if (file.list().length == 0) return true;
            CMessageBox.showInformation(this, "The specified workspace directory is not empty.");
            return false;
        }
        boolean bl2 = false;
        try {
            bl2 = file.createNewFile();
            return bl2;
        }
        catch (IOException var4_4) {
            CMessageBox.showError(this, String.format("Could create workspace directory. '%s'", file.getAbsolutePath()));
            boolean bl3 = false;
            return bl3;
        }
        finally {
            if (bl2) {
                file.delete();
            }
        }
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(3, 1, 5, 5));
        jPanel2.setBorder(new TitledBorder(""));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Name:", 100, this.workspaceName, 25));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("Location:", 100, this.workspaceDirectoryPanel, 25));
        jPanel2.add(GuiUtils.createHorizontalNamedComponentPanel("", 96, this.createDirectory, 25));
        jPanel.add((Component)jPanel2, "North");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel4.add(this.ok);
        jPanel4.add(this.cancel);
        jPanel3.add((Component)this.defaultWorkspace, "West");
        jPanel3.add((Component)jPanel4, "East");
        jPanel.add((Component)jPanel3, "South");
        this.add((Component)jPanel, "Center");
    }

    public String getWorkspaceName() {
        return this.workspaceName.getText();
    }

    public String getWorkspacePath() {
        String string;
        if (!this.createDirectory.isSelected()) return this.workspaceDirectoryPanel.getText();
        String string2 = this.workspaceDirectoryPanel.getText();
        if (!string2.endsWith(File.separator)) {
            String string3 = String.valueOf(string2);
            String string4 = String.valueOf(File.separator);
            string2 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        }
        String string5 = String.valueOf(string2);
        String string6 = String.valueOf(this.workspaceName.getText());
        if (string6.length() != 0) {
            string = string5.concat(string6);
            return string;
        }
        string = new String(string5);
        return string;
    }

    public boolean isDefaultWorkspace() {
        return this.defaultWorkspace.isSelected();
    }

    public boolean isOkPressed() {
        return this.okPressed;
    }

    static /* synthetic */ FileChooserPanel access$100(NewWorkspaceDialog newWorkspaceDialog) {
        return newWorkspaceDialog.workspaceDirectoryPanel;
    }

    static /* synthetic */ JButton access$200(NewWorkspaceDialog newWorkspaceDialog) {
        return newWorkspaceDialog.ok;
    }

    static /* synthetic */ boolean access$300(NewWorkspaceDialog newWorkspaceDialog) {
        return newWorkspaceDialog.validateValues();
    }

    static /* synthetic */ boolean access$402(NewWorkspaceDialog newWorkspaceDialog, boolean bl2) {
        newWorkspaceDialog.okPressed = bl2;
        return newWorkspaceDialog.okPressed;
    }
}

