/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class MatchedFunctionViewsNode
extends AbstractTreeNode {
    private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    private NodePopupMenu popupMenu;
    private final MatchedFunctionsTreeNodeContextPanel component;

    public MatchedFunctionViewsNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        super(workspaceTabPanelFunctions, diff);
        this.popupMenu = new NodePopupMenu(workspaceTabPanelFunctions);
        this.component = new MatchedFunctionsTreeNodeContextPanel(workspaceTabPanelFunctions, diff);
    }

    @Override
    protected void createChildren() {
    }

    @Override
    protected void delete() {
        this.component.dispose();
        this.popupMenu.dispose();
        this.popupMenu = null;
    }

    @Override
    public void doubleClicked() {
    }

    @Override
    public Component getComponent() {
        return this.component;
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }

    @Override
    public String toString() {
        return String.format("Matched Functions (%d)", this.getDiff().getMatches().getSizeOfMatchedFunctions());
    }
}

