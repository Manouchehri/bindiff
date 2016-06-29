package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource$1;
import com.google.common.io.ByteSource$AsCharSource;
import com.google.common.io.ByteSource$ByteArrayByteSource;
import com.google.common.io.ByteSource$ConcatenatedByteSource;
import com.google.common.io.ByteSource$EmptyByteSource;
import com.google.common.io.ByteSource$SlicedByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ByteSource {
   private static final int BUF_SIZE = 4096;
   private static final byte[] countBuffer = new byte[4096];

   public CharSource asCharSource(Charset var1) {
      return new ByteSource$AsCharSource(this, var1, (ByteSource$1)null);
   }

   public abstract InputStream openStream();

   public InputStream openBufferedStream() {
      InputStream var1 = this.openStream();
      return var1 instanceof BufferedInputStream?(BufferedInputStream)var1:new BufferedInputStream(var1);
   }

   @GoogleInternal
   public ReadableByteChannel openChannel() {
      return Channels.newChannel(this.openStream());
   }

   public ByteSource slice(long var1, long var3) {
      return new ByteSource$SlicedByteSource(this, var1, var3);
   }

   public boolean isEmpty() {
      Optional var1 = this.sizeIfKnown();
      if(var1.isPresent() && ((Long)var1.get()).longValue() == 0L) {
         return true;
      } else {
         Closer var2 = Closer.create();

         boolean var4;
         try {
            InputStream var3 = (InputStream)var2.register(this.openStream());
            var4 = var3.read() == -1;
         } catch (Throwable var8) {
            throw var2.rethrow(var8);
         } finally {
            var2.close();
         }

         return var4;
      }
   }

   @Beta
   public Optional sizeIfKnown() {
      return Optional.absent();
   }

   public long size() {
      Optional var1 = this.sizeIfKnown();
      if(var1.isPresent()) {
         return ((Long)var1.get()).longValue();
      } else {
         Closer var2 = Closer.create();

         InputStream var3;
         long var4;
         try {
            var3 = (InputStream)var2.register(this.openStream());
            var4 = this.countBySkipping(var3);
            return var4;
         } catch (IOException var18) {
            ;
         } finally {
            var2.close();
         }

         var2 = Closer.create();

         try {
            var3 = (InputStream)var2.register(this.openStream());
            var4 = this.countByReading(var3);
         } catch (Throwable var16) {
            throw var2.rethrow(var16);
         } finally {
            var2.close();
         }

         return var4;
      }
   }

   private long countBySkipping(InputStream var1) {
      long var2 = 0L;

      while(true) {
         while(true) {
            long var4 = var1.skip((long)Math.min(var1.available(), Integer.MAX_VALUE));
            if(var4 <= 0L) {
               if(var1.read() == -1) {
                  return var2;
               }

               if(var2 == 0L && var1.available() == 0) {
                  throw new IOException();
               }

               ++var2;
            } else {
               var2 += var4;
            }
         }
      }
   }

   private long countByReading(InputStream var1) {
      long var2;
      long var4;
      for(var2 = 0L; (var4 = (long)var1.read(countBuffer)) != -1L; var2 += var4) {
         ;
      }

      return var2;
   }

   public long copyTo(OutputStream var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var4;
      try {
         InputStream var3 = (InputStream)var2.register(this.openStream());
         var4 = ByteStreams.copy(var3, var1);
      } catch (Throwable var9) {
         throw var2.rethrow(var9);
      } finally {
         var2.close();
      }

      return var4;
   }

   public long copyTo(ByteSink var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var5;
      try {
         InputStream var3 = (InputStream)var2.register(this.openStream());
         OutputStream var4 = (OutputStream)var2.register(var1.openStream());
         var5 = ByteStreams.copy(var3, var4);
      } catch (Throwable var10) {
         throw var2.rethrow(var10);
      } finally {
         var2.close();
      }

      return var5;
   }

   @GoogleInternal
   public long copyTo(WritableByteChannel var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var4;
      try {
         ReadableByteChannel var3 = (ReadableByteChannel)var2.register(this.openChannel());
         var4 = ByteStreams.copy(var3, var1);
      } catch (Throwable var9) {
         throw var2.rethrow(var9);
      } finally {
         var2.close();
      }

      return var4;
   }

   public byte[] read() {
      Closer var1 = Closer.create();

      byte[] var3;
      try {
         InputStream var2 = (InputStream)var1.register(this.openStream());
         var3 = ByteStreams.toByteArray(var2);
      } catch (Throwable var7) {
         throw var1.rethrow(var7);
      } finally {
         var1.close();
      }

      return var3;
   }

   @Beta
   public Object read(ByteProcessor var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      Object var4;
      try {
         InputStream var3 = (InputStream)var2.register(this.openStream());
         var4 = ByteStreams.readBytes(var3, var1);
      } catch (Throwable var8) {
         throw var2.rethrow(var8);
      } finally {
         var2.close();
      }

      return var4;
   }

   public HashCode hash(HashFunction var1) {
      Hasher var2 = var1.newHasher();
      this.copyTo(Funnels.asOutputStream(var2));
      return var2.hash();
   }

   public boolean contentEquals(ByteSource var1) {
      Preconditions.checkNotNull(var1);
      byte[] var2 = new byte[4096];
      byte[] var3 = new byte[4096];
      Closer var4 = Closer.create();

      try {
         InputStream var5 = (InputStream)var4.register(this.openStream());
         InputStream var6 = (InputStream)var4.register(var1.openStream());

         int var7;
         boolean var9;
         do {
            var7 = ByteStreams.read(var5, var2, 0, 4096);
            int var8 = ByteStreams.read(var6, var3, 0, 4096);
            if(var7 != var8 || !Arrays.equals(var2, var3)) {
               var9 = false;
               return var9;
            }
         } while(var7 == 4096);

         var9 = true;
         return var9;
      } catch (Throwable var13) {
         throw var4.rethrow(var13);
      } finally {
         var4.close();
      }
   }

   public static ByteSource concat(Iterable var0) {
      return new ByteSource$ConcatenatedByteSource(var0);
   }

   public static ByteSource concat(Iterator var0) {
      return concat((Iterable)ImmutableList.copyOf(var0));
   }

   public static ByteSource concat(ByteSource... var0) {
      return concat((Iterable)ImmutableList.copyOf((Object[])var0));
   }

   public static ByteSource wrap(byte[] var0) {
      return new ByteSource$ByteArrayByteSource(var0);
   }

   public static ByteSource empty() {
      return ByteSource$EmptyByteSource.INSTANCE;
   }
}
