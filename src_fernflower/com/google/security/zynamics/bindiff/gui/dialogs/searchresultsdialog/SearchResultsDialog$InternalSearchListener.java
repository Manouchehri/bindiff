package com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog$1;

class SearchResultsDialog$InternalSearchListener implements IGraphSearchFieldListener {
   // $FF: synthetic field
   final SearchResultsDialog this$0;

   private SearchResultsDialog$InternalSearchListener(SearchResultsDialog var1) {
      this.this$0 = var1;
   }

   public void cleaned() {
      this.searched();
   }

   public void searched() {
      SearchResultsDialog.access$300(this.this$0, SearchResultsDialog.access$200(this.this$0));
      SearchResultsDialog.access$300(this.this$0, SearchResultsDialog.access$400(this.this$0));
      SearchResultsDialog.access$600(this.this$0, SearchResultsDialog.access$500(this.this$0).getGraphs());
      SearchResultsDialog.access$200(this.this$0).updateUI();
      SearchResultsDialog.access$400(this.this$0).updateUI();
      SearchResultsDialog.access$700(this.this$0).updateUI();
      SearchResultsDialog.access$800(this.this$0).updateUI();
   }

   // $FF: synthetic method
   SearchResultsDialog$InternalSearchListener(SearchResultsDialog var1, SearchResultsDialog$1 var2) {
      this(var1);
   }
}
