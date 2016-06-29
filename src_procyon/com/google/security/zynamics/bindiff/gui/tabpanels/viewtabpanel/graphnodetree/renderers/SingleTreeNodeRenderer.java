package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import javax.swing.tree.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;

public class SingleTreeNodeRenderer extends DefaultTreeCellRenderer
{
    private static final Font NORMAL_FONT;
    private static final Font BOLD_FONT;
    
    public SingleTreeNodeRenderer() {
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.GRAY);
    }
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        final AbstractTreeNode abstractTreeNode = (AbstractTreeNode)o;
        final Icon icon = abstractTreeNode.getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        this.setFont(abstractTreeNode.isSelected() ? SingleTreeNodeRenderer.BOLD_FONT : SingleTreeNodeRenderer.NORMAL_FONT);
        this.setForeground(abstractTreeNode.isVisible() ? Color.BLACK : Color.GRAY);
        Color borderSelectionColor = Color.WHITE;
        Enum enum1 = null;
        if (abstractTreeNode instanceof SingleCallGraphFunctionTreeNode) {
            enum1 = ((SingleCallGraphFunctionTreeNode)abstractTreeNode).getFunction().getFunctionType();
        }
        else if (abstractTreeNode instanceof SingleFlowGraphBaseTreeNode) {
            enum1 = ((FlowGraphViewData)abstractTreeNode.getRootNode().getView()).getRawGraph(abstractTreeNode.getRootNode().getSide()).getFunctionType();
        }
        if (enum1 != null) {
            switch (SingleTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[enum1.ordinal()]) {
                case 1: {
                    borderSelectionColor = Colors.FUNCTION_TYPE_NORMAL;
                    break;
                }
                case 2: {
                    borderSelectionColor = Colors.FUNCTION_TYPE_IMPORTED;
                    break;
                }
                case 3: {
                    borderSelectionColor = Colors.FUNCTION_TYPE_LIBRARY;
                    break;
                }
                case 4: {
                    borderSelectionColor = Colors.FUNCTION_TYPE_THUNK;
                    break;
                }
                case 5: {
                    borderSelectionColor = Colors.FUNCTION_TYPE_UNKNOWN;
                    break;
                }
            }
        }
        this.setBackgroundSelectionColor(borderSelectionColor);
        this.setBackgroundNonSelectionColor(borderSelectionColor);
        this.setBorderSelectionColor(borderSelectionColor);
        this.setToolTipText(abstractTreeNode.getTooltipText());
        return this;
    }
    
    static {
        NORMAL_FONT = GuiHelper.DEFAULT_FONT;
        BOLD_FONT = new Font(SingleTreeNodeRenderer.NORMAL_FONT.getName(), 1, SingleTreeNodeRenderer.NORMAL_FONT.getSize());
    }
}
