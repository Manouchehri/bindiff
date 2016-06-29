package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.ui.tabbedui.TabbedDialog;

class TabbedDialog$MenuBarChangeListener implements PropertyChangeListener {
   private final TabbedDialog this$0;

   public TabbedDialog$MenuBarChangeListener(TabbedDialog var1) {
      this.this$0 = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(var1.getPropertyName().equals("jMenuBar")) {
         this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
      }

   }
}
