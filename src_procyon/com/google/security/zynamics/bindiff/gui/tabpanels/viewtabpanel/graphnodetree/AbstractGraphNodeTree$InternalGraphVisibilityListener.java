package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.zylib.gui.zygraph.*;

class AbstractGraphNodeTree$InternalGraphVisibilityListener implements IZyGraphVisibilityListener
{
    final /* synthetic */ AbstractGraphNodeTree this$0;
    
    private AbstractGraphNodeTree$InternalGraphVisibilityListener(final AbstractGraphNodeTree this$0) {
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
