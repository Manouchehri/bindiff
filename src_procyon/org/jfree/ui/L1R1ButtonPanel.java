package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public class L1R1ButtonPanel extends JPanel
{
    private JButton left;
    private JButton right;
    
    public L1R1ButtonPanel(final String s, final String s2) {
        this.setLayout(new BorderLayout());
        this.left = new JButton(s);
        this.right = new JButton(s2);
        this.add(this.left, "West");
        this.add(this.right, "East");
    }
    
    public JButton getLeftButton() {
        return this.left;
    }
    
    public JButton getRightButton() {
        return this.right;
    }
}
