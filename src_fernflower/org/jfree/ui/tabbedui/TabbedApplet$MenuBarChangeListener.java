package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.ui.tabbedui.TabbedApplet;

class TabbedApplet$MenuBarChangeListener implements PropertyChangeListener {
   private final TabbedApplet this$0;

   public TabbedApplet$MenuBarChangeListener(TabbedApplet var1) {
      this.this$0 = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(var1.getPropertyName().equals("jMenuBar")) {
         this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
      }

   }
}
