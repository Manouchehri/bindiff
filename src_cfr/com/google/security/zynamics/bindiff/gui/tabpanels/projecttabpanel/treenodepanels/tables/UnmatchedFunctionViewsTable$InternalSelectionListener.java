/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$1;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class UnmatchedFunctionViewsTable$InternalSelectionListener
implements ListSelectionListener {
    final /* synthetic */ UnmatchedFunctionViewsTable this$0;

    private UnmatchedFunctionViewsTable$InternalSelectionListener(UnmatchedFunctionViewsTable unmatchedFunctionViewsTable) {
        this.this$0 = unmatchedFunctionViewsTable;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        Iterator iterator = UnmatchedFunctionViewsTable.access$100(this.this$0).iterator();
        while (iterator.hasNext()) {
            IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener = (IUnmatchedFunctionsViewsTableListener)iterator.next();
            iUnmatchedFunctionsViewsTableListener.rowSelectionChanged(this.this$0);
        }
    }

    /* synthetic */ UnmatchedFunctionViewsTable$InternalSelectionListener(UnmatchedFunctionViewsTable unmatchedFunctionViewsTable, UnmatchedFunctionViewsTable$1 unmatchedFunctionViewsTable$1) {
        this(unmatchedFunctionViewsTable);
    }
}

