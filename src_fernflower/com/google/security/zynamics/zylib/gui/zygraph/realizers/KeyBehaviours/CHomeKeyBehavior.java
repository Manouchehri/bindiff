package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CHomeKeyBehavior extends CAbstractKeyBehavior {
   public CHomeKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
      if(!this.isShiftPressed() && !this.isCtrlPressed()) {
         this.setCaret(0, 0, this.getCaretMousePressedY(), 0, 0, this.getCaretMouseReleasedY());
      } else if(this.isShiftPressed() && !this.isCtrlPressed()) {
         this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), 0, 0, this.getCaretMouseReleasedY());
      } else if(!this.isShiftPressed() && this.isCtrlPressed()) {
         this.setCaret(0, 0, 0, 0, 0, 0);
      } else if(this.isShiftPressed() && this.isCtrlPressed()) {
         this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), 0, 0, 0);
      }

   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
   }

   protected void updateSelection() {
   }

   protected void updateUndoHistory() {
   }
}
