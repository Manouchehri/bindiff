/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class WorkspaceMenu$1
extends AbstractAction {
    final /* synthetic */ String val$workspace;
    final /* synthetic */ WorkspaceMenu this$0;

    WorkspaceMenu$1(WorkspaceMenu workspaceMenu, String string) {
        this.this$0 = workspaceMenu;
        this.val$workspace = string;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WorkspaceMenu.access$100(this.this$0).closeWorkspace();
        WorkspaceMenu.access$100(this.this$0).loadWorkspace(this.val$workspace);
    }
}

