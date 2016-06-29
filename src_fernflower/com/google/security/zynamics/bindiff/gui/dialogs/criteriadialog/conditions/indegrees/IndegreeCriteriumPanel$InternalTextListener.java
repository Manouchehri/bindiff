package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class IndegreeCriteriumPanel$InternalTextListener implements KeyListener {
   // $FF: synthetic field
   final IndegreeCriteriumPanel this$0;

   private IndegreeCriteriumPanel$InternalTextListener(IndegreeCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void keyPressed(KeyEvent var1) {
      IndegreeCriteriumPanel.access$200(this.this$0).update();
   }

   public void keyReleased(KeyEvent var1) {
      IndegreeCriteriumPanel.access$200(this.this$0).update();
   }

   public void keyTyped(KeyEvent var1) {
      IndegreeCriteriumPanel.access$200(this.this$0).update();
   }

   // $FF: synthetic method
   IndegreeCriteriumPanel$InternalTextListener(IndegreeCriteriumPanel var1, IndegreeCriteriumPanel$1 var2) {
      this(var1);
   }
}
