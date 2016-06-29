package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteBuffers$1;
import com.google.common.io.ByteBuffers$2;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@GoogleInternal
public final class ByteBuffers {
   public static ByteBuffer allocate(int var0) {
      return ByteBuffer.allocate(var0).order(ByteOrder.LITTLE_ENDIAN);
   }

   public static ByteBuffer allocateDirect(int var0) {
      return ByteBuffer.allocateDirect(var0).order(ByteOrder.LITTLE_ENDIAN);
   }

   public static ByteBuffer allocateDirectAndFlip(int var0) {
      ByteBuffer var1 = ByteBuffer.allocateDirect(var0).order(ByteOrder.LITTLE_ENDIAN);
      var1.flip();
      return var1;
   }

   public static ByteBuffer wrap(byte[] var0) {
      return ByteBuffer.wrap(var0).order(ByteOrder.LITTLE_ENDIAN);
   }

   public static byte[] extractBytes(ByteBuffer var0) {
      if(var0.hasArray() && var0.arrayOffset() == 0 && var0.position() == 0 && var0.limit() == var0.capacity()) {
         return var0.array();
      } else {
         byte[] var1 = new byte[var0.remaining()];
         var0.get(var1);
         var0.position(var0.position() - var1.length);
         return var1;
      }
   }

   public static ByteSource asByteSource(ByteBuffer var0) {
      Preconditions.checkNotNull(var0);
      return new ByteBuffers$1(var0);
   }

   public static InputStream newConsumingInputStream(ByteBuffer var0) {
      Preconditions.checkNotNull(var0);
      return new ByteBuffers$2(var0);
   }
}
