package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SingleFlowGraphBasicBlockTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode
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
    private final SingleDiffNode singleDiffNode;
    private final RawBasicBlock rawBasicblock;
    
    public SingleFlowGraphBasicBlockTreeNode(final SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode, final SingleDiffNode singleDiffNode) {
        super(singleFlowGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        this.rawBasicblock = (RawBasicBlock)this.singleDiffNode.getRawNode();
        this.createChildren();
    }
    
    private boolean isChangedBasicblock() {
        final Diff diff = this.getDiff();
        final EMatchState matchState = this.getMatchState();
        if (matchState == EMatchState.PRIMARY_UNMATCHED || matchState == EMatchState.SECONDRAY_UNMATCHED) {
            return false;
        }
        final MatchData matches = diff.getMatches();
        if (this.rawBasicblock.getSide() == ESide.PRIMARY) {
            final IAddress functionAddr = this.rawBasicblock.getFunctionAddr();
            if (matches.getSecondaryFunctionAddr(functionAddr) != null) {
                final FunctionMatchData functionMatch = matches.getFunctionMatch(functionAddr, ESide.PRIMARY);
                if (functionMatch != null) {
                    final IAddress address = this.rawBasicblock.getAddress();
                    final IAddress secondaryBasicblockAddr = functionMatch.getSecondaryBasicblockAddr(address);
                    if (functionMatch.isBasicblockMatch(address, secondaryBasicblockAddr)) {
                        final RawBasicBlock basicblock = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.SECONDARY).getBasicblock(secondaryBasicblockAddr);
                        final BasicBlockMatchData basicblockMatch = functionMatch.getBasicblockMatch(address, ESide.PRIMARY);
                        if (basicblockMatch != null) {
                            final int sizeOfMatchedInstructions = basicblockMatch.getSizeOfMatchedInstructions();
                            return this.rawBasicblock.getInstructions().size() > sizeOfMatchedInstructions || basicblock.getInstructions().size() > sizeOfMatchedInstructions;
                        }
                    }
                }
            }
        }
        else {
            final IAddress primaryFunctionAddr = matches.getPrimaryFunctionAddr(this.rawBasicblock.getFunctionAddr());
            if (primaryFunctionAddr != null) {
                final FunctionMatchData functionMatch2 = matches.getFunctionMatch(primaryFunctionAddr, ESide.PRIMARY);
                if (functionMatch2 != null) {
                    final IAddress address2 = this.rawBasicblock.getAddress();
                    final IAddress primaryBasicblockAddr = functionMatch2.getPrimaryBasicblockAddr(address2);
                    if (functionMatch2.isBasicblockMatch(primaryBasicblockAddr, address2)) {
                        final RawBasicBlock basicblock2 = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.PRIMARY).getBasicblock(primaryBasicblockAddr);
                        final BasicBlockMatchData basicblockMatch2 = functionMatch2.getBasicblockMatch(primaryBasicblockAddr, ESide.PRIMARY);
                        if (basicblockMatch2 != null) {
                            final int sizeOfMatchedInstructions2 = basicblockMatch2.getSizeOfMatchedInstructions();
                            return this.rawBasicblock.getInstructions().size() > sizeOfMatchedInstructions2 || basicblock2.getInstructions().size() > sizeOfMatchedInstructions2;
                        }
                    }
                }
            }
        }
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
    public IAddress getAddress(final ESide eSide) {
        return (this.rawBasicblock.getSide() == eSide) ? this.rawBasicblock.getAddress() : null;
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
    public ZyGraphNode getGraphNode(final ESide eSide) {
        if (this.singleDiffNode.getSide() != eSide) {
            return null;
        }
        return this.singleDiffNode;
    }
    
    @Override
    public Icon getIcon() {
        switch (SingleFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
            case 1: {
                if (!this.isChangedBasicblock()) {
                    if (this.isSelected()) {
                        return SingleFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK_SELECTED;
                    }
                    if (!this.isVisible()) {
                        return SingleFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK_INVISIBLE;
                    }
                    return SingleFlowGraphBasicBlockTreeNode.MATCHED_BASICBLOCK;
                }
                else {
                    if (this.isSelected()) {
                        return SingleFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK_SELECTED;
                    }
                    if (!this.isVisible()) {
                        return SingleFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK_INVISIBLE;
                    }
                    return SingleFlowGraphBasicBlockTreeNode.CHANGED_BASICBLOCK;
                }
                break;
            }
            case 2: {
                if (this.isSelected()) {
                    return SingleFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (!this.isVisible()) {
                    return SingleFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE;
                }
                return SingleFlowGraphBasicBlockTreeNode.PRIMARY_UNMATCHED_BASICBLOCK;
            }
            case 3: {
                if (this.isSelected()) {
                    return SingleFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK_SELECTED;
                }
                if (!this.isVisible()) {
                    return SingleFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE;
                }
                return SingleFlowGraphBasicBlockTreeNode.SECONDARY_UNMATCHED_BASICBLOCK;
            }
            default: {
                throw new IllegalStateException("Unknown match type.");
            }
        }
    }
    
    @Override
    public EMatchState getMatchState() {
        return this.rawBasicblock.getMatchState();
    }
    
    @Override
    public EMatchType getMatchType() {
        if (this.getMatchState() != EMatchState.MATCHED) {
            return EMatchType.UNUMATCHED;
        }
        if (this.isChangedBasicblock()) {
            return EMatchType.INSTRUCTIONS_CHANGED;
        }
        return EMatchType.IDENTICAL;
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
    public void handleMouseEvent(final MouseEvent mouseEvent) {
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
