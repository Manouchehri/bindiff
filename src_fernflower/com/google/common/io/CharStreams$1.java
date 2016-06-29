package com.google.common.io;

import java.io.Closeable;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharStreams$1 extends Reader {
   // $FF: synthetic field
   final Readable val$readable;

   CharStreams$1(Readable var1) {
      this.val$readable = var1;
   }

   public int read(char[] var1, int var2, int var3) {
      return this.read(CharBuffer.wrap(var1, var2, var3));
   }

   public int read(CharBuffer var1) {
      return this.val$readable.read(var1);
   }

   public void close() {
      if(this.val$readable instanceof Closeable) {
         ((Closeable)this.val$readable).close();
      }

   }
}
