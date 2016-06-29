/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RecursionCriterium
extends ConditionCriterium {
    private static final ImageIcon RECURSION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/recursion-condition.png");
    private final RecursionCriteriumPanel panel;

    public RecursionCriterium() {
        this.panel = new RecursionCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        Object[] arrobject = new Object[1];
        arrobject[0] = this.panel.getRecursionState() == RecursionState.IS_RECURSION ? "" : "no";
        return String.format("Nodes with %s Recursion", arrobject);
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return RECURSION_CONDITION_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        if (this.panel.getRecursionState() != RecursionState.IS_RECURSION) return zyGraphNode.getChildren().contains(zyGraphNode);
        return zyGraphNode.getChildren().contains(zyGraphNode);
    }

    public void update() {
        this.notifyListeners();
    }
}

