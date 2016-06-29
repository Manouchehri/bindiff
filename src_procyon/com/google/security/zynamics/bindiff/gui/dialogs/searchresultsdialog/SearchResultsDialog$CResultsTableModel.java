package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import javax.swing.table.*;

class SearchResultsDialog$CResultsTableModel extends DefaultTableModel
{
    final /* synthetic */ SearchResultsDialog this$0;
    
    public SearchResultsDialog$CResultsTableModel(final SearchResultsDialog this$0, final Object[][] array, final String[] array2) {
        this.this$0 = this$0;
        super(array, array2);
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return false;
    }
}
