package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

final class CharMatcher$Ascii extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$Ascii INSTANCE = new CharMatcher$Ascii();

   CharMatcher$Ascii() {
      super("CharMatcher.ascii()");
   }

   public boolean matches(char var1) {
      return var1 <= 127;
   }
}
