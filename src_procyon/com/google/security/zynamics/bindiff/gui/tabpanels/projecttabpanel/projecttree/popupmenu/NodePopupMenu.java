package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public class NodePopupMenu extends JPopupMenu
{
    private final WorkspaceTabPanelFunctions controller;
    private final JMenuItem openDiff;
    private final JMenuItem closeDiff;
    private final JMenuItem deleteDiff;
    private final JMenuItem closeViews;
    private final NodePopupMenu$InternalWorkspaceTreeListener workspaceTreeListener;
    private final NodePopupMenu$InternalDiffListener diffListener;
    private Diff lastSelectedDiff;
    
    public NodePopupMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
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
    
    private void registerCurrentDiffListener(final Diff lastSelectedDiff) {
        this.unregisterCurrentDiffListener();
        (this.lastSelectedDiff = lastSelectedDiff).addListener(this.diffListener);
    }
    
    private void unregisterCurrentDiffListener() {
        if (this.lastSelectedDiff != null) {
            this.lastSelectedDiff.removeListener(this.diffListener);
            this.lastSelectedDiff = null;
        }
    }
    
    private void updateMenu(final Diff diff) {
        this.openDiff.setEnabled(!diff.isLoaded());
        this.closeDiff.setEnabled(diff.isLoaded());
        this.deleteDiff.setEnabled(true);
        final HashSet<Diff> set = new HashSet<Diff>();
        set.add(diff);
        this.closeViews.setEnabled(this.controller.getOpenViews(set).size() > 0);
    }
    
    public void dispose() {
        this.unregisterCurrentDiffListener();
        this.controller.getWorkspaceTree().removeListener(this.workspaceTreeListener);
    }
}
