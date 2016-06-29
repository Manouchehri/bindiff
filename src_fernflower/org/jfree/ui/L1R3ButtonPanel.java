package org.jfree.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class L1R3ButtonPanel extends JPanel {
   private JButton left;
   private JButton right1;
   private JButton right2;
   private JButton right3;

   public L1R3ButtonPanel(String var1, String var2, String var3, String var4) {
      this.setLayout(new BorderLayout());
      JPanel var5 = new JPanel(new BorderLayout());
      JPanel var6 = new JPanel(new BorderLayout());
      this.left = new JButton(var1);
      this.right1 = new JButton(var2);
      this.right2 = new JButton(var3);
      this.right3 = new JButton(var4);
      var5.add(this.left, "West");
      var6.add(this.right1, "East");
      var5.add(var6, "Center");
      var5.add(this.right2, "East");
      this.add(var5, "Center");
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
