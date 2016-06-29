/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus.NodeMenuBuilder;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class CriteriumTreeNode
extends AbstractCriteriumTreeNode {
    private static final ImageIcon DEFAULT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/default-condition.png");
    private final NodeMenuBuilder menuBuilder;

    public CriteriumTreeNode(ICriterium iCriterium, List list, ExpressionTreeActionProvider expressionTreeActionProvider) {
        super(iCriterium);
        this.menuBuilder = new NodeMenuBuilder(this, list, expressionTreeActionProvider);
    }

    @Override
    public Icon getIcon() {
        Icon icon = this.getCriterium().getIcon();
        if (icon != null) return icon;
        return DEFAULT_ICON;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return this.menuBuilder.getPopup();
    }

    @Override
    public String toString() {
        return this.getCriterium().getCriteriumDescription();
    }
}

