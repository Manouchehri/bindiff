package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.strings.StringHelper;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public abstract class CAbstractKeyBehavior {
   private ZyLabelContent m_labelContent = null;
   private final CUndoManager m_undoManager;
   private KeyEvent m_event = null;
   private boolean m_alt;
   private boolean m_ctrl;
   private boolean m_shift;

   public CAbstractKeyBehavior(CUndoManager var1) {
      this.m_undoManager = (CUndoManager)Preconditions.checkNotNull(var1, "Error: Undo manager can\'t be null.");
   }

   private ZyCaret getCaret() {
      return this.m_labelContent.getCaret();
   }

   private String getSingleLineCommentText(ZyLineContent var1) {
      StringBuilder var2 = new StringBuilder();
      String var3 = var1.getText();
      boolean var4 = false;
      Iterator var5 = var1.getLineFragmentObjectList().iterator();

      while(var5.hasNext()) {
         IZyEditableObject var6 = (IZyEditableObject)var5.next();
         if(var6.isCommentDelimiter()) {
            var4 = true;
         } else if(var4) {
            String var7 = var3.substring(var6.getStart(), var6.getEnd());
            var2.append(var7);
         }
      }

      return var2.toString();
   }

   private void setModifier(KeyEvent var1) {
      this.m_ctrl = false;
      this.m_shift = false;
      this.m_alt = false;
      if(var1.getModifiersEx() == 192) {
         this.m_ctrl = true;
         this.m_shift = true;
      } else if(var1.getModifiersEx() == 640) {
         this.m_ctrl = true;
         this.m_alt = true;
      } else if(var1.getModifiersEx() == 576) {
         this.m_alt = true;
         this.m_shift = true;
      } else if(var1.isAltDown()) {
         this.m_alt = true;
      } else if(var1.isControlDown()) {
         this.m_ctrl = true;
      } else if(var1.isShiftDown()) {
         this.m_shift = true;
      }

   }

   private void updateLabelSize() {
      ZyLabelContent var1 = this.getLabelContent();
      IZyEditableObject var2 = var1.getModel();
      var1.getLineEditor().recreateLabelLines(var1, var2);
   }

   protected int correctMouseReleasedX(int var1, int var2, int var3) {
      int var4 = this.getLastLineXPos(var2);
      return var1 > var4 && var2 == var3?var4:var1;
   }

   protected void deleteSelection() {
      if(this.isSelection() && this.isDeleteableSelection()) {
         int var1 = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
         int var2 = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
         int var3 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
         int var4 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
         int var5 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
         int var6 = this.m_labelContent.getFirstLineIndexOfModelAt(var3);
         int var7 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(var3);
         int var8 = this.m_labelContent.getLastLineIndexOfModelAt(var3);
         int var9 = var6;
         int var10 = var8;
         if(var7 != -1) {
            if(var3 < var7) {
               var10 = var7 - 1;
            } else {
               var9 = var7;
            }
         }

         StringBuilder var11 = new StringBuilder();
         ZyLineContent var12 = this.getLineContent(var3);
         IZyEditableObject var13 = var12.getLineFragmentObjectAt(var1);
         int var14;
         ZyLineContent var15;
         if(var13 == null) {
            for(var14 = var9; var14 <= var10; ++var14) {
               var15 = this.getLineContent(var14);
               var13 = var15.getLineFragmentObjectAt(var1);
               if(var13 != null) {
                  break;
               }
            }
         }

         if(var9 == var10 && !this.isComment(var5, var3)) {
            if(var13.isCommentDelimiter()) {
               var1 = var13.getEnd();
               var5 = var13.getEnd();
               var13 = var12.getLineFragmentObjectAt(var5);
            }

            String var22 = var12.getText();
            var11 = new StringBuilder(String.format("%s%s", new Object[]{var22.substring(var13.getStart(), var1), var22.substring(var2)}));
         } else {
            for(var14 = var9; var14 <= var10; ++var14) {
               var15 = this.getLineContent(var14);
               IZyEditableObject var16 = var15.getLineFragmentObjectAt(var1);
               if(var16 == null) {
                  var16 = var15.getLineFragmentObjectAt(this.getLastLineXPos(var14));
               }

               int var17 = var1;
               int var18 = var2;
               if(var16.isCommentDelimiter()) {
                  var16 = var15.getLineFragmentObjectAt(var16.getEnd());
                  var17 = var16.getStart();
                  if(var2 < var17) {
                     var18 = var17;
                  }
               }

               String var19 = var15.getText();
               int var20 = Math.min(var19.length(), var18);
               if(var14 >= var3 && var14 <= var4 && var19.length() > var17) {
                  String var21 = String.format("%s%s", new Object[]{var19.substring(var16.getStart(), var17), var19.substring(var20)});
                  if(!var21.equals("\n") && !var21.equals("\r")) {
                     var11.append(var21);
                  }
               } else {
                  var11.append(var15.getText(var16));
               }
            }
         }

         if(var11.toString().endsWith("\n")) {
            var11 = new StringBuilder(var11.substring(0, var11.length() - 1));
         }

         if(!var11.toString().endsWith("\r")) {
            var11.append("\r");
         }

         if(var13 != null && var13.isCommentDelimiter()) {
            var5 = var13.getEnd();
            var1 = var13.getEnd();
         }

         for(var14 = var9; var14 <= var10; ++var14) {
            var12 = this.getLineContent(var14);
            if(var12.getText().length() >= var1 && var3 <= var14) {
               var3 = var14;
               var5 = var1;
               break;
            }
         }

         if(var13 != null) {
            var13.update(var11.toString());
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var13.getPersistentModel());
         }

         this.setCaret(var5, var1, var3, var5, var1, var3);
      }

   }

   protected int getCaretEndPosX() {
      return this.getCaret().getCaretEndPos();
   }

   protected int getCaretMousePressedX() {
      return this.getCaret().getXmousePressed();
   }

   protected int getCaretMousePressedY() {
      return this.getCaret().getYmousePressed();
   }

   protected int getCaretMouseReleasedX() {
      return this.getCaret().getXmouseReleased();
   }

   protected int getCaretMouseReleasedY() {
      return this.getCaret().getYmouseReleased();
   }

   protected int getCaretStartPosX() {
      return this.getCaret().getCaretStartPos();
   }

   protected KeyEvent getEvent() {
      return this.m_event;
   }

   protected ZyLabelContent getLabelContent() {
      return this.m_labelContent;
   }

   protected int getLastLineXPos(int var1) {
      ZyLineContent var2 = this.getLineContent(var1);
      String var3 = var2.getText();
      return !var3.endsWith("\n") && !var3.endsWith("\r")?var3.length():var3.length() - 1;
   }

   protected ZyLineContent getLineContent(int var1) {
      return this.m_labelContent.getLineContent(var1);
   }

   protected int getMaxLineLength(int var1, int var2) {
      return this.getCaret().getMaxLineLength(var1, var2);
   }

   protected String getMultilineComment(int var1, String var2) {
      StringBuilder var3 = new StringBuilder();
      int var4 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(var1);
      int var5 = this.m_labelContent.getFirstLineIndexOfModelAt(var1);
      int var6 = this.m_labelContent.getLastLineIndexOfModelAt(var1);
      int var7 = this.isAboveLineComment(var1)?var5:var4;
      int var8 = this.isAboveLineComment(var1)?var4 - 1:var6;
      if(var4 == -1) {
         var7 = var5;
         var8 = var6;
      }

      for(int var9 = var7; var9 <= var8; ++var9) {
         if(var9 == var1) {
            var3.append(var2);
         } else {
            ZyLineContent var10 = this.m_labelContent.getLineContent(var9);
            String var11 = this.getSingleLineCommentText(var10);
            var3.append(var11);
         }
      }

      return var3.toString().equals("")?var2:var3.toString();
   }

   protected String getMultiLineComment(int var1) {
      StringBuilder var2 = new StringBuilder();
      int var3 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(var1);
      int var4 = this.m_labelContent.getFirstLineIndexOfModelAt(var1);
      int var5 = this.m_labelContent.getLastLineIndexOfModelAt(var1);
      int var6 = this.isAboveLineComment(var1)?var4:var3;
      int var7 = this.isAboveLineComment(var1)?var3 - 1:var5;
      if(var3 < 0) {
         var6 = var4;
         var7 = var5;
      }

      for(int var8 = var6; var8 <= var7; ++var8) {
         ZyLineContent var9 = this.m_labelContent.getLineContent(var8);
         String var10 = this.getSingleLineCommentText(var9);
         var2.append(var10);
      }

      return var2.toString();
   }

   protected ZyLineContent getNextModelLineContent(int var1) {
      ZyLineContent var2 = this.m_labelContent.getLineContent(var1);
      IZyEditableObject var3 = var2.getLineObject();

      for(int var4 = var1 + 1; var4 < this.m_labelContent.getLineCount(); ++var4) {
         ZyLineContent var5 = this.m_labelContent.getLineContent(var4);
         if(var5 == null) {
            return null;
         }

         IZyEditableObject var6 = var5.getLineObject();
         if(var3 != var6 && !var6.isPlaceholder()) {
            return var5;
         }
      }

      return null;
   }

   protected int getNextModelLineIndex(int var1) {
      ZyLineContent var2 = this.getNextModelLineContent(var1);

      for(int var3 = var1 + 1; var3 < this.m_labelContent.getLineCount(); ++var3) {
         if(var2 != null && !var2.getLineObject().isPlaceholder()) {
            return this.getLabelContent().getLineIndex(var2);
         }
      }

      return -1;
   }

   protected String getSelectedText() {
      if(!this.isSelection()) {
         return "";
      } else {
         int var1 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
         int var2 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
         int var3 = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
         int var4 = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
         StringBuilder var5 = new StringBuilder();

         for(int var6 = var1; var6 <= var2; ++var6) {
            ZyLineContent var7 = this.getLineContent(var6);
            int var8 = var7.getText().length();
            if(var3 < var8) {
               int var9 = var4;
               if(var4 > var8) {
                  var9 = var8;
               }

               String var10 = var7.getText();
               String var11 = var10.substring(var3, var9);
               if(!var11.endsWith("\n") && var6 != var2) {
                  var11 = String.valueOf(var11).concat("\n");
               }

               if(var11.endsWith("\r") || var6 == var2 && var11.endsWith("\n")) {
                  var11 = var11.substring(0, var11.length() - 1);
               }

               var5.append(var11);
            } else if(var6 != var2) {
               var5.append("\n");
            }
         }

         return var5.toString();
      }
   }

   protected abstract void initUndoHistory();

   protected boolean isAboveLineComment(int var1) {
      int var2 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var1);
      return var2 < 0?false:var2 > var1;
   }

   protected boolean isAltPressed() {
      return this.m_alt;
   }

   protected boolean isBehindLineComment(int var1, int var2) {
      int var3 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var2);
      if(var3 < 0) {
         return false;
      } else if(var3 < var2) {
         return true;
      } else {
         if(var3 == var2) {
            ZyLineContent var4 = this.getLabelContent().getLineContent(var2);
            if(var4 == null) {
               return false;
            }

            Iterator var5 = var4.getLineFragmentObjectList().iterator();

            while(var5.hasNext()) {
               IZyEditableObject var6 = (IZyEditableObject)var5.next();
               if(var6.isCommentDelimiter()) {
                  return var6.getStart() <= var1;
               }
            }
         }

         return false;
      }
   }

   protected boolean isComment(int var1, int var2) {
      ZyLineContent var3 = this.getLabelContent().getLineContent(var2);
      if(var3 != null) {
         boolean var4 = false;
         Iterator var5 = var3.getLineFragmentObjectList().iterator();

         while(var5.hasNext()) {
            IZyEditableObject var6 = (IZyEditableObject)var5.next();
            if(var6.isCommentDelimiter()) {
               var4 = true;
            }

            if(var1 >= var6.getStart() && var4) {
               return true;
            }
         }
      }

      return false;
   }

   protected boolean isCtrlPressed() {
      return this.m_ctrl;
   }

   protected boolean isDeleteableSelection() {
      int var1 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
      int var2 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
      int var3 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
      int var4 = Math.max(this.getCaretStartPosX(), this.getCaretEndPosX());
      ZyLineContent var5 = this.getLineContent(var1);
      ZyLineContent var6 = this.getLineContent(var2);
      IZyEditableObject var7 = var5.getLineFragmentObjectAt(var3);
      IZyEditableObject var8 = var5.getLineFragmentObjectAt(var4);
      if(var5.getLineObject() != var6.getLineObject()) {
         return false;
      } else {
         if(this.isComment(var3, var1)) {
            if(var2 > var1) {
               int var9 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(var1);
               if(var9 != -1) {
                  if(var1 < var9 && var2 >= var9) {
                     return false;
                  }

                  if(var1 >= var9 && var2 < var9) {
                     return false;
                  }
               }
            }
         } else if(var7 != var8 || var7 == null && var8 == null) {
            return false;
         }

         return true;
      }
   }

   protected boolean isEditable(int var1, int var2) {
      ZyLineContent var3 = this.getLabelContent().getLineContent(var2);
      return var3.isEditable(var1);
   }

   protected boolean isLabelComment(int var1) {
      return this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var1) == -1;
   }

   protected boolean isSelection() {
      return this.getCaret().isSelection();
   }

   protected boolean isShiftPressed() {
      return this.m_shift;
   }

   protected Point pasteClipboardText() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      boolean var3 = false;
      ZyLineContent var4 = this.getLineContent(var2);
      IZyEditableObject var5 = var4.getLineFragmentObjectAt(var1);
      if(var5 == null && var1 == var4.getText().length()) {
         int var6 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var2);
         if(var6 != -1 && var6 == var2) {
            var5 = var4.getLineObject();
            var3 = true;
         }
      }

      if(var5 != null) {
         String var12 = ClipboardHelpers.getClipboardString();
         if(var5.isCommentDelimiter()) {
            var1 = var5.getEnd();
            var5 = var4.getLineFragmentObjectAt(var1);
            if(var5 == null) {
               return null;
            }
         }

         int var7;
         if(this.isComment(var1, var2)) {
            var7 = StringHelper.count(var12, '\n');
            int var8 = var12.lastIndexOf("\n");
            int var9 = var1 - var5.getStart();
            String var10 = var4.getText().substring(var5.getStart(), var5.getEnd());
            String var11 = String.format("%s%s%s", new Object[]{var10.substring(0, var9), var12, var10.substring(var9)});
            var11 = this.getMultilineComment(var2, var11);
            var5.update(var11);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var5.getPersistentModel());
            var1 += var12.length() - var8 - 1;
            var2 += var7;
         } else if(var3) {
            var5.updateComment(var12, ECommentPlacement.BEHIND_LINE);
            if(!this.isLabelComment(var2)) {
               this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), var5.getPersistentModel());
               var7 = StringHelper.count(var12, '\n');
               var2 += var7;
               ZyLineContent var13 = this.getLineContent(var2);
               var1 += var13.getText().length() - 1;
            }
         } else {
            var12 = var12.replace("\n", "");
            var12 = var12.replace("\r", "");
            var7 = var1;
            var1 += var12.length();
            String var14 = var4.getText();
            var14.substring(var5.getStart(), var5.getEnd());
            int var16 = var7 - var5.getStart();
            String var15 = String.format("%s%s%s", new Object[]{var14.substring(var5.getStart(), var16), var12, var14.substring(var1, var5.getEnd())});
            var5.update(var15);
         }
      }

      return new Point(var1, var2);
   }

   protected void redo() {
      this.m_undoManager.redo();
   }

   protected void setCaret(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.getCaret().setCaret(var1, var2, var3, var4, var5, var6);
   }

   protected void udpateUndolist(ZyLabelContent var1, Object var2, IZyEditableObject var3, String var4, boolean var5, boolean var6, boolean var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      this.m_undoManager.addUndoState(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
   }

   protected void undo() {
      this.m_undoManager.undo();
   }

   protected abstract void updateCaret();

   protected abstract void updateClipboard();

   protected abstract void updateLabelContent();

   protected abstract void updateSelection();

   protected abstract void updateUndoHistory();

   public void keyPressed(ZyLabelContent var1, KeyEvent var2) {
      this.m_labelContent = var1;
      this.m_event = var2;
      this.setModifier(var2);
      if(var1.isEditable()) {
         this.initUndoHistory();
      }

      this.updateClipboard();
      this.updateSelection();
      if(var1.isEditable()) {
         this.updateLabelContent();
      }

      this.updateCaret();
      if(var1.isEditable()) {
         this.updateUndoHistory();
         this.updateLabelSize();
      }

      this.m_alt = false;
      this.m_shift = false;
      this.m_ctrl = false;
   }
}
