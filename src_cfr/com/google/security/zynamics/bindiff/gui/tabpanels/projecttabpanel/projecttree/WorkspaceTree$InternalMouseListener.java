/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class WorkspaceTree$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ WorkspaceTree this$0;

    private WorkspaceTree$InternalMouseListener(WorkspaceTree workspaceTree) {
        this.this$0 = workspaceTree;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            WorkspaceTree.access$300(this.this$0, mouseEvent);
            return;
        }
        if (mouseEvent.getClickCount() != 2) return;
        WorkspaceTree.access$400(this.this$0, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (!mouseEvent.isPopupTrigger()) return;
        WorkspaceTree.access$300(this.this$0, mouseEvent);
    }

    /* synthetic */ WorkspaceTree$InternalMouseListener(WorkspaceTree workspaceTree, WorkspaceTree$1 workspaceTree$1) {
        this(workspaceTree);
    }
}

