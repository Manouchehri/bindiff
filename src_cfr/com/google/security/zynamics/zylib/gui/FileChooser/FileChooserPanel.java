/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.FileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class FileChooserPanel
extends JPanel {
    private final JTextField inputField;
    private final JButton browseButton;

    public FileChooserPanel(String string, ActionListener actionListener) {
        this(string, actionListener, "...", 0, 0, 0);
    }

    public FileChooserPanel(String string, ActionListener actionListener, String string2) {
        this(string, actionListener, string2, 0, 0, 0);
    }

    public FileChooserPanel(String string, ActionListener actionListener, String string2, int n2, int n3, int n4) {
        super(new BorderLayout());
        this.setBorder(new LineBorder(Color.GRAY));
        this.inputField = new JTextField(string);
        this.inputField.setEditable(false);
        if (n2 > 0 || n3 > 0) {
            this.setPreferredSize(new Dimension(n2, n3));
        }
        JPanel jPanel = new JPanel(new BorderLayout());
        this.browseButton = new JButton(string2);
        this.browseButton.setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
        Dimension dimension = this.browseButton.getPreferredSize();
        this.browseButton.setPreferredSize(new Dimension(dimension.width + 15, dimension.height));
        if (n4 > 0) {
            this.browseButton.setPreferredSize(new Dimension(n4, n3));
        }
        jPanel.add((Component)this.browseButton, "Center");
        this.browseButton.setFocusable(false);
        this.add((Component)this.inputField, "Center");
        this.add((Component)jPanel, "East");
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
    public void setEnabled(boolean bl2) {
        this.browseButton.setEnabled(bl2);
        super.setEnabled(bl2);
    }

    public void setText(String string) {
        this.inputField.setText(string);
    }
}

