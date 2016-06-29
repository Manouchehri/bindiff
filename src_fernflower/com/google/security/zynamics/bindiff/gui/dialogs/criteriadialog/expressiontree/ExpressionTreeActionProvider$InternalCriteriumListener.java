package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$1;

class ExpressionTreeActionProvider$InternalCriteriumListener implements ICriteriumListener {
   // $FF: synthetic field
   final ExpressionTreeActionProvider this$0;

   private ExpressionTreeActionProvider$InternalCriteriumListener(ExpressionTreeActionProvider var1) {
      this.this$0 = var1;
   }

   public void criteriumChanged() {
      ExpressionTreeActionProvider.access$100(this.this$0).updateUI();
   }

   // $FF: synthetic method
   ExpressionTreeActionProvider$InternalCriteriumListener(ExpressionTreeActionProvider var1, ExpressionTreeActionProvider$1 var2) {
      this(var1);
   }
}
