/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$1;

class SearchResultsDialog$InternalSearchListener
implements IGraphSearchFieldListener {
    final /* synthetic */ SearchResultsDialog this$0;

    private SearchResultsDialog$InternalSearchListener(SearchResultsDialog searchResultsDialog) {
        this.this$0 = searchResultsDialog;
    }

    @Override
    public void cleaned() {
        this.searched();
    }

    @Override
    public void searched() {
        SearchResultsDialog.access$300(this.this$0, SearchResultsDialog.access$200(this.this$0));
        SearchResultsDialog.access$300(this.this$0, SearchResultsDialog.access$400(this.this$0));
        SearchResultsDialog.access$600(this.this$0, SearchResultsDialog.access$500(this.this$0).getGraphs());
        SearchResultsDialog.access$200(this.this$0).updateUI();
        SearchResultsDialog.access$400(this.this$0).updateUI();
        SearchResultsDialog.access$700(this.this$0).updateUI();
        SearchResultsDialog.access$800(this.this$0).updateUI();
    }

    /* synthetic */ SearchResultsDialog$InternalSearchListener(SearchResultsDialog searchResultsDialog, SearchResultsDialog$1 searchResultsDialog$1) {
        this(searchResultsDialog);
    }
}

