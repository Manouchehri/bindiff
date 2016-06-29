/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerCombinedBasicBlock;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.SortedMap;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class CombinedFlowGraphBasicBlockTreeNode
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
    private final CombinedDiffNode combinedDiffNode;
    private final RawCombinedBasicBlock combinedBasicblock;

    public CombinedFlowGraphBasicBlockTreeNode(CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode, CombinedDiffNode combinedDiffNode) {
        super(combinedFlowGraphRootTreeNode);
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
        this.combinedBasicblock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
        this.createChildren();
    }

    private boolean isChangedBasicblock() {
        IAddress iAddress;
        IAddress iAddress2;
        Diff diff = this.getDiff();
        EMatchState eMatchState = this.getMatchState();
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) return false;
        if (eMatchState == EMatchState.SECONDRAY_UNMATCHED) {
            return false;
        }
        MatchData matchData = diff.getMatches();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(iAddress = this.combinedBasicblock.getPrimaryFunctionAddress(), ESide.PRIMARY);
        if (functionMatchData == null) return false;
        RawBasicBlock rawBasicBlock = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
        RawBasicBlock rawBasicBlock2 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
        IAddress iAddress3 = this.combinedBasicblock.getAddress(ESide.PRIMARY);
        if (!functionMatchData.isBasicblockMatch(iAddress3, iAddress2 = this.combinedBasicblock.getAddress(ESide.SECONDARY))) return false;
        BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress3, ESide.PRIMARY);
        if (basicBlockMatchData == null) return false;
        int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
        if (rawBasicBlock.getInstructions().size() > n2) return true;
        if (rawBasicBlock2.getInstructions().size() > n2) return true;
        return false;
    }

    @Override
    public IAddress getAddress() {
        return null;
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        return this.combinedBasicblock.getAddress(eSide);
    }

    public RawCombinedBasicBlock getCombinedBasicblock() {
        return this.combinedBasicblock;
    }

    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }

    @Override
    public String getFunctionName() {
        return null;
    }

    @Override
    public EFunctionType getFunctionType() {
        return null;
    }

    @Override
    public ZyGraphNode getGraphNode() {
        return this.combinedDiffNode;
    }

    @Override
    public ZyGraphNode getGraphNode(ESide eSide) {
        SingleDiffNode singleDiffNode;
        if (eSide == ESide.PRIMARY) {
            singleDiffNode = this.combinedDiffNode.getPrimaryDiffNode();
            return singleDiffNode;
        }
        singleDiffNode = this.combinedDiffNode.getSecondaryDiffNode();
        return singleDiffNode;
    }

    @Override
    public Icon getIcon() {
        switch (CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
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
        return this.combinedBasicblock.getMatchState();
    }

    @Override
    public EMatchType getMatchType() {
        EMatchType eMatchType;
        if (this.getMatchState() != EMatchState.MATCHED) {
            return EMatchType.UNUMATCHED;
        }
        if (this.isChangedBasicblock()) {
            eMatchType = EMatchType.INSTRUCTIONS_CHANGED;
            return eMatchType;
        }
        eMatchType = EMatchType.IDENTICAL;
        return eMatchType;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return new FlowGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.combinedDiffNode);
    }

    @Override
    public CombinedFlowGraphRootTreeNode getRootNode() {
        return (CombinedFlowGraphRootTreeNode)this.getAbstractRootNode();
    }

    @Override
    public void handleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.handleMouseSelectionEvent(mouseEvent, this);
        }
        super.handleMouseEvent(mouseEvent);
    }

    @Override
    public boolean isSelected() {
        return this.combinedBasicblock.isSelected();
    }

    @Override
    public boolean isVisible() {
        return this.combinedBasicblock.isVisible();
    }

    @Override
    public String toString() {
        RawBasicBlock rawBasicBlock = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
        RawBasicBlock rawBasicBlock2 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
        Object[] arrobject = new Object[2];
        arrobject[0] = rawBasicBlock == null ? "missing" : rawBasicBlock.getAddress().toHexString();
        arrobject[1] = rawBasicBlock2 == null ? "missing" : rawBasicBlock2.getAddress().toHexString();
        return String.format("%s \u2194 %s", arrobject);
    }
}

