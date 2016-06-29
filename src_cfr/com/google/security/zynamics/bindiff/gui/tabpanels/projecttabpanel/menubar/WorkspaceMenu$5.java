/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class WorkspaceMenu$5
extends AbstractAction {
    final /* synthetic */ WorkspaceMenu this$0;

    WorkspaceMenu$5(WorkspaceMenu workspaceMenu) {
        this.this$0 = workspaceMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WorkspaceMenu.access$100(this.this$0).exitBinDiff();
    }
}

