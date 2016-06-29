package com.google.common.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStream;

class BaseEncoding$2 extends ByteSource {
   // $FF: synthetic field
   final CharSource val$encodedSource;
   // $FF: synthetic field
   final BaseEncoding this$0;

   BaseEncoding$2(BaseEncoding var1, CharSource var2) {
      this.this$0 = var1;
      this.val$encodedSource = var2;
   }

   public InputStream openStream() {
      return this.this$0.decodingStream(this.val$encodedSource.openStream());
   }
}
