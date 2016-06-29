package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

class UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener implements ActionListener {
   // $FF: synthetic field
   final UnmatchedFunctionViewsFilterPanel this$0;

   private UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(UnmatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      boolean var2 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isRegEx();
      boolean var3 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isCaseSensitive();
      boolean var4 = ESide.PRIMARY == UnmatchedFunctionViewsFilterPanel.access$600(this.this$0);
      boolean var5 = ESide.SECONDARY == UnmatchedFunctionViewsFilterPanel.access$600(this.this$0);
      boolean var6 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isTemporaryTableUse();
      ViewSearchOptionsDialog var7 = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", var2, var3, var4, var5, var6);
      var7.disableSideCheckboxes();
      var7.setVisible(true);
      if(var7.getOkButtonPressed() && (var2 != var7.getRegExSelected() || var3 != var7.getCaseSensitiveSelected() || var4 != var7.getPrimarySideSearch() || var5 != var7.getSecondarySideSearch() || var6 != var7.getTemporaryTableUse())) {
         UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).setSearchOptions(var7.getRegExSelected(), var7.getCaseSensitiveSelected(), var7.getPrimarySideSearch(), var7.getSecondarySideSearch(), var7.getTemporaryTableUse());
         UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).updateResults();
      }

   }

   // $FF: synthetic method
   UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(UnmatchedFunctionViewsFilterPanel var1, UnmatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
