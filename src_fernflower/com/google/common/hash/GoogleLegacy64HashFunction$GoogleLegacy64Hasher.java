package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.GoogleLegacy64HashFunction$1;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Mixer;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

final class GoogleLegacy64HashFunction$GoogleLegacy64Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher {
   private static final int CHUNK_SIZE = 24;
   private final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer;
   private int length;

   private GoogleLegacy64HashFunction$GoogleLegacy64Hasher(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var1) {
      super(24);
      this.length = 0;
      this.mixer = var1;
   }

   protected void process(ByteBuffer var1) {
      this.length += 24;
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer var2 = this.mixer;
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + var1.getLong());
      var2 = this.mixer;
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + var1.getLong());
      var2 = this.mixer;
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + var1.getLong());
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$400(this.mixer);
   }

   protected void processRemaining(ByteBuffer var1) {
      this.length += var1.remaining();
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer var2;
      switch(var1.remaining()) {
      case 7:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(6) & 255L) << 48));
      case 6:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(5) & 255L) << 40));
      case 5:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(4) & 255L) << 32));
      case 4:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(3) & 255L) << 24));
      case 3:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(2) & 255L) << 16));
      case 2:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + (((long)var1.get(1) & 255L) << 8));
      case 1:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + ((long)var1.get(0) & 255L));
         break;
      case 15:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(14) & 255L) << 48));
      case 14:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(13) & 255L) << 40));
      case 13:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(12) & 255L) << 32));
      case 12:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(11) & 255L) << 24));
      case 11:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(10) & 255L) << 16));
      case 10:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + (((long)var1.get(9) & 255L) << 8));
      case 9:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + ((long)var1.get(8) & 255L));
      case 8:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + var1.getLong());
         break;
      case 23:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + ((long)var1.get(22) << 56));
      case 22:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(21) & 255L) << 48));
      case 21:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(20) & 255L) << 40));
      case 20:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(19) & 255L) << 32));
      case 19:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(18) & 255L) << 24));
      case 18:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(17) & 255L) << 16));
      case 17:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var2) + (((long)var1.get(16) & 255L) << 8));
      case 16:
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(var2) + var1.getLong());
         var2 = this.mixer;
         GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(var2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(var2) + var1.getLong());
         break;
      default:
         throw new AssertionError("Should never get here.");
      }

   }

   public HashCode makeHash() {
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer var1 = this.mixer;
      GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(var1, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(var1) + (long)this.length);
      return this.mixer.makeHash();
   }

   // $FF: synthetic method
   GoogleLegacy64HashFunction$GoogleLegacy64Hasher(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var1, GoogleLegacy64HashFunction$1 var2) {
      this(var1);
   }
}
