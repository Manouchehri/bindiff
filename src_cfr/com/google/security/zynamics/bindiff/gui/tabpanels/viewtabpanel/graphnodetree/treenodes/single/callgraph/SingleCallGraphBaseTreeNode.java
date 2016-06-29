/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class SingleCallGraphBaseTreeNode
extends AbstractBaseTreeNode {
    private static final Icon CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    private List functionNodes = new ArrayList();
    private SingleDiffNode lastSelectedTreeNode;

    public SingleCallGraphBaseTreeNode(SingleCallGraphRootTreeNode singleCallGraphRootTreeNode) {
        super(singleCallGraphRootTreeNode);
        this.createChildren();
    }

    @Override
    protected void delete() {
        super.delete();
        this.functionNodes.clear();
        this.functionNodes = null;
        this.lastSelectedTreeNode = null;
    }

    @Override
    protected void updateTreeNodes(boolean bl2) {
        Iterator iterator22;
        TreeNodeSearcher treeNodeSearcher = this.getSearcher();
        GraphNodeMultiFilter graphNodeMultiFilter = this.getFilter();
        ArrayList<SingleCallGraphFunctionTreeNode> arrayList = new ArrayList<SingleCallGraphFunctionTreeNode>();
        if (treeNodeSearcher.getUseTemporaryResults() && !"".equals(treeNodeSearcher.getSearchString())) {
            for (int i2 = 1; i2 < this.getChildCount(); ++i2) {
                arrayList.add((SingleCallGraphFunctionTreeNode)this.getChildAt(i2));
            }
        } else {
            arrayList.addAll(this.functionNodes);
        }
        this.removeAllChildren();
        List list = new ArrayList();
        if (bl2) {
            if (!"".equals(treeNodeSearcher.getSearchString())) {
                list = treeNodeSearcher.search(arrayList);
                arrayList.clear();
                for (Iterator iterator22 : list) {
                    arrayList.add((SingleCallGraphFunctionTreeNode)((Object)iterator22));
                }
            } else {
                treeNodeSearcher.search((List)null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (SingleCallGraphFunctionTreeNode object22 : arrayList) {
            if (!graphNodeMultiFilter.filterRawFunction(object22.getFunction())) continue;
            if (!bl2 && !"".equals(treeNodeSearcher.getSearchString())) {
                if (!treeNodeSearcher.isSearchHit(object22.getSingleDiffNode())) continue;
                arrayList2.add(object22);
                continue;
            }
            arrayList2.add(object22);
        }
        for (Comparator comparator : this.getRootNode().getSorter().getSingleFunctionTreeNodeComparatorList()) {
            Collections.sort(arrayList2, comparator);
        }
        iterator22 = arrayList2.iterator();
        do {
            if (!iterator22.hasNext()) {
                this.getTree().getModel().nodeStructureChanged(this);
                this.getTree().updateUI();
                return;
            }
            SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode = (SingleCallGraphFunctionTreeNode)iterator22.next();
            this.add(singleCallGraphFunctionTreeNode);
        } while (true);
    }

    @Override
    public void createChildren() {
        this.functionNodes.clear();
        Iterator iterator = this.getRootNode().getGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                this.updateTreeNodes(false);
                return;
            }
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            this.functionNodes.add(new SingleCallGraphFunctionTreeNode(this.getRootNode(), singleDiffNode));
        } while (true);
    }

    @Override
    public Icon getIcon() {
        return CALLGRAPH_ICON;
    }

    public SingleDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        ESide eSide = this.getRootNode().getSide();
        JMenuItem jMenuItem = new JMenuItem(new SingleCallGraphBaseTreeNode$1(this, "Copy Image Name", eSide));
        JMenuItem jMenuItem2 = new JMenuItem(new SingleCallGraphBaseTreeNode$2(this, "Copy Image Hash", eSide));
        JMenuItem jMenuItem3 = new JMenuItem(new SingleCallGraphBaseTreeNode$3(this, "Copy IDB Name", eSide));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.add(jMenuItem2);
        jPopupMenu.add(jMenuItem3);
        return jPopupMenu;
    }

    @Override
    public SingleCallGraphRootTreeNode getRootNode() {
        return (SingleCallGraphRootTreeNode)this.getAbstractRootNode();
    }

    @Override
    public String getTooltipText() {
        return null;
    }

    @Override
    public void handleMouseEvent(MouseEvent mouseEvent) {
        if (!mouseEvent.isPopupTrigger()) return;
        this.getPopupMenu().show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    public void setLastSelectedGraphNode(SingleDiffNode singleDiffNode) {
        this.lastSelectedTreeNode = singleDiffNode;
    }

    @Override
    public String toString() {
        return String.format("%s (%d / %d)", "Call Graph", this.getChildCount(), this.functionNodes.size());
    }

    static /* synthetic */ Diff access$000(SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode) {
        return singleCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$100(SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode) {
        return singleCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$200(SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode) {
        return singleCallGraphBaseTreeNode.getDiff();
    }
}

