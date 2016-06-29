package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

final class Murmur3_32HashFunction$Murmur3_32Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher {
   private static final int CHUNK_SIZE = 4;
   private int h1;
   private int length;

   Murmur3_32HashFunction$Murmur3_32Hasher(int var1) {
      super(4);
      this.h1 = var1;
      this.length = 0;
   }

   protected void process(ByteBuffer var1) {
      int var2 = Murmur3_32HashFunction.access$000(var1.getInt());
      this.h1 = Murmur3_32HashFunction.access$100(this.h1, var2);
      this.length += 4;
   }

   protected void processRemaining(ByteBuffer var1) {
      this.length += var1.remaining();
      int var2 = 0;

      for(int var3 = 0; var1.hasRemaining(); var3 += 8) {
         var2 ^= UnsignedBytes.toInt(var1.get()) << var3;
      }

      this.h1 ^= Murmur3_32HashFunction.access$000(var2);
   }

   public HashCode makeHash() {
      return Murmur3_32HashFunction.access$200(this.h1, this.length);
   }
}
