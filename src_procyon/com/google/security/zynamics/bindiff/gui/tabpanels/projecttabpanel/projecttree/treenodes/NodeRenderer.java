package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import javax.swing.tree.*;
import java.awt.*;
import javax.swing.*;

public final class NodeRenderer extends DefaultTreeCellRenderer
{
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        final Icon icon = ((AbstractTreeNode)o).getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        return this;
    }
}
