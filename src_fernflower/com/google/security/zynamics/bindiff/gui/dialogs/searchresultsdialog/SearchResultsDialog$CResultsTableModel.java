package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import javax.swing.table.DefaultTableModel;

class SearchResultsDialog$CResultsTableModel extends DefaultTableModel {
   // $FF: synthetic field
   final SearchResultsDialog this$0;

   public SearchResultsDialog$CResultsTableModel(SearchResultsDialog var1, Object[][] var2, String[] var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   public boolean isCellEditable(int var1, int var2) {
      return false;
   }
}
