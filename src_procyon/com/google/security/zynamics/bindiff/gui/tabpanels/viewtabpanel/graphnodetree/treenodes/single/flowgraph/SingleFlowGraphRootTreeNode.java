package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import javax.swing.tree.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.graph.*;

public class SingleFlowGraphRootTreeNode extends AbstractFlowGraphRootTreeNode
{
    public SingleFlowGraphRootTreeNode(final ViewTabPanelFunctions viewTabPanelFunctions, final AbstractGraphNodeTree abstractGraphNodeTree, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        super(viewTabPanelFunctions, abstractGraphNodeTree, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.createChildren();
    }
    
    @Override
    public void createChildren() {
        if (this.getView().getRawGraph(this.getSide()) != null) {
            this.add(new SingleFlowGraphBaseTreeNode(this));
        }
    }
    
    public SingleGraph getGraph() {
        return (SingleGraph)this.getTree().getGraph();
    }
    
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }
    
    @Override
    public SingleFlowGraphRootTreeNode getRootNode() {
        return this;
    }
    
    @Override
    public ESide getSide() {
        return this.getGraph().getSide();
    }
    
    @Override
    public String getTooltipText() {
        return null;
    }
    
    @Override
    public void handleMouseEvent(final MouseEvent mouseEvent) {
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }
    
    @Override
    public boolean isVisible() {
        return true;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
