package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaLowerCase extends CharMatcher {
   static final CharMatcher$JavaLowerCase INSTANCE = new CharMatcher$JavaLowerCase();

   public boolean matches(char var1) {
      return Character.isLowerCase(var1);
   }

   public String toString() {
      return "CharMatcher.javaLowerCase()";
   }
}
