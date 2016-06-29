package com.google.security.zynamics.zylib.gui.JHint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class JHintDialog extends JDialog {
   private static final long serialVersionUID = -6233942484161880642L;

   public JHintDialog(Window var1, String var2) {
      super(var1);
      this.setResizable(false);
      this.setLayout(new BorderLayout());
      this.setAlwaysOnTop(true);
      this.setUndecorated(true);
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new LineBorder(Color.BLACK));
      JTextArea var4 = new JTextArea(var2);
      var4.setEditable(false);
      var3.add(var4);
      this.add(var3);
      this.pack();
   }
}
