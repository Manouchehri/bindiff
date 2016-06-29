package org.jfree.ui.tabbedui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.jfree.ui.tabbedui.AbstractTabbedUI;

public class AbstractTabbedUI$ExitAction extends AbstractAction {
   private final AbstractTabbedUI this$0;

   public AbstractTabbedUI$ExitAction(AbstractTabbedUI var1) {
      this.this$0 = var1;
      this.putValue("Name", "Exit");
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.attempExit();
   }
}
