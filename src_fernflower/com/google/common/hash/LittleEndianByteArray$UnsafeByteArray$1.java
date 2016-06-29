package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;

enum LittleEndianByteArray$UnsafeByteArray$1 {
   public long getLongLittleEndian(byte[] var1, int var2) {
      return LittleEndianByteArray$UnsafeByteArray.access$200().getLong(var1, (long)var2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100());
   }

   public void putLongLittleEndian(byte[] var1, int var2, long var3) {
      LittleEndianByteArray$UnsafeByteArray.access$200().putLong(var1, (long)var2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100(), var3);
   }
}
