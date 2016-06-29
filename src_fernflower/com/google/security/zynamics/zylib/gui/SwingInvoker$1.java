package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.SwingInvoker;

class SwingInvoker$1 implements Runnable {
   // $FF: synthetic field
   final SwingInvoker this$0;

   SwingInvoker$1(SwingInvoker var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.operation();
   }
}
