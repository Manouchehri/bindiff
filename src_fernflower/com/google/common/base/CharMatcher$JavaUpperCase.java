package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$JavaUpperCase extends CharMatcher {
   static final CharMatcher$JavaUpperCase INSTANCE = new CharMatcher$JavaUpperCase();

   public boolean matches(char var1) {
      return Character.isUpperCase(var1);
   }

   public String toString() {
      return "CharMatcher.javaUpperCase()";
   }
}
