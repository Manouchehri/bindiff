package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;

enum LittleEndianByteArray$UnsafeByteArray$2 {
   public long getLongLittleEndian(byte[] var1, int var2) {
      long var3 = LittleEndianByteArray$UnsafeByteArray.access$200().getLong(var1, (long)var2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100());
      return Long.reverseBytes(var3);
   }

   public void putLongLittleEndian(byte[] var1, int var2, long var3) {
      long var5 = Long.reverseBytes(var3);
      LittleEndianByteArray$UnsafeByteArray.access$200().putLong(var1, (long)var2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100(), var5);
   }
}
