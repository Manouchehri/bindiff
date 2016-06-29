package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CDialogEscaper$1;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

public class CDialogEscaper {
   public CDialogEscaper(JDialog var1) {
      Preconditions.checkNotNull(var1, "Error: dialog argument can not be null");
      var1.getRootPane().registerKeyboardAction(new CDialogEscaper$1(this, var1), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
   }
}
