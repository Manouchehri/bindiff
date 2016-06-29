package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$2 implements MultiplexingOutputStream$OutputStreamCaller {
   // $FF: synthetic field
   final MultiplexingOutputStream this$0;

   MultiplexingOutputStream$2(MultiplexingOutputStream var1) {
      this.this$0 = var1;
   }

   public void call(OutputStream var1) {
      var1.flush();
   }
}
