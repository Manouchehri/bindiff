package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource$ByteArrayByteSource;
import com.google.common.io.CharSource;
import java.nio.charset.Charset;

final class ByteSource$EmptyByteSource extends ByteSource$ByteArrayByteSource {
   static final ByteSource$EmptyByteSource INSTANCE = new ByteSource$EmptyByteSource();

   ByteSource$EmptyByteSource() {
      super(new byte[0]);
   }

   public CharSource asCharSource(Charset var1) {
      Preconditions.checkNotNull(var1);
      return CharSource.empty();
   }

   public byte[] read() {
      return this.bytes;
   }

   public String toString() {
      return "ByteSource.empty()";
   }
}
