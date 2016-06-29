package com.google.protobuf;

import java.io.OutputStream;
import java.nio.ByteBuffer;

class CodedOutputStream$ByteBufferOutputStream extends OutputStream {
   private final ByteBuffer byteBuffer;

   public CodedOutputStream$ByteBufferOutputStream(ByteBuffer var1) {
      this.byteBuffer = var1;
   }

   public void write(int var1) {
      this.byteBuffer.put((byte)var1);
   }

   public void write(byte[] var1, int var2, int var3) {
      this.byteBuffer.put(var1, var2, var3);
   }
}
