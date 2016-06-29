/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;

public class CloseDiffAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;

    public CloseDiffAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HashSet<Diff> hashSet = new HashSet<Diff>();
        hashSet.add(this.controller.getSelectedDiff());
        this.controller.closeDiffs(hashSet);
    }
}

