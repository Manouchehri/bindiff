package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

class MatchedFunctionViewsFilterPanel$InternalOptionButtonListener implements ActionListener
{
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;
    
    private MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(final MatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final boolean regEx = this.this$0.searchCombobox.isRegEx();
        final boolean caseSensitive = this.this$0.searchCombobox.isCaseSensitive();
        final boolean primarySideSearch = this.this$0.searchCombobox.isPrimarySideSearch();
        final boolean secondarySideSearch = this.this$0.searchCombobox.isSecondarySideSearch();
        final boolean temporaryTableUse = this.this$0.searchCombobox.isTemporaryTableUse();
        final ViewSearchOptionsDialog viewSearchOptionsDialog = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", regEx, caseSensitive, primarySideSearch, secondarySideSearch, temporaryTableUse);
        viewSearchOptionsDialog.setVisible(true);
        if (viewSearchOptionsDialog.getOkButtonPressed() && (regEx != viewSearchOptionsDialog.getRegExSelected() || caseSensitive != viewSearchOptionsDialog.getCaseSensitiveSelected() || primarySideSearch != viewSearchOptionsDialog.getPrimarySideSearch() || secondarySideSearch != viewSearchOptionsDialog.getSecondarySideSearch() || temporaryTableUse != viewSearchOptionsDialog.getTemporaryTableUse())) {
            this.this$0.searchCombobox.setSearchOptions(viewSearchOptionsDialog.getRegExSelected(), viewSearchOptionsDialog.getCaseSensitiveSelected(), viewSearchOptionsDialog.getPrimarySideSearch(), viewSearchOptionsDialog.getSecondarySideSearch(), viewSearchOptionsDialog.getTemporaryTableUse());
            this.this$0.searchCombobox.updateResults();
        }
    }
}
