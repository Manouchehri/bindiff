package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

final class MinimalCodeDisplayHarness$ShowDialog implements ActionListener {
   private JFrame innerFrame;

   MinimalCodeDisplayHarness$ShowDialog(JFrame var1) {
      this.innerFrame = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JOptionPane.showMessageDialog(this.innerFrame, "This is a dialog");
   }
}
