package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.RootEditor;
import org.jfree.util.Log;

class AbstractTabbedUI$TabEnableChangeListener implements PropertyChangeListener {
   private final AbstractTabbedUI this$0;

   public AbstractTabbedUI$TabEnableChangeListener(AbstractTabbedUI var1) {
      this.this$0 = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(!var1.getPropertyName().equals("enabled")) {
         Log.debug("PropertyName");
      } else if(!(var1.getSource() instanceof RootEditor)) {
         Log.debug("Source");
      } else {
         RootEditor var2 = (RootEditor)var1.getSource();
         this.this$0.updateRootEditorEnabled(var2);
      }
   }
}
