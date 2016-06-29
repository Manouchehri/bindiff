/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$InternalActionListener;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RenameFileDialog
extends BaseDialog {
    private final RenameFileDialog$InternalActionListener buttonListener;
    private final JFormattedTextField nameField;
    private final String borderTitle;
    private final String extension;
    private final JButton ok;
    private final JButton cancel;
    private boolean okPressed;

    public RenameFileDialog(Window window, String string, String string2, String string3, String string4) {
        super(window, string);
        this.buttonListener = new RenameFileDialog$InternalActionListener(this, null);
        this.ok = new JButton("Ok");
        this.cancel = new JButton("Cancel");
        this.okPressed = false;
        this.nameField = new JFormattedTextField(new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
        this.extension = string4;
        this.borderTitle = string2;
        this.setDefaultText(string3);
        this.init();
    }

    private void setDefaultText(String string) {
        String string2 = "";
        int n2 = 0;
        while (n2 < string.length()) {
            char c2;
            String string3;
            String string4 = this.nameField.getText();
            if (string4.equals("")) {
                string3 = string2;
                c2 = string.charAt(n2);
                string4 = new StringBuilder(1 + String.valueOf(string3).length()).append(string3).append(c2).toString();
            } else {
                string3 = String.valueOf(string4);
                c2 = string.charAt(n2);
                string4 = new StringBuilder(1 + String.valueOf(string3).length()).append(string3).append(c2).toString();
            }
            this.nameField.setText(string4);
            if (!this.nameField.getText().equals("")) {
                string2 = string4;
            }
            ++n2;
        }
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder(this.borderTitle)));
        jPanel2.add((Component)this.nameField, "Center");
        String string = String.valueOf(this.extension);
        jPanel2.add((Component)new JLabel(string.length() != 0 ? "  .".concat(string) : new String("  .")), "East");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel4.add(this.ok);
        jPanel4.add(this.cancel);
        jPanel3.add((Component)jPanel4, "East");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)jPanel3, "South");
        this.add((Component)jPanel, "Center");
        this.pack();
        GuiHelper.centerChildToParent(this.getParent(), this, true);
    }

    @Override
    public void dispose() {
        this.ok.removeActionListener(this.buttonListener);
        this.cancel.removeActionListener(this.buttonListener);
        super.dispose();
    }

    public String getFileName(boolean bl2) {
        String string;
        String string2;
        String string3 = String.valueOf(this.nameField.getText());
        if (bl2) {
            String string4 = String.valueOf(this.extension);
            string2 = string4.length() != 0 ? ".".concat(string4) : new String(".");
        } else {
            string2 = "";
        }
        String string5 = String.valueOf(string2);
        if (string5.length() != 0) {
            string = string3.concat(string5);
            return string;
        }
        string = new String(string3);
        return string;
    }

    public boolean isOkPressed() {
        return this.okPressed;
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2) {
            this.ok.addActionListener(this.buttonListener);
            this.cancel.addActionListener(this.buttonListener);
            this.okPressed = false;
        }
        super.setVisible(bl2);
    }

    static /* synthetic */ boolean access$102(RenameFileDialog renameFileDialog, boolean bl2) {
        renameFileDialog.okPressed = bl2;
        return renameFileDialog.okPressed;
    }

    static /* synthetic */ JButton access$200(RenameFileDialog renameFileDialog) {
        return renameFileDialog.ok;
    }
}

