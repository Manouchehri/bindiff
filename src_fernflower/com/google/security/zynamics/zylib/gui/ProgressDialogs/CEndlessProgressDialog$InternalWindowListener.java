package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CEndlessProgressDialog$InternalWindowListener extends WindowAdapter {
   // $FF: synthetic field
   final CEndlessProgressDialog this$0;

   private CEndlessProgressDialog$InternalWindowListener(CEndlessProgressDialog var1) {
      this.this$0 = var1;
   }

   public void windowClosed(WindowEvent var1) {
      CEndlessProgressDialog.access$400(this.this$0).stop();
   }

   public void windowClosing(WindowEvent var1) {
      CEndlessProgressDialog.access$300(this.this$0).closeRequested();
   }

   // $FF: synthetic method
   CEndlessProgressDialog$InternalWindowListener(CEndlessProgressDialog var1, CEndlessProgressDialog$1 var2) {
      this(var1);
   }
}
