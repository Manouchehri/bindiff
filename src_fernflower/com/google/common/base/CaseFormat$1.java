package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;

enum CaseFormat$1 {
   CaseFormat$1(CharMatcher var3, String var4) {
   }

   String normalizeWord(String var1) {
      return Ascii.toLowerCase(var1);
   }

   String convert(CaseFormat var1, String var2) {
      return var1 == LOWER_UNDERSCORE?var2.replace('-', '_'):(var1 == UPPER_UNDERSCORE?Ascii.toUpperCase(var2.replace('-', '_')):super.convert(var1, var2));
   }
}
