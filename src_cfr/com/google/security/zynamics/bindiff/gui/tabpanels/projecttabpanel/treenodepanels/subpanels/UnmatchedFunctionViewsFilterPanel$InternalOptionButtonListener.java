/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

class UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener
implements ActionListener {
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;

    private UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        this.this$0 = unmatchedFunctionViewsFilterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean bl2 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isRegEx();
        boolean bl3 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isCaseSensitive();
        boolean bl4 = ESide.PRIMARY == UnmatchedFunctionViewsFilterPanel.access$600(this.this$0);
        boolean bl5 = ESide.SECONDARY == UnmatchedFunctionViewsFilterPanel.access$600(this.this$0);
        boolean bl6 = UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).isTemporaryTableUse();
        ViewSearchOptionsDialog viewSearchOptionsDialog = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", bl2, bl3, bl4, bl5, bl6);
        viewSearchOptionsDialog.disableSideCheckboxes();
        viewSearchOptionsDialog.setVisible(true);
        if (!viewSearchOptionsDialog.getOkButtonPressed()) return;
        if (bl2 == viewSearchOptionsDialog.getRegExSelected() && bl3 == viewSearchOptionsDialog.getCaseSensitiveSelected() && bl4 == viewSearchOptionsDialog.getPrimarySideSearch() && bl5 == viewSearchOptionsDialog.getSecondarySideSearch()) {
            if (bl6 == viewSearchOptionsDialog.getTemporaryTableUse()) return;
        }
        UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).setSearchOptions(viewSearchOptionsDialog.getRegExSelected(), viewSearchOptionsDialog.getCaseSensitiveSelected(), viewSearchOptionsDialog.getPrimarySideSearch(), viewSearchOptionsDialog.getSecondarySideSearch(), viewSearchOptionsDialog.getTemporaryTableUse());
        UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).updateResults();
    }

    /* synthetic */ UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel, UnmatchedFunctionViewsFilterPanel$1 unmatchedFunctionViewsFilterPanel$1) {
        this(unmatchedFunctionViewsFilterPanel);
    }
}

