package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class TextCriteriumPanel$InternalTextListener implements KeyListener {
   // $FF: synthetic field
   final TextCriteriumPanel this$0;

   private TextCriteriumPanel$InternalTextListener(TextCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void keyPressed(KeyEvent var1) {
      TextCriteriumPanel.access$100(this.this$0).update();
   }

   public void keyReleased(KeyEvent var1) {
      TextCriteriumPanel.access$100(this.this$0).update();
   }

   public void keyTyped(KeyEvent var1) {
      TextCriteriumPanel.access$100(this.this$0).update();
   }

   // $FF: synthetic method
   TextCriteriumPanel$InternalTextListener(TextCriteriumPanel var1, TextCriteriumPanel$1 var2) {
      this(var1);
   }
}
