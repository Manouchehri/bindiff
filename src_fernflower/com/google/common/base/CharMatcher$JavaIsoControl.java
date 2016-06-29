package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

final class CharMatcher$JavaIsoControl extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$JavaIsoControl INSTANCE = new CharMatcher$JavaIsoControl();

   private CharMatcher$JavaIsoControl() {
      super("CharMatcher.javaIsoControl()");
   }

   public boolean matches(char var1) {
      return var1 <= 31 || var1 >= 127 && var1 <= 159;
   }
}
