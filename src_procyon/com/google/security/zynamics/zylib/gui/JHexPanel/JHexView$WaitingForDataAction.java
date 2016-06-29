package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import com.google.common.base.*;

class JHexView$WaitingForDataAction extends AbstractAction
{
    private static final long serialVersionUID = -610823391617272365L;
    private final long m_offset;
    private final int m_size;
    final /* synthetic */ JHexView this$0;
    
    private JHexView$WaitingForDataAction(final JHexView this$0, final long offset, final int size) {
        this.this$0 = this$0;
        this.m_offset = offset;
        this.m_size = size;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.this$0.m_dataProvider.hasData(this.m_offset, this.m_size)) {
            this.this$0.setEnabled(true);
            this.this$0.setDefinitionStatus(JHexView$DefinitionStatus.DEFINED);
            ((Timer)actionEvent.getSource()).stop();
        }
        else if (!this.this$0.m_dataProvider.keepTrying()) {
            ((Timer)actionEvent.getSource()).stop();
        }
    }
}
