package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ColorCriterium extends ConditionCriterium
{
    private static final ImageIcon COLOR_CONDITION_ICON;
    private final ColorCriteriumPanel panel;
    private final AbstractGraphsContainer graphs;
    
    public ColorCriterium(final AbstractGraphsContainer graphs) {
        Preconditions.checkNotNull(graphs);
        this.panel = new ColorCriteriumPanel(this);
        this.graphs = graphs;
    }
    
    private JPanel getCriteriumPanel(final AbstractGraphsContainer abstractGraphsContainer) {
        this.panel.updateColors(abstractGraphsContainer);
        return this.panel;
    }
    
    public Color getColor() {
        return this.panel.getColor();
    }
    
    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Color %06X", this.getColor().getRGB() & 0xFFFFFF);
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.getCriteriumPanel(this.graphs);
    }
    
    @Override
    public Icon getIcon() {
        return ColorCriterium.COLOR_CONDITION_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return ((CViewNode)zyGraphNode.getRawNode()).getColor().equals(this.getColor());
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        COLOR_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/color-condition.png");
    }
}
