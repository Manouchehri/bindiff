package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CharEscaper;

class StringUtil$CharEscaperBuilder$CharArrayDecorator extends StringUtil$CharEscaper {
   private final char[][] replacements;
   private final int replaceLength;

   StringUtil$CharEscaperBuilder$CharArrayDecorator(char[][] var1) {
      super((StringUtil$1)null);
      this.replacements = var1;
      this.replaceLength = var1.length;
   }

   public String escape(String var1) {
      int var2 = var1.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1.charAt(var3);
         if(var4 < this.replacements.length && this.replacements[var4] != null) {
            return this.escapeSlow(var1, var3);
         }
      }

      return var1;
   }

   protected char[] escape(char var1) {
      return var1 < this.replaceLength?this.replacements[var1]:null;
   }
}
