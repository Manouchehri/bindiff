package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import java.util.List;

public class CBackspaceKeyBehavior extends CAbstractKeyBehavior {
   private int m_caretX;
   private int m_caretY;
   private boolean m_wasSelection = false;
   private boolean m_isBehindComment = false;
   private boolean m_isAboveComment = false;
   private boolean m_isLabelComment = false;
   private IZyEditableObject m_editableObject = null;
   private IZyEditableObject m_lineModel = null;
   private boolean m_wasEditablePosition = false;

   public CBackspaceKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   private void handleLineComments() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      if(this.m_editableObject != null) {
         int var4 = this.getLabelContent().getFirstLineIndexOfModelAt(var2);
         int var5 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var2);
         int var6 = var5 != -1 && this.m_isBehindComment?var5:var4;
         String var7 = var3.getText();
         String var8 = "";
         if(!this.isCommentDelimiter(var1, var2)) {
            if(var7.length() > 0 && var7.length() == this.m_editableObject.getEnd() && var1 == var7.length()) {
               char var9 = var7.charAt(var7.length() - 1);
               if(var9 == 10 || var9 == 13) {
                  var1 = -1;
               }
            }

            var8 = String.format("%s%s", new Object[]{var7.substring(this.m_editableObject.getStart(), var1 - 1), var7.substring(var1, this.m_editableObject.getEnd())});
            this.m_caretY = var2;
            this.m_caretX = var1 - 1;
            var8 = this.getMultilineComment(this.m_caretY, var8);
         } else {
            List var13 = var3.getLineFragmentObjectList();
            this.m_editableObject = (IZyEditableObject)var13.get(var13.size() - 1);
            ZyLineContent var10;
            if(var6 == var2) {
               if(this.m_editableObject.getLength() != 1) {
                  this.m_caretX = this.getCaretEndPosX();
                  this.m_caretY = this.getCaretMouseReleasedY();
                  return;
               }

               if(var2 > 0) {
                  this.m_caretY = var2 - 1;
                  var10 = this.getLineContent(this.m_caretY);
                  this.m_caretX = var10.getText().length();
               }

               var8 = this.getMultilineComment(var2, var8);
            } else {
               var10 = this.getLineContent(var2 - 1);
               String var11 = var10.getText();
               if(!var11.isEmpty() && !var10.getLineObject().isPlaceholder()) {
                  IZyEditableObject var12 = var10.getLineFragmentObjectAt(var11.length() - 1);
                  var8 = var11.substring(var12.getStart(), var12.getEnd() - 1);
                  this.m_caretY = var2 - 1;
                  this.m_caretX = var11.length() - 1;
                  var8 = this.getMultilineComment(this.m_caretY, var8);
               } else {
                  this.m_caretY = var2 - 1;
                  this.m_caretX = 0;
               }
            }
         }

         if(var8.endsWith("\n")) {
            var8 = String.valueOf(var8.substring(0, var8.length() - 1)).concat("\r");
         }

         if(this.m_isAboveComment) {
            this.m_editableObject.updateComment(var8, ECommentPlacement.ABOVE_LINE);
         } else if(this.m_isBehindComment) {
            this.m_editableObject.updateComment(var8, ECommentPlacement.BEHIND_LINE);
         } else if(this.m_isLabelComment) {
            this.m_editableObject.update(var8);
         }

         this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.m_editableObject.getPersistentModel());
      }
   }

   private void handleTextFragment() {
      throw new RuntimeException("Not implemneted yet");
   }

   private boolean isCommentDelimiter(int var1, int var2) {
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      IZyEditableObject var5 = var1 > 0?var3.getLineFragmentObjectAt(var1 - 1):null;
      return var4 != null && var4.isCommentDelimiter() || var5 != null && var5.isCommentDelimiter();
   }

   protected void initUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      this.m_editableObject = var3.getLineFragmentObjectAt(var1);
      this.m_lineModel = var3.getLineObject();
      if(this.m_editableObject != null) {
         this.m_wasEditablePosition = true;
         String var4 = var3.getText().substring(this.m_editableObject.getStart(), this.m_editableObject.getEnd());
         this.m_isAboveComment = this.isAboveLineComment(var2);
         this.m_isBehindComment = this.isBehindLineComment(var1, var2);
         this.m_isLabelComment = this.isLabelComment(var2);
         if(this.isComment(var1, var2)) {
            var4 = this.getMultiLineComment(var2);
         }

         this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_editableObject, var4, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }

   protected void updateCaret() {
      this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
      this.m_wasSelection = false;
   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
      this.m_caretX = this.getCaretEndPosX();
      this.m_caretY = this.getCaretMouseReleasedY();
      if(!this.m_wasSelection) {
         if(this.isComment(this.m_caretX, this.m_caretY)) {
            this.handleLineComments();
         } else if(this.getLineContent(this.m_caretY).getLineFragmentObjectAt(this.m_caretX) != null) {
            this.handleTextFragment();
         }
      }

   }

   protected void updateSelection() {
      this.m_wasSelection = this.isSelection();
      this.deleteSelection();
   }

   protected void updateUndoHistory() {
      if(this.m_wasEditablePosition) {
         this.m_wasEditablePosition = false;
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMouseReleasedY();
         ZyLineContent var3 = this.getLineContent(var2);
         String var4 = "";
         if(var3 != null && var3.getLineObject() != null && this.m_lineModel.getPersistentModel() == var3.getLineObject().getPersistentModel()) {
            if(this.isComment(var1, var2)) {
               var4 = this.getMultiLineComment(var2);
            }
         } else if(!this.m_isLabelComment) {
            byte var5 = 0;
            if(var2 + 1 < this.getLabelContent().getLineCount()) {
               var5 = 1;
               var3 = this.getLineContent(var2 + var5);
            }

            if(this.m_lineModel.getPersistentModel() != var3.getLineObject().getPersistentModel() && var2 > 0) {
               var5 = -1;
               this.getLineContent(var2 + var5);
            }

            int var10000 = var2 + var5;
         }

         this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_lineModel, var4, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }
   }
}
