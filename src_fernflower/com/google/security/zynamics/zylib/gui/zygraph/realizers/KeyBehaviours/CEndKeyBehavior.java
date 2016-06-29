package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CEndKeyBehavior extends CAbstractKeyBehavior {
   public CEndKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
      int var1;
      int var2;
      if(!this.isShiftPressed() && !this.isCtrlPressed()) {
         var1 = this.getCaretMouseReleasedY();
         var2 = this.getLastLineXPos(var1);
         this.setCaret(var2, var2, var1, var2, var2, var1);
      } else {
         int var3;
         if(this.isShiftPressed() && !this.isCtrlPressed()) {
            var1 = this.getCaretMouseReleasedY();
            var2 = this.getLineContent(var1).getTextLayout().getCharacterCount();
            var3 = var2;
            ZyLineContent var4 = this.getLineContent(this.getCaretMouseReleasedY());
            boolean var5 = this.getCaretEndPosX() == var4.getText().length();
            boolean var6 = var4.getText().endsWith("\n") && this.getCaretEndPosX() == var4.getText().length() - 1;
            boolean var7 = var4.getText().endsWith("\r") && this.getCaretEndPosX() == var4.getText().length() - 1;
            if(var5 || var6 || var7) {
               var3 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            }

            if((var4.getText().endsWith("\n") || var4.getText().endsWith("\r")) && var3 > 0) {
               --var3;
            }

            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), var2, var3, var1);
         } else if(!this.isShiftPressed() && this.isCtrlPressed()) {
            ZyLabelContent var8 = this.getLabelContent();
            var2 = var8.getLineContent(var8.getLineCount() - 1).getText().length();
            var3 = var8.getLineCount() - 1;
            this.setCaret(var2, var2, var3, var2, var2, var3);
         } else if(this.isShiftPressed() && this.isCtrlPressed()) {
            var1 = this.getLabelContent().getLineCount() - 1;
            var2 = this.getLabelContent().getLineContent(var1).getText().length();
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), var2, var2, var1);
         }
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
