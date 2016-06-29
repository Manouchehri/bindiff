package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

class MatchedFunctionViewsFilterPanel$InternalOptionButtonListener implements ActionListener {
   // $FF: synthetic field
   final MatchedFunctionViewsFilterPanel this$0;

   private MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(MatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      boolean var2 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isRegEx();
      boolean var3 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isCaseSensitive();
      boolean var4 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isPrimarySideSearch();
      boolean var5 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isSecondarySideSearch();
      boolean var6 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isTemporaryTableUse();
      ViewSearchOptionsDialog var7 = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", var2, var3, var4, var5, var6);
      var7.setVisible(true);
      if(var7.getOkButtonPressed() && (var2 != var7.getRegExSelected() || var3 != var7.getCaseSensitiveSelected() || var4 != var7.getPrimarySideSearch() || var5 != var7.getSecondarySideSearch() || var6 != var7.getTemporaryTableUse())) {
         MatchedFunctionViewsFilterPanel.access$400(this.this$0).setSearchOptions(var7.getRegExSelected(), var7.getCaseSensitiveSelected(), var7.getPrimarySideSearch(), var7.getSecondarySideSearch(), var7.getTemporaryTableUse());
         MatchedFunctionViewsFilterPanel.access$400(this.this$0).updateResults();
      }

   }

   // $FF: synthetic method
   MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(MatchedFunctionViewsFilterPanel var1, MatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
