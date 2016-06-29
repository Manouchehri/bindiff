package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

enum LittleEndianByteArray$UnsafeByteArray implements LittleEndianByteArray$LittleEndianBytes {
   UNSAFE_LITTLE_ENDIAN,
   UNSAFE_BIG_ENDIAN;

   private static final Unsafe theUnsafe;
   private static final int BYTE_ARRAY_BASE_OFFSET;

   private LittleEndianByteArray$UnsafeByteArray() {
   }

   private static Unsafe getUnsafe() {
      try {
         return Unsafe.getUnsafe();
      } catch (SecurityException var2) {
         try {
            return (Unsafe)AccessController.doPrivileged(new LittleEndianByteArray$UnsafeByteArray$3());
         } catch (PrivilegedActionException var1) {
            throw new RuntimeException("Could not initialize intrinsics", var1.getCause());
         }
      }
   }

   // $FF: synthetic method
   LittleEndianByteArray$UnsafeByteArray(LittleEndianByteArray$1 var3) {
      this();
   }

   // $FF: synthetic method
   static int access$100() {
      return BYTE_ARRAY_BASE_OFFSET;
   }

   // $FF: synthetic method
   static Unsafe access$200() {
      return theUnsafe;
   }

   static {
      theUnsafe = getUnsafe();
      BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
      if(theUnsafe.arrayIndexScale(byte[].class) != 1) {
         throw new AssertionError();
      }
   }
}
