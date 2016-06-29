package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CriteriaDialog$InternalOkCancelButttonListener implements ActionListener {
   // $FF: synthetic field
   final CriteriaDialog this$0;

   private CriteriaDialog$InternalOkCancelButttonListener(CriteriaDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      CriteriaDialog.access$102(this.this$0, var1.getActionCommand().equals("Execute"));
      this.this$0.dispose();
   }

   // $FF: synthetic method
   CriteriaDialog$InternalOkCancelButttonListener(CriteriaDialog var1, CriteriaDialog$1 var2) {
      this(var1);
   }
}
