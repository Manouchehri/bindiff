/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$6;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Component;
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
import javax.swing.JSeparator;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class CombinedCallGraphBaseTreeNode
extends AbstractBaseTreeNode {
    private static final Icon CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    private List functionNodes = new ArrayList();
    private CombinedDiffNode lastSelectedTreeNode;

    public CombinedCallGraphBaseTreeNode(CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode) {
        super(combinedCallGraphRootTreeNode);
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
        ArrayList<CombinedCallGraphFunctionTreeNode> arrayList = new ArrayList<CombinedCallGraphFunctionTreeNode>();
        if (treeNodeSearcher.getUseTemporaryResults() && !"".equals(treeNodeSearcher.getSearchString())) {
            for (int i2 = 1; i2 < this.getChildCount(); ++i2) {
                arrayList.add((CombinedCallGraphFunctionTreeNode)this.getChildAt(i2));
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
                    arrayList.add((CombinedCallGraphFunctionTreeNode)((Object)iterator22));
                }
            } else {
                treeNodeSearcher.search((List)null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (CombinedCallGraphFunctionTreeNode object22 : arrayList) {
            if (!graphNodeMultiFilter.filterRawCombinedFunction(object22.getCombinedFunction())) continue;
            if (!bl2 && !"".equals(treeNodeSearcher.getSearchString())) {
                if (!treeNodeSearcher.isSearchHit(object22.getCombinedDiffNode())) continue;
                arrayList2.add(object22);
                continue;
            }
            arrayList2.add(object22);
        }
        for (Comparator comparator : this.getRootNode().getSorter().getCombinedFunctionTreeNodeComparatorList()) {
            Collections.sort(arrayList2, comparator);
        }
        iterator22 = arrayList2.iterator();
        do {
            if (!iterator22.hasNext()) {
                this.getTree().getModel().nodeStructureChanged(this);
                this.getTree().updateUI();
                return;
            }
            CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode = (CombinedCallGraphFunctionTreeNode)iterator22.next();
            this.add(combinedCallGraphFunctionTreeNode);
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
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            this.functionNodes.add(new CombinedCallGraphFunctionTreeNode(this.getRootNode(), combinedDiffNode));
        } while (true);
    }

    @Override
    public Icon getIcon() {
        return CALLGRAPH_ICON;
    }

    public CombinedDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem(new CombinedCallGraphBaseTreeNode$1(this, "Copy Primary Image Name"));
        JMenuItem jMenuItem2 = new JMenuItem(new CombinedCallGraphBaseTreeNode$2(this, "Copy Secondary Image Name"));
        JMenuItem jMenuItem3 = new JMenuItem(new CombinedCallGraphBaseTreeNode$3(this, "Copy Primary Image Hash"));
        JMenuItem jMenuItem4 = new JMenuItem(new CombinedCallGraphBaseTreeNode$4(this, "Copy Secondary Image Hash"));
        JMenuItem jMenuItem5 = new JMenuItem(new CombinedCallGraphBaseTreeNode$5(this, "Copy Primary IDB Name"));
        JMenuItem jMenuItem6 = new JMenuItem(new CombinedCallGraphBaseTreeNode$6(this, "Copy Secondary IDB Name"));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.add(jMenuItem3);
        jPopupMenu.add(jMenuItem5);
        jPopupMenu.add(new JSeparator());
        jPopupMenu.add(jMenuItem2);
        jPopupMenu.add(jMenuItem4);
        jPopupMenu.add(jMenuItem6);
        return jPopupMenu;
    }

    @Override
    public CombinedCallGraphRootTreeNode getRootNode() {
        return (CombinedCallGraphRootTreeNode)this.getAbstractRootNode();
    }

    public void setLastSelectedGraphNode(CombinedDiffNode combinedDiffNode) {
        this.lastSelectedTreeNode = combinedDiffNode;
    }

    @Override
    public String toString() {
        return String.format("%s (%d / %d)", "Combined Call Graph", this.getChildCount(), this.functionNodes.size());
    }

    static /* synthetic */ Diff access$000(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$100(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$200(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$300(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$400(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }

    static /* synthetic */ Diff access$500(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode) {
        return combinedCallGraphBaseTreeNode.getDiff();
    }
}

