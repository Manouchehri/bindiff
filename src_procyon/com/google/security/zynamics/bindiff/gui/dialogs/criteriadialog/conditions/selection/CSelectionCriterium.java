package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CSelectionCriterium extends ConditionCriterium
{
    private static final ImageIcon SELECTION_CONDITION_ICON;
    private final CSelectionCriteriumPanel panel;
    
    public CSelectionCriterium() {
        this.panel = new CSelectionCriteriumPanel(this);
    }
    
    @Override
    public String getCriteriumDescription() {
        return String.format("%s Nodes", (this.panel.getSelectionState() == SelectionState.SELECTED) ? "Selected" : "Unselected");
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return CSelectionCriterium.SELECTION_CONDITION_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return ((CViewNode)zyGraphNode.getRawNode()).isSelected() == (this.panel.getSelectionState() == SelectionState.SELECTED);
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        SELECTION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/selection-condition.png");
    }
}
