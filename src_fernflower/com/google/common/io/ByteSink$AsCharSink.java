package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSink$1;
import com.google.common.io.CharSink;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class ByteSink$AsCharSink extends CharSink {
   private final Charset charset;
   // $FF: synthetic field
   final ByteSink this$0;

   private ByteSink$AsCharSink(ByteSink var1, Charset var2) {
      this.this$0 = var1;
      this.charset = (Charset)Preconditions.checkNotNull(var2);
   }

   public Writer openStream() {
      return new OutputStreamWriter(this.this$0.openStream(), this.charset);
   }

   public String toString() {
      String var1 = String.valueOf(this.this$0.toString());
      String var2 = String.valueOf(this.charset);
      return (new StringBuilder(13 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".asCharSink(").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   ByteSink$AsCharSink(ByteSink var1, Charset var2, ByteSink$1 var3) {
      this(var1, var2);
   }
}
