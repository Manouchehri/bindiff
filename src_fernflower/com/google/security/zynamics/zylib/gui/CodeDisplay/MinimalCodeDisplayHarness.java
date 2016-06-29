package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayModelExample;
import com.google.security.zynamics.zylib.gui.CodeDisplay.MinimalCodeDisplayHarness$ShowDialog;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MinimalCodeDisplayHarness {
   public static void main(String... var0) {
      MinimalCodeDisplayHarness var1 = new MinimalCodeDisplayHarness();
      var1.buildAndDisplayGui();
   }

   private void buildAndDisplayGui() {
      JFrame var1 = new JFrame("Test Frame");
      this.buildContent(var1);
      var1.setDefaultCloseOperation(3);
      var1.pack();
      var1.setVisible(true);
   }

   private void buildContent(JFrame var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      CodeDisplayModelExample var3 = new CodeDisplayModelExample();
      var2.add(new CodeDisplay(var3), "Center");
      JButton var4 = new JButton("OK");
      var4.addActionListener(new MinimalCodeDisplayHarness$ShowDialog(var1));
      var2.add(var4, "South");
      var1.getContentPane().add(var2);
   }
}
