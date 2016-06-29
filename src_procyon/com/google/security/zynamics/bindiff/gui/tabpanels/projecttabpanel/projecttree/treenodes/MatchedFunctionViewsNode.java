package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;

public final class MatchedFunctionViewsNode extends AbstractTreeNode
{
    private static final ImageIcon ICON;
    private NodePopupMenu popupMenu;
    private final MatchedFunctionsTreeNodeContextPanel component;
    
    public MatchedFunctionViewsNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
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
        return MatchedFunctionViewsNode.ICON;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }
    
    @Override
    public String toString() {
        return String.format("Matched Functions (%d)", this.getDiff().getMatches().getSizeOfMatchedFunctions());
    }
    
    static {
        ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    }
}
