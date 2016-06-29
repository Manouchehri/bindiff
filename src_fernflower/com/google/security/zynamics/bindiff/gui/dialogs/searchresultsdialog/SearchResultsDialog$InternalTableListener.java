package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$1;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class SearchResultsDialog$InternalTableListener implements ListSelectionListener {
   // $FF: synthetic field
   final SearchResultsDialog this$0;

   private SearchResultsDialog$InternalTableListener(SearchResultsDialog var1) {
      this.this$0 = var1;
   }

   public void valueChanged(ListSelectionEvent var1) {
      int var2;
      if(SearchResultsDialog.access$900(this.this$0).getSelectedIndex() == 0) {
         var2 = SearchResultsDialog.access$200(this.this$0).getSelectedRow();
         if(var2 == -1) {
            return;
         }

         SearchResultsDialog.access$500(this.this$0).jumpToIndex(var2, ESide.PRIMARY);
      } else {
         var2 = SearchResultsDialog.access$400(this.this$0).getSelectedRow();
         if(var2 == -1) {
            return;
         }

         SearchResultsDialog.access$500(this.this$0).jumpToIndex(var2, ESide.SECONDARY);
      }

   }

   // $FF: synthetic method
   SearchResultsDialog$InternalTableListener(SearchResultsDialog var1, SearchResultsDialog$1 var2) {
      this(var1);
   }
}
