package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;

class JStackPanel$InternalListener implements IStackModelListener {
   // $FF: synthetic field
   final JStackPanel this$0;

   private JStackPanel$InternalListener(JStackPanel var1) {
      this.this$0 = var1;
   }

   public void dataChanged() {
      this.this$0.repaint();
   }

   // $FF: synthetic method
   JStackPanel$InternalListener(JStackPanel var1, JStackPanel$1 var2) {
      this(var1);
   }
}
