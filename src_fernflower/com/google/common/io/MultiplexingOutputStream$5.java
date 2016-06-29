package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$5 implements MultiplexingOutputStream$OutputStreamCaller {
   // $FF: synthetic field
   final int val$b;
   // $FF: synthetic field
   final MultiplexingOutputStream this$0;

   MultiplexingOutputStream$5(MultiplexingOutputStream var1, int var2) {
      this.this$0 = var1;
      this.val$b = var2;
   }

   public void call(OutputStream var1) {
      var1.write(this.val$b);
   }
}
