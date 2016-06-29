package com.google.common.hash;

import com.google.common.base.Supplier;
import com.google.common.hash.Hashing$1;
import java.util.zip.Checksum;

enum Hashing$ChecksumType implements Supplier {
   CRC_32(32),
   ADLER_32(32);

   private final int bits;

   private Hashing$ChecksumType(int var3) {
      this.bits = var3;
   }

   public abstract Checksum get();

   // $FF: synthetic method
   static int access$300(Hashing$ChecksumType var0) {
      return var0.bits;
   }

   // $FF: synthetic method
   Hashing$ChecksumType(int var3, Hashing$1 var4) {
      this(var3);
   }
}
