package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink$1;
import com.google.common.io.ByteSink$AsCharSink;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.Closer;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public abstract class ByteSink {
   public CharSink asCharSink(Charset var1) {
      return new ByteSink$AsCharSink(this, var1, (ByteSink$1)null);
   }

   public abstract OutputStream openStream();

   public OutputStream openBufferedStream() {
      OutputStream var1 = this.openStream();
      return var1 instanceof BufferedOutputStream?(BufferedOutputStream)var1:new BufferedOutputStream(var1);
   }

   @GoogleInternal
   public WritableByteChannel openChannel() {
      return Channels.newChannel(this.openStream());
   }

   public void write(byte[] var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      try {
         OutputStream var3 = (OutputStream)var2.register(this.openStream());
         var3.write(var1);
         var3.flush();
      } catch (Throwable var7) {
         throw var2.rethrow(var7);
      } finally {
         var2.close();
      }

   }

   public long writeFrom(InputStream var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var6;
      try {
         OutputStream var3 = (OutputStream)var2.register(this.openStream());
         long var4 = ByteStreams.copy(var1, var3);
         var3.flush();
         var6 = var4;
      } catch (Throwable var11) {
         throw var2.rethrow(var11);
      } finally {
         var2.close();
      }

      return var6;
   }

   @GoogleInternal
   public long writeFrom(ReadableByteChannel var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var4;
      try {
         WritableByteChannel var3 = (WritableByteChannel)var2.register(this.openChannel());
         var4 = ByteStreams.copy(var1, var3);
      } catch (Throwable var9) {
         throw var2.rethrow(var9);
      } finally {
         var2.close();
      }

      return var4;
   }
}
