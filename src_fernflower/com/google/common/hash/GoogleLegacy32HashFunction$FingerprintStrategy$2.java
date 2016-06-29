package com.google.common.hash;

import com.google.common.primitives.Ints;

enum GoogleLegacy32HashFunction$FingerprintStrategy$2 {
   int maybeAddSignCruft(int var1) {
      return var1;
   }

   int word32At(byte[] var1, int var2) {
      return Ints.fromBytes(var1[var2 + 3], var1[var2 + 2], var1[var2 + 1], var1[var2]);
   }
}
