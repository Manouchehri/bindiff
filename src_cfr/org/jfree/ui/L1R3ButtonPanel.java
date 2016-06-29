/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;

public class L1R3ButtonPanel
extends JPanel {
    private JButton left;
    private JButton right1;
    private JButton right2;
    private JButton right3;

    public L1R3ButtonPanel(String string, String string2, String string3, String string4) {
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        this.left = new JButton(string);
        this.right1 = new JButton(string2);
        this.right2 = new JButton(string3);
        this.right3 = new JButton(string4);
        jPanel.add((Component)this.left, "West");
        jPanel2.add((Component)this.right1, "East");
        jPanel.add((Component)jPanel2, "Center");
        jPanel.add((Component)this.right2, "East");
        this.add((Component)jPanel, "Center");
        this.add((Component)this.right3, "East");
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

    public JButton getRightButton3() {
        return this.right3;
    }
}

