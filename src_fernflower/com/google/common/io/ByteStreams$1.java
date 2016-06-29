package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.OutputStream;

final class ByteStreams$1 extends OutputStream {
   public void write(int var1) {
   }

   public void write(byte[] var1) {
      Preconditions.checkNotNull(var1);
   }

   public void write(byte[] var1, int var2, int var3) {
      Preconditions.checkNotNull(var1);
   }

   public String toString() {
      return "ByteStreams.nullOutputStream()";
   }
}
