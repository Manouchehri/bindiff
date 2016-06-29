package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.font.TextHitInfo;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class ZyCaret {
   private final ZyLabelContent m_content;
   private int m_mouse_pressed_x = 0;
   private int m_mouse_pressed_y = 0;
   private int m_mouse_released_x = 0;
   private int m_mouse_released_y = 0;
   private int m_caret_endpos_x = 0;
   private int m_caret_startpos_x = 0;

   public ZyCaret(ZyLabelContent var1) {
      Preconditions.checkNotNull(var1, "Error: Label content can\'t be null.");
      this.m_content = var1;
   }

   private int calcCaretPosition(int var1, double var2, double var4) {
      ZyLineContent var6 = this.m_content.getLineContent(var1);
      TextLayout var7 = this.m_content.getLineContent(var1).getTextLayout();
      TextHitInfo var8 = var7.hitTestChar((float)var2, (float)var4, var6.getBounds());
      return var8.getInsertionIndex();
   }

   private int calcHitLine(double var1) {
      int var3 = this.m_content.getLineCount();
      double var4 = this.m_content.getLineHeight();
      int var6 = 0;
      if(var1 < this.m_content.getLineContent(0).getBounds().getMinY()) {
         var6 = 0;
      } else if(var1 > this.m_content.getLineContent(var3 - 1).getBounds().getMinY() + (double)var3 * var4) {
         var6 = var3 - 1;
      } else {
         for(int var7 = 0; var7 < var3; ++var7) {
            Rectangle2D var8 = this.m_content.getLineContent(var7).getBounds();
            double var9 = var8.getY() + (double)var7 * var4 + (double)this.m_content.getPaddingTop();
            Double var11 = new Double(var8.getX(), var9, var8.getWidth(), var8.getHeight());
            if(var11.getY() < var1 && var11.getY() + var4 > var1) {
               var6 = var7;
               break;
            }
         }
      }

      return var6;
   }

   private int calcHitPosition(int var1, double var2, double var4, double var6) {
      boolean var8 = false;
      int var9 = this.m_mouse_pressed_y;
      int var10 = this.m_mouse_released_y;
      if(var9 > var10) {
         var9 = this.m_mouse_released_y;
         var10 = this.m_mouse_pressed_y;
         var8 = true;
      }

      int var11 = this.m_content.getLineCount();
      double var12 = (double)((float)this.m_content.getLineHeight());
      int var14 = var1;

      for(int var15 = var9; var15 <= var10; ++var15) {
         double var16 = 0.0D;
         if(var8) {
            var16 = var12 * var6 * (double)var15;
         } else {
            var16 = -(var12 * var6 * (double)(var11 - var15));
         }

         TextLayout var18 = this.m_content.getLineContent(var15).getTextLayout();
         TextHitInfo var19 = var18.hitTestChar((float)var2, (float)(var4 + var16), var18.getBounds());
         int var20 = var19.getInsertionIndex();
         if(var1 < var20 && var20 > var14) {
            var14 = var20;
         }
      }

      return var14;
   }

   private int calcSelectedLinesMaxLength() {
      int var1 = this.m_mouse_pressed_y;
      int var2 = this.m_mouse_released_y;
      if(var1 > var2) {
         var1 = this.m_mouse_released_y;
         var2 = this.m_mouse_pressed_y;
      }

      int var3 = 0;

      for(int var4 = var1; var4 <= var2; ++var4) {
         var3 = Math.max(var3, this.m_content.getLineContent(var4).getText().length());
      }

      return var3;
   }

   private int getLastLineXPos(int var1) {
      ZyLineContent var2 = this.m_content.getLineContent(var1);
      String var3 = var2.getText();
      return !var3.endsWith("\n") && !var3.endsWith("\r")?var3.length():var3.length() - 1;
   }

   public int getCaretEndPos() {
      return this.m_caret_endpos_x;
   }

   public int getCaretStartPos() {
      return this.m_caret_startpos_x;
   }

   public int getMaxLineLength(int var1, int var2) {
      int var3 = 0;
      int var4;
      if(var1 > var2) {
         var4 = var1;
         var1 = var2;
         var2 = var4;
      }

      for(var4 = var1; var4 <= var2; ++var4) {
         ZyLineContent var5 = this.m_content.getLineContent(var4);
         int var6 = var5.getText().length();
         if(var3 < var6) {
            var3 = var6;
         }
      }

      return var3;
   }

   public int getXmousePressed() {
      return this.m_mouse_pressed_x;
   }

   public int getXmouseReleased() {
      return this.m_mouse_released_x;
   }

   public int getYmousePressed() {
      return this.m_mouse_pressed_y;
   }

   public int getYmouseReleased() {
      return this.m_mouse_released_y;
   }

   public boolean isSelection() {
      boolean var1 = this.getXmousePressed() != this.getXmouseReleased() && this.getYmousePressed() == this.getYmouseReleased();
      if(var1) {
         int var2 = this.m_content.getLastLineIndexOfModelAt(this.m_mouse_pressed_y);
         return var2 >= this.m_mouse_pressed_y;
      } else {
         return this.getXmousePressed() != this.getXmouseReleased() || this.getYmousePressed() != this.getYmouseReleased();
      }
   }

   public void selectAll() {
      this.m_mouse_pressed_x = 0;
      this.m_mouse_pressed_y = 0;
      this.m_mouse_released_y = this.m_content.getLineCount() - 1;
      this.m_mouse_released_x = this.calcSelectedLinesMaxLength();
      this.m_caret_startpos_x = this.m_mouse_pressed_x;
      this.m_caret_endpos_x = this.m_mouse_released_x;
   }

   public void selectLine(double var1, double var3) {
      double var5 = var3 - var1 - (double)this.m_content.getPaddingTop();
      this.m_mouse_released_y = this.calcHitLine(var5);
      this.m_mouse_pressed_y = this.m_mouse_released_y;
      this.m_mouse_released_x = this.m_content.getLineContent(this.m_mouse_pressed_y).getTextLayout().getCharacterCount();
      this.m_mouse_pressed_x = 0;
      this.m_caret_endpos_x = this.m_mouse_released_x;
      this.m_caret_startpos_x = this.m_mouse_pressed_x;
   }

   public void selectWord(double var1, double var3, double var5, double var7, double var9) {
      double var11 = var5 - var1 - (double)this.m_content.getPaddingLeft();
      double var13 = var7 - var3 - (double)this.m_content.getPaddingTop();
      this.m_mouse_released_y = this.calcHitLine(var13);
      this.m_mouse_pressed_y = this.m_mouse_released_y;
      this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, (double)((float)var11), (double)((float)var13), var9);
      String var15 = this.m_content.getLineContent(this.m_mouse_released_y).getText();
      if(this.m_mouse_released_x <= var15.length() - 1) {
         if(var15.charAt(this.m_mouse_released_x) != 32) {
            this.m_caret_endpos_x = var15.length();

            int var16;
            for(var16 = this.m_mouse_released_x; var16 < this.m_caret_endpos_x; ++var16) {
               if(var15.charAt(var16) == 32) {
                  this.m_caret_endpos_x = var16;
                  break;
               }
            }

            this.m_caret_startpos_x = 0;

            for(var16 = this.m_mouse_released_x; var16 >= 0; --var16) {
               if(var15.charAt(var16) == 32) {
                  this.m_caret_startpos_x = var16 + 1;
                  break;
               }
            }

            this.m_mouse_pressed_x = this.m_caret_startpos_x;
            this.m_mouse_released_x = this.m_caret_endpos_x;
         }
      }
   }

   public void setCaret(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = this.getLastLineXPos(var3);
      if(var1 > var7) {
         var1 = var7;
      }

      if(var2 > var7) {
         var2 = var7;
      }

      int var8 = this.getLastLineXPos(var6);
      if(var4 > var8) {
         var4 = var8;
      }

      this.m_caret_startpos_x = var1;
      this.m_mouse_pressed_x = var2;
      this.m_mouse_pressed_y = var3;
      this.m_caret_endpos_x = var4;
      this.m_mouse_released_x = var5;
      this.m_mouse_released_y = var6;
   }

   public void setCaretEnd(double var1, double var3, double var5, double var7, double var9) {
      double var11 = var5 - var1 - (double)this.m_content.getPaddingLeft();
      double var13 = var7 - var3;
      this.m_mouse_released_y = this.calcHitLine(var13);
      this.m_caret_endpos_x = this.calcCaretPosition(this.m_mouse_released_y, var11, var13);
      this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, var11, var13, var9);
   }

   public void setCaretEndPos(int var1) {
      int var2 = this.getLastLineXPos(this.m_mouse_released_y);
      if(var1 > var2) {
         var1 = var2;
      }

      this.m_caret_endpos_x = var1;
   }

   public void setCaretStart(double var1, double var3, double var5, double var7, double var9) {
      double var11 = var5 - var1 - (double)this.m_content.getPaddingLeft();
      double var13 = var7 - var3;
      this.m_mouse_pressed_y = this.calcHitLine(var13);
      this.m_caret_startpos_x = this.calcCaretPosition(this.m_mouse_pressed_y, var11, var13);
      this.m_mouse_pressed_x = this.calcHitPosition(this.m_caret_startpos_x, var11, var13, var9);
   }

   public void setCaretStartPos(int var1) {
      int var2 = this.getLastLineXPos(this.m_mouse_pressed_y);
      if(var1 > var2) {
         var1 = var2;
      }

      this.m_caret_startpos_x = var1;
   }

   public void setXmousePressed(int var1) {
      int var2 = this.getLastLineXPos(this.m_mouse_pressed_y);
      if(var1 > var2) {
         var1 = var2;
      }

      this.m_mouse_pressed_x = var1;
   }

   public void setXmouseReleased(int var1) {
      int var2 = this.getLastLineXPos(this.m_mouse_released_y);
      if(var1 > var2) {
         var1 = var2;
      }

      this.m_mouse_released_x = var1;
   }

   public void setYmousePressed(int var1) {
      this.m_mouse_pressed_y = var1;
   }

   public void setYmouseReleased(int var1) {
      this.m_mouse_released_y = var1;
   }
}
