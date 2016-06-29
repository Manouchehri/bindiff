package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteSource$1;
import com.google.common.io.CharSource;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

final class ByteSource$AsCharSource extends CharSource {
   private final Charset charset;
   // $FF: synthetic field
   final ByteSource this$0;

   private ByteSource$AsCharSource(ByteSource var1, Charset var2) {
      this.this$0 = var1;
      this.charset = (Charset)Preconditions.checkNotNull(var2);
   }

   public Reader openStream() {
      return new InputStreamReader(this.this$0.openStream(), this.charset);
   }

   public String toString() {
      String var1 = String.valueOf(this.this$0.toString());
      String var2 = String.valueOf(this.charset);
      return (new StringBuilder(15 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".asCharSource(").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   ByteSource$AsCharSource(ByteSource var1, Charset var2, ByteSource$1 var3) {
      this(var1, var2);
   }
}
