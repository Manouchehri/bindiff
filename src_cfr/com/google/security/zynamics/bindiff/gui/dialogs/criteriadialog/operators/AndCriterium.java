/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.AbstractCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AndCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AndCriterium
extends AbstractCriterium {
    private static final ImageIcon ADD_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/add.png");
    private final AndCriteriumPanel panel = new AndCriteriumPanel();

    @Override
    public String getCriteriumDescription() {
        return "AND";
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return ADD_ICON;
    }

    @Override
    public CriteriumType getType() {
        return CriteriumType.AND;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        return true;
    }
}

