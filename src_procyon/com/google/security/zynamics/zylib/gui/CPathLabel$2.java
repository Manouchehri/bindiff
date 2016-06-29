package com.google.security.zynamics.zylib.gui;

import java.awt.event.*;

class CPathLabel$2 extends ComponentAdapter
{
    final /* synthetic */ CPathLabel this$0;
    
    CPathLabel$2(final CPathLabel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void componentResized(final ComponentEvent componentEvent) {
        this.this$0.updatePathEllipsis();
    }
}
