package com.google.common.hash;

import com.google.common.hash.GoogleLegacy32HashFunction$1;

enum GoogleLegacy32HashFunction$FingerprintStrategy {
   WORKING,
   BROKEN;

   private GoogleLegacy32HashFunction$FingerprintStrategy() {
   }

   abstract int maybeAddSignCruft(int var1);

   abstract int word32At(byte[] var1, int var2);

   // $FF: synthetic method
   GoogleLegacy32HashFunction$FingerprintStrategy(GoogleLegacy32HashFunction$1 var3) {
      this();
   }
}
