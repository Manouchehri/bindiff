/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$InternalColorPanelListener;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.ColorPanel.IColorPanelListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ColorCriteriumPanel
extends JPanel {
    private final ColorPanel selectedColorPanel;
    private final ColorCriterium colorCriterium;
    private final List colorPanels = new ArrayList();
    private final ColorCriteriumPanel$InternalColorPanelListener colorPanelListener;

    public ColorCriteriumPanel(ColorCriterium colorCriterium) {
        super(new BorderLayout());
        this.colorPanelListener = new ColorCriteriumPanel$InternalColorPanelListener(this, null);
        this.colorCriterium = colorCriterium;
        this.selectedColorPanel = new ColorPanel(null, false);
        this.selectedColorPanel.addListener(this.colorPanelListener);
        this.selectedColorPanel.addMouseListener(this.colorPanelListener);
    }

    private void createPanel(List list) {
        this.removeAll();
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Color Condition"));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(0, 5, 3, 5));
        jPanel2.add(jPanel2);
        JPanel jPanel3 = new JPanel(new GridLayout(1 + list.size() / 4, 4));
        jPanel3.setBorder(new TitledBorder(""));
        for (Color color : list) {
            JPanel jPanel4 = new JPanel(new BorderLayout());
            jPanel4.setBorder(new EmptyBorder(3, 3, 3, 3));
            ColorPanel colorPanel = new ColorPanel(color, false);
            jPanel4.add((Component)colorPanel, "Center");
            this.colorPanels.add(colorPanel);
            colorPanel.addListener(this.colorPanelListener);
            colorPanel.addMouseListener(this.colorPanelListener);
            jPanel3.add((Component)jPanel4, "North");
        }
        this.selectedColorPanel.setColor(list.size() > 0 ? (Color)list.get(0) : Color.WHITE);
        jPanel.add((Component)jPanel2, "North");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.add((Component)jPanel3, "North");
        jPanel5.setBorder(new EmptyBorder(3, 5, 0, 5));
        jPanel.add((Component)jPanel5, "Center");
        this.add((Component)jPanel, "Center");
    }

    private void getColors(Set set, AbstractZyGraph abstractZyGraph) {
        Iterator iterator = abstractZyGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            set.add(zyGraphNode.getRealizer().getFillColor());
        }
    }

    public void delete() {
        this.selectedColorPanel.removeListener(this.colorPanelListener);
        this.selectedColorPanel.removeMouseListener(this.colorPanelListener);
        Iterator iterator = this.colorPanels.iterator();
        while (iterator.hasNext()) {
            ColorPanel colorPanel = (ColorPanel)iterator.next();
            colorPanel.removeListener(this.colorPanelListener);
            colorPanel.removeMouseListener(this.colorPanelListener);
        }
    }

    public Color getColor() {
        return this.selectedColorPanel.getColor();
    }

    public void updateColors(AbstractGraphsContainer abstractGraphsContainer) {
        HashSet hashSet = new HashSet();
        this.getColors(hashSet, abstractGraphsContainer.getPrimaryGraph());
        this.getColors(hashSet, abstractGraphsContainer.getSecondaryGraph());
        this.getColors(hashSet, abstractGraphsContainer.getCombinedGraph());
        this.createPanel(new ArrayList(hashSet));
    }

    static /* synthetic */ ColorCriterium access$100(ColorCriteriumPanel colorCriteriumPanel) {
        return colorCriteriumPanel.colorCriterium;
    }

    static /* synthetic */ ColorPanel access$200(ColorCriteriumPanel colorCriteriumPanel) {
        return colorCriteriumPanel.selectedColorPanel;
    }
}

