package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.zylib.system.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;

public class RenameFileDialog extends BaseDialog
{
    private final RenameFileDialog$InternalActionListener buttonListener;
    private final JFormattedTextField nameField;
    private final String borderTitle;
    private final String extension;
    private final JButton ok;
    private final JButton cancel;
    private boolean okPressed;
    
    public RenameFileDialog(final Window window, final String s, final String borderTitle, final String defaultText, final String extension) {
        super(window, s);
        this.buttonListener = new RenameFileDialog$InternalActionListener(this, null);
        this.ok = new JButton("Ok");
        this.cancel = new JButton("Cancel");
        this.okPressed = false;
        this.nameField = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
        this.extension = extension;
        this.borderTitle = borderTitle;
        this.setDefaultText(defaultText);
        this.init();
    }
    
    private void setDefaultText(final String s) {
        String s2 = "";
        for (int i = 0; i < s.length(); ++i) {
            final String text = this.nameField.getText();
            String text2;
            if (text.equals("")) {
                final String s3 = s2;
                text2 = new StringBuilder(1 + String.valueOf(s3).length()).append(s3).append(s.charAt(i)).toString();
            }
            else {
                final String value = String.valueOf(text);
                text2 = new StringBuilder(1 + String.valueOf(value).length()).append(value).append(s.charAt(i)).toString();
            }
            this.nameField.setText(text2);
            if (!this.nameField.getText().equals("")) {
                s2 = text2;
            }
        }
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder(this.borderTitle)));
        panel2.add(this.nameField, "Center");
        final JPanel panel3 = panel2;
        final String s = "  .";
        final String value = String.valueOf(this.extension);
        panel3.add(new JLabel((value.length() != 0) ? s.concat(value) : new String(s)), "East");
        final JPanel panel4 = new JPanel(new BorderLayout());
        final JPanel panel5 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel5.add(this.ok);
        panel5.add(this.cancel);
        panel4.add(panel5, "East");
        panel.add(panel2, "North");
        panel.add(panel4, "South");
        this.add(panel, "Center");
        this.pack();
        GuiHelper.centerChildToParent(this.getParent(), this, true);
    }
    
    @Override
    public void dispose() {
        this.ok.removeActionListener(this.buttonListener);
        this.cancel.removeActionListener(this.buttonListener);
        super.dispose();
    }
    
    public String getFileName(final boolean b) {
        final String value = String.valueOf(this.nameField.getText());
        String s2;
        if (b) {
            final String s = ".";
            final String value2 = String.valueOf(this.extension);
            s2 = ((value2.length() != 0) ? s.concat(value2) : new String(s));
        }
        else {
            s2 = "";
        }
        final String value3 = String.valueOf(s2);
        return (value3.length() != 0) ? value.concat(value3) : new String(value);
    }
    
    public boolean isOkPressed() {
        return this.okPressed;
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible) {
            this.ok.addActionListener(this.buttonListener);
            this.cancel.addActionListener(this.buttonListener);
            this.okPressed = false;
        }
        super.setVisible(visible);
    }
}
