/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

class UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister
implements ActionListener {
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;

    private UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        this.this$0 = unmatchedFunctionViewsFilterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).reset();
        UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
    }

    /* synthetic */ UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel, UnmatchedFunctionViewsFilterPanel$1 unmatchedFunctionViewsFilterPanel$1) {
        this(unmatchedFunctionViewsFilterPanel);
    }
}

