/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OutdegreeCriterium
extends ConditionCriterium {
    private static final ImageIcon OUTDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/outdegree-condition.png");
    private final OutdegreeCriteriumPanel panel;

    public OutdegreeCriterium() {
        this.panel = new OutdegreeCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Outdegree %s %d", this.getOperator(), this.getOutdegree());
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return OUTDEGREE_CONDITION_ICON;
    }

    public String getOperator() {
        return this.panel.getOperator();
    }

    public int getOutdegree() {
        return this.panel.getOutdegree();
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        String string = this.panel.getOperator();
        IViewNode iViewNode = zyGraphNode.getRawNode();
        if (string.equals("<")) {
            if (iViewNode.getOutgoingEdges().size() >= this.getOutdegree()) return false;
            return true;
        }
        if (string.equals("=")) {
            if (iViewNode.getOutgoingEdges().size() != this.getOutdegree()) return false;
            return true;
        }
        if (!string.equals(">")) return false;
        if (iViewNode.getOutgoingEdges().size() <= this.getOutdegree()) return false;
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

