package org.jfree.ui.tabbedui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.ui.tabbedui.AbstractTabbedUI;

class AbstractTabbedUI$TabChangeHandler implements ChangeListener {
   private final JTabbedPane pane;
   private final AbstractTabbedUI this$0;

   public AbstractTabbedUI$TabChangeHandler(AbstractTabbedUI var1, JTabbedPane var2) {
      this.this$0 = var1;
      this.pane = var2;
   }

   public void stateChanged(ChangeEvent var1) {
      this.this$0.setSelectedEditor(this.pane.getSelectedIndex());
   }
}
