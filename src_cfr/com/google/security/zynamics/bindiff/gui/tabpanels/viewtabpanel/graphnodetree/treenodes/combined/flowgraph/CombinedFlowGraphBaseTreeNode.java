/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
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

public class CombinedFlowGraphBaseTreeNode
extends AbstractBaseTreeNode {
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private final IMatchesChangeListener matchesChangeListener;
    private final List basicblockTreeNodes;
    private CombinedDiffNode lastSelectedTreeNode;

    public CombinedFlowGraphBaseTreeNode(CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode) {
        super(combinedFlowGraphRootTreeNode);
        this.matchesChangeListener = new CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, null);
        this.basicblockTreeNodes = new ArrayList();
        this.createChildren();
        this.getDiff().getMatches().addListener(this.matchesChangeListener);
    }

    @Override
    protected void delete() {
        this.getDiff().getMatches().removeListener(this.matchesChangeListener);
        super.delete();
    }

    @Override
    protected void updateTreeNodes(boolean bl2) {
        Iterator iterator22;
        TreeNodeSearcher treeNodeSearcher = this.getSearcher();
        GraphNodeMultiFilter graphNodeMultiFilter = this.getFilter();
        ArrayList<CombinedFlowGraphBasicBlockTreeNode> arrayList = new ArrayList<CombinedFlowGraphBasicBlockTreeNode>();
        if (treeNodeSearcher.getUseTemporaryResults() && !"".equals(treeNodeSearcher.getSearchString())) {
            for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
                arrayList.add((CombinedFlowGraphBasicBlockTreeNode)this.getChildAt(i2));
            }
        } else {
            arrayList.addAll(this.basicblockTreeNodes);
        }
        this.removeAllChildren();
        List list = new ArrayList();
        if (bl2) {
            if (!"".equals(treeNodeSearcher.getSearchString())) {
                list = treeNodeSearcher.search(arrayList);
                arrayList.clear();
                for (Iterator iterator22 : list) {
                    arrayList.add((CombinedFlowGraphBasicBlockTreeNode)((Object)iterator22));
                }
            } else {
                treeNodeSearcher.search((List)null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (CombinedFlowGraphBasicBlockTreeNode object22 : arrayList) {
            if (!graphNodeMultiFilter.filterRawCombinedBasicblock(object22.getCombinedBasicblock())) continue;
            if (!bl2 && !"".equals(treeNodeSearcher.getSearchString())) {
                if (!treeNodeSearcher.isSearchHit(object22.getCombinedDiffNode())) continue;
                arrayList2.add(object22);
                continue;
            }
            arrayList2.add(object22);
        }
        for (Comparator comparator : this.getRootNode().getSorter().getCombinedBasicblockTreeNodeComparatorList()) {
            Collections.sort(arrayList2, comparator);
        }
        iterator22 = arrayList2.iterator();
        do {
            if (!iterator22.hasNext()) {
                this.getTree().getModel().nodeStructureChanged(this);
                this.getTree().updateUI();
                return;
            }
            CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = (CombinedFlowGraphBasicBlockTreeNode)iterator22.next();
            this.add(combinedFlowGraphBasicBlockTreeNode);
        } while (true);
    }

    @Override
    public void createChildren() {
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = this.getRootNode();
        this.basicblockTreeNodes.clear();
        Iterator iterator = combinedFlowGraphRootTreeNode.getGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                this.updateTreeNodes(false);
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            this.basicblockTreeNodes.add(new CombinedFlowGraphBasicBlockTreeNode(combinedFlowGraphRootTreeNode, combinedDiffNode));
        } while (true);
    }

    @Override
    public Icon getIcon() {
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = this.getRootNode();
        FlowGraphViewData flowGraphViewData = combinedFlowGraphRootTreeNode.getView();
        RawFlowGraph rawFlowGraph = flowGraphViewData.getRawGraph(ESide.PRIMARY);
        RawFlowGraph rawFlowGraph2 = flowGraphViewData.getRawGraph(ESide.SECONDARY);
        RawFunction rawFunction = GraphGetter.getFunction(this.getDiff(), rawFlowGraph);
        RawFunction rawFunction2 = GraphGetter.getFunction(this.getDiff(), rawFlowGraph2);
        if (rawFunction2 == null) {
            return PRIMARY_UNMATCHED_FUNCTION_ICON;
        }
        if (rawFunction == null) {
            return SECONDRAY_UNMATCHED_FUNCNTION_ICON;
        }
        if (rawFunction.isChangedInstructionsOnlyMatch()) {
            return MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
        }
        if (!rawFunction.isChangedStructuralMatch()) return MATCHED_IDENTICAL_FUNCTION_ICON;
        return MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    }

    public CombinedDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem(new CombinedFlowGraphBaseTreeNode$1(this, "Copy Primary Function Address"));
        JMenuItem jMenuItem2 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$2(this, "Copy Primary Function Name"));
        JMenuItem jMenuItem3 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$3(this, "Copy Secondary Function Address"));
        JMenuItem jMenuItem4 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$4(this, "Copy Secondary Function Name"));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.add(jMenuItem2);
        jPopupMenu.add(jMenuItem3);
        jPopupMenu.add(jMenuItem4);
        return jPopupMenu;
    }

    @Override
    public CombinedFlowGraphRootTreeNode getRootNode() {
        return (CombinedFlowGraphRootTreeNode)this.getAbstractRootNode();
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

    public void setLastSelectedGraphNode(CombinedDiffNode combinedDiffNode) {
        this.lastSelectedTreeNode = combinedDiffNode;
    }

    @Override
    public String toString() {
        FlowGraphViewData flowGraphViewData = this.getRootNode().getView();
        RawFlowGraph rawFlowGraph = flowGraphViewData.getRawGraph(ESide.PRIMARY);
        RawFlowGraph rawFlowGraph2 = flowGraphViewData.getRawGraph(ESide.SECONDARY);
        String string = "missing";
        String string2 = "missing";
        if (rawFlowGraph != null) {
            string = rawFlowGraph.getName();
        }
        if (rawFlowGraph2 == null) return String.format("%s \u2194 %s (%d / %d)", string, string2, this.getChildCount(), this.basicblockTreeNodes.size());
        string2 = rawFlowGraph2.getName();
        return String.format("%s \u2194 %s (%d / %d)", string, string2, this.getChildCount(), this.basicblockTreeNodes.size());
    }

    static /* synthetic */ ViewData access$100(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        return combinedFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ ViewData access$200(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        return combinedFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ ViewData access$300(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        return combinedFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ ViewData access$400(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        return combinedFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ List access$500(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        return combinedFlowGraphBaseTreeNode.basicblockTreeNodes;
    }
}

