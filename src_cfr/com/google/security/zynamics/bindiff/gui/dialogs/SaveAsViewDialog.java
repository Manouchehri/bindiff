/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SaveAsViewDialog
extends BaseDialog {
    private final SaveAsViewDialog$InternalButtonListener buttonListener;
    private final JTextField nameTextField;
    private final JTextArea commentTextField;
    private final JButton okButton;
    private final JButton cancelButton;
    private boolean pressedOkButton;

    public SaveAsViewDialog(Window window, String string) {
        super(window, "Save View As");
        this.buttonListener = new SaveAsViewDialog$InternalButtonListener(this, null);
        this.nameTextField = new JTextField();
        this.commentTextField = new JTextArea();
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.pressedOkButton = false;
        this.setModal(true);
        this.setLayout(new BorderLayout());
        this.nameTextField.setText(string.toString());
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.init();
        GuiHelper.centerChildToParent(window, this, true);
    }

    private void init() {
        this.nameTextField.setPreferredSize(new Dimension(this.nameTextField.getPreferredSize().width, 25));
        this.commentTextField.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(this.commentTextField);
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder("View Name"));
        jPanel2.add((Component)this.nameTextField, "North");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new TitledBorder("View Comment"));
        jPanel3.add((Component)jScrollPane, "Center");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(10, 5, 5, 5));
        JPanel jPanel5 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel5.add(this.okButton);
        jPanel5.add(this.cancelButton);
        jPanel4.add((Component)jPanel5, "East");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)jPanel3, "Center");
        jPanel.add((Component)jPanel4, "South");
        this.add((Component)jPanel, "Center");
        this.pack();
        this.setPreferredSize(new Dimension(400, 250));
        this.setSize(new Dimension(400, 250));
        this.setMinimumSize(this.getSize());
    }

    @Override
    public void dispose() {
        this.okButton.removeActionListener(this.buttonListener);
        this.cancelButton.removeActionListener(this.buttonListener);
        super.dispose();
    }

    public boolean getOkButtonPressed() {
        return this.pressedOkButton;
    }

    public String getViewComment() {
        return this.commentTextField.getText();
    }

    public String getViewName() {
        return this.nameTextField.getText();
    }

    static /* synthetic */ JButton access$100(SaveAsViewDialog saveAsViewDialog) {
        return saveAsViewDialog.okButton;
    }

    static /* synthetic */ boolean access$202(SaveAsViewDialog saveAsViewDialog, boolean bl2) {
        saveAsViewDialog.pressedOkButton = bl2;
        return saveAsViewDialog.pressedOkButton;
    }
}

