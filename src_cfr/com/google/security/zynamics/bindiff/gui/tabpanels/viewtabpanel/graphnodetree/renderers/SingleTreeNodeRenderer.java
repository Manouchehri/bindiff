/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.SingleTreeNodeRenderer$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class SingleTreeNodeRenderer
extends DefaultTreeCellRenderer {
    private static final Font NORMAL_FONT = GuiHelper.DEFAULT_FONT;
    private static final Font BOLD_FONT = new Font(NORMAL_FONT.getName(), 1, NORMAL_FONT.getSize());

    public SingleTreeNodeRenderer() {
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.GRAY);
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
        if (abstractTreeNode instanceof SingleCallGraphFunctionTreeNode) {
            SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode = (SingleCallGraphFunctionTreeNode)abstractTreeNode;
            eFunctionType = singleCallGraphFunctionTreeNode.getFunction().getFunctionType();
        } else if (abstractTreeNode instanceof SingleFlowGraphBaseTreeNode) {
            FlowGraphViewData flowGraphViewData = (FlowGraphViewData)abstractTreeNode.getRootNode().getView();
            ESide eSide = abstractTreeNode.getRootNode().getSide();
            RawFlowGraph rawFlowGraph = flowGraphViewData.getRawGraph(eSide);
            eFunctionType = rawFlowGraph.getFunctionType();
        }
        if (eFunctionType != null) {
            switch (SingleTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[eFunctionType.ordinal()]) {
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
            }
        }
        this.setBackgroundSelectionColor(color);
        this.setBackgroundNonSelectionColor(color);
        this.setBorderSelectionColor(color);
        this.setToolTipText(abstractTreeNode.getTooltipText());
        return this;
    }
}

