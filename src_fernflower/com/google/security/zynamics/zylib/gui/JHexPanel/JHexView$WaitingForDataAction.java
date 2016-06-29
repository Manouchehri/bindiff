package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

class JHexView$WaitingForDataAction extends AbstractAction {
   private static final long serialVersionUID = -610823391617272365L;
   private final long m_offset;
   private final int m_size;
   // $FF: synthetic field
   final JHexView this$0;

   private JHexView$WaitingForDataAction(JHexView var1, long var2, int var4) {
      this.this$0 = var1;
      this.m_offset = var2;
      this.m_size = var4;
   }

   public void actionPerformed(ActionEvent var1) {
      if(JHexView.access$1100(this.this$0).hasData(this.m_offset, this.m_size)) {
         this.this$0.setEnabled(true);
         this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
         ((Timer)var1.getSource()).stop();
      } else if(!JHexView.access$1100(this.this$0).keepTrying()) {
         ((Timer)var1.getSource()).stop();
      }

   }

   // $FF: synthetic method
   JHexView$WaitingForDataAction(JHexView var1, long var2, int var4, JHexView$1 var5) {
      this(var1, var2, var4);
   }
}
