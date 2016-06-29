/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.AbstractCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.NotCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NotCriterium
extends AbstractCriterium {
    private static final ImageIcon NOT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/not.png");
    private final NotCriteriumPanel panel = new NotCriteriumPanel();

    @Override
    public String getCriteriumDescription() {
        return "NOT";
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return NOT_ICON;
    }

    @Override
    public CriteriumType getType() {
        return CriteriumType.NOT;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        return true;
    }
}

