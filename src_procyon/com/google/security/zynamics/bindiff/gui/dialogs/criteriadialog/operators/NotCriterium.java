package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class NotCriterium extends AbstractCriterium
{
    private static final ImageIcon NOT_ICON;
    private final NotCriteriumPanel panel;
    
    public NotCriterium() {
        this.panel = new NotCriteriumPanel();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "NOT";
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return NotCriterium.NOT_ICON;
    }
    
    @Override
    public CriteriumType getType() {
        return CriteriumType.NOT;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return true;
    }
    
    static {
        NOT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/not.png");
    }
}
