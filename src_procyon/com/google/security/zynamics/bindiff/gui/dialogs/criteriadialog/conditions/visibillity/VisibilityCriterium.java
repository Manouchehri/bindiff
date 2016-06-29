package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class VisibilityCriterium extends ConditionCriterium
{
    private static final ImageIcon VISIBILITY_CONDITION_ICON;
    private final VisibilityCriteriumPanel panel;
    
    public VisibilityCriterium() {
        this.panel = new VisibilityCriteriumPanel(this);
    }
    
    @Override
    public String getCriteriumDescription() {
        return String.format("%s Nodes", (this.panel.getVisibilityState() == VisibilityState.VISIBLE) ? "Visible" : "Invisible");
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return VisibilityCriterium.VISIBILITY_CONDITION_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return zyGraphNode.isVisible() == (this.panel.getVisibilityState() == VisibilityState.VISIBLE);
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        VISIBILITY_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/visibility-condition.png");
    }
}
