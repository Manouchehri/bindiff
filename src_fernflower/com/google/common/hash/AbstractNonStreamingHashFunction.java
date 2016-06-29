package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractNonStreamingHashFunction$BufferingHasher;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

abstract class AbstractNonStreamingHashFunction implements HashFunction {
   public Hasher newHasher() {
      return new AbstractNonStreamingHashFunction$BufferingHasher(this, 32);
   }

   public Hasher newHasher(int var1) {
      Preconditions.checkArgument(var1 >= 0);
      return new AbstractNonStreamingHashFunction$BufferingHasher(this, var1);
   }

   public HashCode hashObject(Object var1, Funnel var2) {
      return this.newHasher().putObject(var1, var2).hash();
   }

   @Deprecated
   public HashCode hashString(CharSequence var1) {
      return this.hashUnencodedChars(var1);
   }

   public HashCode hashUnencodedChars(CharSequence var1) {
      int var2 = var1.length();
      Hasher var3 = this.newHasher(var2 * 2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.putChar(var1.charAt(var4));
      }

      return var3.hash();
   }

   public HashCode hashString(CharSequence var1, Charset var2) {
      return this.hashBytes(var1.toString().getBytes(var2));
   }

   public HashCode hashInt(int var1) {
      return this.newHasher(4).putInt(var1).hash();
   }

   public HashCode hashLong(long var1) {
      return this.newHasher(8).putLong(var1).hash();
   }

   public HashCode hashBytes(byte[] var1) {
      return this.hashBytes(var1, 0, var1.length);
   }
}
