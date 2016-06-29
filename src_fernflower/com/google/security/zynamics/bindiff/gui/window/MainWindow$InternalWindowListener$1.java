package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener;

class MainWindow$InternalWindowListener$1 implements Runnable {
   // $FF: synthetic field
   final MainWindow$InternalWindowListener this$1;

   MainWindow$InternalWindowListener$1(MainWindow$InternalWindowListener var1) {
      this.this$1 = var1;
   }

   public void run() {
      MainWindow.access$400(this.this$1.this$0).exitBinDiff();
   }
}
