/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable$1;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MatchedFunctionViewsTable$InternalSelectionListener
implements ListSelectionListener {
    final /* synthetic */ MatchedFunctionViewsTable this$0;

    private MatchedFunctionViewsTable$InternalSelectionListener(MatchedFunctionViewsTable matchedFunctionViewsTable) {
        this.this$0 = matchedFunctionViewsTable;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        Iterator iterator = MatchedFunctionViewsTable.access$100(this.this$0).iterator();
        while (iterator.hasNext()) {
            IMatchedFunctionsViewsTableListener iMatchedFunctionsViewsTableListener = (IMatchedFunctionsViewsTableListener)iterator.next();
            iMatchedFunctionsViewsTableListener.rowSelectionChanged(this.this$0);
        }
    }

    /* synthetic */ MatchedFunctionViewsTable$InternalSelectionListener(MatchedFunctionViewsTable matchedFunctionViewsTable, MatchedFunctionViewsTable$1 matchedFunctionViewsTable$1) {
        this(matchedFunctionViewsTable);
    }
}

