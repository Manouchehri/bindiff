package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class JHexView$PageDownAction extends AbstractAction {
   private static final long serialVersionUID = 490837791577654025L;
   // $FF: synthetic field
   final JHexView this$0;

   private JHexView$PageDownAction(JHexView var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JHexView.access$1000(this.this$0, var1, JHexView.access$2800(this.this$0) * JHexView.access$900(this.this$0) * 2);
   }

   // $FF: synthetic method
   JHexView$PageDownAction(JHexView var1, JHexView$1 var2) {
      this(var1);
   }
}
