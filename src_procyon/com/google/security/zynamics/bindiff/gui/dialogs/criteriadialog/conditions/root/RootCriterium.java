package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class RootCriterium extends ConditionCriterium
{
    private static final ImageIcon ROOT_ICON;
    private final RootCriteriumPanel panel;
    
    public RootCriterium() {
        this.panel = new RootCriteriumPanel();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Root Node";
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return RootCriterium.ROOT_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return true;
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        ROOT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/root.png");
    }
}
