package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CCursorKeyBehavior extends CAbstractKeyBehavior {
   public CCursorKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   private int getXdelta() {
      byte var1 = 0;
      if(this.getEvent().getKeyCode() == 37) {
         var1 = -1;
      } else if(this.getEvent().getKeyCode() == 39) {
         var1 = 1;
      }

      return var1;
   }

   private int getYdelta() {
      byte var1 = 0;
      if(this.getEvent().getKeyCode() == 38) {
         var1 = -1;
      } else if(this.getEvent().getKeyCode() == 40) {
         var1 = 1;
      }

      return var1;
   }

   protected void handleNotShiftAndCtrl(int var1, int var2) {
      ZyLabelContent var3 = this.getLabelContent();
      int var4 = this.getCaretStartPosX();
      int var5 = this.getCaretMousePressedX();
      int var6 = this.getCaretMousePressedY();
      int var7 = this.getCaretEndPosX();
      int var8 = this.getCaretMouseReleasedX();
      int var9 = this.getCaretMouseReleasedY();
      if(var1 != 0) {
         ZyLineContent var10 = var3.getLineContent(var9);
         String var11 = String.valueOf(var10.getText()).concat(" ");
         boolean var12;
         int var13;
         int var14;
         if(var1 > 0) {
            var12 = var11.charAt(var7) == 32;
            var13 = 0;

            for(var14 = var7; var14 < var11.length(); ++var14) {
               var13 = var14;
               if(var12) {
                  if(var11.charAt(var14) != 32) {
                     break;
                  }
               } else if(var11.charAt(var14) == 32) {
                  break;
               }
            }

            if((var10.getText().endsWith("\n") || var10.getText().endsWith("\r")) && var10.getText().length() == var13) {
               --var13;
            }

            var4 = var13;
            var5 = var13;
            var8 = var13;
            var7 = var13;
         } else if(var1 < 0) {
            if(var7 == 0) {
               return;
            }

            var12 = var11.charAt(var7 - 1) == 32;
            var13 = var7 - 1;

            for(var14 = var7 - 1; var14 >= 0; var13 = var14--) {
               if(var12) {
                  if(var11.charAt(var14) != 32) {
                     break;
                  }
               } else if(var11.charAt(var14) == 32) {
                  break;
               }
            }

            var4 = var13;
            var5 = var13;
            var8 = var13;
            var7 = var13;
         }

         var8 = this.correctMouseReleasedX(var8, var9, var6);
         this.setCaret(var4, var5, var6, var7, var8, var9);
      } else if(var2 != 0) {
         this.handleNotShiftAndNotCtrl(0, var2);
      }

   }

   protected void handleNotShiftAndNotCtrl(int var1, int var2) {
      ZyLabelContent var3 = this.getLabelContent();
      int var4 = this.getCaretStartPosX();
      int var5 = this.getCaretMousePressedX();
      int var6 = this.getCaretMousePressedY();
      int var7 = this.getCaretEndPosX();
      int var8 = this.getCaretMouseReleasedX();
      int var9 = this.getCaretMouseReleasedY();
      if(this.isSelection() && var1 != 0 && var2 == 0) {
         if(var6 <= var9 && var5 <= var8) {
            if(var1 < 0) {
               var8 = var5;
               var7 = var4;
               var9 = var6;
            } else {
               var5 = var8;
               var4 = var8;
               var6 = var9;
            }
         } else if(var1 > 0) {
            var8 = var5;
            var7 = var4;
            var9 = var6;
         } else {
            var5 = var8;
            var4 = var8;
            var6 = var9;
         }
      } else {
         var6 = var9 + var2;
         if(var6 < 0) {
            var6 = 0;
         }

         if(var6 > var3.getLineCount() - 1) {
            var6 = var3.getLineCount() - 1;
         }

         var9 = var6;
         var5 = var8 + var1;
         if(var5 < 0) {
            var5 = 0;
         }

         if(var5 > var3.getLineContent(var6).getTextLayout().getCharacterCount() - 1) {
            var5 = var3.getLineContent(var6).getTextLayout().getCharacterCount();
         }

         var7 = var5;
         var8 = var5;
         var4 = var5;
      }

      var8 = this.correctMouseReleasedX(var8, var9, var6);
      this.setCaret(var4, var5, var6, var7, var8, var9);
   }

   protected void handleShiftAndCtrl(int var1, int var2) {
      if(var2 != 0) {
         this.handleShiftAndNotCtrl(0, var2);
      } else if(var1 != 0) {
         ZyLabelContent var3 = this.getLabelContent();
         ZyLineContent var4 = var3.getLineContent(this.getCaretMouseReleasedY());
         int var5 = this.getCaretStartPosX();
         int var6 = this.getCaretMousePressedX();
         int var7 = this.getCaretMousePressedY();
         int var8 = this.getCaretEndPosX();
         int var9 = this.getCaretMouseReleasedX();
         int var10 = this.getCaretMouseReleasedY();
         String var11 = String.valueOf(var4.getText()).concat(" ");
         boolean var12;
         int var13;
         int var14;
         if(var1 > 0) {
            var12 = var11.charAt(var8) == 32;
            var13 = 0;

            for(var14 = var8; var14 < var11.length(); ++var14) {
               var13 = var14;
               if(var12) {
                  if(var11.charAt(var14) != 32) {
                     break;
                  }
               } else if(var11.charAt(var14) == 32) {
                  break;
               }
            }

            if((var4.getText().endsWith("\n") || var4.getText().endsWith("\r")) && var4.getText().length() == var13) {
               --var13;
            }

            var5 = var6;
            var9 = var13;
            var8 = var13;
            boolean var17 = this.getCaretEndPosX() == var4.getText().length();
            boolean var15 = var4.getText().endsWith("\n") && this.getCaretEndPosX() == var4.getText().length() - 1;
            boolean var16 = var4.getText().endsWith("\r") && this.getCaretEndPosX() == var4.getText().length() - 1;
            if(var17 || var15 || var16) {
               var9 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            }
         } else if(var1 < 0) {
            if(var8 == 0) {
               return;
            }

            var12 = var11.charAt(var8 - 1) == 32;
            var13 = var8 - 1;

            for(var14 = var8 - 1; var14 >= 0; var13 = var14--) {
               if(var12) {
                  if(var11.charAt(var14) != 32) {
                     break;
                  }
               } else if(var11.charAt(var14) == 32) {
                  break;
               }
            }

            var5 = var6;
            var9 = var13;
            var8 = var13;
         }

         var9 = this.correctMouseReleasedX(var9, var10, var7);
         this.setCaret(var5, var6, var7, var8, var9, var10);
      }

   }

   protected void handleShiftAndNotCtrl(int var1, int var2) {
      ZyLabelContent var3 = this.getLabelContent();
      int var4 = this.getCaretStartPosX();
      int var5 = this.getCaretMousePressedX();
      int var6 = this.getCaretMousePressedY();
      int var7 = this.getCaretEndPosX();
      int var8 = this.getCaretMouseReleasedX();
      int var9 = this.getCaretMouseReleasedY();
      int var10 = var3.getLineCount();
      if(var1 != 0 || var2 != 0) {
         var9 += var2;
         if(var9 < 0) {
            var9 = 0;
         }

         if(var9 > var10 - 1) {
            var9 = var10 - 1;
         }

         var8 += var1;
         if(var8 < 0) {
            var8 = 0;
         }

         int var11 = var6;
         int var12 = var9;
         if(var6 > var9) {
            var11 = var9;
            var12 = var6;
         }

         int var13 = 0;

         for(int var14 = var11; var14 <= var12; ++var14) {
            var13 = Math.max(var13, var3.getLineContent(var14).getText().length());
         }

         if(var8 > var13) {
            var8 = var13;
         }

         if(var8 <= var3.getLineContent(var9).getTextLayout().getCharacterCount()) {
            var7 = var8;
         } else {
            var7 = var3.getLineContent(var9).getTextLayout().getCharacterCount();
         }

         var4 = var5;
      }

      var8 = this.correctMouseReleasedX(var8, var9, var6);
      this.setCaret(var4, var5, var6, var7, var8, var9);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
      int var1 = this.getXdelta();
      int var2 = this.getYdelta();
      if(!this.isShiftPressed() && !this.isCtrlPressed()) {
         this.handleNotShiftAndNotCtrl(var1, var2);
      } else if(this.isShiftPressed() && !this.isCtrlPressed()) {
         this.handleShiftAndNotCtrl(var1, var2);
      } else if(!this.isShiftPressed() && this.isCtrlPressed()) {
         this.handleNotShiftAndCtrl(var1, var2);
      } else if(this.isShiftPressed() && this.isCtrlPressed()) {
         this.handleShiftAndCtrl(var1, var2);
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
