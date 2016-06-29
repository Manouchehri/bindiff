package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SingleCallGraphFunctionTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode
{
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_ICON;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON;
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
    private SingleDiffNode singleDiffNode;
    
    public SingleCallGraphFunctionTreeNode(final SingleCallGraphRootTreeNode singleCallGraphRootTreeNode, final SingleDiffNode singleDiffNode) {
        super(singleCallGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        this.createChildren();
    }
    
    public SingleCallGraphFunctionTreeNode(final SingleCallGraphRootTreeNode singleCallGraphRootTreeNode, final SingleDiffNode singleDiffNode, final boolean b) {
        super(singleCallGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        if (!b) {
            this.createChildren();
        }
    }
    
    @Override
    protected void delete() {
        super.delete();
        this.singleDiffNode = null;
    }
    
    @Override
    public void createChildren() {
    }
    
    @Override
    public IAddress getAddress() {
        return this.getFunction().getAddress();
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        if (this.getFunction().getSide() != eSide) {
            return null;
        }
        return this.getAddress();
    }
    
    public RawFunction getFunction() {
        return (RawFunction)this.singleDiffNode.getRawNode();
    }
    
    @Override
    public String getFunctionName() {
        return this.getFunction().getName();
    }
    
    @Override
    public EFunctionType getFunctionType() {
        return this.getFunction().getFunctionType();
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
        final RawFunction function = this.getFunction();
        switch (SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[function.getMatchState().ordinal()]) {
            case 1: {
                if (function.isIdenticalMatch()) {
                    if (this.isSelected()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
                    }
                    return SingleCallGraphFunctionTreeNode.MATCHED_IDENTICAL_FUNCTION_ICON;
                }
                else if (function.isChangedInstructionsOnlyMatch()) {
                    if (this.isSelected()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
                    }
                    return SingleCallGraphFunctionTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
                }
                else {
                    if (!function.isChangedStructuralMatch()) {
                        break;
                    }
                    if (this.isSelected()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
                    }
                    if (!this.isVisible()) {
                        return SingleCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
                    }
                    return SingleCallGraphFunctionTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
                }
                break;
            }
            case 2: {
                if (this.isSelected()) {
                    return SingleCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON;
                }
                if (!this.isVisible()) {
                    return SingleCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
                }
                return SingleCallGraphFunctionTreeNode.PRIMARY_UNMATCHED_FUNCTION_ICON;
            }
            case 3: {
                if (this.isSelected()) {
                    return SingleCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON;
                }
                if (!this.isVisible()) {
                    return SingleCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
                }
                return SingleCallGraphFunctionTreeNode.SECONDARY_UNMATCHED_FUNCTION_ICON;
            }
        }
        throw new IllegalStateException("Unknown match type.");
    }
    
    @Override
    public EMatchState getMatchState() {
        return this.getFunction().getMatchState();
    }
    
    @Override
    public EMatchType getMatchType() {
        final RawFunction rawFunction = (RawFunction)this.singleDiffNode.getRawNode();
        if (rawFunction == null) {
            return EMatchType.UNUMATCHED;
        }
        if (rawFunction.isIdenticalMatch()) {
            return EMatchType.IDENTICAL;
        }
        if (rawFunction.isChangedInstructionsOnlyMatch()) {
            return EMatchType.INSTRUCTIONS_CHANGED;
        }
        return EMatchType.STRUCTURAL_CHANGED;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return new CallGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.singleDiffNode);
    }
    
    @Override
    public SingleCallGraphRootTreeNode getRootNode() {
        return (SingleCallGraphRootTreeNode)this.getAbstractRootNode();
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
            MouseTreeNodeSelectionHandlerSingleFunction.handleMouseSelectionEvent(mouseEvent, this);
        }
        super.handleMouseEvent(mouseEvent);
    }
    
    @Override
    public boolean isSelected() {
        return this.getFunction().isSelected();
    }
    
    @Override
    public boolean isVisible() {
        return this.getFunction().isVisible();
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", this.getFunction().getAddress().toHexString(), this.getFunction().getName());
    }
    
    static {
        PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
        PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
        PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
        SECONDARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
        SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
        SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
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
