/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root.RootCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RootCriterium
extends ConditionCriterium {
    private static final ImageIcon ROOT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/root.png");
    private final RootCriteriumPanel panel = new RootCriteriumPanel();

    @Override
    public String getCriteriumDescription() {
        return "Root Node";
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return ROOT_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

