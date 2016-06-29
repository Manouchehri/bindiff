package com.google.common.hash;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

enum Hashing$ChecksumType$1 {
   Hashing$ChecksumType$1(int var3) {
   }

   public Checksum get() {
      return new CRC32();
   }
}
