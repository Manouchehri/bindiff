/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.CombinedTreeNodeRenderer$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CombinedTreeNodeRenderer
extends DefaultTreeCellRenderer {
    private static final Font NORMAL_FONT = GuiHelper.DEFAULT_FONT;
    private static final Font BOLD_FONT = new Font(NORMAL_FONT.getName(), 1, NORMAL_FONT.getSize());

    public CombinedTreeNodeRenderer() {
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.GRAY);
    }

    private static EFunctionType getFunctionType(RawCombinedFunction rawCombinedFunction) {
        RawFunction rawFunction = rawCombinedFunction.getRawNode(ESide.PRIMARY);
        RawFunction rawFunction2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
        return CombinedTreeNodeRenderer.getFunctionType(rawFunction, rawFunction2);
    }

    private static EFunctionType getFunctionType(RawFunction rawFunction, RawFunction rawFunction2) {
        if (rawFunction != null && rawFunction2 != null && rawFunction.getFunctionType() != rawFunction2.getFunctionType()) {
            return EFunctionType.MIXED;
        }
        RawFunction rawFunction3 = rawFunction;
        if (rawFunction3 != null) return rawFunction3.getFunctionType();
        rawFunction3 = rawFunction2;
        return rawFunction3.getFunctionType();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl2, boolean bl3, boolean bl4, int n2, boolean bl5) {
        super.getTreeCellRendererComponent(jTree, object, bl2, bl3, bl4, n2, bl5);
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)object;
        Icon icon = abstractTreeNode.getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        this.setFont(abstractTreeNode.isSelected() ? BOLD_FONT : NORMAL_FONT);
        this.setForeground(abstractTreeNode.isVisible() ? Color.BLACK : Color.GRAY);
        Color color = Color.WHITE;
        EFunctionType eFunctionType = null;
        if (abstractTreeNode instanceof CombinedCallGraphFunctionTreeNode) {
            CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode = (CombinedCallGraphFunctionTreeNode)abstractTreeNode;
            eFunctionType = CombinedTreeNodeRenderer.getFunctionType(combinedCallGraphFunctionTreeNode.getCombinedFunction());
        } else if (abstractTreeNode instanceof CombinedFlowGraphBaseTreeNode) {
            CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)abstractTreeNode;
            CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = combinedFlowGraphBaseTreeNode.getRootNode();
            FlowGraphViewData flowGraphViewData = combinedFlowGraphRootTreeNode.getView();
            EFunctionType eFunctionType2 = null;
            EFunctionType eFunctionType3 = null;
            if (flowGraphViewData.getRawGraph(ESide.PRIMARY) != null) {
                eFunctionType2 = flowGraphViewData.getRawGraph(ESide.PRIMARY).getFunctionType();
            }
            if (flowGraphViewData.getRawGraph(ESide.SECONDARY) != null) {
                eFunctionType3 = flowGraphViewData.getRawGraph(ESide.SECONDARY).getFunctionType();
            }
            EFunctionType eFunctionType4 = eFunctionType = eFunctionType2 == eFunctionType3 ? eFunctionType2 : EFunctionType.MIXED;
        }
        if (eFunctionType != null) {
            switch (CombinedTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[eFunctionType.ordinal()]) {
                case 1: {
                    color = Colors.FUNCTION_TYPE_NORMAL;
                    break;
                }
                case 2: {
                    color = Colors.FUNCTION_TYPE_IMPORTED;
                    break;
                }
                case 3: {
                    color = Colors.FUNCTION_TYPE_LIBRARY;
                    break;
                }
                case 4: {
                    color = Colors.FUNCTION_TYPE_THUNK;
                    break;
                }
                case 5: {
                    color = Colors.FUNCTION_TYPE_UNKNOWN;
                    break;
                }
                case 6: {
                    color = Colors.TABLE_CELL_CHANGED_BACKGROUND;
                }
            }
        }
        this.setBackgroundSelectionColor(color);
        this.setBackgroundNonSelectionColor(color);
        this.setBorderSelectionColor(color);
        this.setToolTipText(abstractTreeNode.getTooltipText());
        return this;
    }
}

