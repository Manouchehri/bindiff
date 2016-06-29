package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CReturnKeyBehavior extends CAbstractKeyBehavior {
   private int m_caretY = -1;
   private boolean m_wasUneditableSelection;

   public CReturnKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
      // $FF: Couldn't be decompiled
   }

   protected void updateCaret() {
      if(this.m_caretY > -1 && this.isComment(this.getCaretEndPosX(), this.m_caretY)) {
         ZyLineContent var1 = this.getLineContent(this.m_caretY);
         IZyEditableObject var2 = (IZyEditableObject)var1.getLineFragmentObjectList().get(0);
         int var3 = 0;
         if(var2 != null) {
            var3 = var2.getEnd();
         }

         this.setCaret(var3, var3, this.m_caretY, var3, var3, this.m_caretY);
      }

   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
      // $FF: Couldn't be decompiled
   }

   protected void updateSelection() {
      this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
      this.deleteSelection();
   }

   protected void updateUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      if(var4 != null) {
         String var5 = var3.getText().substring(var4.getStart(), var4.getEnd());
         if(this.isComment(var1, var2)) {
            var5 = this.getMultiLineComment(var2);
         }

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), var4, var5, this.isAboveLineComment(var2), this.isBehindLineComment(var1, var2), this.isLabelComment(var2), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }
}
