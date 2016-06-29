package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher$1;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

@GwtIncompatible("java.util.BitSet")
final class CharMatcher$BitSetMatcher extends CharMatcher$NamedFastMatcher {
   private final BitSet table;

   private CharMatcher$BitSetMatcher(BitSet var1, String var2) {
      super(var2);
      if(var1.length() + 64 < var1.size()) {
         var1 = (BitSet)var1.clone();
      }

      this.table = var1;
   }

   public boolean matches(char var1) {
      return this.table.get(var1);
   }

   void setBits(BitSet var1) {
      var1.or(this.table);
   }

   // $FF: synthetic method
   CharMatcher$BitSetMatcher(BitSet var1, String var2, CharMatcher$1 var3) {
      this(var1, var2);
   }
}
