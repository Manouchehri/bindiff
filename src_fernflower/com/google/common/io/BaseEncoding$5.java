package com.google.common.io;

import java.io.Writer;

final class BaseEncoding$5 extends Writer {
   // $FF: synthetic field
   final Appendable val$seperatingAppendable;
   // $FF: synthetic field
   final Writer val$delegate;

   BaseEncoding$5(Appendable var1, Writer var2) {
      this.val$seperatingAppendable = var1;
      this.val$delegate = var2;
   }

   public void write(int var1) {
      this.val$seperatingAppendable.append((char)var1);
   }

   public void write(char[] var1, int var2, int var3) {
      throw new UnsupportedOperationException();
   }

   public void flush() {
      this.val$delegate.flush();
   }

   public void close() {
      this.val$delegate.close();
   }
}
