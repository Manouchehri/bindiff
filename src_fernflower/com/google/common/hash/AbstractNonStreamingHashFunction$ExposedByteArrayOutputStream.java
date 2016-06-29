package com.google.common.hash;

import java.io.ByteArrayOutputStream;

final class AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream extends ByteArrayOutputStream {
   AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(int var1) {
      super(var1);
   }

   byte[] byteArray() {
      return this.buf;
   }

   int length() {
      return this.count;
   }
}
