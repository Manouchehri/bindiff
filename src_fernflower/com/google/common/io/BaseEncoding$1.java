package com.google.common.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import java.io.OutputStream;

class BaseEncoding$1 extends ByteSink {
   // $FF: synthetic field
   final CharSink val$encodedSink;
   // $FF: synthetic field
   final BaseEncoding this$0;

   BaseEncoding$1(BaseEncoding var1, CharSink var2) {
      this.this$0 = var1;
      this.val$encodedSink = var2;
   }

   public OutputStream openStream() {
      return this.this$0.encodingStream(this.val$encodedSink.openStream());
   }
}
