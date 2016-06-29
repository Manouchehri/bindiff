/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ECallDirection;
import com.google.security.zynamics.bindiff.enums.EExistence;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener
implements IMatchedFunctionsViewsTableListener {
    final /* synthetic */ AddedAndRemovedCalledFunctionsPanel this$0;

    private AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel) {
        this.this$0 = addedAndRemovedCalledFunctionsPanel;
    }

    @Override
    public void rowSelectionChanged(MatchedFunctionViewsTable matchedFunctionViewsTable) {
        int[] arrn = matchedFunctionViewsTable.getSelectedRows();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (int n6 : arrn) {
            String string = (String)matchedFunctionViewsTable.getModel().getValueAt(n6, 3);
            String string2 = (String)matchedFunctionViewsTable.getModel().getValueAt(n6, 6);
            CAddress cAddress = new CAddress(string, 16);
            CAddress cAddress2 = new CAddress(string2, 16);
            AddedAndRemovedCalledFunctionsPanel.access$100(this.this$0, cAddress, cAddress2, ECallDirection.INCOMING, arrayList);
            AddedAndRemovedCalledFunctionsPanel.access$100(this.this$0, cAddress, cAddress2, ECallDirection.OUTGOING, arrayList2);
        }
        for (Triple triple : arrayList) {
            if (triple.third() == EExistence.ADDED) {
                ++n2;
                continue;
            }
            ++n3;
        }
        Iterator iterator = arrayList2.iterator();
        do {
            if (!iterator.hasNext()) {
                ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$200(this.this$0).getTableModel()).setMatchedFunctionPairs(arrayList2);
                ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$300(this.this$0).getTableModel()).setMatchedFunctionPairs(arrayList);
                ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$200(this.this$0).getTableModel()).fireTableDataChanged();
                ((ExtendedMatchedFunctionViewsTableModel)AddedAndRemovedCalledFunctionsPanel.access$300(this.this$0).getTableModel()).fireTableDataChanged();
                AddedAndRemovedCalledFunctionsPanel.access$400(this.this$0, n2, n3, n4, n5);
                return;
            }
            Triple triple2 = (Triple)iterator.next();
            if (triple2.third() == EExistence.ADDED) {
                ++n4;
                continue;
            }
            ++n5;
        } while (true);
    }

    @Override
    public void tableDataChanged(MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel) {
    }

    /* synthetic */ AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel, AddedAndRemovedCalledFunctionsPanel$1 addedAndRemovedCalledFunctionsPanel$1) {
        this(addedAndRemovedCalledFunctionsPanel);
    }
}

