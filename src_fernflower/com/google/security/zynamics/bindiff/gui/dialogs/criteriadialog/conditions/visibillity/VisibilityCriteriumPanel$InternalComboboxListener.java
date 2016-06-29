package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VisibilityCriteriumPanel$InternalComboboxListener implements ActionListener {
   // $FF: synthetic field
   final VisibilityCriteriumPanel this$0;

   private VisibilityCriteriumPanel$InternalComboboxListener(VisibilityCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      VisibilityCriteriumPanel.access$100(this.this$0).update();
   }

   // $FF: synthetic method
   VisibilityCriteriumPanel$InternalComboboxListener(VisibilityCriteriumPanel var1, VisibilityCriteriumPanel$1 var2) {
      this(var1);
   }
}
