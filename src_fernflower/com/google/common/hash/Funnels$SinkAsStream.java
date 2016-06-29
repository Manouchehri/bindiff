package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;

class Funnels$SinkAsStream extends OutputStream {
   final PrimitiveSink sink;

   Funnels$SinkAsStream(PrimitiveSink var1) {
      this.sink = (PrimitiveSink)Preconditions.checkNotNull(var1);
   }

   public void write(int var1) {
      this.sink.putByte((byte)var1);
   }

   public void write(byte[] var1) {
      this.sink.putBytes(var1);
   }

   public void write(byte[] var1, int var2, int var3) {
      this.sink.putBytes(var1, var2, var3);
   }

   public String toString() {
      String var1 = String.valueOf(this.sink);
      return (new StringBuilder(24 + String.valueOf(var1).length())).append("Funnels.asOutputStream(").append(var1).append(")").toString();
   }
}
