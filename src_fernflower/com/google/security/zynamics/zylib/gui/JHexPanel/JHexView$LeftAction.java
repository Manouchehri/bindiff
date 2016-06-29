package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class JHexView$LeftAction extends AbstractAction {
   private static final long serialVersionUID = -9032577023548944503L;
   // $FF: synthetic field
   final JHexView this$0;

   private JHexView$LeftAction(JHexView var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JHexView.access$1000(this.this$0, var1, JHexView.access$2300(this.this$0) == JHexView$Views.HEX_VIEW?-1:-2);
   }

   // $FF: synthetic method
   JHexView$LeftAction(JHexView var1, JHexView$1 var2) {
      this(var1);
   }
}
