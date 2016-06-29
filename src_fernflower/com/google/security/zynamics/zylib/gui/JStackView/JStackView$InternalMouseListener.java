package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.JStackView;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

class JStackView$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final JStackView this$0;

   private JStackView$InternalMouseListener(JStackView var1) {
      this.this$0 = var1;
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      if(this.this$0.isEnabled()) {
         int var2 = var1.getWheelRotation();
         JStackView.access$200(this.this$0).setValue(JStackView.access$200(this.this$0).getValue() + var2);
      }
   }

   // $FF: synthetic method
   JStackView$InternalMouseListener(JStackView var1, JStackView$1 var2) {
      this(var1);
   }
}
