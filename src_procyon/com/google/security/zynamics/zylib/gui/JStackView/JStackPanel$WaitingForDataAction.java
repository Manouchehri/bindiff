package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JHexPanel.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import com.google.common.base.*;
import java.awt.*;

class JStackPanel$WaitingForDataAction extends AbstractAction
{
    private static final long serialVersionUID = -610823391617272365L;
    private final long m_startAddress;
    private final long m_numberOfBytes;
    final /* synthetic */ JStackPanel this$0;
    
    private JStackPanel$WaitingForDataAction(final JStackPanel this$0, final long startAddress, final long numberOfBytes) {
        this.this$0 = this$0;
        this.m_startAddress = startAddress;
        this.m_numberOfBytes = numberOfBytes;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.this$0.m_model.hasData(this.m_startAddress, this.m_numberOfBytes)) {
            this.this$0.setEnabled(true);
            this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
            ((Timer)actionEvent.getSource()).stop();
        }
        else if (!this.this$0.m_model.keepTrying()) {
            ((Timer)actionEvent.getSource()).stop();
        }
    }
}
