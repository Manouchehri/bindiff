package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

final class SipHashFunction$SipHasher extends AbstractStreamingHashFunction$AbstractStreamingHasher {
   private static final int CHUNK_SIZE = 8;
   private final int c;
   private final int d;
   private long v0 = 8317987319222330741L;
   private long v1 = 7237128888997146477L;
   private long v2 = 7816392313619706465L;
   private long v3 = 8387220255154660723L;
   private long b = 0L;
   private long finalM = 0L;

   SipHashFunction$SipHasher(int var1, int var2, long var3, long var5) {
      super(8);
      this.c = var1;
      this.d = var2;
      this.v0 ^= var3;
      this.v1 ^= var5;
      this.v2 ^= var3;
      this.v3 ^= var5;
   }

   protected void process(ByteBuffer var1) {
      this.b += 8L;
      this.processM(var1.getLong());
   }

   protected void processRemaining(ByteBuffer var1) {
      this.b += (long)var1.remaining();

      for(int var2 = 0; var1.hasRemaining(); var2 += 8) {
         this.finalM ^= ((long)var1.get() & 255L) << var2;
      }

   }

   public HashCode makeHash() {
      this.finalM ^= this.b << 56;
      this.processM(this.finalM);
      this.v2 ^= 255L;
      this.sipRound(this.d);
      return HashCode.fromLong(this.v0 ^ this.v1 ^ this.v2 ^ this.v3);
   }

   private void processM(long var1) {
      this.v3 ^= var1;
      this.sipRound(this.c);
      this.v0 ^= var1;
   }

   private void sipRound(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         this.v0 += this.v1;
         this.v2 += this.v3;
         this.v1 = Long.rotateLeft(this.v1, 13);
         this.v3 = Long.rotateLeft(this.v3, 16);
         this.v1 ^= this.v0;
         this.v3 ^= this.v2;
         this.v0 = Long.rotateLeft(this.v0, 32);
         this.v2 += this.v1;
         this.v0 += this.v3;
         this.v1 = Long.rotateLeft(this.v1, 17);
         this.v3 = Long.rotateLeft(this.v3, 21);
         this.v1 ^= this.v2;
         this.v3 ^= this.v0;
         this.v2 = Long.rotateLeft(this.v2, 32);
      }

   }
}
