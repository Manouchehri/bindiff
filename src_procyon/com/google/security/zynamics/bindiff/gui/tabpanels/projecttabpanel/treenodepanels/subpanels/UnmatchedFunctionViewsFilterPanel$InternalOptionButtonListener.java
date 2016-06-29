package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;

class UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener implements ActionListener
{
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;
    
    private UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(final UnmatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final boolean regEx = this.this$0.searchCombobox.isRegEx();
        final boolean caseSensitive = this.this$0.searchCombobox.isCaseSensitive();
        final boolean b = ESide.PRIMARY == this.this$0.side;
        final boolean b2 = ESide.SECONDARY == this.this$0.side;
        final boolean temporaryTableUse = this.this$0.searchCombobox.isTemporaryTableUse();
        final ViewSearchOptionsDialog viewSearchOptionsDialog = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", regEx, caseSensitive, b, b2, temporaryTableUse);
        viewSearchOptionsDialog.disableSideCheckboxes();
        viewSearchOptionsDialog.setVisible(true);
        if (viewSearchOptionsDialog.getOkButtonPressed() && (regEx != viewSearchOptionsDialog.getRegExSelected() || caseSensitive != viewSearchOptionsDialog.getCaseSensitiveSelected() || b != viewSearchOptionsDialog.getPrimarySideSearch() || b2 != viewSearchOptionsDialog.getSecondarySideSearch() || temporaryTableUse != viewSearchOptionsDialog.getTemporaryTableUse())) {
            this.this$0.searchCombobox.setSearchOptions(viewSearchOptionsDialog.getRegExSelected(), viewSearchOptionsDialog.getCaseSensitiveSelected(), viewSearchOptionsDialog.getPrimarySideSearch(), viewSearchOptionsDialog.getSecondarySideSearch(), viewSearchOptionsDialog.getTemporaryTableUse());
            this.this$0.searchCombobox.updateResults();
        }
    }
}
