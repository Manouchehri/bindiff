package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

class JStackPanel$WaitingForDataAction extends AbstractAction {
   private static final long serialVersionUID = -610823391617272365L;
   private final long m_startAddress;
   private final long m_numberOfBytes;
   // $FF: synthetic field
   final JStackPanel this$0;

   private JStackPanel$WaitingForDataAction(JStackPanel var1, long var2, long var4) {
      this.this$0 = var1;
      this.m_startAddress = var2;
      this.m_numberOfBytes = var4;
   }

   public void actionPerformed(ActionEvent var1) {
      if(JStackPanel.access$200(this.this$0).hasData(this.m_startAddress, this.m_numberOfBytes)) {
         this.this$0.setEnabled(true);
         this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
         ((Timer)var1.getSource()).stop();
      } else if(!JStackPanel.access$200(this.this$0).keepTrying()) {
         ((Timer)var1.getSource()).stop();
      }

   }

   // $FF: synthetic method
   JStackPanel$WaitingForDataAction(JStackPanel var1, long var2, long var4, JStackPanel$1 var6) {
      this(var1, var2, var4);
   }
}
