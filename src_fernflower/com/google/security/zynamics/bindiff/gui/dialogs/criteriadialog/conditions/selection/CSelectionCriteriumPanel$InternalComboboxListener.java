package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CSelectionCriteriumPanel$InternalComboboxListener implements ActionListener {
   // $FF: synthetic field
   final CSelectionCriteriumPanel this$0;

   private CSelectionCriteriumPanel$InternalComboboxListener(CSelectionCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      CSelectionCriteriumPanel.access$100(this.this$0).update();
   }

   // $FF: synthetic method
   CSelectionCriteriumPanel$InternalComboboxListener(CSelectionCriteriumPanel var1, CSelectionCriteriumPanel$1 var2) {
      this(var1);
   }
}
