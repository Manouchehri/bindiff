package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$ReportAction extends AbstractAction {
   private static final long serialVersionUID = -5953309819908682475L;
   // $FF: synthetic field
   final ErrorDialog this$0;

   private ErrorDialog$ReportAction(ErrorDialog var1) {
      super("Report");
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.report();
   }

   // $FF: synthetic method
   ErrorDialog$ReportAction(ErrorDialog var1, ErrorDialog$1 var2) {
      this(var1);
   }
}
