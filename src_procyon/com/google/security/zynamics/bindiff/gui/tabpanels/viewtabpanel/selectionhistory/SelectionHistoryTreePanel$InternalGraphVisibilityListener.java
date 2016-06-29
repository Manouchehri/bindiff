package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.gui.zygraph.*;

class SelectionHistoryTreePanel$InternalGraphVisibilityListener implements IZyGraphVisibilityListener
{
    final /* synthetic */ SelectionHistoryTreePanel this$0;
    
    private SelectionHistoryTreePanel$InternalGraphVisibilityListener(final SelectionHistoryTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void nodeDeleted() {
        this.this$0.updateUI();
    }
    
    @Override
    public void visibilityChanged() {
        this.this$0.updateUI();
    }
}
