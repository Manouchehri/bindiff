/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public final class NodeRenderer
extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl2, boolean bl3, boolean bl4, int n2, boolean bl5) {
        super.getTreeCellRendererComponent(jTree, object, bl2, bl3, bl4, n2, bl5);
        Icon icon = ((AbstractTreeNode)object).getIcon();
        if (icon == null) return this;
        this.setIcon(icon);
        return this;
    }
}

