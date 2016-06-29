package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class SearchResultsDialog$InternalSearchListener implements IGraphSearchFieldListener
{
    final /* synthetic */ SearchResultsDialog this$0;
    
    private SearchResultsDialog$InternalSearchListener(final SearchResultsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void cleaned() {
        this.searched();
    }
    
    @Override
    public void searched() {
        this.this$0.removAllRows(this.this$0.primaryTable);
        this.this$0.removAllRows(this.this$0.secondaryTable);
        this.this$0.setResults(this.this$0.searchField.getGraphs());
        this.this$0.primaryTable.updateUI();
        this.this$0.secondaryTable.updateUI();
        this.this$0.primaryResultsLabel.updateUI();
        this.this$0.secondaryResultsLabel.updateUI();
    }
}
