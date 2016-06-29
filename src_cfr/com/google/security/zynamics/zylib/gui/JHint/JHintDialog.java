/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JHintDialog
extends JDialog {
    private static final long serialVersionUID = -6233942484161880642L;

    public JHintDialog(Window window, String string) {
        super(window);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new LineBorder(Color.BLACK));
        JTextArea jTextArea = new JTextArea(string);
        jTextArea.setEditable(false);
        jPanel.add(jTextArea);
        this.add(jPanel);
        this.pack();
    }
}

