package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

final class CharMatcher$Digit extends CharMatcher$RangesMatcher {
   private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
   static final CharMatcher$Digit INSTANCE = new CharMatcher$Digit();

   private static char[] zeroes() {
      return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
   }

   private static char[] nines() {
      char[] var0 = new char["0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length()];

      for(int var1 = 0; var1 < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); ++var1) {
         var0[var1] = (char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(var1) + 9);
      }

      return var0;
   }

   private CharMatcher$Digit() {
      super("CharMatcher.digit()", zeroes(), nines());
   }
}
