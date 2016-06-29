package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import javax.swing.tree.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public abstract class AbstractTreeNode extends DefaultMutableTreeNode
{
    private AbstractRootTreeNode rootNode;
    
    public AbstractTreeNode(final AbstractRootTreeNode rootNode) {
        Preconditions.checkArgument(rootNode != null || this instanceof AbstractRootTreeNode, (Object)"Root node cannot be null for non-root nodes");
        this.rootNode = rootNode;
    }
    
    protected void delete() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            ((AbstractTreeNode)this.getChildAt(i)).delete();
        }
        this.removeAllChildren();
        this.rootNode = null;
    }
    
    protected AbstractRootTreeNode getAbstractRootNode() {
        return this.rootNode;
    }
    
    protected Diff getDiff() {
        return this.rootNode.getDiff();
    }
    
    protected GraphNodeMultiFilter getFilter() {
        return this.getRootNode().getFilter();
    }
    
    protected FunctionMatchData getFunctionMatch() {
        return this.rootNode.getFunctionMatch();
    }
    
    protected BinDiffGraph getGraph() {
        return this.getTree().getGraph();
    }
    
    protected TreeNodeSearcher getSearcher() {
        return this.rootNode.getSearcher();
    }
    
    protected TreeNodeMultiSorter getSorter() {
        return this.getRootNode().getSorter();
    }
    
    protected AbstractGraphNodeTree getTree() {
        return this.rootNode.getTree();
    }
    
    protected ViewData getView() {
        return this.rootNode.getView();
    }
    
    public void createChildren() {
    }
    
    public abstract Icon getIcon();
    
    public JPopupMenu getPopupMenu() {
        return null;
    }
    
    public AbstractRootTreeNode getRootNode() {
        return this.getAbstractRootNode();
    }
    
    public String getTooltipText() {
        return null;
    }
    
    public void handleMouseEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 3 || !mouseEvent.isPopupTrigger()) {
            return;
        }
        final JPopupMenu popupMenu = this.getPopupMenu();
        if (popupMenu != null) {
            popupMenu.show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    public boolean isSelected() {
        return false;
    }
    
    public boolean isVisible() {
        return true;
    }
    
    @Override
    public abstract String toString();
}
