package org.jfree.ui.about;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.ui.about.SystemPropertiesPanel;

final class SystemPropertiesPanel$1 implements ActionListener {
   private final SystemPropertiesPanel this$0;

   SystemPropertiesPanel$1(SystemPropertiesPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.copySystemPropertiesToClipboard();
   }
}
