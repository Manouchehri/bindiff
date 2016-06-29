package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.zylib.gui.zygraph.*;

class AbstractGraphNodeTree$InternalGraphSelectionListener implements IZyGraphSelectionListener
{
    final /* synthetic */ AbstractGraphNodeTree this$0;
    
    private AbstractGraphNodeTree$InternalGraphSelectionListener(final AbstractGraphNodeTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void selectionChanged() {
        this.this$0.updateUI();
    }
}
