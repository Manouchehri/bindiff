package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IndegreeCriteriumPanel$InternalComboboxListener implements ActionListener {
   // $FF: synthetic field
   final IndegreeCriteriumPanel this$0;

   private IndegreeCriteriumPanel$InternalComboboxListener(IndegreeCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      IndegreeCriteriumPanel.access$200(this.this$0).update();
   }

   // $FF: synthetic method
   IndegreeCriteriumPanel$InternalComboboxListener(IndegreeCriteriumPanel var1, IndegreeCriteriumPanel$1 var2) {
      this(var1);
   }
}
