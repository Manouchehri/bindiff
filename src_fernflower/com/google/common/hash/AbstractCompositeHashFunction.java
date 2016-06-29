package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction$1;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

abstract class AbstractCompositeHashFunction extends AbstractStreamingHashFunction {
   final HashFunction[] functions;
   private static final long serialVersionUID = 0L;

   AbstractCompositeHashFunction(HashFunction... var1) {
      HashFunction[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         HashFunction var5 = var2[var4];
         Preconditions.checkNotNull(var5);
      }

      this.functions = var1;
   }

   abstract HashCode makeHash(Hasher[] var1);

   public Hasher newHasher() {
      Hasher[] var1 = new Hasher[this.functions.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = this.functions[var2].newHasher();
      }

      return new AbstractCompositeHashFunction$1(this, var1);
   }
}
