package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.ui.tabbedui.TabbedFrame;

class TabbedFrame$MenuBarChangeListener implements PropertyChangeListener {
   private final TabbedFrame this$0;

   public TabbedFrame$MenuBarChangeListener(TabbedFrame var1) {
      this.this$0 = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(var1.getPropertyName().equals("jMenuBar")) {
         this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
      }

   }
}
