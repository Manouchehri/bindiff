/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.util.Collection;

class SelectionHistoryTreePanel$InternalGraphSelectionListener
implements IZyGraphSelectionListener {
    private SelectionSnapshot lastSnapshot;
    final /* synthetic */ SelectionHistoryTreePanel this$0;

    private SelectionHistoryTreePanel$InternalGraphSelectionListener(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        this.this$0 = selectionHistoryTreePanel;
    }

    @Override
    public void selectionChanged() {
        SelectionSnapshot selectionSnapshot = new SelectionSnapshot(GraphNodeFilter.filterNodes(SelectionHistoryTreePanel.access$500(this.this$0), GraphNodeFilter$Criterium.SELECTED));
        if (selectionSnapshot.getNumberOfSelectedNodes() != 0 && !selectionSnapshot.equals(this.lastSnapshot)) {
            SelectionHistoryTreePanel.access$600(this.this$0).addSnapshot(selectionSnapshot);
            this.lastSnapshot = selectionSnapshot;
        }
        this.this$0.updateUI();
    }

    /* synthetic */ SelectionHistoryTreePanel$InternalGraphSelectionListener(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionHistoryTreePanel$1 selectionHistoryTreePanel$1) {
        this(selectionHistoryTreePanel);
    }
}

