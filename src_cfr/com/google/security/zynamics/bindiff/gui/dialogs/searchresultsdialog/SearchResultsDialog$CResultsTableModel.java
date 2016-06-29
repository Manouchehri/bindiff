/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import javax.swing.table.DefaultTableModel;

class SearchResultsDialog$CResultsTableModel
extends DefaultTableModel {
    final /* synthetic */ SearchResultsDialog this$0;

    public SearchResultsDialog$CResultsTableModel(SearchResultsDialog searchResultsDialog, Object[][] arrobject, String[] arrstring) {
        this.this$0 = searchResultsDialog;
        super(arrobject, arrstring);
    }

    @Override
    public boolean isCellEditable(int n2, int n3) {
        return false;
    }
}

