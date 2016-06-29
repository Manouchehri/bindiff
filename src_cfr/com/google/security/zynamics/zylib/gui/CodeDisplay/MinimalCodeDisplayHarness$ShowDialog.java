/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

final class MinimalCodeDisplayHarness$ShowDialog
implements ActionListener {
    private JFrame innerFrame;

    MinimalCodeDisplayHarness$ShowDialog(JFrame jFrame) {
        this.innerFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this.innerFrame, "This is a dialog");
    }
}

