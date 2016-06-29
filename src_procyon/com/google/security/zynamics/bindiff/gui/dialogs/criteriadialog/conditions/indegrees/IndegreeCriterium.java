package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class IndegreeCriterium extends ConditionCriterium
{
    private static final ImageIcon INDEGREE_CONDITION_ICON;
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
        return IndegreeCriterium.INDEGREE_CONDITION_ICON;
    }
    
    public int getIndegree() {
        return this.panel.getIndegree();
    }
    
    public String getOperator() {
        return this.panel.getOperator();
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        final String operator = this.panel.getOperator();
        final IViewNode rawNode = zyGraphNode.getRawNode();
        if (operator.equals("<")) {
            return rawNode.getIncomingEdges().size() < this.getIndegree();
        }
        if (operator.equals("=")) {
            return rawNode.getIncomingEdges().size() == this.getIndegree();
        }
        return operator.equals(">") && rawNode.getIncomingEdges().size() > this.getIndegree();
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        INDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/indegree-condition.png");
    }
}
