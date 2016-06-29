package com.google.common.io;

import com.google.common.io.ByteBuffers;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class ByteBuffers$1 extends ByteSource {
   // $FF: synthetic field
   final ByteBuffer val$buf;

   ByteBuffers$1(ByteBuffer var1) {
      this.val$buf = var1;
   }

   public InputStream openStream() {
      return ByteBuffers.newConsumingInputStream(this.val$buf.slice());
   }

   public String toString() {
      String var1 = String.valueOf(this.val$buf);
      return (new StringBuilder(26 + String.valueOf(var1).length())).append("ByteBuffers.asByteSource(").append(var1).append(")").toString();
   }
}
