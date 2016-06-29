/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
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

public class SingleFlowGraphBaseTreeNode
extends AbstractBaseTreeNode {
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    private final IMatchesChangeListener matchesChangeListener;
    private final List basicBlockTreeNodes;
    private SingleDiffNode lastSelectedTreeNode;

    public SingleFlowGraphBaseTreeNode(SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode) {
        super(singleFlowGraphRootTreeNode);
        this.matchesChangeListener = new SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, null);
        this.basicBlockTreeNodes = new ArrayList();
        this.createChildren();
        this.getDiff().getMatches().addListener(this.matchesChangeListener);
    }

    private void replaceBasicblockTreeNode(IAddress iAddress) {
        SingleDiffNode singleDiffNode = null;
        for (Object object2 : this.getRootNode().getGraph().getNodes()) {
            if (!iAddress.equals(object2.getRawNode().getAddress())) continue;
            singleDiffNode = object2;
            break;
        }
        if (singleDiffNode == null) return;
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            Object object2;
            object2 = (SingleFlowGraphBasicBlockTreeNode)this.getChildAt(i2);
            RawBasicBlock rawBasicBlock = object2.getBasicblock();
            if (!iAddress.equals(rawBasicBlock.getAddress())) continue;
            SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode = new SingleFlowGraphBasicBlockTreeNode(this.getRootNode(), singleDiffNode);
            this.insert(singleFlowGraphBasicBlockTreeNode, i2);
            int n2 = this.basicBlockTreeNodes.indexOf(object2);
            this.basicBlockTreeNodes.set(n2, singleFlowGraphBasicBlockTreeNode);
            break;
        }
        this.updateTreeNodes(true);
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
        ArrayList<SingleFlowGraphBasicBlockTreeNode> arrayList = new ArrayList<SingleFlowGraphBasicBlockTreeNode>();
        if (treeNodeSearcher.getUseTemporaryResults() && !"".equals(treeNodeSearcher.getSearchString())) {
            for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
                arrayList.add((SingleFlowGraphBasicBlockTreeNode)this.getChildAt(i2));
            }
        } else {
            arrayList.addAll(this.basicBlockTreeNodes);
        }
        this.removeAllChildren();
        List list = new ArrayList();
        if (bl2) {
            if (!"".equals(treeNodeSearcher.getSearchString())) {
                list = treeNodeSearcher.search(arrayList);
                arrayList.clear();
                for (Iterator iterator22 : list) {
                    arrayList.add((SingleFlowGraphBasicBlockTreeNode)((Object)iterator22));
                }
            } else {
                treeNodeSearcher.search((List)null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (SingleFlowGraphBasicBlockTreeNode object22 : arrayList) {
            if (!graphNodeMultiFilter.filterRawBasicblock(object22.getBasicblock())) continue;
            if (!bl2 && !"".equals(treeNodeSearcher.getSearchString())) {
                if (!treeNodeSearcher.isSearchHit(object22.getSingleDiffNode())) continue;
                arrayList2.add(object22);
                continue;
            }
            arrayList2.add(object22);
        }
        for (Comparator comparator : this.getRootNode().getSorter().getSingleBasicblockTreeNodeComparatorList()) {
            Collections.sort(arrayList2, comparator);
        }
        iterator22 = arrayList2.iterator();
        do {
            if (!iterator22.hasNext()) {
                this.getTree().getModel().nodeStructureChanged(this);
                this.getTree().updateUI();
                return;
            }
            SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode = (SingleFlowGraphBasicBlockTreeNode)iterator22.next();
            this.add(singleFlowGraphBasicBlockTreeNode);
        } while (true);
    }

    @Override
    public void createChildren() {
        this.basicBlockTreeNodes.clear();
        SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode = this.getRootNode();
        Iterator iterator = this.getRootNode().getGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                this.updateTreeNodes(false);
                return;
            }
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            this.basicBlockTreeNodes.add(new SingleFlowGraphBasicBlockTreeNode(singleFlowGraphRootTreeNode, singleDiffNode));
        } while (true);
    }

    @Override
    public Icon getIcon() {
        FlowGraphViewData flowGraphViewData = this.getRootNode().getView();
        ESide eSide = this.getRootNode().getSide();
        RawFlowGraph rawFlowGraph = flowGraphViewData.getRawGraph(eSide);
        IAddress iAddress = rawFlowGraph.getAddress();
        RawFunction rawFunction = this.getDiff().getCallgraph(eSide).getFunction(iAddress);
        EMatchState eMatchState = rawFunction.getMatchState();
        if (eMatchState != EMatchState.MATCHED) {
            if (eMatchState != EMatchState.PRIMARY_UNMATCHED) return SECONDRAY_UNMATCHED_FUNCNTION_ICON;
            return PRIMARY_UNMATCHED_FUNCTION_ICON;
        }
        IAddress iAddress2 = rawFunction.getMatchedFunctionAddress();
        RawFunction rawFunction2 = rawFunction.getSide() == ESide.PRIMARY ? rawFunction : this.getDiff().getFunction(iAddress2, ESide.PRIMARY);
        if (rawFunction2.isIdenticalMatch()) {
            return MATCHED_IDENTICAL_FUNCTION_ICON;
        }
        if (rawFunction2.isChangedInstructionsOnlyMatch()) {
            return MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
        }
        if (!rawFunction2.isChangedStructuralMatch()) return SECONDRAY_UNMATCHED_FUNCNTION_ICON;
        return MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    }

    public SingleDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        ESide eSide = this.getRootNode().getSide();
        JMenuItem jMenuItem = new JMenuItem(new SingleFlowGraphBaseTreeNode$1(this, "Copy Function Address", eSide));
        JMenuItem jMenuItem2 = new JMenuItem(new SingleFlowGraphBaseTreeNode$2(this, "Copy Function Name", eSide));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.add(jMenuItem2);
        return jPopupMenu;
    }

    @Override
    public SingleFlowGraphRootTreeNode getRootNode() {
        return (SingleFlowGraphRootTreeNode)this.getAbstractRootNode();
    }

    @Override
    public String getTooltipText() {
        return null;
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
        FlowGraphViewData flowGraphViewData = this.getRootNode().getView();
        ESide eSide = this.getRootNode().getSide();
        RawFlowGraph rawFlowGraph = flowGraphViewData.getRawGraph(eSide);
        return String.format("%s (%d / %d)", rawFlowGraph.getName(), this.getChildCount(), this.basicBlockTreeNodes.size());
    }

    static /* synthetic */ ViewData access$100(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode) {
        return singleFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ ViewData access$200(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode) {
        return singleFlowGraphBaseTreeNode.getView();
    }

    static /* synthetic */ void access$300(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode, IAddress iAddress) {
        singleFlowGraphBaseTreeNode.replaceBasicblockTreeNode(iAddress);
    }
}

