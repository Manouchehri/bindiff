package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public class L1R2ButtonPanel extends JPanel
{
    private JButton left;
    private JButton right1;
    private JButton right2;
    
    public L1R2ButtonPanel(final String s, final String s2, final String s3) {
        this.setLayout(new BorderLayout());
        this.left = new JButton(s);
        final JPanel panel = new JPanel(new GridLayout(1, 2));
        this.right1 = new JButton(s2);
        this.right2 = new JButton(s3);
        panel.add(this.right1);
        panel.add(this.right2);
        this.add(this.left, "West");
        this.add(panel, "East");
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
