package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteStreams$1;
import com.google.common.io.ByteStreams$ByteArrayDataInputStream;
import com.google.common.io.ByteStreams$ByteArrayDataOutputStream;
import com.google.common.io.ByteStreams$FastByteArrayOutputStream;
import com.google.common.io.ByteStreams$LimitedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

@Beta
public final class ByteStreams {
   private static final int BUF_SIZE = 8192;
   private static final int ZERO_COPY_CHUNK_SIZE = 524288;
   private static final OutputStream NULL_OUTPUT_STREAM = new ByteStreams$1();

   public static long copy(InputStream var0, OutputStream var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      byte[] var2 = new byte[8192];
      long var3 = 0L;

      while(true) {
         int var5 = var0.read(var2);
         if(var5 == -1) {
            return var3;
         }

         var1.write(var2, 0, var5);
         var3 += (long)var5;
      }
   }

   public static long copy(ReadableByteChannel var0, WritableByteChannel var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      long var3;
      if(var0 instanceof FileChannel) {
         FileChannel var9 = (FileChannel)var0;
         var3 = var9.position();
         long var5 = var3;

         long var7;
         do {
            do {
               var7 = var9.transferTo(var5, 524288L, var1);
               var5 += var7;
               var9.position(var5);
            } while(var7 > 0L);
         } while(var5 < var9.size());

         return var5 - var3;
      } else {
         ByteBuffer var2 = ByteBuffer.allocate(8192);
         var3 = 0L;

         while(var0.read(var2) != -1) {
            var2.flip();

            while(var2.hasRemaining()) {
               var3 += (long)var1.write(var2);
            }

            var2.clear();
         }

         return var3;
      }
   }

   public static byte[] toByteArray(InputStream var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      copy((InputStream)var0, (OutputStream)var1);
      return var1.toByteArray();
   }

   static byte[] toByteArray(InputStream var0, int var1) {
      byte[] var2 = new byte[var1];

      int var4;
      int var5;
      for(int var3 = var1; var3 > 0; var3 -= var5) {
         var4 = var1 - var3;
         var5 = var0.read(var2, var4, var3);
         if(var5 == -1) {
            return Arrays.copyOf(var2, var4);
         }
      }

      var4 = var0.read();
      if(var4 == -1) {
         return var2;
      } else {
         ByteStreams$FastByteArrayOutputStream var7 = new ByteStreams$FastByteArrayOutputStream((ByteStreams$1)null);
         var7.write(var4);
         copy((InputStream)var0, (OutputStream)var7);
         byte[] var6 = new byte[var2.length + var7.size()];
         System.arraycopy(var2, 0, var6, 0, var2.length);
         var7.writeTo(var6, var2.length);
         return var6;
      }
   }

   public static ByteArrayDataInput newDataInput(byte[] var0) {
      return newDataInput(new ByteArrayInputStream(var0));
   }

   public static ByteArrayDataInput newDataInput(byte[] var0, int var1) {
      Preconditions.checkPositionIndex(var1, var0.length);
      return newDataInput(new ByteArrayInputStream(var0, var1, var0.length - var1));
   }

   public static ByteArrayDataInput newDataInput(ByteArrayInputStream var0) {
      return new ByteStreams$ByteArrayDataInputStream((ByteArrayInputStream)Preconditions.checkNotNull(var0));
   }

   public static ByteArrayDataOutput newDataOutput() {
      return newDataOutput(new ByteArrayOutputStream());
   }

   public static ByteArrayDataOutput newDataOutput(int var0) {
      if(var0 < 0) {
         throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(var0)}));
      } else {
         return newDataOutput(new ByteArrayOutputStream(var0));
      }
   }

   public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream var0) {
      return new ByteStreams$ByteArrayDataOutputStream((ByteArrayOutputStream)Preconditions.checkNotNull(var0));
   }

   public static OutputStream nullOutputStream() {
      return NULL_OUTPUT_STREAM;
   }

   public static InputStream limit(InputStream var0, long var1) {
      return new ByteStreams$LimitedInputStream(var0, var1);
   }

   public static void readFully(InputStream var0, byte[] var1) {
      readFully(var0, var1, 0, var1.length);
   }

   public static void readFully(InputStream var0, byte[] var1, int var2, int var3) {
      int var4 = read(var0, var1, var2, var3);
      if(var4 != var3) {
         throw new EOFException((new StringBuilder(81)).append("reached end of stream after reading ").append(var4).append(" bytes; ").append(var3).append(" bytes expected").toString());
      }
   }

   public static void skipFully(InputStream var0, long var1) {
      long var3 = var1;

      while(var1 > 0L) {
         long var5 = var0.skip(var1);
         if(var5 == 0L) {
            if(var0.read() == -1) {
               long var7 = var3 - var1;
               throw new EOFException((new StringBuilder(100)).append("reached end of stream after skipping ").append(var7).append(" bytes; ").append(var3).append(" bytes expected").toString());
            }

            --var1;
         } else {
            var1 -= var5;
         }
      }

   }

   public static Object readBytes(InputStream var0, ByteProcessor var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      byte[] var2 = new byte[8192];

      int var3;
      do {
         var3 = var0.read(var2);
      } while(var3 != -1 && var1.processBytes(var2, 0, var3));

      return var1.getResult();
   }

   public static int read(InputStream var0, byte[] var1, int var2, int var3) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(var3 < 0) {
         throw new IndexOutOfBoundsException("len is negative");
      } else {
         int var4;
         int var5;
         for(var4 = 0; var4 < var3; var4 += var5) {
            var5 = var0.read(var1, var2 + var4, var3 - var4);
            if(var5 == -1) {
               break;
            }
         }

         return var4;
      }
   }
}
