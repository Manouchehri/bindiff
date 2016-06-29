/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

class JStackPanel$WaitingForDataAction
extends AbstractAction {
    private static final long serialVersionUID = -610823391617272365L;
    private final long m_startAddress;
    private final long m_numberOfBytes;
    final /* synthetic */ JStackPanel this$0;

    private JStackPanel$WaitingForDataAction(JStackPanel jStackPanel, long l2, long l3) {
        this.this$0 = jStackPanel;
        this.m_startAddress = l2;
        this.m_numberOfBytes = l3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (JStackPanel.access$200(this.this$0).hasData(this.m_startAddress, this.m_numberOfBytes)) {
            this.this$0.setEnabled(true);
            this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
            ((Timer)actionEvent.getSource()).stop();
            return;
        }
        if (JStackPanel.access$200(this.this$0).keepTrying()) return;
        ((Timer)actionEvent.getSource()).stop();
    }

    /* synthetic */ JStackPanel$WaitingForDataAction(JStackPanel jStackPanel, long l2, long l3, JStackPanel$1 jStackPanel$1) {
        this(jStackPanel, l2, l3);
    }
}

