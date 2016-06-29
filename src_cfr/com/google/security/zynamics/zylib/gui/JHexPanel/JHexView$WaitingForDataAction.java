/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

class JHexView$WaitingForDataAction
extends AbstractAction {
    private static final long serialVersionUID = -610823391617272365L;
    private final long m_offset;
    private final int m_size;
    final /* synthetic */ JHexView this$0;

    private JHexView$WaitingForDataAction(JHexView jHexView, long l2, int n2) {
        this.this$0 = jHexView;
        this.m_offset = l2;
        this.m_size = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (JHexView.access$1100(this.this$0).hasData(this.m_offset, this.m_size)) {
            this.this$0.setEnabled(true);
            this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
            ((Timer)actionEvent.getSource()).stop();
            return;
        }
        if (JHexView.access$1100(this.this$0).keepTrying()) return;
        ((Timer)actionEvent.getSource()).stop();
    }

    /* synthetic */ JHexView$WaitingForDataAction(JHexView jHexView, long l2, int n2, JHexView$1 jHexView$1) {
        this(jHexView, l2, n2);
    }
}

