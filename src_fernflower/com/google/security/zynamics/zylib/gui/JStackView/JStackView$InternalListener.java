package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

class JStackView$InternalListener implements IStackModelListener, AdjustmentListener, ComponentListener {
   // $FF: synthetic field
   final JStackView this$0;

   private JStackView$InternalListener(JStackView var1) {
      this.this$0 = var1;
   }

   public void adjustmentValueChanged(AdjustmentEvent var1) {
      if(var1.getSource() == JStackView.access$200(this.this$0)) {
         JStackView.access$300(this.this$0).setFirstRow(var1.getValue());
      } else {
         JStackView.access$300(this.this$0).setFirstColumn(var1.getValue());
      }

      JStackView.access$300(this.this$0).repaint();
   }

   public void componentHidden(ComponentEvent var1) {
   }

   public void componentMoved(ComponentEvent var1) {
   }

   public void componentResized(ComponentEvent var1) {
      JStackView.access$400(this.this$0);
      JStackView.access$500(this.this$0);
   }

   public void componentShown(ComponentEvent var1) {
   }

   public void dataChanged() {
      JStackView.access$400(this.this$0);
      JStackView.access$500(this.this$0);
      JStackView.access$300(this.this$0).repaint();
   }

   // $FF: synthetic method
   JStackView$InternalListener(JStackView var1, JStackView$1 var2) {
      this(var1);
   }
}
