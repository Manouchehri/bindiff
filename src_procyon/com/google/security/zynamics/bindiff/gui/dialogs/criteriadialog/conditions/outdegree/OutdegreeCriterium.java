package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class OutdegreeCriterium extends ConditionCriterium
{
    private static final ImageIcon OUTDEGREE_CONDITION_ICON;
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
        return OutdegreeCriterium.OUTDEGREE_CONDITION_ICON;
    }
    
    public String getOperator() {
        return this.panel.getOperator();
    }
    
    public int getOutdegree() {
        return this.panel.getOutdegree();
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        final String operator = this.panel.getOperator();
        final IViewNode rawNode = zyGraphNode.getRawNode();
        if (operator.equals("<")) {
            return rawNode.getOutgoingEdges().size() < this.getOutdegree();
        }
        if (operator.equals("=")) {
            return rawNode.getOutgoingEdges().size() == this.getOutdegree();
        }
        return operator.equals(">") && rawNode.getOutgoingEdges().size() > this.getOutdegree();
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        OUTDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/outdegree-condition.png");
    }
}
