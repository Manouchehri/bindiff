/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

class MatchedFunctionViewsFilterPanel$InternalOptionButtonListener
implements ActionListener {
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;

    private MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        this.this$0 = matchedFunctionViewsFilterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean bl2 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isRegEx();
        boolean bl3 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isCaseSensitive();
        boolean bl4 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isPrimarySideSearch();
        boolean bl5 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isSecondarySideSearch();
        boolean bl6 = MatchedFunctionViewsFilterPanel.access$400(this.this$0).isTemporaryTableUse();
        ViewSearchOptionsDialog viewSearchOptionsDialog = new ViewSearchOptionsDialog(SwingUtilities.getWindowAncestor(this.this$0), "Filter Options", bl2, bl3, bl4, bl5, bl6);
        viewSearchOptionsDialog.setVisible(true);
        if (!viewSearchOptionsDialog.getOkButtonPressed()) return;
        if (bl2 == viewSearchOptionsDialog.getRegExSelected() && bl3 == viewSearchOptionsDialog.getCaseSensitiveSelected() && bl4 == viewSearchOptionsDialog.getPrimarySideSearch() && bl5 == viewSearchOptionsDialog.getSecondarySideSearch()) {
            if (bl6 == viewSearchOptionsDialog.getTemporaryTableUse()) return;
        }
        MatchedFunctionViewsFilterPanel.access$400(this.this$0).setSearchOptions(viewSearchOptionsDialog.getRegExSelected(), viewSearchOptionsDialog.getCaseSensitiveSelected(), viewSearchOptionsDialog.getPrimarySideSearch(), viewSearchOptionsDialog.getSecondarySideSearch(), viewSearchOptionsDialog.getTemporaryTableUse());
        MatchedFunctionViewsFilterPanel.access$400(this.this$0).updateResults();
    }

    /* synthetic */ MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel, MatchedFunctionViewsFilterPanel$1 matchedFunctionViewsFilterPanel$1) {
        this(matchedFunctionViewsFilterPanel);
    }
}

