package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class OutdegreeCriteriumPanel$InternalTextListener implements KeyListener {
   // $FF: synthetic field
   final OutdegreeCriteriumPanel this$0;

   private OutdegreeCriteriumPanel$InternalTextListener(OutdegreeCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void keyPressed(KeyEvent var1) {
      OutdegreeCriteriumPanel.access$200(this.this$0).update();
   }

   public void keyReleased(KeyEvent var1) {
      OutdegreeCriteriumPanel.access$200(this.this$0).update();
   }

   public void keyTyped(KeyEvent var1) {
      OutdegreeCriteriumPanel.access$200(this.this$0).update();
   }

   // $FF: synthetic method
   OutdegreeCriteriumPanel$InternalTextListener(OutdegreeCriteriumPanel var1, OutdegreeCriteriumPanel$1 var2) {
      this(var1);
   }
}
