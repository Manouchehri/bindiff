package com.google.common.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

final class ByteBuffers$2 extends InputStream {
   // $FF: synthetic field
   final ByteBuffer val$buf;

   ByteBuffers$2(ByteBuffer var1) {
      this.val$buf = var1;
   }

   public int read() {
      try {
         return UnsignedBytes.toInt(this.val$buf.get());
      } catch (BufferUnderflowException var2) {
         return -1;
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.val$buf.hasRemaining()) {
         int var4 = Math.min(var3, this.val$buf.remaining());
         this.val$buf.get(var1, var2, var4);
         return var4;
      } else {
         return -1;
      }
   }

   public long skip(long var1) {
      if(var1 <= 0L) {
         return 0L;
      } else {
         int var3 = (int)Math.min((long)this.val$buf.remaining(), var1);
         this.val$buf.position(var3 + this.val$buf.position());
         return (long)var3;
      }
   }

   public int available() {
      return this.val$buf.remaining();
   }

   public boolean markSupported() {
      return true;
   }

   public synchronized void mark(int var1) {
      this.val$buf.mark();
   }

   public synchronized void reset() {
      try {
         this.val$buf.reset();
      } catch (InvalidMarkException var2) {
         throw new IOException(var2);
      }
   }
}
