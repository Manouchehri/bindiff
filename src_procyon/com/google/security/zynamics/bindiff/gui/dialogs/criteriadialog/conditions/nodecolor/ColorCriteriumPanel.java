package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;

public class ColorCriteriumPanel extends JPanel
{
    private final ColorPanel selectedColorPanel;
    private final ColorCriterium colorCriterium;
    private final List colorPanels;
    private final ColorCriteriumPanel$InternalColorPanelListener colorPanelListener;
    
    public ColorCriteriumPanel(final ColorCriterium colorCriterium) {
        super(new BorderLayout());
        this.colorPanels = new ArrayList();
        this.colorPanelListener = new ColorCriteriumPanel$InternalColorPanelListener(this, null);
        this.colorCriterium = colorCriterium;
        (this.selectedColorPanel = new ColorPanel((Color)null, false)).addListener(this.colorPanelListener);
        this.selectedColorPanel.addMouseListener(this.colorPanelListener);
    }
    
    private void createPanel(final List list) {
        this.removeAll();
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Color Condition"));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(0, 5, 3, 5));
        panel2.add(panel2);
        final JPanel panel3 = new JPanel(new GridLayout(1 + list.size() / 4, 4));
        panel3.setBorder(new TitledBorder(""));
        for (final Color color : list) {
            final JPanel panel4 = new JPanel(new BorderLayout());
            panel4.setBorder(new EmptyBorder(3, 3, 3, 3));
            final ColorPanel colorPanel = new ColorPanel(color, false);
            panel4.add(colorPanel, "Center");
            this.colorPanels.add(colorPanel);
            colorPanel.addListener(this.colorPanelListener);
            colorPanel.addMouseListener(this.colorPanelListener);
            panel3.add(panel4, "North");
        }
        this.selectedColorPanel.setColor((list.size() > 0) ? list.get(0) : Color.WHITE);
        panel.add(panel2, "North");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.add(panel3, "North");
        panel5.setBorder(new EmptyBorder(3, 5, 0, 5));
        panel.add(panel5, "Center");
        this.add(panel, "Center");
    }
    
    private void getColors(final Set set, final AbstractZyGraph abstractZyGraph) {
        final Iterator<ZyGraphNode> iterator = abstractZyGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next().getRealizer().getFillColor());
        }
    }
    
    public void delete() {
        this.selectedColorPanel.removeListener(this.colorPanelListener);
        this.selectedColorPanel.removeMouseListener(this.colorPanelListener);
        for (final ColorPanel colorPanel : this.colorPanels) {
            colorPanel.removeListener(this.colorPanelListener);
            colorPanel.removeMouseListener(this.colorPanelListener);
        }
    }
    
    public Color getColor() {
        return this.selectedColorPanel.getColor();
    }
    
    public void updateColors(final AbstractGraphsContainer abstractGraphsContainer) {
        final HashSet set = new HashSet<Object>();
        this.getColors(set, abstractGraphsContainer.getPrimaryGraph());
        this.getColors(set, abstractGraphsContainer.getSecondaryGraph());
        this.getColors(set, abstractGraphsContainer.getCombinedGraph());
        this.createPanel(new ArrayList(set));
    }
}
