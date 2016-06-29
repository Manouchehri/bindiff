/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VisibilityCriterium
extends ConditionCriterium {
    private static final ImageIcon VISIBILITY_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/visibility-condition.png");
    private final VisibilityCriteriumPanel panel;

    public VisibilityCriterium() {
        this.panel = new VisibilityCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        Object[] arrobject = new Object[1];
        arrobject[0] = this.panel.getVisibilityState() == VisibilityState.VISIBLE ? "Visible" : "Invisible";
        return String.format("%s Nodes", arrobject);
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return VISIBILITY_CONDITION_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isVisible() != (this.panel.getVisibilityState() == VisibilityState.VISIBLE)) return false;
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

