package com.google.common.hash;

import com.google.common.hash.AbstractHasher;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.io.IOException;

final class AbstractNonStreamingHashFunction$BufferingHasher extends AbstractHasher {
   final AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream stream;
   static final int BOTTOM_BYTE = 255;
   // $FF: synthetic field
   final AbstractNonStreamingHashFunction this$0;

   AbstractNonStreamingHashFunction$BufferingHasher(AbstractNonStreamingHashFunction var1, int var2) {
      this.this$0 = var1;
      this.stream = new AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(var2);
   }

   public Hasher putByte(byte var1) {
      this.stream.write(var1);
      return this;
   }

   public Hasher putBytes(byte[] var1) {
      try {
         this.stream.write(var1);
         return this;
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }
   }

   public Hasher putBytes(byte[] var1, int var2, int var3) {
      this.stream.write(var1, var2, var3);
      return this;
   }

   public Hasher putShort(short var1) {
      this.stream.write(var1 & 255);
      this.stream.write(var1 >>> 8 & 255);
      return this;
   }

   public Hasher putInt(int var1) {
      this.stream.write(var1 & 255);
      this.stream.write(var1 >>> 8 & 255);
      this.stream.write(var1 >>> 16 & 255);
      this.stream.write(var1 >>> 24 & 255);
      return this;
   }

   public Hasher putLong(long var1) {
      for(int var3 = 0; var3 < 64; var3 += 8) {
         this.stream.write((byte)((int)(var1 >>> var3 & 255L)));
      }

      return this;
   }

   public Hasher putChar(char var1) {
      this.stream.write(var1 & 255);
      this.stream.write(var1 >>> 8 & 255);
      return this;
   }

   public Hasher putObject(Object var1, Funnel var2) {
      var2.funnel(var1, this);
      return this;
   }

   public HashCode hash() {
      return this.this$0.hashBytes(this.stream.byteArray(), 0, this.stream.length());
   }
}
