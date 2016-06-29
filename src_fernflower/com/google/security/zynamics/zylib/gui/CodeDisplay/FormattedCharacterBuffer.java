package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class FormattedCharacterBuffer {
   private char[] charBuffer;
   private Font[] perCharFonts;
   private static final Font DEFAULT_FONT = new Font("Monospaced", 0, 12);
   private Color[] perCharForegroundColor;
   private Color defaultForegroundColor;
   private Color[] perCharBackgroundColor;
   private Color defaultBackgroundColor;
   private int numberOfLinesInBuffer;
   private int numberOfColumnsInBuffer;

   public FormattedCharacterBuffer(int var1, int var2) {
      this.charBuffer = new char[0];
      this.perCharFonts = new Font[0];
      this.perCharForegroundColor = new Color[0];
      this.defaultForegroundColor = Color.BLACK;
      this.perCharBackgroundColor = new Color[0];
      this.defaultBackgroundColor = Color.WHITE;
      this.numberOfLinesInBuffer = var1;
      this.numberOfColumnsInBuffer = var2;
      this.charBuffer = new char[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
      this.perCharFonts = new Font[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
      this.perCharForegroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
      this.perCharBackgroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
      this.clear();
   }

   public void clear() {
      for(int var1 = 0; var1 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++var1) {
         this.charBuffer[var1] = 32;
         this.perCharFonts[var1] = DEFAULT_FONT;
         this.perCharForegroundColor[var1] = this.defaultForegroundColor;
         this.perCharBackgroundColor[var1] = this.defaultBackgroundColor;
      }

   }

   public FormattedCharacterBuffer(String var1, Font var2, Color var3, Color var4) {
      this(1, var1.length());

      for(int var5 = 0; var5 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++var5) {
         this.charBuffer[var5] = var1.charAt(var5) == 10?95:var1.charAt(var5);
         this.perCharFonts[var5] = var2;
         this.perCharForegroundColor[var5] = var3;
         this.perCharBackgroundColor[var5] = var4;
      }

   }

   public int getNumberOfColumns() {
      return this.numberOfColumnsInBuffer;
   }

   public int getNumberOfLines() {
      return this.numberOfLinesInBuffer;
   }

   public FormattedCharacterBuffer setBackgroundColor(Color var1) {
      for(int var2 = 0; var2 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++var2) {
         this.perCharBackgroundColor[var2] = var1;
      }

      return this;
   }

   public void setAt(int var1, int var2, char var3, Font var4, Color var5, Color var6) {
      int var7 = var1 * this.numberOfColumnsInBuffer + var2;
      this.charBuffer[var7] = var3;
      this.perCharFonts[var7] = var4;
      this.perCharForegroundColor[var7] = var5;
      this.perCharBackgroundColor[var7] = var6;
   }

   public boolean copyInto(int var1, int var2, FormattedCharacterBuffer var3) {
      if(var1 + var3.getNumberOfLines() <= this.numberOfLinesInBuffer && var2 + var3.getNumberOfColumns() <= this.numberOfColumnsInBuffer) {
         for(int var4 = 0; var4 < var3.getNumberOfLines(); ++var4) {
            for(int var5 = 0; var5 < var3.getNumberOfColumns(); ++var5) {
               int var6 = var4 * var3.getNumberOfColumns() + var5;
               char var7 = var3.charBuffer[var6];
               Font var8 = var3.perCharFonts[var6];
               Color var9 = var3.perCharForegroundColor[var6];
               Color var10 = var3.perCharBackgroundColor[var6];
               this.setAt(var1 + var4, var2 + var5, var7, var8, var9, var10);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public FormattedCharacterBuffer getLine(int var1) {
      FormattedCharacterBuffer var2 = new FormattedCharacterBuffer(1, this.numberOfColumnsInBuffer);

      for(int var3 = 0; var3 < this.getNumberOfColumns(); ++var3) {
         int var4 = var1 * this.getNumberOfColumns() + var3;
         char var5 = this.charBuffer[var4];
         Font var6 = this.perCharFonts[var4];
         Color var7 = this.perCharForegroundColor[var4];
         Color var8 = this.perCharBackgroundColor[var4];
         var2.setAt(0, var3, var5, var6, var7, var8);
      }

      return var2;
   }

   protected void paintBuffer(Graphics2D var1, int var2, int var3, int var4) {
      var1.setFont(this.perCharFonts[0]);
      FontMetrics var5 = var1.getFontMetrics();
      var1.fillRect(0, 0, this.numberOfColumnsInBuffer * var5.charWidth('a'), this.numberOfLinesInBuffer * var5.getHeight());

      for(int var6 = 0; var6 < this.numberOfLinesInBuffer; ++var6) {
         AttributedString var7 = this.getAttributedStringForLine(var6, var4);
         var1.drawString(var7.getIterator(), var2, var3 + var5.getHeight() * (var6 + 1));
      }

   }

   private AttributedString getAttributedStringForLine(int var1, int var2) {
      String var3 = new String(this.charBuffer, this.numberOfColumnsInBuffer * var1 + var2, this.numberOfColumnsInBuffer - var2);
      AttributedString var4 = new AttributedString(var3);
      int var5 = var1 * this.numberOfColumnsInBuffer + var2;

      for(int var6 = 0; var6 < this.numberOfColumnsInBuffer - var2; ++var6) {
         var4.addAttribute(TextAttribute.FONT, this.perCharFonts[var5 + var6], var6, var6 + 1);
         var4.addAttribute(TextAttribute.BACKGROUND, this.perCharBackgroundColor[var5 + var6], var6, var6 + 1);
         var4.addAttribute(TextAttribute.FOREGROUND, this.perCharForegroundColor[var5 + var6], var6, var6 + 1);
      }

      return var4;
   }

   public String getCharBufferAsString() {
      StringBuilder var1 = new StringBuilder(this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer);

      for(int var2 = 0; var2 < this.numberOfLinesInBuffer; ++var2) {
         var1.append(this.charBuffer, this.numberOfColumnsInBuffer * var2, this.numberOfColumnsInBuffer);
         var1.append("\n");
      }

      return var1.toString();
   }
}
