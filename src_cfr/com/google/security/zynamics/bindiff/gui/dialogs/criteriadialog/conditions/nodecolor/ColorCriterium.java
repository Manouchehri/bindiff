/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ColorCriterium
extends ConditionCriterium {
    private static final ImageIcon COLOR_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/color-condition.png");
    private final ColorCriteriumPanel panel;
    private final AbstractGraphsContainer graphs;

    public ColorCriterium(AbstractGraphsContainer abstractGraphsContainer) {
        Preconditions.checkNotNull(abstractGraphsContainer);
        this.panel = new ColorCriteriumPanel(this);
        this.graphs = abstractGraphsContainer;
    }

    private JPanel getCriteriumPanel(AbstractGraphsContainer abstractGraphsContainer) {
        this.panel.updateColors(abstractGraphsContainer);
        return this.panel;
    }

    public Color getColor() {
        return this.panel.getColor();
    }

    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Color %06X", this.getColor().getRGB() & 16777215);
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.getCriteriumPanel(this.graphs);
    }

    @Override
    public Icon getIcon() {
        return COLOR_CONDITION_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        return ((CViewNode)zyGraphNode.getRawNode()).getColor().equals(this.getColor());
    }

    public void update() {
        this.notifyListeners();
    }
}

