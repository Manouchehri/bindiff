/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerSingleBasicBlock;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBasicBlockTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.SortedMap;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleFlowGraphBasicBlockTreeNode
extends AbstractTreeNode
implements ISearchableTreeNode,
ISortableTreeNode {
    private static final Icon MATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/matched-basicblock.png");
    private static final Icon CHANGED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/changed-basicblock.png");
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-basicblock.png");
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-basicblock.png");
    private static final Icon MATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/matched-selected-basicblock.png");
    private static final Icon CHANGED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/changed-selected-basicblock.png");
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-selected-basicblock.png");
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-selected-basicblock.png");
    private static final Icon MATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/matched-invisible-basicblock.png");
    private static final Icon CHANGED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/changed-invisible-basicblock.png");
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-invisible-basicblock.png");
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-invisible-basicblock.png");
    private final SingleDiffNode singleDiffNode;
    private final RawBasicBlock rawBasicblock;

    public SingleFlowGraphBasicBlockTreeNode(SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode, SingleDiffNode singleDiffNode) {
        super(singleFlowGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        this.rawBasicblock = (RawBasicBlock)this.singleDiffNode.getRawNode();
        this.createChildren();
    }

    private boolean isChangedBasicblock() {
        Diff diff = this.getDiff();
        EMatchState eMatchState = this.getMatchState();
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) return false;
        if (eMatchState == EMatchState.SECONDRAY_UNMATCHED) {
            return false;
        }
        MatchData matchData = diff.getMatches();
        if (this.rawBasicblock.getSide() == ESide.PRIMARY) {
            IAddress iAddress;
            IAddress iAddress2 = this.rawBasicblock.getFunctionAddr();
            IAddress iAddress3 = matchData.getSecondaryFunctionAddr(iAddress2);
            if (iAddress3 == null) return false;
            FunctionMatchData functionMatchData = matchData.getFunctionMatch(iAddress2, ESide.PRIMARY);
            if (functionMatchData == null) return false;
            IAddress iAddress4 = this.rawBasicblock.getAddress();
            if (!functionMatchData.isBasicblockMatch(iAddress4, iAddress = functionMatchData.getSecondaryBasicblockAddr(iAddress4))) return false;
            RawBasicBlock rawBasicBlock = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.SECONDARY).getBasicblock(iAddress);
            BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress4, ESide.PRIMARY);
            if (basicBlockMatchData == null) return false;
            int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
            if (this.rawBasicblock.getInstructions().size() > n2) return true;
            if (rawBasicBlock.getInstructions().size() > n2) return true;
            return false;
        }
        IAddress iAddress = this.rawBasicblock.getFunctionAddr();
        IAddress iAddress5 = matchData.getPrimaryFunctionAddr(iAddress);
        if (iAddress5 == null) return false;
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(iAddress5, ESide.PRIMARY);
        if (functionMatchData == null) return false;
        IAddress iAddress6 = this.rawBasicblock.getAddress();
        IAddress iAddress7 = functionMatchData.getPrimaryBasicblockAddr(iAddress6);
        if (!functionMatchData.isBasicblockMatch(iAddress7, iAddress6)) return false;
        RawBasicBlock rawBasicBlock = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.PRIMARY).getBasicblock(iAddress7);
        BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress7, ESide.PRIMARY);
        if (basicBlockMatchData == null) return false;
        int n3 = basicBlockMatchData.getSizeOfMatchedInstructions();
        if (this.rawBasicblock.getInstructions().size() > n3) return true;
        if (rawBasicBlock.getInstructions().size() > n3) return true;
        return false;
    }

    @Override
    public void createChildren() {
    }

    @Override
    public IAddress getAddress() {
        return this.rawBasicblock.getAddress();
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        if (this.rawBasicblock.getSide() != eSide) return null;
        IAddress iAddress = this.rawBasicblock.getAddress();
        return iAddress;
    }

    public RawBasicBlock getBasicblock() {
        return this.rawBasicblock;
    }

    @Override
    public String getFunctionName() {
        return this.rawBasicblock.getFunctionName();
    }

    @Override
    public EFunctionType getFunctionType() {
        return null;
    }

    @Override
    public ZyGraphNode getGraphNode() {
        return this.singleDiffNode;
    }

    @Override
    public ZyGraphNode getGraphNode(ESide eSide) {
        if (this.singleDiffNode.getSide() == eSide) return this.singleDiffNode;
        return null;
    }

    @Override
    public Icon getIcon() {
        switch (SingleFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
            case 1: {
                if (!this.isChangedBasicblock()) {
                    if (this.isSelected()) {
                        return MATCHED_BASICBLOCK_SELECTED;
                    }
                    if (this.isVisible()) return MATCHED_BASICBLOCK;
                    return MATCHED_BASICBLOCK_INVISIBLE;
                }
                if (this.isSelected()) {
                    return CHANGED_BASICBLOCK_SELECTED;
                }
                if (this.isVisible()) return CHANGED_BASICBLOCK;
                return CHANGED_BASICBLOCK_INVISIBLE;
            }
            case 2: {
                if (this.isSelected()) {
                    return PRIMARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (this.isVisible()) return PRIMARY_UNMATCHED_BASICBLOCK;
                return PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE;
            }
            case 3: {
                if (this.isSelected()) {
                    return SECONDARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (this.isVisible()) return SECONDARY_UNMATCHED_BASICBLOCK;
                return SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE;
            }
        }
        throw new IllegalStateException("Unknown match type.");
    }

    @Override
    public EMatchState getMatchState() {
        return this.rawBasicblock.getMatchState();
    }

    @Override
    public EMatchType getMatchType() {
        if (this.getMatchState() != EMatchState.MATCHED) return EMatchType.UNUMATCHED;
        if (!this.isChangedBasicblock()) return EMatchType.IDENTICAL;
        return EMatchType.INSTRUCTIONS_CHANGED;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return new FlowGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.singleDiffNode);
    }

    @Override
    public SingleFlowGraphRootTreeNode getRootNode() {
        return (SingleFlowGraphRootTreeNode)this.getAbstractRootNode();
    }

    public SingleDiffNode getSingleDiffNode() {
        return this.singleDiffNode;
    }

    @Override
    public String getTooltipText() {
        return null;
    }

    @Override
    public void handleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.handleMouseSelectionEvent(mouseEvent, this);
        }
        super.handleMouseEvent(mouseEvent);
    }

    @Override
    public boolean isSelected() {
        return this.rawBasicblock.isSelected();
    }

    @Override
    public boolean isVisible() {
        return this.rawBasicblock.isVisible();
    }

    @Override
    public String toString() {
        return this.rawBasicblock.getAddress().toHexString();
    }
}

