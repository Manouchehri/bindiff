/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IndegreeCriterium
extends ConditionCriterium {
    private static final ImageIcon INDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/indegree-condition.png");
    private final IndegreeCriteriumPanel panel;

    public IndegreeCriterium() {
        this.panel = new IndegreeCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Indegree %s %d", this.getOperator(), this.getIndegree());
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return INDEGREE_CONDITION_ICON;
    }

    public int getIndegree() {
        return this.panel.getIndegree();
    }

    public String getOperator() {
        return this.panel.getOperator();
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        String string = this.panel.getOperator();
        IViewNode iViewNode = zyGraphNode.getRawNode();
        if (string.equals("<")) {
            if (iViewNode.getIncomingEdges().size() >= this.getIndegree()) return false;
            return true;
        }
        if (string.equals("=")) {
            if (iViewNode.getIncomingEdges().size() != this.getIndegree()) return false;
            return true;
        }
        if (!string.equals(">")) return false;
        if (iViewNode.getIncomingEdges().size() <= this.getIndegree()) return false;
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

