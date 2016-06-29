package org.jfree.ui.tabbedui;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.jfree.ui.tabbedui.TabbedFrame;

final class TabbedFrame$1 extends WindowAdapter {
   private final TabbedFrame this$0;

   TabbedFrame$1(TabbedFrame var1) {
      this.this$0 = var1;
   }

   public void windowClosing(WindowEvent var1) {
      this.this$0.getTabbedUI().getCloseAction().actionPerformed(new ActionEvent(this, 1001, (String)null, 0));
   }
}
