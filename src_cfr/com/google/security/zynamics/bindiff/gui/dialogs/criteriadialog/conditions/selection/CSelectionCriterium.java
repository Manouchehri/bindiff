/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.SelectionState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CSelectionCriterium
extends ConditionCriterium {
    private static final ImageIcon SELECTION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/selection-condition.png");
    private final CSelectionCriteriumPanel panel;

    public CSelectionCriterium() {
        this.panel = new CSelectionCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        Object[] arrobject = new Object[1];
        arrobject[0] = this.panel.getSelectionState() == SelectionState.SELECTED ? "Selected" : "Unselected";
        return String.format("%s Nodes", arrobject);
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return SELECTION_CONDITION_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        if (((CViewNode)zyGraphNode.getRawNode()).isSelected() != (this.panel.getSelectionState() == SelectionState.SELECTED)) return false;
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

