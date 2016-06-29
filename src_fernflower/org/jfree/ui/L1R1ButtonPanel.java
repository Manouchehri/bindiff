package org.jfree.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class L1R1ButtonPanel extends JPanel {
   private JButton left;
   private JButton right;

   public L1R1ButtonPanel(String var1, String var2) {
      this.setLayout(new BorderLayout());
      this.left = new JButton(var1);
      this.right = new JButton(var2);
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
