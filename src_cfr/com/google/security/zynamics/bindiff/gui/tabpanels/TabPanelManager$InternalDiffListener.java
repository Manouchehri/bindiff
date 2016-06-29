/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;

class TabPanelManager$InternalDiffListener
extends DiffListenerAdapter {
    final /* synthetic */ TabPanelManager this$0;

    private TabPanelManager$InternalDiffListener(TabPanelManager tabPanelManager) {
        this.this$0 = tabPanelManager;
    }

    @Override
    public void closedView(Diff diff) {
        TabPanelManager.access$400(this.this$0, diff);
    }

    /* synthetic */ TabPanelManager$InternalDiffListener(TabPanelManager tabPanelManager, TabPanelManager$1 tabPanelManager$1) {
        this(tabPanelManager);
    }
}

