/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$InternalWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class NodePopupMenu
extends JPopupMenu {
    private final WorkspaceTabPanelFunctions controller;
    private final JMenuItem openDiff;
    private final JMenuItem closeDiff;
    private final JMenuItem deleteDiff;
    private final JMenuItem closeViews;
    private final NodePopupMenu$InternalWorkspaceTreeListener workspaceTreeListener;
    private final NodePopupMenu$InternalDiffListener diffListener;
    private Diff lastSelectedDiff;

    public NodePopupMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.workspaceTreeListener = new NodePopupMenu$InternalWorkspaceTreeListener(this, null);
        this.diffListener = new NodePopupMenu$InternalDiffListener(this, null);
        this.lastSelectedDiff = null;
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.openDiff = GuiUtils.buildMenuItem("Open Diff", new LoadDiffAction(workspaceTabPanelFunctions));
        this.closeDiff = GuiUtils.buildMenuItem("Close Diff", new CloseDiffAction(workspaceTabPanelFunctions));
        this.deleteDiff = GuiUtils.buildMenuItem("Delete Diff", new DeleteDiffAction(workspaceTabPanelFunctions));
        this.closeViews = GuiUtils.buildMenuItem("Close Views", new CloseViewsAction(workspaceTabPanelFunctions));
        this.add(this.openDiff);
        this.add(this.closeDiff);
        this.add(new JSeparator());
        this.add(this.deleteDiff);
        this.add(new JSeparator());
        this.add(this.closeViews);
        this.openDiff.setEnabled(true);
        this.closeDiff.setEnabled(false);
        this.closeViews.setEnabled(false);
        this.controller.getWorkspaceTree().addListener(this.workspaceTreeListener);
    }

    private void registerCurrentDiffListener(Diff diff) {
        this.unregisterCurrentDiffListener();
        this.lastSelectedDiff = diff;
        this.lastSelectedDiff.addListener(this.diffListener);
    }

    private void unregisterCurrentDiffListener() {
        if (this.lastSelectedDiff == null) return;
        this.lastSelectedDiff.removeListener(this.diffListener);
        this.lastSelectedDiff = null;
    }

    private void updateMenu(Diff diff) {
        this.openDiff.setEnabled(!diff.isLoaded());
        this.closeDiff.setEnabled(diff.isLoaded());
        this.deleteDiff.setEnabled(true);
        HashSet<Diff> hashSet = new HashSet<Diff>();
        hashSet.add(diff);
        this.closeViews.setEnabled(this.controller.getOpenViews(hashSet).size() > 0);
    }

    public void dispose() {
        this.unregisterCurrentDiffListener();
        this.controller.getWorkspaceTree().removeListener(this.workspaceTreeListener);
    }

    static /* synthetic */ void access$200(NodePopupMenu nodePopupMenu, Diff diff) {
        nodePopupMenu.updateMenu(diff);
    }

    static /* synthetic */ JMenuItem access$300(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.openDiff;
    }

    static /* synthetic */ void access$400(NodePopupMenu nodePopupMenu) {
        nodePopupMenu.unregisterCurrentDiffListener();
    }

    static /* synthetic */ NodePopupMenu$InternalWorkspaceTreeListener access$500(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.workspaceTreeListener;
    }

    static /* synthetic */ WorkspaceTabPanelFunctions access$600(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.controller;
    }

    static /* synthetic */ JMenuItem access$700(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.closeDiff;
    }

    static /* synthetic */ JMenuItem access$800(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.deleteDiff;
    }

    static /* synthetic */ JMenuItem access$900(NodePopupMenu nodePopupMenu) {
        return nodePopupMenu.closeViews;
    }

    static /* synthetic */ void access$1000(NodePopupMenu nodePopupMenu, Diff diff) {
        nodePopupMenu.registerCurrentDiffListener(diff);
    }
}

