package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.SyntaxDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;

public class ConsoleHelpers {
   private final SyntaxDocument document;
   private final MutableAttributeSet normal;

   public ConsoleHelpers(SyntaxDocument var1, MutableAttributeSet var2) {
      this.document = var1;
      this.normal = var2;
   }

   public int getCaretOffsetInLine(int var1) {
      return var1 - this.document.getParagraphElement(var1).getStartOffset();
   }

   public String getCurrentLine(int var1) {
      Element var2 = this.document.getParagraphElement(var1);
      String var3 = "";

      try {
         var3 = this.document.getText(var2.getStartOffset(), var2.getEndOffset() - var2.getStartOffset());
      } catch (BadLocationException var5) {
         System.out.println("Bad location!");
         var5.printStackTrace();
      }

      return var3;
   }

   public int getLineStartOffset(int var1) {
      return this.document.getParagraphElement(var1).getStartOffset();
   }

   public MutableAttributeSet getNormal() {
      return this.normal;
   }

   public String getWord(int var1) {
      int var2 = var1;
      Element var3 = this.document.getParagraphElement(var1);

      String var4;
      try {
         var4 = this.document.getText(var3.getStartOffset(), var3.getEndOffset() - var3.getStartOffset());
      } catch (Exception var8) {
         return "";
      }

      int var5 = var4.length();
      if(var5 == 0) {
         return "";
      } else {
         boolean var6 = false;
         if(var3.getStartOffset() > 0) {
            var2 = var1 - var3.getStartOffset();
         }

         for(int var9 = var2 - 1; var9 >= 0; --var9) {
            char var7 = var4.charAt(var9);
            if(this.document.isDelimiter((new StringBuilder(1)).append(var7).toString()) || var9 == 0) {
               return var4.substring(var9 + 1, var2).trim();
            }
         }

         return "";
      }
   }
}
