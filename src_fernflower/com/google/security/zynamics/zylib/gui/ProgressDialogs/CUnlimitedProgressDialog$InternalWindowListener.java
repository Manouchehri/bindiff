package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$1;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CUnlimitedProgressDialog$InternalWindowListener extends WindowAdapter implements ActionListener {
   // $FF: synthetic field
   final CUnlimitedProgressDialog this$0;

   private CUnlimitedProgressDialog$InternalWindowListener(CUnlimitedProgressDialog var1) {
      this.this$0 = var1;
   }

   private void cancel() {
      try {
         if(CUnlimitedProgressDialog.access$600(this.this$0)) {
            this.this$0.setDescription("Canceling...");
            ((ICancelableCommand)CUnlimitedProgressDialog.access$100(this.this$0)).cancel();
         }
      } catch (Exception var2) {
         CUnlimitedProgressDialog.access$200(this.this$0, var2);
      }

   }

   public void actionPerformed(ActionEvent var1) {
      this.cancel();
   }

   public void windowClosing(WindowEvent var1) {
      this.cancel();
   }

   // $FF: synthetic method
   CUnlimitedProgressDialog$InternalWindowListener(CUnlimitedProgressDialog var1, CUnlimitedProgressDialog$1 var2) {
      this(var1);
   }
}
