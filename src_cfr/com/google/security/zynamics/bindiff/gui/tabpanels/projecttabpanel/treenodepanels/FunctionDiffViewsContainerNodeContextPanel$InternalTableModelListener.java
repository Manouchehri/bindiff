/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener
implements TableModelListener {
    final /* synthetic */ FunctionDiffViewsContainerNodeContextPanel this$0;

    private FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(FunctionDiffViewsContainerNodeContextPanel functionDiffViewsContainerNodeContextPanel) {
        this.this$0 = functionDiffViewsContainerNodeContextPanel;
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        FunctionDiffViewsContainerNodeContextPanel.access$100(this.this$0);
    }

    /* synthetic */ FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(FunctionDiffViewsContainerNodeContextPanel functionDiffViewsContainerNodeContextPanel, FunctionDiffViewsContainerNodeContextPanel$1 functionDiffViewsContainerNodeContextPanel$1) {
        this(functionDiffViewsContainerNodeContextPanel);
    }
}

