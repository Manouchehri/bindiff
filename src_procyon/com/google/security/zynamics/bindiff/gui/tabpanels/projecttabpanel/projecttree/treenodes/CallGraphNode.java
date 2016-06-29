package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.utils.*;

public final class CallGraphNode extends AbstractTreeNode
{
    private static final ImageIcon ICON;
    private final NodePopupMenu popupMenu;
    private final CallGraphsTreeNodeContextPanel component;
    
    public CallGraphNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
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
        final WorkspaceTabPanelFunctions controller = this.getController();
        controller.openCallgraphView(controller.getMainWindow(), this.getDiff());
    }
    
    @Override
    public Component getComponent() {
        return this.component;
    }
    
    @Override
    public Icon getIcon() {
        return CallGraphNode.ICON;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }
    
    @Override
    public String toString() {
        final MatchData matches = this.getDiff().getMatches();
        return String.format("Call Graph (%d/%d)", matches.getSizeOfFunctions(ESide.PRIMARY), matches.getSizeOfFunctions(ESide.SECONDARY));
    }
    
    static {
        ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    }
}
