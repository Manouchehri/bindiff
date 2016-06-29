package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CCharKeyBehavior extends CAbstractKeyBehavior {
   private int m_caretX;
   private IZyEditableObject m_editableObject = null;
   private boolean m_isLabelComment = false;
   private boolean m_isAboveComment = false;
   private boolean m_isBehindComment = false;
   private boolean m_wasUneditableSelection;

   public CCharKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      this.m_isAboveComment = this.isAboveLineComment(var2);
      this.m_isBehindComment = this.isBehindLineComment(var1, var2);
      this.m_isLabelComment = this.isLabelComment(var2);
      boolean var5 = false;
      if(var1 == var3.getText().length() && !this.isComment(var1, var2)) {
         this.m_isBehindComment = true;
         var5 = true;
         var4 = var3.getLineObject();
      }

      this.m_editableObject = var4;
      String var6 = "";
      if(var4 != null) {
         if(!var5) {
            var6 = var3.getText().substring(var4.getStart(), var4.getEnd());
            if(this.isComment(var1, var2)) {
               var6 = this.getMultiLineComment(var2);
            }
         }

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), var4, var6, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }

   protected void updateCaret() {
      int var1 = this.getCaretMouseReleasedY();
      this.setCaret(this.m_caretX, this.m_caretX, var1, this.m_caretX, this.m_caretX, var1);
   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
      if(this.m_wasUneditableSelection) {
         this.m_caretX = this.getCaretEndPosX();
      } else {
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMouseReleasedY();
         this.m_caretX = var1;
         ZyLineContent var3;
         if(this.isComment(var1, var2)) {
            ++this.m_caretX;
            var3 = this.getLineContent(var2);
            IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
            if(var4 == null || var4.isCommentDelimiter()) {
               return;
            }

            int var5 = var1 - var4.getStart();
            String var6 = var3.getText().substring(var4.getStart(), var4.getEnd());
            String var7 = String.valueOf(this.getEvent().getKeyChar());
            String var8 = String.format("%s%s%s", new Object[]{var6.substring(0, var5), var7, var6.substring(var5)});
            if(this.isComment(var1, var2)) {
               var8 = this.getMultilineComment(var2, var8);
            }

            var4.update(var8);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var4.getPersistentModel());
         } else {
            if(this.isEditable(var1, var2)) {
               throw new RuntimeException("Not implemented yet.");
            }

            var3 = this.getLineContent(var2);
            if(var1 == var3.getText().length() && var3.getLineObject() != null) {
               var3.getLineObject().updateComment(Character.toString(this.getEvent().getKeyChar()), ECommentPlacement.BEHIND_LINE);
               this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var3.getLineObject().getPersistentModel());
               this.m_caretX = this.getLineContent(var2).getText().length();
            }
         }

      }
   }

   protected void updateSelection() {
      this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
      this.deleteSelection();
   }

   protected void updateUndoHistory() {
      if(this.m_editableObject != null) {
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMouseReleasedY();
         ZyLineContent var3 = this.getLineContent(var2);
         IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
         if(var4 != null) {
            String var5 = var3.getText().substring(var4.getStart(), var4.getEnd());
            if(this.isComment(var1, var2)) {
               var5 = this.getMultiLineComment(var2);
            }

            this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), var4, var5, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
         }
      }

   }
}
