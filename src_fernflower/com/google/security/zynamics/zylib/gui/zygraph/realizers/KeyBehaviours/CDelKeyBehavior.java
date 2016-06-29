package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import java.awt.Point;

public class CDelKeyBehavior extends CAbstractKeyBehavior {
   private boolean m_wasSelection = false;
   private IZyEditableObject m_editableObject;
   private boolean m_isAboveComment;
   private boolean m_isBehindComment;
   private boolean m_isLabelComment;

   public CDelKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   private Point getMultiCommentEndPoint(int var1, int var2) {
      if(!this.isComment(var1, var2)) {
         return null;
      } else {
         ZyLineContent var3 = this.getLineContent(var2);
         int var4 = ((IZyEditableObject)var3.getLineFragmentObjectList().get(var3.getLineFragmentObjectList().size() - 1)).getEnd();
         int var5 = var2;

         for(int var6 = var2 + 1; var6 <= this.getLabelContent().getLastLineIndexOfModelAt(var2); ++var6) {
            ZyLineContent var7 = this.getLineContent(var6);
            int var8 = var7.getLineFragmentObjectList().size();
            IZyEditableObject var9 = var7.getLineFragmentObjectAt(0);
            if(var9 == null) {
               break;
            }

            if(var9.isCommentDelimiter()) {
               var4 = var7.getLineFragmentObjectAt(var8 - 1).getEnd();
               var5 = var6;
            }
         }

         return new Point(var4, var5);
      }
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

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), this.m_editableObject, var5, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }

   protected void updateCaret() {
      this.m_wasSelection = false;
   }

   protected void updateClipboard() {
      if(this.isShiftPressed() && !this.isCtrlPressed() && !this.isAltPressed()) {
         String var1 = this.getSelectedText();
         ClipboardHelpers.copyToClipboard(var1);
      }

   }

   protected void updateLabelContent() {
      if(!this.m_wasSelection) {
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMouseReleasedY();
         ZyLineContent var3 = this.getLineContent(var2);
         IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
         if(var4 != null) {
            if(this.isComment(var1, var2)) {
               if(!var4.isCommentDelimiter()) {
                  Point var5 = this.getMultiCommentEndPoint(var1, var2);
                  if(var2 != var5.y || var1 != var5.x && (var1 != var5.x - 1 || !var3.getText().endsWith("\n"))) {
                     int var6 = var1 - var4.getStart();
                     String var7 = var3.getText().substring(var4.getStart(), var4.getEnd());
                     String var8 = var7;
                     if(var6 < var7.length()) {
                        var8 = String.format("%s%s", new Object[]{var7.substring(0, var6), var7.substring(var6 + 1)});
                     } else if(this.isComment(var1, var2) && var2 < this.getLabelContent().getLineCount() - 1) {
                        ZyLineContent var9 = this.getLineContent(var2 + 1);
                        if(var9.getLineObject() == var3.getLineObject()) {
                           IZyEditableObject var10 = var9.getLineFragmentObjectAt(0);
                           if(var10 != null && var10.isCommentDelimiter()) {
                              var8 = var7.substring(0, var6 - 1);
                           }
                        }
                     }

                     if(this.isComment(var1, var2)) {
                        var8 = this.getMultilineComment(var2, var8);
                        if(!var8.endsWith("\r")) {
                           var8 = String.valueOf(var8).concat("\r");
                        }
                     }

                     var4.update(var8);
                     if(this.isLabelComment(var2)) {
                        var3.getLineObject().update(var8);
                     } else if(this.isAboveLineComment(var2)) {
                        var3.getLineObject().updateComment(var8, ECommentPlacement.ABOVE_LINE);
                     } else if(this.isBehindLineComment(var1, var2)) {
                        var3.getLineObject().updateComment(var8, ECommentPlacement.BEHIND_LINE);
                     }

                     this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var3.getLineObject().getPersistentModel());
                  }
               }
            } else {
               throw new RuntimeException("Not implemented yet.");
            }
         }
      }
   }

   protected void updateSelection() {
      this.m_wasSelection = this.isSelection();
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
