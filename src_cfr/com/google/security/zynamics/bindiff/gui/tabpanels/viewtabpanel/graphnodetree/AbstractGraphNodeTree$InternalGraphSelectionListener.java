/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;

class AbstractGraphNodeTree$InternalGraphSelectionListener
implements IZyGraphSelectionListener {
    final /* synthetic */ AbstractGraphNodeTree this$0;

    private AbstractGraphNodeTree$InternalGraphSelectionListener(AbstractGraphNodeTree abstractGraphNodeTree) {
        this.this$0 = abstractGraphNodeTree;
    }

    @Override
    public void selectionChanged() {
        this.this$0.updateUI();
    }

    /* synthetic */ AbstractGraphNodeTree$InternalGraphSelectionListener(AbstractGraphNodeTree abstractGraphNodeTree, AbstractGraphNodeTree$1 abstractGraphNodeTree$1) {
        this(abstractGraphNodeTree);
    }
}

