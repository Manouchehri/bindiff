/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayModelExample;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import com.google.security.zynamics.zylib.gui.CodeDisplay.MinimalCodeDisplayHarness$ShowDialog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MinimalCodeDisplayHarness {
    public static /* varargs */ void main(String ... arrstring) {
        MinimalCodeDisplayHarness minimalCodeDisplayHarness = new MinimalCodeDisplayHarness();
        minimalCodeDisplayHarness.buildAndDisplayGui();
    }

    private void buildAndDisplayGui() {
        JFrame jFrame = new JFrame("Test Frame");
        this.buildContent(jFrame);
        jFrame.setDefaultCloseOperation(3);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void buildContent(JFrame jFrame) {
        JPanel jPanel = new JPanel(new BorderLayout());
        CodeDisplayModelExample codeDisplayModelExample = new CodeDisplayModelExample();
        jPanel.add((Component)new CodeDisplay(codeDisplayModelExample), "Center");
        JButton jButton = new JButton("OK");
        jButton.addActionListener(new MinimalCodeDisplayHarness$ShowDialog(jFrame));
        jPanel.add((Component)jButton, "South");
        jFrame.getContentPane().add(jPanel);
    }
}

