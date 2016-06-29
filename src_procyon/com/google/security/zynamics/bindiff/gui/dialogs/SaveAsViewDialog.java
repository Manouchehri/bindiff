package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class SaveAsViewDialog extends BaseDialog
{
    private final SaveAsViewDialog$InternalButtonListener buttonListener;
    private final JTextField nameTextField;
    private final JTextArea commentTextField;
    private final JButton okButton;
    private final JButton cancelButton;
    private boolean pressedOkButton;
    
    public SaveAsViewDialog(final Window window, final String s) {
        super(window, "Save View As");
        this.buttonListener = new SaveAsViewDialog$InternalButtonListener(this, null);
        this.nameTextField = new JTextField();
        this.commentTextField = new JTextArea();
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.pressedOkButton = false;
        this.setModal(true);
        this.setLayout(new BorderLayout());
        this.nameTextField.setText(s.toString());
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.init();
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private void init() {
        this.nameTextField.setPreferredSize(new Dimension(this.nameTextField.getPreferredSize().width, 25));
        this.commentTextField.setLineWrap(true);
        final JScrollPane scrollPane = new JScrollPane(this.commentTextField);
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("View Name"));
        panel2.add(this.nameTextField, "North");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new TitledBorder("View Comment"));
        panel3.add(scrollPane, "Center");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(10, 5, 5, 5));
        final JPanel panel5 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel5.add(this.okButton);
        panel5.add(this.cancelButton);
        panel4.add(panel5, "East");
        panel.add(panel2, "North");
        panel.add(panel3, "Center");
        panel.add(panel4, "South");
        this.add(panel, "Center");
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
}
