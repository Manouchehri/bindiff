package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CCopyKeyBehavior extends CAbstractKeyBehavior {
   public CCopyKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
   }

   protected void updateClipboard() {
      String var1 = this.getSelectedText();
      ClipboardHelpers.copyToClipboard(var1);
   }

   protected void updateLabelContent() {
   }

   protected void updateSelection() {
   }

   protected void updateUndoHistory() {
   }
}
