package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CaseFormat$StringConverter;
import com.google.common.base.CharMatcher;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public enum CaseFormat {
   LOWER_HYPHEN(CharMatcher.is('-'), "-"),
   LOWER_UNDERSCORE(CharMatcher.is('_'), "_"),
   LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), ""),
   UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), ""),
   UPPER_UNDERSCORE(CharMatcher.is('_'), "_");

   private final CharMatcher wordBoundary;
   private final String wordSeparator;

   private CaseFormat(CharMatcher var3, String var4) {
      this.wordBoundary = var3;
      this.wordSeparator = var4;
   }

   public final String to(CaseFormat var1, String var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return var1 == this?var2:this.convert(var1, var2);
   }

   String convert(CaseFormat var1, String var2) {
      StringBuilder var3 = null;
      int var4 = 0;
      int var5 = -1;

      while(true) {
         ++var5;
         if((var5 = this.wordBoundary.indexIn(var2, var5)) == -1) {
            return var4 == 0?var1.normalizeFirstWord(var2):var3.append(var1.normalizeWord(var2.substring(var4))).toString();
         }

         if(var4 == 0) {
            var3 = new StringBuilder(var2.length() + 4 * this.wordSeparator.length());
            var3.append(var1.normalizeFirstWord(var2.substring(var4, var5)));
         } else {
            var3.append(var1.normalizeWord(var2.substring(var4, var5)));
         }

         var3.append(var1.wordSeparator);
         var4 = var5 + this.wordSeparator.length();
      }
   }

   @Beta
   public Converter converterTo(CaseFormat var1) {
      return new CaseFormat$StringConverter(this, var1);
   }

   abstract String normalizeWord(String var1);

   private String normalizeFirstWord(String var1) {
      return this == LOWER_CAMEL?Ascii.toLowerCase(var1):this.normalizeWord(var1);
   }

   private static String firstCharOnlyToUpper(String var0) {
      return var0.isEmpty()?var0:(new StringBuilder(var0.length())).append(Ascii.toUpperCase(var0.charAt(0))).append(Ascii.toLowerCase(var0.substring(1))).toString();
   }

   // $FF: synthetic method
   CaseFormat(CharMatcher var3, String var4, CaseFormat$1 var5) {
      this(var3, var4);
   }

   // $FF: synthetic method
   static String access$100(String var0) {
      return firstCharOnlyToUpper(var0);
   }
}
