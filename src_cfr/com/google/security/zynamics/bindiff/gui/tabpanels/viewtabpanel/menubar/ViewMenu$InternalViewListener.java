/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ISavableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;

class ViewMenu$InternalViewListener
implements ISavableListener {
    final /* synthetic */ ViewMenu this$0;

    private ViewMenu$InternalViewListener(ViewMenu viewMenu) {
        this.this$0 = viewMenu;
    }

    @Override
    public void isSavable(boolean bl2) {
        if (!ViewMenu.access$100(this.this$0).getGraphs().getDiff().isFunctionDiff()) {
            if (ViewMenu.access$200(this.this$0).isEnabled() == bl2) return;
            ViewMenu.access$200(this.this$0).setEnabled(bl2);
            return;
        }
        ViewMenu.access$200(this.this$0).setEnabled(true);
    }

    /* synthetic */ ViewMenu$InternalViewListener(ViewMenu viewMenu, ViewMenu$1 viewMenu$1) {
        this(viewMenu);
    }
}

