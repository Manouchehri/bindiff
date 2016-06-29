/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.Icon;

class MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener
implements ItemListener {
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;

    private MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        this.this$0 = matchedFunctionViewsFilterPanel;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        boolean bl2 = MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected();
        boolean bl3 = MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected();
        boolean bl4 = MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected();
        Iterator iterator = MatchedFunctionViewsFilterPanel.access$1000(this.this$0).iterator();
        do {
            if (!iterator.hasNext()) {
                MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
                this.this$0.updateUI();
                return;
            }
            IViewsFilterCheckboxListener iViewsFilterCheckboxListener = (IViewsFilterCheckboxListener)iterator.next();
            iViewsFilterCheckboxListener.functionViewsFilterChanged(bl2, bl3, bl4);
        } while (true);
    }

    /* synthetic */ MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel, MatchedFunctionViewsFilterPanel$1 matchedFunctionViewsFilterPanel$1) {
        this(matchedFunctionViewsFilterPanel);
    }
}

