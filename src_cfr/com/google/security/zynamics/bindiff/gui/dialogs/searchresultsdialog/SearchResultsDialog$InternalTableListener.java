/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$1;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SearchResultsDialog$InternalTableListener
implements ListSelectionListener {
    final /* synthetic */ SearchResultsDialog this$0;

    private SearchResultsDialog$InternalTableListener(SearchResultsDialog searchResultsDialog) {
        this.this$0 = searchResultsDialog;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (SearchResultsDialog.access$900(this.this$0).getSelectedIndex() == 0) {
            int n2 = SearchResultsDialog.access$200(this.this$0).getSelectedRow();
            if (n2 == -1) {
                return;
            }
            SearchResultsDialog.access$500(this.this$0).jumpToIndex(n2, ESide.PRIMARY);
            return;
        }
        int n3 = SearchResultsDialog.access$400(this.this$0).getSelectedRow();
        if (n3 == -1) {
            return;
        }
        SearchResultsDialog.access$500(this.this$0).jumpToIndex(n3, ESide.SECONDARY);
    }

    /* synthetic */ SearchResultsDialog$InternalTableListener(SearchResultsDialog searchResultsDialog, SearchResultsDialog$1 searchResultsDialog$1) {
        this(searchResultsDialog);
    }
}

