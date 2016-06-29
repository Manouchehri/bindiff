package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

final class MinimalCodeDisplayHarness$ShowDialog implements ActionListener
{
    private JFrame innerFrame;
    
    MinimalCodeDisplayHarness$ShowDialog(final JFrame innerFrame) {
        this.innerFrame = innerFrame;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this.innerFrame, "This is a dialog");
    }
}
