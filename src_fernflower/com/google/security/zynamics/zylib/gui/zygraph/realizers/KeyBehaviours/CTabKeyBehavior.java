package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import java.util.Iterator;
import java.util.List;

public class CTabKeyBehavior extends CAbstractKeyBehavior {
   public CTabKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
      if(!this.isAltPressed() && !this.isCtrlPressed()) {
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMousePressedY();
         ZyLineContent var3 = this.getLineContent(var2);
         IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
         List var5 = var3.getLineFragmentObjectList();
         IZyEditableObject var6 = null;
         IZyEditableObject var8;
         int var9;
         List var10;
         int var11;
         int var12;
         boolean var13;
         ZyLineContent var14;
         int var10000;
         if(!this.isShiftPressed()) {
            if(var4 != null) {
               if(!this.isComment(var1, var2)) {
                  var11 = var3.getLineFragmentObjectList().indexOf(var4);
                  if(var11 < var5.size() - 1) {
                     var6 = (IZyEditableObject)var5.get(var11 + 1);
                  }
               }
            } else {
               Iterator var7 = var5.iterator();

               while(var7.hasNext()) {
                  var8 = (IZyEditableObject)var7.next();
                  if(var8.getStart() > var1) {
                     var6 = var8;
                     break;
                  }
               }
            }

            var11 = var2;
            if(this.isComment(var1, var2)) {
               var12 = this.getLabelContent().getLastLineIndexOfModelAt(var2);
               var9 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var2);
               if(var9 != -1) {
                  if(var2 < var9) {
                     var11 = var9 - 1;
                  } else {
                     var11 = var12;
                  }
               } else {
                  var11 = this.getLabelContent().getLineCount() - 1;
               }
            }

            if(var6 == null) {
               var13 = true;

               while(var6 == null && var11 != var2 || var13) {
                  var13 = false;
                  if(var11 == this.getLabelContent().getLineCount() - 1) {
                     var10000 = 0;
                  } else {
                     ++var11;
                     var10000 = var11;
                  }

                  var11 = var10000;
                  var14 = this.getLineContent(var11);
                  var10 = var14.getLineFragmentObjectList();
                  if(var10.size() > 0) {
                     var6 = (IZyEditableObject)var10.get(0);
                  }
               }
            }

            if(var6 != null) {
               var1 = var6.getStart();
               if(var6.isCommentDelimiter()) {
                  var1 = var6.getEnd();
               }

               this.setCaret(var1, var1, var11, var1, var1, var11);
            }
         } else {
            if(var4 != null) {
               if(!this.isComment(var1, var2)) {
                  var11 = var3.getLineFragmentObjectList().indexOf(var4);
                  if(var11 < 1) {
                     var6 = (IZyEditableObject)var5.get(var11 - 1);
                  }
               }
            } else {
               for(var11 = var5.size() - 1; var11 >= 0; --var11) {
                  var8 = (IZyEditableObject)var5.get(var11);
                  if(var8.getEnd() < var1) {
                     var6 = var8;
                     break;
                  }
               }
            }

            var11 = var2;
            if(this.isComment(var1, var2)) {
               var12 = this.getLabelContent().getFirstLineIndexOfModelAt(var2);
               var9 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var2);
               if(var9 != -1) {
                  if(var2 < var9) {
                     var11 = var12;
                  } else {
                     var11 = var9;
                  }
               }
            }

            if(var6 == null) {
               var13 = true;

               while(var6 == null && var11 != var2 || var13) {
                  var13 = false;
                  if(var11 == 0) {
                     var10000 = this.getLabelContent().getLineCount() - 1;
                  } else {
                     --var11;
                     var10000 = var11;
                  }

                  var11 = var10000;
                  var14 = this.getLineContent(var11);
                  var10 = var14.getLineFragmentObjectList();
                  if(var10.size() > 0) {
                     var6 = (IZyEditableObject)var10.get(var10.size() - 1);
                  }
               }
            }

            if(var6 != null) {
               var1 = var6.getStart();
               if(var6.isCommentDelimiter()) {
                  var1 = var6.getEnd();
               }

               var2 = var11;
               if(this.isComment(var1, var11)) {
                  var12 = this.getLabelContent().getFirstLineIndexOfModelAt(var11);
                  var9 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var11);
                  if(var11 > var9 && var9 >= 0) {
                     var2 = var9;
                  } else {
                     var2 = var12;
                  }

                  var3 = this.getLineContent(var2);
                  var6 = var3.getLineFragmentObjectAt(var1);
                  if(var6 != null && var6.isCommentDelimiter()) {
                     var1 = var6.getEnd();
                  }
               }

               this.setCaret(var1, var1, var2, var1, var1, var2);
            }
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
