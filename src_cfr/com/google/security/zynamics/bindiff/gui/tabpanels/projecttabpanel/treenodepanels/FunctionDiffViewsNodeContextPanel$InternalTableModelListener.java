/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class FunctionDiffViewsNodeContextPanel$InternalTableModelListener
implements TableModelListener {
    final /* synthetic */ FunctionDiffViewsNodeContextPanel this$0;

    private FunctionDiffViewsNodeContextPanel$InternalTableModelListener(FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel) {
        this.this$0 = functionDiffViewsNodeContextPanel;
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        FunctionDiffViewsNodeContextPanel.access$100(this.this$0);
    }

    /* synthetic */ FunctionDiffViewsNodeContextPanel$InternalTableModelListener(FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel, FunctionDiffViewsNodeContextPanel$1 functionDiffViewsNodeContextPanel$1) {
        this(functionDiffViewsNodeContextPanel);
    }
}

