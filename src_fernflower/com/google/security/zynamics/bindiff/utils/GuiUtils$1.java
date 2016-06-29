package com.google.security.zynamics.bindiff.utils;

import javax.swing.JComponent;

final class GuiUtils$1 implements Runnable {
   // $FF: synthetic field
   final JComponent val$component;

   GuiUtils$1(JComponent var1) {
      this.val$component = var1;
   }

   public void run() {
      this.val$component.updateUI();
   }
}
