package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import java.io.InputStream;

final class ByteSource$SlicedByteSource extends ByteSource {
   final long offset;
   final long length;
   // $FF: synthetic field
   final ByteSource this$0;

   ByteSource$SlicedByteSource(ByteSource var1, long var2, long var4) {
      this.this$0 = var1;
      Preconditions.checkArgument(var2 >= 0L, "offset (%s) may not be negative", new Object[]{Long.valueOf(var2)});
      Preconditions.checkArgument(var4 >= 0L, "length (%s) may not be negative", new Object[]{Long.valueOf(var4)});
      this.offset = var2;
      this.length = var4;
   }

   public InputStream openStream() {
      return this.sliceStream(this.this$0.openStream());
   }

   public InputStream openBufferedStream() {
      return this.sliceStream(this.this$0.openBufferedStream());
   }

   private InputStream sliceStream(InputStream var1) {
      if(this.offset > 0L) {
         try {
            ByteStreams.skipFully(var1, this.offset);
         } catch (Throwable var8) {
            Throwable var2 = var8;
            Closer var3 = Closer.create();
            var3.register(var1);

            try {
               throw var3.rethrow(var2);
            } finally {
               var3.close();
            }
         }
      }

      return ByteStreams.limit(var1, this.length);
   }

   public ByteSource slice(long var1, long var3) {
      Preconditions.checkArgument(var1 >= 0L, "offset (%s) may not be negative", new Object[]{Long.valueOf(var1)});
      Preconditions.checkArgument(var3 >= 0L, "length (%s) may not be negative", new Object[]{Long.valueOf(var3)});
      long var5 = this.length - var1;
      return this.this$0.slice(this.offset + var1, Math.min(var3, var5));
   }

   public boolean isEmpty() {
      return this.length == 0L || super.isEmpty();
   }

   public Optional sizeIfKnown() {
      Optional var1 = this.this$0.sizeIfKnown();
      return var1.isPresent()?Optional.of(Long.valueOf(Math.min(this.offset + this.length, ((Long)var1.get()).longValue()) - this.offset)):Optional.absent();
   }

   public String toString() {
      String var1 = String.valueOf(this.this$0.toString());
      long var2 = this.offset;
      long var4 = this.length;
      return (new StringBuilder(50 + String.valueOf(var1).length())).append(var1).append(".slice(").append(var2).append(", ").append(var4).append(")").toString();
   }
}
