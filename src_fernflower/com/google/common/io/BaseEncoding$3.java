package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.Reader;

final class BaseEncoding$3 extends Reader {
   // $FF: synthetic field
   final Reader val$delegate;
   // $FF: synthetic field
   final CharMatcher val$toIgnore;

   BaseEncoding$3(Reader var1, CharMatcher var2) {
      this.val$delegate = var1;
      this.val$toIgnore = var2;
   }

   public int read() {
      int var1;
      do {
         var1 = this.val$delegate.read();
      } while(var1 != -1 && this.val$toIgnore.matches((char)var1));

      return var1;
   }

   public int read(char[] var1, int var2, int var3) {
      throw new UnsupportedOperationException();
   }

   public void close() {
      this.val$delegate.close();
   }
}
