package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$CloseButtonListener extends AbstractAction {
   private static final long serialVersionUID = 2709310936594698502L;
   // $FF: synthetic field
   final ErrorDialog this$0;

   private ErrorDialog$CloseButtonListener(ErrorDialog var1) {
      super("Close");
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.dispose();
   }

   // $FF: synthetic method
   ErrorDialog$CloseButtonListener(ErrorDialog var1, ErrorDialog$1 var2) {
      this(var1);
   }
}
