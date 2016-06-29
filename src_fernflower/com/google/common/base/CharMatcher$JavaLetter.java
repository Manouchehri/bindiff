package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLetter extends CharMatcher {
   static final CharMatcher$JavaLetter INSTANCE = new CharMatcher$JavaLetter();

   public boolean matches(char var1) {
      return Character.isLetter(var1);
   }

   public String toString() {
      return "CharMatcher.javaLetter()";
   }
}
