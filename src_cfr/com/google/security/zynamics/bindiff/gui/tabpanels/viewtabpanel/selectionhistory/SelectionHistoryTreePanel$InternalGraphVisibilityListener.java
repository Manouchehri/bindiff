/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class SelectionHistoryTreePanel$InternalGraphVisibilityListener
implements IZyGraphVisibilityListener {
    final /* synthetic */ SelectionHistoryTreePanel this$0;

    private SelectionHistoryTreePanel$InternalGraphVisibilityListener(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        this.this$0 = selectionHistoryTreePanel;
    }

    @Override
    public void nodeDeleted() {
        this.this$0.updateUI();
    }

    @Override
    public void visibilityChanged() {
        this.this$0.updateUI();
    }

    /* synthetic */ SelectionHistoryTreePanel$InternalGraphVisibilityListener(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionHistoryTreePanel$1 selectionHistoryTreePanel$1) {
        this(selectionHistoryTreePanel);
    }
}

