package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class L1R2ButtonPanel extends JPanel {
   private JButton left;
   private JButton right1;
   private JButton right2;

   public L1R2ButtonPanel(String var1, String var2, String var3) {
      this.setLayout(new BorderLayout());
      this.left = new JButton(var1);
      JPanel var4 = new JPanel(new GridLayout(1, 2));
      this.right1 = new JButton(var2);
      this.right2 = new JButton(var3);
      var4.add(this.right1);
      var4.add(this.right2);
      this.add(this.left, "West");
      this.add(var4, "East");
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
