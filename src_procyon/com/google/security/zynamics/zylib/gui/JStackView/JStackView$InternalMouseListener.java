package com.google.security.zynamics.zylib.gui.JStackView;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.JHexPanel.*;

class JStackView$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ JStackView this$0;
    
    private JStackView$InternalMouseListener(final JStackView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        this.this$0.m_scrollbar.setValue(this.this$0.m_scrollbar.getValue() + mouseWheelEvent.getWheelRotation());
    }
}
