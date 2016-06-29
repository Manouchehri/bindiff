package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public class L1R3ButtonPanel extends JPanel
{
    private JButton left;
    private JButton right1;
    private JButton right2;
    private JButton right3;
    
    public L1R3ButtonPanel(final String s, final String s2, final String s3, final String s4) {
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        this.left = new JButton(s);
        this.right1 = new JButton(s2);
        this.right2 = new JButton(s3);
        this.right3 = new JButton(s4);
        panel.add(this.left, "West");
        panel2.add(this.right1, "East");
        panel.add(panel2, "Center");
        panel.add(this.right2, "East");
        this.add(panel, "Center");
        this.add(this.right3, "East");
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
