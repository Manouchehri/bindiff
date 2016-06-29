package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CombinedCallGraphFunctionTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode
{
    private static final Icon PRIMARY_UNMATCHED_FUNCTION;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
    private CombinedDiffNode combinedDiffNode;
    
    public CombinedCallGraphFunctionTreeNode(final CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode, final CombinedDiffNode combinedDiffNode) {
        super(combinedCallGraphRootTreeNode);
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
        this.createChildren();
    }
    
    @Override
    protected void delete() {
        super.delete();
        this.combinedDiffNode = null;
    }
    
    @Override
    public void createChildren() {
    }
    
    @Override
    public IAddress getAddress() {
        return null;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        return this.getCombinedFunction().getAddress(eSide);
    }
    
    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }
    
    public RawCombinedFunction getCombinedFunction() {
        return (RawCombinedFunction)this.combinedDiffNode.getRawNode();
    }
    
    @Override
    public String getFunctionName() {
        return null;
    }
    
    @Override
    public EFunctionType getFunctionType() {
        return this.getCombinedFunction().getFunctionType();
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
        RawFunction rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        if (rawFunction == null) {
            rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        }
        switch (CombinedCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.combinedDiffNode.getRawNode().getMatchState().ordinal()]) {
            case 1: {
                if (rawFunction.isIdenticalMatch()) {
                    if (this.isSelected()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
                    }
                    return CombinedCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_ICON;
                }
                else if (rawFunction.isChangedInstructionsOnlyMatch()) {
                    if (this.isSelected()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
                    }
                    return CombinedCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
                }
                else {
                    if (!rawFunction.isChangedStructuralMatch()) {
                        break;
                    }
                    if (this.isSelected()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return CombinedCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
                    }
                    return CombinedCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
                }
                break;
            }
            case 2: {
                if (this.combinedDiffNode != null) {
                    if (this.combinedDiffNode.isSelected()) {
                        return CombinedCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION_SELECTED;
                    }
                    if (!this.combinedDiffNode.isVisible()) {
                        return CombinedCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION_INVISIBLE;
                    }
                }
                return CombinedCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION;
            }
            case 3: {
                if (this.combinedDiffNode != null) {
                    if (this.combinedDiffNode.isSelected()) {
                        return CombinedCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION_SELECTED;
                    }
                    if (!this.combinedDiffNode.isVisible()) {
                        return CombinedCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION_INVISIBLE;
                    }
                }
                return CombinedCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION;
            }
        }
        throw new IllegalStateException("Unknown match type.");
    }
    
    @Override
    public EMatchState getMatchState() {
        return this.getCombinedFunction().getMatchState();
    }
    
    @Override
    public EMatchType getMatchType() {
        final RawFunction rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        if (rawFunction == null) {
            return EMatchType.UNUMATCHED;
        }
        if (rawFunction.isIdenticalMatch()) {
            return EMatchType.IDENTICAL;
        }
        if (rawFunction.isIdenticalMatch()) {
            return EMatchType.INSTRUCTIONS_CHANGED;
        }
        return EMatchType.STRUCTURAL_CHANGED;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return new CallGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.combinedDiffNode);
    }
    
    @Override
    public CombinedCallGraphRootTreeNode getRootNode() {
        return (CombinedCallGraphRootTreeNode)this.getAbstractRootNode();
    }
    
    @Override
    public void handleMouseEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1) {
            MouseTreeNodeSelectionHandlerCombinedFunction.handleMouseSelectionEvent(mouseEvent, this);
            return;
        }
        super.handleMouseEvent(mouseEvent);
    }
    
    @Override
    public boolean isSelected() {
        return this.combinedDiffNode.isSelected();
    }
    
    @Override
    public boolean isVisible() {
        return this.combinedDiffNode.isVisible();
    }
    
    @Override
    public String toString() {
        String s = "";
        final EMatchState matchState = this.combinedDiffNode.getRawNode().getMatchState();
        if (matchState == EMatchState.MATCHED) {
            s = String.format("%s \u2194 %s", this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString());
        }
        else if (matchState == EMatchState.PRIMARY_UNMATCHED) {
            s = String.format("%s \u2194 %s", this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), "missing");
        }
        else if (matchState == EMatchState.SECONDRAY_UNMATCHED) {
            s = String.format("%s \u2194 %s", "missing", this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString());
        }
        return s;
    }
    
    static {
        PRIMARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
        PRIMARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
        PRIMARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
        SECONDARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
        SECONDARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
        SECONDARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
        MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
        MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-selected.png");
        MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-invisible.png");
        MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
        MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-selected.png");
        MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-invisible.png");
        MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
        MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-selected.png");
        MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-invisible.png");
    }
}
