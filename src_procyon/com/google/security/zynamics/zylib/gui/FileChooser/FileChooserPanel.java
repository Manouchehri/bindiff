package com.google.security.zynamics.zylib.gui.FileChooser;

import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

public class FileChooserPanel extends JPanel
{
    private final JTextField inputField;
    private final JButton browseButton;
    
    public FileChooserPanel(final String s, final ActionListener actionListener) {
        this(s, actionListener, "...", 0, 0, 0);
    }
    
    public FileChooserPanel(final String s, final ActionListener actionListener, final String s2) {
        this(s, actionListener, s2, 0, 0, 0);
    }
    
    public FileChooserPanel(final String s, final ActionListener actionListener, final String s2, final int n, final int n2, final int n3) {
        super(new BorderLayout());
        this.setBorder(new LineBorder(Color.GRAY));
        (this.inputField = new JTextField(s)).setEditable(false);
        if (n > 0 || n2 > 0) {
            this.setPreferredSize(new Dimension(n, n2));
        }
        final JPanel panel = new JPanel(new BorderLayout());
        (this.browseButton = new JButton(s2)).setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
        final Dimension preferredSize = this.browseButton.getPreferredSize();
        this.browseButton.setPreferredSize(new Dimension(preferredSize.width + 15, preferredSize.height));
        if (n3 > 0) {
            this.browseButton.setPreferredSize(new Dimension(n3, n2));
        }
        panel.add(this.browseButton, "Center");
        this.browseButton.setFocusable(false);
        this.add(this.inputField, "Center");
        this.add(panel, "East");
        this.browseButton.addActionListener(actionListener);
        ToolTipManager.sharedInstance().registerComponent(this.inputField);
        this.inputField.setToolTipText(this.getText());
    }
    
    public JButton getButton() {
        return this.browseButton;
    }
    
    public String getText() {
        return this.inputField.getText();
    }
    
    @Override
    public void setEnabled(final boolean b) {
        this.browseButton.setEnabled(b);
        super.setEnabled(b);
    }
    
    public void setText(final String text) {
        this.inputField.setText(text);
    }
}
