package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;

class CStandardProgressDialog$InternalListener implements IStandardProgressListener {
   // $FF: synthetic field
   final CStandardProgressDialog this$0;

   private CStandardProgressDialog$InternalListener(CStandardProgressDialog var1) {
      this.this$0 = var1;
   }

   public void changedDescription(String var1) {
      this.this$0.setSubDescription(var1);
   }

   public void changedMaximum(int var1) {
      CStandardProgressDialog.access$200(this.this$0).setMaximum(var1);
   }

   public void finished() {
      CStandardProgressDialog.access$302(this.this$0, true);
      CStandardProgressDialog.access$400(this.this$0).removeProgressListener(this);
      this.this$0.dispose();
   }

   public void next() {
      CStandardProgressDialog.access$200(this.this$0).next();
   }

   public void reset() {
      CStandardProgressDialog.access$200(this.this$0).reset();
   }

   // $FF: synthetic method
   CStandardProgressDialog$InternalListener(CStandardProgressDialog var1, CStandardProgressDialog$1 var2) {
      this(var1);
   }
}
