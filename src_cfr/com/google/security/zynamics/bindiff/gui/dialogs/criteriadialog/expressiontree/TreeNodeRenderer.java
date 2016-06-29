/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.IconNodeRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;

public class TreeNodeRenderer
extends IconNodeRenderer {
    private static final Color VALID_NODE_FONT_COLOR = new Color(0, 0, 0);
    private static final Color INVALID_NODE_FONT_COLOR = new Color(160, 0, 0);

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl2, boolean bl3, boolean bl4, int n2, boolean bl5) {
        super.getTreeCellRendererComponent(jTree, object, bl2, bl3, bl4, n2, bl5);
        if (!(object instanceof AbstractCriteriumTreeNode)) return this;
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)object;
        int n3 = abstractCriteriumTreeNode.getChildCount();
        CriteriumType criteriumType = abstractCriteriumTreeNode.getCriterium().getType();
        if (criteriumType == CriteriumType.CONDITION) return this;
        if (n3 == 1 && (criteriumType == CriteriumType.NOT || abstractCriteriumTreeNode.getLevel() == 0) || n3 > 1 && criteriumType != CriteriumType.NOT) {
            this.setForeground(VALID_NODE_FONT_COLOR);
            return this;
        }
        this.setForeground(INVALID_NODE_FONT_COLOR);
        return this;
    }
}

