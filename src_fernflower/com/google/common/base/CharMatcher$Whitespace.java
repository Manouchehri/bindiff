package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

@VisibleForTesting
final class CharMatcher$Whitespace extends CharMatcher$NamedFastMatcher {
   static final String TABLE = " 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　";
   static final int MULTIPLIER = 1682554634;
   static final int SHIFT = Integer.numberOfLeadingZeros(" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".length() - 1);
   static final CharMatcher$Whitespace INSTANCE = new CharMatcher$Whitespace();

   CharMatcher$Whitespace() {
      super("CharMatcher.whitespace()");
   }

   public boolean matches(char var1) {
      return " 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".charAt(1682554634 * var1 >>> SHIFT) == var1;
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      for(int var2 = 0; var2 < " 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".length(); ++var2) {
         var1.set(" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".charAt(var2));
      }

   }
}
