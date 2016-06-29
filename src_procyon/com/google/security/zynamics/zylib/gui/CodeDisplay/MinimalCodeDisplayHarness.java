package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public final class MinimalCodeDisplayHarness
{
    public static void main(final String... array) {
        new MinimalCodeDisplayHarness().buildAndDisplayGui();
    }
    
    private void buildAndDisplayGui() {
        final JFrame frame = new JFrame("Test Frame");
        this.buildContent(frame);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void buildContent(final JFrame frame) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new CodeDisplay(new CodeDisplayModelExample()), "Center");
        final JButton button = new JButton("OK");
        button.addActionListener(new MinimalCodeDisplayHarness$ShowDialog(frame));
        panel.add(button, "South");
        frame.getContentPane().add(panel);
    }
}
