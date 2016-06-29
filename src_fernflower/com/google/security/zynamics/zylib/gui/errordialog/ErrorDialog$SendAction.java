package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$SendAction extends AbstractAction {
   private static final long serialVersionUID = -6488875605584243902L;
   // $FF: synthetic field
   final ErrorDialog this$0;

   private ErrorDialog$SendAction(ErrorDialog var1) {
      super("Send");
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.send(ErrorDialog.access$300(this.this$0), ErrorDialog.access$400(this.this$0), ErrorDialog.access$500(this.this$0));
   }

   // $FF: synthetic method
   ErrorDialog$SendAction(ErrorDialog var1, ErrorDialog$1 var2) {
      this(var1);
   }
}
