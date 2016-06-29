/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.UnmatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class UnmatchedFunctionViewsNode
extends AbstractTreeNode {
    private static final ImageIcon PRIMARY_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private static final ImageIcon SECONDRAY_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    private final NodePopupMenu popupMenu;
    private final ESide side;
    private final UnmatchedFunctionsTreeNodeContextPanel component;

    public UnmatchedFunctionViewsNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff, ESide eSide) {
        super(workspaceTabPanelFunctions, diff);
        this.side = eSide;
        this.popupMenu = new NodePopupMenu(workspaceTabPanelFunctions);
        this.component = new UnmatchedFunctionsTreeNodeContextPanel(diff, this.getController(), eSide);
    }

    @Override
    protected void createChildren() {
    }

    @Override
    protected void delete() {
        this.popupMenu.dispose();
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
        ImageIcon imageIcon;
        if (this.side == ESide.PRIMARY) {
            imageIcon = PRIMARY_ICON;
            return imageIcon;
        }
        imageIcon = SECONDRAY_ICON;
        return imageIcon;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }

    @Override
    public String toString() {
        MatchData matchData = this.getDiff().getMatches();
        int n2 = matchData.getSizeOfUnmatchedFunctions(this.side);
        int n3 = matchData.getSizeOfFunctions(this.side);
        if (this.side != ESide.PRIMARY) return String.format("Secondary Unmatched Functions (%d/%d)", n2, n3);
        return String.format("Primary Unmatched Functions (%d/%d)", n2, n3);
    }
}

