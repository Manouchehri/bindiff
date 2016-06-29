package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLetterOrDigit extends CharMatcher {
   static final CharMatcher$JavaLetterOrDigit INSTANCE = new CharMatcher$JavaLetterOrDigit();

   public boolean matches(char var1) {
      return Character.isLetterOrDigit(var1);
   }

   public String toString() {
      return "CharMatcher.javaLetterOrDigit()";
   }
}
