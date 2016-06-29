package com.google.common.hash;

enum GoogleLegacy32HashFunction$FingerprintStrategy$1 {
   int maybeAddSignCruft(int var1) {
      return (var1 & 2139062143) - (var1 & -2139062144);
   }

   int word32At(byte[] var1, int var2) {
      return var1[var2 + 0] + (var1[var2 + 1] << 8) + (var1[var2 + 2] << 16) + (var1[var2 + 3] << 24);
   }
}
