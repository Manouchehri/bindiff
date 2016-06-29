package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class RecursionCriterium extends ConditionCriterium
{
    private static final ImageIcon RECURSION_CONDITION_ICON;
    private final RecursionCriteriumPanel panel;
    
    public RecursionCriterium() {
        this.panel = new RecursionCriteriumPanel(this);
    }
    
    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with %s Recursion", (this.panel.getRecursionState() == RecursionState.IS_RECURSION) ? "" : "no");
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return RecursionCriterium.RECURSION_CONDITION_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        if (this.panel.getRecursionState() == RecursionState.IS_RECURSION) {
            return zyGraphNode.getChildren().contains(zyGraphNode);
        }
        return zyGraphNode.getChildren().contains(zyGraphNode);
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        RECURSION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/recursion-condition.png");
    }
}
