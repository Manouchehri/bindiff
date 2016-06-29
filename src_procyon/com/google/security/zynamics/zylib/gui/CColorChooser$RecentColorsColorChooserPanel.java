package com.google.security.zynamics.zylib.gui;

import javax.swing.colorchooser.*;
import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

class CColorChooser$RecentColorsColorChooserPanel extends AbstractColorChooserPanel
{
    final /* synthetic */ CColorChooser this$0;
    
    CColorChooser$RecentColorsColorChooserPanel(final CColorChooser this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected void buildChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(this.this$0.m_recentColors.length, 1, 1, 1));
        for (final Color color : this.this$0.m_recentColors) {
            final ColorPanel colorPanel = new ColorPanel(color, false, true);
            colorPanel.addMouseListener(new CColorChooser$RecentColorsColorChooserPanel$1(this, color));
            colorPanel.setPreferredSize(new Dimension(200, 25));
            final JPanel panel2 = new JPanel();
            panel2.setBorder(new EmptyBorder(1, 1, 1, 1));
            panel2.add(colorPanel, "First");
            panel.add(colorPanel);
        }
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 23;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = 2;
        final JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.add(panel, gridBagConstraints);
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(panel3, "North");
        final JScrollPane scrollPane = new JScrollPane(panel4);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(30);
        scrollPane.setVerticalScrollBarPolicy(20);
        this.add(scrollPane, "Center");
    }
    
    @Override
    public String getDisplayName() {
        return "Recent Colors";
    }
    
    @Override
    public Icon getLargeDisplayIcon() {
        return null;
    }
    
    @Override
    public Icon getSmallDisplayIcon() {
        return null;
    }
    
    @Override
    public void updateChooser() {
    }
}
