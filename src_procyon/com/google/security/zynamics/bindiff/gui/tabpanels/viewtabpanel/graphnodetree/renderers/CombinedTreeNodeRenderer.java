package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers;

import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.*;
import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.zylib.gui.*;

public class CombinedTreeNodeRenderer extends DefaultTreeCellRenderer
{
    private static final Font NORMAL_FONT;
    private static final Font BOLD_FONT;
    
    public CombinedTreeNodeRenderer() {
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.GRAY);
    }
    
    private static EFunctionType getFunctionType(final RawCombinedFunction rawCombinedFunction) {
        return getFunctionType(rawCombinedFunction.getRawNode(ESide.PRIMARY), rawCombinedFunction.getRawNode(ESide.SECONDARY));
    }
    
    private static EFunctionType getFunctionType(final RawFunction rawFunction, final RawFunction rawFunction2) {
        if (rawFunction != null && rawFunction2 != null && rawFunction.getFunctionType() != rawFunction2.getFunctionType()) {
            return EFunctionType.MIXED;
        }
        RawFunction rawFunction3 = rawFunction;
        if (rawFunction3 == null) {
            rawFunction3 = rawFunction2;
        }
        return rawFunction3.getFunctionType();
    }
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        final AbstractTreeNode abstractTreeNode = (AbstractTreeNode)o;
        final Icon icon = abstractTreeNode.getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        this.setFont(abstractTreeNode.isSelected() ? CombinedTreeNodeRenderer.BOLD_FONT : CombinedTreeNodeRenderer.NORMAL_FONT);
        this.setForeground(abstractTreeNode.isVisible() ? Color.BLACK : Color.GRAY);
        Color borderSelectionColor = Color.WHITE;
        Enum functionType = null;
        if (abstractTreeNode instanceof CombinedCallGraphFunctionTreeNode) {
            functionType = getFunctionType(((CombinedCallGraphFunctionTreeNode)abstractTreeNode).getCombinedFunction());
        }
        else if (abstractTreeNode instanceof CombinedFlowGraphBaseTreeNode) {
            final FlowGraphViewData view = ((CombinedFlowGraphBaseTreeNode)abstractTreeNode).getRootNode().getView();
            EFunctionType functionType2 = null;
            EFunctionType functionType3 = null;
            if (view.getRawGraph(ESide.PRIMARY) != null) {
                functionType2 = view.getRawGraph(ESide.PRIMARY).getFunctionType();
            }
            if (view.getRawGraph(ESide.SECONDARY) != null) {
                functionType3 = view.getRawGraph(ESide.SECONDARY).getFunctionType();
            }
            functionType = ((functionType2 == functionType3) ? functionType2 : EFunctionType.MIXED);
        }
        if (functionType != null) {
            switch (CombinedTreeNodeRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[functionType.ordinal()]) {
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
                case 6: {
                    borderSelectionColor = Colors.TABLE_CELL_CHANGED_BACKGROUND;
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
        BOLD_FONT = new Font(CombinedTreeNodeRenderer.NORMAL_FONT.getName(), 1, CombinedTreeNodeRenderer.NORMAL_FONT.getSize());
    }
}
