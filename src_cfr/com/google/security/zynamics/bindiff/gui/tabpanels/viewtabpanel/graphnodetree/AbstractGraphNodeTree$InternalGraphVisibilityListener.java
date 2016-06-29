/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class AbstractGraphNodeTree$InternalGraphVisibilityListener
implements IZyGraphVisibilityListener {
    final /* synthetic */ AbstractGraphNodeTree this$0;

    private AbstractGraphNodeTree$InternalGraphVisibilityListener(AbstractGraphNodeTree abstractGraphNodeTree) {
        this.this$0 = abstractGraphNodeTree;
    }

    @Override
    public void nodeDeleted() {
        this.this$0.updateUI();
    }

    @Override
    public void visibilityChanged() {
        this.this$0.updateUI();
    }

    /* synthetic */ AbstractGraphNodeTree$InternalGraphVisibilityListener(AbstractGraphNodeTree abstractGraphNodeTree, AbstractGraphNodeTree$1 abstractGraphNodeTree$1) {
        this(abstractGraphNodeTree);
    }
}

