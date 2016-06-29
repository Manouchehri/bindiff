package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CCutKeyBehavior extends CAbstractKeyBehavior {
   private IZyEditableObject m_editableObject;
   private boolean m_isAboveComment;
   private boolean m_isBehindComment;
   private boolean m_isLabelComment;

   public CCutKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      this.m_editableObject = var3.getLineObject();
      if(var4 != null) {
         String var5 = var3.getText().substring(var4.getStart(), var4.getEnd());
         this.m_isAboveComment = this.isAboveLineComment(var2);
         this.m_isBehindComment = this.isBehindLineComment(var1, var2);
         this.m_isLabelComment = this.isLabelComment(var2);
         if(this.isComment(var1, var2)) {
            var5 = this.getMultiLineComment(var2);
         }

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), this.m_editableObject, var5, this.isAboveLineComment(var2), this.isBehindLineComment(var1, var2), this.isLabelComment(var2), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

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
      this.deleteSelection();
   }

   protected void updateUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      String var5 = "";
      if(var4 != null) {
         var5 = var3.getText().substring(var4.getStart(), var4.getEnd());
         if(this.isComment(var1, var2)) {
            var5 = this.getMultiLineComment(var2);
         }

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), this.m_editableObject, var5, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }
}
