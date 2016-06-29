package com.google.common.io;

import com.google.common.io.LineBuffer;
import com.google.common.io.LineReader;

class LineReader$1 extends LineBuffer {
   // $FF: synthetic field
   final LineReader this$0;

   LineReader$1(LineReader var1) {
      this.this$0 = var1;
   }

   protected void handleLine(String var1, String var2) {
      LineReader.access$000(this.this$0).add(var1);
   }
}
