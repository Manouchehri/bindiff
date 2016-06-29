package org.jfree.ui.about;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jfree.ui.about.SystemPropertiesPanel;

class SystemPropertiesPanel$PopupListener extends MouseAdapter {
   private final SystemPropertiesPanel this$0;

   public SystemPropertiesPanel$PopupListener(SystemPropertiesPanel var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      this.maybeShowPopup(var1);
   }

   public void mouseReleased(MouseEvent var1) {
      this.maybeShowPopup(var1);
   }

   private void maybeShowPopup(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         this.this$0.getCopyPopupMenu().show(this.this$0.getTable(), var1.getX(), var1.getY());
      }

   }
}
