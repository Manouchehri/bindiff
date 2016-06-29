package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.MultiplexingOutputStream$1;
import com.google.common.io.MultiplexingOutputStream$2;
import com.google.common.io.MultiplexingOutputStream$3;
import com.google.common.io.MultiplexingOutputStream$4;
import com.google.common.io.MultiplexingOutputStream$5;
import com.google.common.io.MultiplexingOutputStream$MultiplexingIOException;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@GoogleInternal
public final class MultiplexingOutputStream extends OutputStream {
   private final List streams;

   public MultiplexingOutputStream(OutputStream... var1) {
      this((Iterable)Arrays.asList(var1));
   }

   public MultiplexingOutputStream(Iterable var1) {
      Preconditions.checkNotNull(var1);
      this.streams = new ArrayList();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         OutputStream var3 = (OutputStream)var2.next();
         this.streams.add(Preconditions.checkNotNull(var3));
      }

   }

   public void close() {
      this.runOnStreams(new MultiplexingOutputStream$1(this));
   }

   public void flush() {
      this.runOnStreams(new MultiplexingOutputStream$2(this));
   }

   public void write(byte[] var1) {
      Preconditions.checkNotNull(var1);
      this.runOnStreams(new MultiplexingOutputStream$3(this, var1));
   }

   public void write(byte[] var1, int var2, int var3) {
      Preconditions.checkNotNull(var1);
      this.runOnStreams(new MultiplexingOutputStream$4(this, var1, var2, var3));
   }

   public void write(int var1) {
      this.runOnStreams(new MultiplexingOutputStream$5(this, var1));
   }

   private void runOnStreams(MultiplexingOutputStream$OutputStreamCaller var1) {
      ArrayList var2 = new ArrayList(0);
      Iterator var3 = this.streams.iterator();

      while(var3.hasNext()) {
         OutputStream var4 = (OutputStream)var3.next();

         try {
            var1.call(var4);
         } catch (IOException var6) {
            var2.add(var6);
         }
      }

      if(!var2.isEmpty()) {
         throw new MultiplexingOutputStream$MultiplexingIOException(var2);
      }
   }
}
