package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class AndCriterium extends AbstractCriterium
{
    private static final ImageIcon ADD_ICON;
    private final AndCriteriumPanel panel;
    
    public AndCriterium() {
        this.panel = new AndCriteriumPanel();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "AND";
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return AndCriterium.ADD_ICON;
    }
    
    @Override
    public CriteriumType getType() {
        return CriteriumType.AND;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return true;
    }
    
    static {
        ADD_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/add.png");
    }
}
