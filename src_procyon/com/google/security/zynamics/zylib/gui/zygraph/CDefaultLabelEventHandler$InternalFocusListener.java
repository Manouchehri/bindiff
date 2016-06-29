package com.google.security.zynamics.zylib.gui.zygraph;

import java.awt.event.*;

class CDefaultLabelEventHandler$InternalFocusListener implements FocusListener
{
    final /* synthetic */ CDefaultLabelEventHandler this$0;
    
    private CDefaultLabelEventHandler$InternalFocusListener(final CDefaultLabelEventHandler this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.this$0.deactivateLabelContent();
    }
}
