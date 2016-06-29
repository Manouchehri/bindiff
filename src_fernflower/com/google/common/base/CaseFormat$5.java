package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;

enum CaseFormat$5 {
   CaseFormat$5(CharMatcher var3, String var4) {
   }

   String normalizeWord(String var1) {
      return Ascii.toUpperCase(var1);
   }

   String convert(CaseFormat var1, String var2) {
      return var1 == LOWER_HYPHEN?Ascii.toLowerCase(var2.replace('_', '-')):(var1 == LOWER_UNDERSCORE?Ascii.toLowerCase(var2):super.convert(var1, var2));
   }
}
