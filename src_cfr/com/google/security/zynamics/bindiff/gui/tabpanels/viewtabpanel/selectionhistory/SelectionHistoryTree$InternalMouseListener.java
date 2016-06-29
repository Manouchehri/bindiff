/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SelectionHistoryTree$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ SelectionHistoryTree this$0;

    private SelectionHistoryTree$InternalMouseListener(SelectionHistoryTree selectionHistoryTree) {
        this.this$0 = selectionHistoryTree;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        SelectionHistoryTree.access$100(this.this$0, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        SelectionHistoryTree.access$100(this.this$0, mouseEvent);
    }

    /* synthetic */ SelectionHistoryTree$InternalMouseListener(SelectionHistoryTree selectionHistoryTree, SelectionHistoryTree$1 selectionHistoryTree$1) {
        this(selectionHistoryTree);
    }
}

