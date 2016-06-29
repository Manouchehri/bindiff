package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;

class CEndlessProgressDialog$InternalListener implements IEndlessProgressListener {
   // $FF: synthetic field
   final CEndlessProgressDialog this$0;

   private CEndlessProgressDialog$InternalListener(CEndlessProgressDialog var1) {
      this.this$0 = var1;
   }

   public void changedDescription(String var1) {
      this.this$0.setSubDescription(var1);
   }

   public void changedGeneralDescription(String var1) {
      this.this$0.setDescription(var1);
   }

   public void finished() {
      CEndlessProgressDialog.access$202(this.this$0, true);
      CEndlessProgressDialog.access$300(this.this$0).removeProgressListener(this);
      this.this$0.dispose();
   }

   // $FF: synthetic method
   CEndlessProgressDialog$InternalListener(CEndlessProgressDialog var1, CEndlessProgressDialog$1 var2) {
      this(var1);
   }
}
