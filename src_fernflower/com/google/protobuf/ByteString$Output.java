package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LiteralByteString;
import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output extends OutputStream {
   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
   private final int initialCapacity;
   private final ArrayList flushedBuffers;
   private int flushedBuffersTotalBytes;
   private byte[] buffer;
   private int bufferPos;

   ByteString$Output(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Buffer size < 0");
      } else {
         this.initialCapacity = var1;
         this.flushedBuffers = new ArrayList();
         this.buffer = new byte[var1];
      }
   }

   public synchronized void write(int var1) {
      if(this.bufferPos == this.buffer.length) {
         this.flushFullBuffer(1);
      }

      this.buffer[this.bufferPos++] = (byte)var1;
   }

   public synchronized void write(byte[] var1, int var2, int var3) {
      if(var3 <= this.buffer.length - this.bufferPos) {
         System.arraycopy(var1, var2, this.buffer, this.bufferPos, var3);
         this.bufferPos += var3;
      } else {
         int var4 = this.buffer.length - this.bufferPos;
         System.arraycopy(var1, var2, this.buffer, this.bufferPos, var4);
         var2 += var4;
         var3 -= var4;
         this.flushFullBuffer(var3);
         System.arraycopy(var1, var2, this.buffer, 0, var3);
         this.bufferPos = var3;
      }

   }

   public synchronized ByteString toByteString() {
      this.flushLastBuffer();
      return ByteString.copyFrom((Iterable)this.flushedBuffers);
   }

   private byte[] copyArray(byte[] var1, int var2) {
      byte[] var3 = new byte[var2];
      System.arraycopy(var1, 0, var3, 0, Math.min(var1.length, var2));
      return var3;
   }

   public void writeTo(OutputStream var1) {
      ByteString[] var2;
      byte[] var3;
      int var4;
      synchronized(this) {
         var2 = (ByteString[])this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
         var3 = this.buffer;
         var4 = this.bufferPos;
      }

      ByteString[] var5 = var2;
      int var6 = var2.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         ByteString var8 = var5[var7];
         var8.writeTo(var1);
      }

      var1.write(this.copyArray(var3, var4));
   }

   public synchronized int size() {
      return this.flushedBuffersTotalBytes + this.bufferPos;
   }

   public synchronized void reset() {
      this.flushedBuffers.clear();
      this.flushedBuffersTotalBytes = 0;
      this.bufferPos = 0;
   }

   public String toString() {
      return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(this.size())});
   }

   private void flushFullBuffer(int var1) {
      this.flushedBuffers.add(new LiteralByteString(this.buffer));
      this.flushedBuffersTotalBytes += this.buffer.length;
      int var2 = Math.max(this.initialCapacity, Math.max(var1, this.flushedBuffersTotalBytes >>> 1));
      this.buffer = new byte[var2];
      this.bufferPos = 0;
   }

   private void flushLastBuffer() {
      if(this.bufferPos < this.buffer.length) {
         if(this.bufferPos > 0) {
            byte[] var1 = this.copyArray(this.buffer, this.bufferPos);
            this.flushedBuffers.add(new LiteralByteString(var1));
         }
      } else {
         this.flushedBuffers.add(new LiteralByteString(this.buffer));
         this.buffer = EMPTY_BYTE_ARRAY;
      }

      this.flushedBuffersTotalBytes += this.bufferPos;
      this.bufferPos = 0;
   }
}
