package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.common.collect.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.*;

class AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener implements IMatchedFunctionsViewsTableListener
{
    final /* synthetic */ AddedAndRemovedCalledFunctionsPanel this$0;
    
    private AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(final AddedAndRemovedCalledFunctionsPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void rowSelectionChanged(final MatchedFunctionViewsTable matchedFunctionViewsTable) {
        final int[] selectedRows = matchedFunctionViewsTable.getSelectedRows();
        final ArrayList<Triple> matchedFunctionPairs = new ArrayList<Triple>();
        final ArrayList<Triple> matchedFunctionPairs2 = new ArrayList<Triple>();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (final int n5 : selectedRows) {
            final String s = (String)matchedFunctionViewsTable.getModel().getValueAt(n5, 3);
            final String s2 = (String)matchedFunctionViewsTable.getModel().getValueAt(n5, 6);
            final CAddress cAddress = new CAddress(s, 16);
            final CAddress cAddress2 = new CAddress(s2, 16);
            this.this$0.getSecondaryFunctionCallChanges(cAddress, cAddress2, ECallDirection.INCOMING, matchedFunctionPairs);
            this.this$0.getSecondaryFunctionCallChanges(cAddress, cAddress2, ECallDirection.OUTGOING, matchedFunctionPairs2);
        }
        final Iterator<Object> iterator = matchedFunctionPairs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().third() == EExistence.ADDED) {
                ++n;
            }
            else {
                ++n2;
            }
        }
        final Iterator<Object> iterator2 = matchedFunctionPairs2.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().third() == EExistence.ADDED) {
                ++n3;
            }
            else {
                ++n4;
            }
        }
        ((ExtendedMatchedFunctionViewsTableModel)this.this$0.outgoingFunctionsCalledTable.getTableModel()).setMatchedFunctionPairs(matchedFunctionPairs2);
        ((ExtendedMatchedFunctionViewsTableModel)this.this$0.incomingFunctionsCalledTable.getTableModel()).setMatchedFunctionPairs(matchedFunctionPairs);
        ((ExtendedMatchedFunctionViewsTableModel)this.this$0.outgoingFunctionsCalledTable.getTableModel()).fireTableDataChanged();
        ((ExtendedMatchedFunctionViewsTableModel)this.this$0.incomingFunctionsCalledTable.getTableModel()).fireTableDataChanged();
        this.this$0.updateBorders(n, n2, n3, n4);
    }
    
    @Override
    public void tableDataChanged(final MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel) {
    }
}
