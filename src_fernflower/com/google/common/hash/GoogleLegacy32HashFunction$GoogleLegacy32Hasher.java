package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Mixer;
import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

final class GoogleLegacy32HashFunction$GoogleLegacy32Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher {
   private static final int CHUNK_SIZE = 12;
   private final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer;
   private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;
   private int length;

   private GoogleLegacy32HashFunction$GoogleLegacy32Hasher(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var1, GoogleLegacy32HashFunction$FingerprintStrategy var2) {
      super(12);
      this.length = 0;
      this.mixer = var1;
      this.fingerprintStrategy = var2;
   }

   protected void process(ByteBuffer var1) {
      this.length += 12;
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer var2 = this.mixer;
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
      var2 = this.mixer;
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
      var2 = this.mixer;
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$500(this.mixer);
   }

   protected void processRemaining(ByteBuffer var1) {
      this.length += var1.remaining();
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer var2;
      switch(var1.remaining()) {
      case 3:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + (UnsignedBytes.toInt(var1.get(2)) << 16));
      case 2:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + (UnsignedBytes.toInt(var1.get(1)) << 8));
      case 1:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + UnsignedBytes.toInt(var1.get(0)));
         break;
      case 7:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(var2) + (UnsignedBytes.toInt(var1.get(6)) << 16));
      case 6:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(var2) + (UnsignedBytes.toInt(var1.get(5)) << 8));
      case 5:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(var2) + UnsignedBytes.toInt(var1.get(4)));
      case 4:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
         break;
      case 11:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(var2) + (var1.get(10) << 24));
      case 10:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(var2) + (UnsignedBytes.toInt(var1.get(9)) << 16));
      case 9:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(var2) + (UnsignedBytes.toInt(var1.get(8)) << 8));
      case 8:
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
         var2 = this.mixer;
         GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(var2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(var2) + this.fingerprintStrategy.maybeAddSignCruft(var1.getInt()));
         break;
      default:
         throw new AssertionError("Should never get here.");
      }

   }

   public HashCode makeHash() {
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer var1 = this.mixer;
      GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(var1, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(var1) + this.length);
      return this.mixer.makeHash();
   }

   // $FF: synthetic method
   GoogleLegacy32HashFunction$GoogleLegacy32Hasher(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var1, GoogleLegacy32HashFunction$FingerprintStrategy var2, GoogleLegacy32HashFunction$1 var3) {
      this(var1, var2);
   }
}
