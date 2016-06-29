package org.jfree.ui.tabbedui;

import javax.swing.JComponent;
import org.jfree.ui.tabbedui.RootEditor;

public abstract class RootPanel extends JComponent implements RootEditor {
   private boolean active;

   public final boolean isActive() {
      return this.active;
   }

   protected void panelActivated() {
   }

   protected void panelDeactivated() {
   }

   public final void setActive(boolean var1) {
      if(this.active != var1) {
         this.active = var1;
         if(var1) {
            this.panelActivated();
         } else {
            this.panelDeactivated();
         }

      }
   }

   public JComponent getMainPanel() {
      return this;
   }

   public JComponent getToolbar() {
      return null;
   }
}
