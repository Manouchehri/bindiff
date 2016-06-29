package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class OrCriterium extends AbstractCriterium
{
    private static final ImageIcon OR_ICON;
    private final OrCriteriumPanel panel;
    
    public OrCriterium() {
        this.panel = new OrCriteriumPanel();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "OR";
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return OrCriterium.OR_ICON;
    }
    
    @Override
    public CriteriumType getType() {
        return CriteriumType.OR;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return true;
    }
    
    static {
        OR_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/or.png");
    }
}
