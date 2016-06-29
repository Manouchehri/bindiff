package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.utils.*;

public final class UnmatchedFunctionViewsNode extends AbstractTreeNode
{
    private static final ImageIcon PRIMARY_ICON;
    private static final ImageIcon SECONDRAY_ICON;
    private final NodePopupMenu popupMenu;
    private final ESide side;
    private final UnmatchedFunctionsTreeNodeContextPanel component;
    
    public UnmatchedFunctionViewsNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff, final ESide side) {
        super(workspaceTabPanelFunctions, diff);
        this.side = side;
        this.popupMenu = new NodePopupMenu(workspaceTabPanelFunctions);
        this.component = new UnmatchedFunctionsTreeNodeContextPanel(diff, this.getController(), side);
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
        return (this.side == ESide.PRIMARY) ? UnmatchedFunctionViewsNode.PRIMARY_ICON : UnmatchedFunctionViewsNode.SECONDRAY_ICON;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }
    
    @Override
    public String toString() {
        final MatchData matches = this.getDiff().getMatches();
        final int sizeOfUnmatchedFunctions = matches.getSizeOfUnmatchedFunctions(this.side);
        final int sizeOfFunctions = matches.getSizeOfFunctions(this.side);
        if (this.side == ESide.PRIMARY) {
            return String.format("Primary Unmatched Functions (%d/%d)", sizeOfUnmatchedFunctions, sizeOfFunctions);
        }
        return String.format("Secondary Unmatched Functions (%d/%d)", sizeOfUnmatchedFunctions, sizeOfFunctions);
    }
    
    static {
        PRIMARY_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
        SECONDRAY_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    }
}
