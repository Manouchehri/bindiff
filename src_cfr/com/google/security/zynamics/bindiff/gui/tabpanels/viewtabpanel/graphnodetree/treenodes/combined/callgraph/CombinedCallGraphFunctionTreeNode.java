/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerCombinedFunction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class CombinedCallGraphFunctionTreeNode
extends AbstractTreeNode
implements ISearchableTreeNode,
ISortableTreeNode {
    private static final Icon PRIMARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
    private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-selected.png");
    private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-invisible.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-selected.png");
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-invisible.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-selected.png");
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-invisible.png");
    private CombinedDiffNode combinedDiffNode;

    public CombinedCallGraphFunctionTreeNode(CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode, CombinedDiffNode combinedDiffNode) {
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
    public IAddress getAddress(ESide eSide) {
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
        RawFunction rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        if (rawFunction == null) {
            rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        }
        switch (CombinedCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.combinedDiffNode.getRawNode().getMatchState().ordinal()]) {
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
                if (this.combinedDiffNode == null) return PRIMARY_UNMATCHED_FUNCTION;
                if (this.combinedDiffNode.isSelected()) {
                    return PRIMARY_UNMATCHED_FUNCTION_SELECTED;
                }
                if (this.combinedDiffNode.isVisible()) return PRIMARY_UNMATCHED_FUNCTION;
                return PRIMARY_UNMATCHED_FUNCTION_INVISIBLE;
            }
            case 3: {
                if (this.combinedDiffNode == null) return SECONDARY_UNMATCHED_FUNCTION;
                if (this.combinedDiffNode.isSelected()) {
                    return SECONDARY_UNMATCHED_FUNCTION_SELECTED;
                }
                if (this.combinedDiffNode.isVisible()) return SECONDARY_UNMATCHED_FUNCTION;
                return SECONDARY_UNMATCHED_FUNCTION_INVISIBLE;
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
        RawFunction rawFunction = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
        if (rawFunction == null) {
            return EMatchType.UNUMATCHED;
        }
        if (rawFunction.isIdenticalMatch()) {
            return EMatchType.IDENTICAL;
        }
        if (!rawFunction.isIdenticalMatch()) return EMatchType.STRUCTURAL_CHANGED;
        return EMatchType.INSTRUCTIONS_CHANGED;
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
    public void handleMouseEvent(MouseEvent mouseEvent) {
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
        String string = "";
        EMatchState eMatchState = this.combinedDiffNode.getRawNode().getMatchState();
        if (eMatchState == EMatchState.MATCHED) {
            return String.format("%s \u2194 %s", this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString());
        }
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
            return String.format("%s \u2194 %s", this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), "missing");
        }
        if (eMatchState != EMatchState.SECONDRAY_UNMATCHED) return string;
        return String.format("%s \u2194 %s", "missing", this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString());
    }
}

