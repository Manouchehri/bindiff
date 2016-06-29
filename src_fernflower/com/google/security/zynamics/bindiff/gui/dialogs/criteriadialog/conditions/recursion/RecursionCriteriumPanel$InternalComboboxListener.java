package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RecursionCriteriumPanel$InternalComboboxListener implements ActionListener {
   // $FF: synthetic field
   final RecursionCriteriumPanel this$0;

   private RecursionCriteriumPanel$InternalComboboxListener(RecursionCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      RecursionCriteriumPanel.access$100(this.this$0).update();
   }

   // $FF: synthetic method
   RecursionCriteriumPanel$InternalComboboxListener(RecursionCriteriumPanel var1, RecursionCriteriumPanel$1 var2) {
      this(var1);
   }
}
