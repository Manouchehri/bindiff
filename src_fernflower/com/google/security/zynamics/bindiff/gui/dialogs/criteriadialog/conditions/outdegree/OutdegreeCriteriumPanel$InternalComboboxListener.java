package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OutdegreeCriteriumPanel$InternalComboboxListener implements ActionListener {
   // $FF: synthetic field
   final OutdegreeCriteriumPanel this$0;

   private OutdegreeCriteriumPanel$InternalComboboxListener(OutdegreeCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      OutdegreeCriteriumPanel.access$200(this.this$0).update();
   }

   // $FF: synthetic method
   OutdegreeCriteriumPanel$InternalComboboxListener(OutdegreeCriteriumPanel var1, OutdegreeCriteriumPanel$1 var2) {
      this(var1);
   }
}
