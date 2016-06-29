package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.zylib.gui.jtree.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class TreeNodeRenderer extends IconNodeRenderer
{
    private static final Color VALID_NODE_FONT_COLOR;
    private static final Color INVALID_NODE_FONT_COLOR;
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        if (o instanceof AbstractCriteriumTreeNode) {
            final AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)o;
            final int childCount = abstractCriteriumTreeNode.getChildCount();
            final CriteriumType type = abstractCriteriumTreeNode.getCriterium().getType();
            if (type != CriteriumType.CONDITION) {
                if ((childCount == 1 && (type == CriteriumType.NOT || abstractCriteriumTreeNode.getLevel() == 0)) || (childCount > 1 && type != CriteriumType.NOT)) {
                    this.setForeground(TreeNodeRenderer.VALID_NODE_FONT_COLOR);
                }
                else {
                    this.setForeground(TreeNodeRenderer.INVALID_NODE_FONT_COLOR);
                }
            }
        }
        return this;
    }
    
    static {
        VALID_NODE_FONT_COLOR = new Color(0, 0, 0);
        INVALID_NODE_FONT_COLOR = new Color(160, 0, 0);
    }
}
