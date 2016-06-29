package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$BreakingWhitespace extends CharMatcher {
   static final CharMatcher INSTANCE = new CharMatcher$BreakingWhitespace();

   public boolean matches(char var1) {
      switch(var1) {
      case '\t':
      case '\n':
      case '\u000b':
      case '\f':
      case '\r':
      case ' ':
      case '\u0085':
      case ' ':
      case '\u2028':
      case '\u2029':
      case ' ':
      case '　':
         return true;
      case ' ':
         return false;
      default:
         return var1 >= 8192 && var1 <= 8202;
      }
   }

   public String toString() {
      return "CharMatcher.breakingWhitespace()";
   }
}
