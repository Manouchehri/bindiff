package com.google.common.io;

import com.google.common.io.ByteStreams$1;
import java.io.ByteArrayOutputStream;

final class ByteStreams$FastByteArrayOutputStream extends ByteArrayOutputStream {
   private ByteStreams$FastByteArrayOutputStream() {
   }

   void writeTo(byte[] var1, int var2) {
      System.arraycopy(this.buf, 0, var1, var2, this.count);
   }

   // $FF: synthetic method
   ByteStreams$FastByteArrayOutputStream(ByteStreams$1 var1) {
      this();
   }
}
