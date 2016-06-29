package org.jfree.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.ui.StrokeChooserPanel;

final class StrokeChooserPanel$1 implements ActionListener {
   private final StrokeChooserPanel this$0;

   StrokeChooserPanel$1(StrokeChooserPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.getSelector().transferFocus();
   }
}
