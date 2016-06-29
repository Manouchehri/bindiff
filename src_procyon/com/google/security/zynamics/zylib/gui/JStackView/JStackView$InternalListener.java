package com.google.security.zynamics.zylib.gui.JStackView;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.JHexPanel.*;

class JStackView$InternalListener implements IStackModelListener, AdjustmentListener, ComponentListener
{
    final /* synthetic */ JStackView this$0;
    
    private JStackView$InternalListener(final JStackView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void adjustmentValueChanged(final AdjustmentEvent adjustmentEvent) {
        if (adjustmentEvent.getSource() == this.this$0.m_scrollbar) {
            this.this$0.m_panel.setFirstRow(adjustmentEvent.getValue());
        }
        else {
            this.this$0.m_panel.setFirstColumn(adjustmentEvent.getValue());
        }
        this.this$0.m_panel.repaint();
    }
    
    @Override
    public void componentHidden(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void componentMoved(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void componentResized(final ComponentEvent componentEvent) {
        this.this$0.setScrollBarMaximum();
        this.this$0.setHorizontalScrollBarMaximum();
    }
    
    @Override
    public void componentShown(final ComponentEvent componentEvent) {
    }
    
    @Override
    public void dataChanged() {
        this.this$0.setScrollBarMaximum();
        this.this$0.setHorizontalScrollBarMaximum();
        this.this$0.m_panel.repaint();
    }
}
