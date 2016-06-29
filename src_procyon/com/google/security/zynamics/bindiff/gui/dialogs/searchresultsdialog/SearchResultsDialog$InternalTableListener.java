package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class SearchResultsDialog$InternalTableListener implements ListSelectionListener
{
    final /* synthetic */ SearchResultsDialog this$0;
    
    private SearchResultsDialog$InternalTableListener(final SearchResultsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent listSelectionEvent) {
        if (this.this$0.tabbedPane.getSelectedIndex() == 0) {
            final int selectedRow = this.this$0.primaryTable.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }
            this.this$0.searchField.jumpToIndex(selectedRow, ESide.PRIMARY);
        }
        else {
            final int selectedRow2 = this.this$0.secondaryTable.getSelectedRow();
            if (selectedRow2 == -1) {
                return;
            }
            this.this$0.searchField.jumpToIndex(selectedRow2, ESide.SECONDARY);
        }
    }
}
