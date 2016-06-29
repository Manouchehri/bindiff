/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IViewsTableListener;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class AbstractTable$InternalSelectionListener
implements ListSelectionListener {
    final /* synthetic */ AbstractTable this$0;

    private AbstractTable$InternalSelectionListener(AbstractTable abstractTable) {
        this.this$0 = abstractTable;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        Iterator iterator = AbstractTable.access$400(this.this$0).iterator();
        while (iterator.hasNext()) {
            IViewsTableListener iViewsTableListener = (IViewsTableListener)iterator.next();
            iViewsTableListener.rowSelectionChanged(this.this$0);
        }
    }

    /* synthetic */ AbstractTable$InternalSelectionListener(AbstractTable abstractTable, AbstractTable$1 abstractTable$1) {
        this(abstractTable);
    }
}

