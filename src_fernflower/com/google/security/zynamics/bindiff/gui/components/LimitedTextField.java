package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.zylib.gui.textfields.JTextFieldLimit;
import javax.swing.JTextPane;

public class LimitedTextField extends JTextPane {
   public LimitedTextField(String var1) {
      super(new JTextFieldLimit(30000));
      this.setText(var1);
   }
}
