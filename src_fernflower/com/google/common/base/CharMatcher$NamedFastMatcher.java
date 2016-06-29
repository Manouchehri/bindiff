package com.google.common.base;

import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;

abstract class CharMatcher$NamedFastMatcher extends CharMatcher$FastMatcher {
   private final String description;

   CharMatcher$NamedFastMatcher(String var1) {
      this.description = (String)Preconditions.checkNotNull(var1);
   }

   public final String toString() {
      return this.description;
   }
}
