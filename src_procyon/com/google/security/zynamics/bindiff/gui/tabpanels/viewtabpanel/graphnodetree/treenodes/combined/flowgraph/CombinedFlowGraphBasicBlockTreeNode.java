package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CombinedFlowGraphBasicBlockTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode
{
    private static final Icon MATCHED_BASICBLOCK;
    private static final Icon CHANGED_BASICBLOCK;
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK;
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK;
    private static final Icon MATCHED_BASICBLOCK_SELECTED;
    private static final Icon CHANGED_BASICBLOCK_SELECTED;
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_SELECTED;
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_SELECTED;
    private static final Icon MATCHED_BASICBLOCK_INVISIBLE;
    private static final Icon CHANGED_BASICBLOCK_INVISIBLE;
    private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE;
    private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE;
    private final CombinedDiffNode combinedDiffNode;
    private final RawCombinedBasicBlock combinedBasicblock;
    
    public CombinedFlowGraphBasicBlockTreeNode(final CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode, final CombinedDiffNode combinedDiffNode) {
        super(combinedFlowGraphRootTreeNode);
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
        this.combinedBasicblock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
        this.createChildren();
    }
    
    private boolean isChangedBasicblock() {
        final Diff diff = this.getDiff();
        final EMatchState matchState = this.getMatchState();
        if (matchState == EMatchState.PRIMARY_UNMATCHED || matchState == EMatchState.SECONDRAY_UNMATCHED) {
            return false;
        }
        final FunctionMatchData functionMatch = diff.getMatches().getFunctionMatch(this.combinedBasicblock.getPrimaryFunctionAddress(), ESide.PRIMARY);
        if (functionMatch != null) {
            final RawBasicBlock rawNode = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
            final RawBasicBlock rawNode2 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
            final IAddress address = this.combinedBasicblock.getAddress(ESide.PRIMARY);
            if (functionMatch.isBasicblockMatch(address, this.combinedBasicblock.getAddress(ESide.SECONDARY))) {
                final BasicBlockMatchData basicblockMatch = functionMatch.getBasicblockMatch(address, ESide.PRIMARY);
                if (basicblockMatch != null) {
                    final int sizeOfMatchedInstructions = basicblockMatch.getSizeOfMatchedInstructions();
                    return rawNode.getInstructions().size() > sizeOfMatchedInstructions || rawNode2.getInstructions().size() > sizeOfMatchedInstructions;
                }
            }
        }
        return false;
    }
    
    @Override
    public IAddress getAddress() {
        return null;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
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
    public ZyGraphNode getGraphNode(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.combinedDiffNode.getPrimaryDiffNode() : this.combinedDiffNode.getSecondaryDiffNode();
    }
    
    @Override
    public Icon getIcon() {
        switch (CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
            case 1: {
                if (!this.isChangedBasicblock()) {
                    if (this.isSelected()) {
                        return CombinedFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK_SELECTED;
                    }
                    if (!this.isVisible()) {
                        return CombinedFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK_INVISIBLE;
                    }
                    return CombinedFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK;
                }
                else {
                    if (this.isSelected()) {
                        return CombinedFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK_SELECTED;
                    }
                    if (!this.isVisible()) {
                        return CombinedFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK_INVISIBLE;
                    }
                    return CombinedFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK;
                }
                break;
            }
            case 2: {
                if (this.isSelected()) {
                    return CombinedFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (!this.isVisible()) {
                    return CombinedFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE;
                }
                return CombinedFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK;
            }
            case 3: {
                if (this.isSelected()) {
                    return CombinedFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (!this.isVisible()) {
                    return CombinedFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE;
                }
                return CombinedFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK;
            }
            default: {
                throw new IllegalStateException("Unknown match type.");
            }
        }
    }
    
    @Override
    public EMatchState getMatchState() {
        return this.combinedBasicblock.getMatchState();
    }
    
    @Override
    public EMatchType getMatchType() {
        if (this.getMatchState() != EMatchState.MATCHED) {
            return EMatchType.UNUMATCHED;
        }
        return this.isChangedBasicblock() ? EMatchType.INSTRUCTIONS_CHANGED : EMatchType.IDENTICAL;
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
    public void handleMouseEvent(final MouseEvent mouseEvent) {
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
        final RawBasicBlock rawNode = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
        final RawBasicBlock rawNode2 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
        return String.format("%s \u2194 %s", (rawNode == null) ? "missing" : rawNode.getAddress().toHexString(), (rawNode2 == null) ? "missing" : rawNode2.getAddress().toHexString());
    }
    
    static {
        MATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/matched-basicblock.png");
        CHANGED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/changed-basicblock.png");
        PRIMARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-basicblock.png");
        SECONDARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-basicblock.png");
        MATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/matched-selected-basicblock.png");
        CHANGED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/changed-selected-basicblock.png");
        PRIMARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-selected-basicblock.png");
        SECONDARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-selected-basicblock.png");
        MATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/matched-invisible-basicblock.png");
        CHANGED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/changed-invisible-basicblock.png");
        PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-invisible-basicblock.png");
        SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-invisible-basicblock.png");
    }
}
