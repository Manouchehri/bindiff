package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$4 implements MultiplexingOutputStream$OutputStreamCaller {
   // $FF: synthetic field
   final byte[] val$b;
   // $FF: synthetic field
   final int val$off;
   // $FF: synthetic field
   final int val$len;
   // $FF: synthetic field
   final MultiplexingOutputStream this$0;

   MultiplexingOutputStream$4(MultiplexingOutputStream var1, byte[] var2, int var3, int var4) {
      this.this$0 = var1;
      this.val$b = var2;
      this.val$off = var3;
      this.val$len = var4;
   }

   public void call(OutputStream var1) {
      var1.write(this.val$b, this.val$off, this.val$len);
   }
}
