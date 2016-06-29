package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

class ByteSource$ByteArrayByteSource extends ByteSource {
   final byte[] bytes;
   final int offset;
   final int length;

   ByteSource$ByteArrayByteSource(byte[] var1) {
      this(var1, 0, var1.length);
   }

   ByteSource$ByteArrayByteSource(byte[] var1, int var2, int var3) {
      this.bytes = var1;
      this.offset = var2;
      this.length = var3;
   }

   public InputStream openStream() {
      return new ByteArrayInputStream(this.bytes, this.offset, this.length);
   }

   public InputStream openBufferedStream() {
      return this.openStream();
   }

   public boolean isEmpty() {
      return this.length == 0;
   }

   public long size() {
      return (long)this.length;
   }

   public Optional sizeIfKnown() {
      return Optional.of(Long.valueOf((long)this.length));
   }

   public byte[] read() {
      return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
   }

   public long copyTo(OutputStream var1) {
      var1.write(this.bytes, this.offset, this.length);
      return (long)this.length;
   }

   @GoogleInternal
   public long copyTo(WritableByteChannel var1) {
      return (long)var1.write(ByteBuffer.wrap(this.bytes, this.offset, this.length));
   }

   public Object read(ByteProcessor var1) {
      var1.processBytes(this.bytes, this.offset, this.length);
      return var1.getResult();
   }

   public HashCode hash(HashFunction var1) {
      return var1.hashBytes(this.bytes, this.offset, this.length);
   }

   public ByteSource slice(long var1, long var3) {
      Preconditions.checkArgument(var1 >= 0L, "offset (%s) may not be negative", new Object[]{Long.valueOf(var1)});
      Preconditions.checkArgument(var3 >= 0L, "length (%s) may not be negative", new Object[]{Long.valueOf(var3)});
      int var5 = this.offset + (int)Math.min((long)this.length, var1);
      int var6 = this.offset + (int)Math.min((long)this.length, var1 + var3);
      return new ByteSource$ByteArrayByteSource(this.bytes, var5, var6 - var5);
   }

   public String toString() {
      String var1 = truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...");
      return (new StringBuilder(17 + String.valueOf(var1).length())).append("ByteSource.wrap(").append(var1).append(")").toString();
   }

   private static String truncate(CharSequence var0, int var1, String var2) {
      Preconditions.checkNotNull(var0);
      int var3 = var1 - var2.length();
      Preconditions.checkArgument(var3 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2.length())});
      if(((CharSequence)var0).length() <= var1) {
         String var4 = ((CharSequence)var0).toString();
         if(var4.length() <= var1) {
            return var4;
         }

         var0 = var4;
      }

      return (new StringBuilder(var1)).append((CharSequence)var0, 0, var3).append(var2).toString();
   }
}
