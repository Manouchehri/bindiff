package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CStandardProgressDialog$InternalWindowListener extends WindowAdapter {
   // $FF: synthetic field
   final CStandardProgressDialog this$0;

   private CStandardProgressDialog$InternalWindowListener(CStandardProgressDialog var1) {
      this.this$0 = var1;
   }

   public void windowClosed(WindowEvent var1) {
   }

   public void windowClosing(WindowEvent var1) {
      CStandardProgressDialog.access$400(this.this$0).closeRequested();
   }

   // $FF: synthetic method
   CStandardProgressDialog$InternalWindowListener(CStandardProgressDialog var1, CStandardProgressDialog$1 var2) {
      this(var1);
   }
}
