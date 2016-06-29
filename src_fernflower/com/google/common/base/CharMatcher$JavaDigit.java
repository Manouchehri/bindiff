package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaDigit extends CharMatcher {
   static final CharMatcher$JavaDigit INSTANCE = new CharMatcher$JavaDigit();

   public boolean matches(char var1) {
      return Character.isDigit(var1);
   }

   public String toString() {
      return "CharMatcher.javaDigit()";
   }
}
