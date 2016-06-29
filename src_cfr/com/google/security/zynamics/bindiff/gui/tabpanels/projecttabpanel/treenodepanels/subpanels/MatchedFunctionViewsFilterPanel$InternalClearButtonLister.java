/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

class MatchedFunctionViewsFilterPanel$InternalClearButtonLister
implements ActionListener {
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;

    private MatchedFunctionViewsFilterPanel$InternalClearButtonLister(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        this.this$0 = matchedFunctionViewsFilterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MatchedFunctionViewsFilterPanel.access$400(this.this$0).reset();
        MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
    }

    /* synthetic */ MatchedFunctionViewsFilterPanel$InternalClearButtonLister(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel, MatchedFunctionViewsFilterPanel$1 matchedFunctionViewsFilterPanel$1) {
        this(matchedFunctionViewsFilterPanel);
    }
}

