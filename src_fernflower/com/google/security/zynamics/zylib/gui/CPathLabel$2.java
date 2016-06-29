package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class CPathLabel$2 extends ComponentAdapter {
   // $FF: synthetic field
   final CPathLabel this$0;

   CPathLabel$2(CPathLabel var1) {
      this.this$0 = var1;
   }

   public void componentResized(ComponentEvent var1) {
      this.this$0.updatePathEllipsis();
   }
}
