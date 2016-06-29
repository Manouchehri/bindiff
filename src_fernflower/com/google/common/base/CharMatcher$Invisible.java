package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

final class CharMatcher$Invisible extends CharMatcher$RangesMatcher {
   private static final String RANGE_STARTS = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f ᠎ \u2028 \u2066\u2067\u2068\u2069\u206a　\ud800\ufeff\ufff9\ufffa";
   private static final String RANGE_ENDS = "  \u00ad\u0604\u061c\u06dd\u070f ᠎\u200f \u2064\u2066\u2067\u2068\u2069\u206f　\uf8ff\ufeff\ufff9\ufffb";
   static final CharMatcher$Invisible INSTANCE = new CharMatcher$Invisible();

   private CharMatcher$Invisible() {
      super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f ᠎ \u2028 \u2066\u2067\u2068\u2069\u206a　\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f ᠎\u200f \u2064\u2066\u2067\u2068\u2069\u206f　\uf8ff\ufeff\ufff9\ufffb".toCharArray());
   }
}
