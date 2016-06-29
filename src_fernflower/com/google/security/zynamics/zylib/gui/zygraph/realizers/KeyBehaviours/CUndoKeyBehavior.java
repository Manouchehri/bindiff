package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CUndoKeyBehavior extends CAbstractKeyBehavior {
   public CUndoKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
      this.undo();
   }

   protected void updateSelection() {
   }

   protected void updateUndoHistory() {
   }
}
