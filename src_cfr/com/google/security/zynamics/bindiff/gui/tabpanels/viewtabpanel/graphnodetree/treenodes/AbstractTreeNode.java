/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public abstract class AbstractTreeNode
extends DefaultMutableTreeNode {
    private AbstractRootTreeNode rootNode;

    public AbstractTreeNode(AbstractRootTreeNode abstractRootTreeNode) {
        Preconditions.checkArgument(abstractRootTreeNode != null || this instanceof AbstractRootTreeNode, "Root node cannot be null for non-root nodes");
        this.rootNode = abstractRootTreeNode;
    }

    protected void delete() {
        int n2 = 0;
        do {
            if (n2 >= this.getChildCount()) {
                this.removeAllChildren();
                this.rootNode = null;
                return;
            }
            AbstractTreeNode abstractTreeNode = (AbstractTreeNode)this.getChildAt(n2);
            abstractTreeNode.delete();
            abstractTreeNode = null;
            ++n2;
        } while (true);
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

    public void handleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 3) return;
        if (!mouseEvent.isPopupTrigger()) {
            return;
        }
        JPopupMenu jPopupMenu = this.getPopupMenu();
        if (jPopupMenu == null) return;
        jPopupMenu.show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
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

