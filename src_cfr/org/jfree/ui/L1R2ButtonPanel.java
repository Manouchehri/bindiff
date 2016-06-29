/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;

public class L1R2ButtonPanel
extends JPanel {
    private JButton left;
    private JButton right1;
    private JButton right2;

    public L1R2ButtonPanel(String string, String string2, String string3) {
        this.setLayout(new BorderLayout());
        this.left = new JButton(string);
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        this.right1 = new JButton(string2);
        this.right2 = new JButton(string3);
        jPanel.add(this.right1);
        jPanel.add(this.right2);
        this.add((Component)this.left, "West");
        this.add((Component)jPanel, "East");
    }

    public JButton getLeftButton() {
        return this.left;
    }

    public JButton getRightButton1() {
        return this.right1;
    }

    public JButton getRightButton2() {
        return this.right2;
    }
}

