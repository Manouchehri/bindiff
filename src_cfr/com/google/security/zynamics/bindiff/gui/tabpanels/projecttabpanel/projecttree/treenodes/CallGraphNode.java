/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class CallGraphNode
extends AbstractTreeNode {
    private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    private final NodePopupMenu popupMenu;
    private final CallGraphsTreeNodeContextPanel component;

    public CallGraphNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        super(workspaceTabPanelFunctions, diff);
        this.popupMenu = new NodePopupMenu(workspaceTabPanelFunctions);
        this.component = new CallGraphsTreeNodeContextPanel(this.getDiff(), this.getController());
    }

    @Override
    protected void createChildren() {
    }

    @Override
    protected void delete() {
        this.popupMenu.dispose();
        this.component.dipose();
    }

    @Override
    public void doubleClicked() {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.getController();
        workspaceTabPanelFunctions.openCallgraphView(workspaceTabPanelFunctions.getMainWindow(), this.getDiff());
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
        MatchData matchData = this.getDiff().getMatches();
        return String.format("Call Graph (%d/%d)", matchData.getSizeOfFunctions(ESide.PRIMARY), matchData.getSizeOfFunctions(ESide.SECONDARY));
    }
}

