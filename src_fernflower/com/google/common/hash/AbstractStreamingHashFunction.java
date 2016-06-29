package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

abstract class AbstractStreamingHashFunction implements HashFunction {
   public HashCode hashObject(Object var1, Funnel var2) {
      return this.newHasher().putObject(var1, var2).hash();
   }

   @Deprecated
   public HashCode hashString(CharSequence var1) {
      return this.hashUnencodedChars(var1);
   }

   public HashCode hashUnencodedChars(CharSequence var1) {
      return this.newHasher().putUnencodedChars(var1).hash();
   }

   public HashCode hashString(CharSequence var1, Charset var2) {
      return this.newHasher().putString(var1, var2).hash();
   }

   public HashCode hashInt(int var1) {
      return this.newHasher().putInt(var1).hash();
   }

   public HashCode hashLong(long var1) {
      return this.newHasher().putLong(var1).hash();
   }

   public HashCode hashBytes(byte[] var1) {
      return this.newHasher().putBytes(var1).hash();
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      return this.newHasher().putBytes(var1, var2, var3).hash();
   }

   public Hasher newHasher(int var1) {
      Preconditions.checkArgument(var1 >= 0);
      return this.newHasher();
   }
}
