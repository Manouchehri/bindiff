/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

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
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerSingleFunction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleCallGraphFunctionTreeNode
extends AbstractTreeNode
implements ISearchableTreeNode,
ISortableTreeNode {
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-selected.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-invisible.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-selected.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-invisible.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-selected.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-invisible.png");
    private SingleDiffNode singleDiffNode;

    public SingleCallGraphFunctionTreeNode(SingleCallGraphRootTreeNode singleCallGraphRootTreeNode, SingleDiffNode singleDiffNode) {
        super(singleCallGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        this.createChildren();
    }

    public SingleCallGraphFunctionTreeNode(SingleCallGraphRootTreeNode singleCallGraphRootTreeNode, SingleDiffNode singleDiffNode, boolean bl2) {
        super(singleCallGraphRootTreeNode);
        this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
        if (bl2) return;
        this.createChildren();
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
    public IAddress getAddress(ESide eSide) {
        if (this.getFunction().getSide() == eSide) return this.getAddress();
        return null;
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
    public ZyGraphNode getGraphNode(ESide eSide) {
        if (this.singleDiffNode.getSide() == eSide) return this.singleDiffNode;
        return null;
    }

    @Override
    public Icon getIcon() {
        RawFunction rawFunction = this.getFunction();
        switch (SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[rawFunction.getMatchState().ordinal()]) {
            case 1: {
                if (rawFunction.isIdenticalMatch()) {
                    if (this.isSelected()) {
                        return MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
                    }
                    if (this.isVisible()) return MATCHED_IDENTICAL_FUNCTION_ICON;
                    return MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
                }
                if (rawFunction.isChangedInstructionsOnlyMatch()) {
                    if (this.isSelected()) {
                        return MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
                    }
                    if (this.isVisible()) return MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
                    return MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
                }
                if (!rawFunction.isChangedStructuralMatch()) throw new IllegalStateException("Unknown match type.");
                if (this.isSelected()) {
                    return MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
                }
                if (this.isVisible()) return MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
                return MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
            }
            case 2: {
                if (this.isSelected()) {
                    return PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON;
                }
                if (this.isVisible()) return PRIMARY_UNMATCHED_FUNCTION_ICON;
                return PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
            }
            case 3: {
                if (this.isSelected()) {
                    return SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON;
                }
                if (this.isVisible()) return SECONDARY_UNMATCHED_FUNCTION_ICON;
                return SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
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
        RawFunction rawFunction = (RawFunction)this.singleDiffNode.getRawNode();
        if (rawFunction == null) {
            return EMatchType.UNUMATCHED;
        }
        if (rawFunction.isIdenticalMatch()) {
            return EMatchType.IDENTICAL;
        }
        if (!rawFunction.isChangedInstructionsOnlyMatch()) return EMatchType.STRUCTURAL_CHANGED;
        return EMatchType.INSTRUCTIONS_CHANGED;
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
    public void handleMouseEvent(MouseEvent mouseEvent) {
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
}

