/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

class CColorChooser$RecentColorsColorChooserPanel
extends AbstractColorChooserPanel {
    final /* synthetic */ CColorChooser this$0;

    CColorChooser$RecentColorsColorChooserPanel(CColorChooser cColorChooser) {
        this.this$0 = cColorChooser;
    }

    @Override
    protected void buildChooser() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(this.this$0.m_recentColors.length, 1, 1, 1));
        Object object = this.this$0.m_recentColors;
        int n2 = object.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                object = new GridBagConstraints();
                object.gridx = 0;
                object.gridy = 0;
                object.anchor = 23;
                object.weightx = 1.0;
                object.fill = 2;
                JPanel jPanel2 = new JPanel(new GridBagLayout());
                jPanel2.add((Component)jPanel, object);
                JPanel jPanel3 = new JPanel(new BorderLayout());
                jPanel3.add((Component)jPanel2, "North");
                JScrollPane jScrollPane = new JScrollPane(jPanel3);
                jScrollPane.setBorder(null);
                jScrollPane.setHorizontalScrollBarPolicy(30);
                jScrollPane.setVerticalScrollBarPolicy(20);
                this.add((Component)jScrollPane, "Center");
                return;
            }
            Color color = object[n3];
            ColorPanel colorPanel = new ColorPanel(color, false, true);
            colorPanel.addMouseListener(new CColorChooser$RecentColorsColorChooserPanel$1(this, color));
            colorPanel.setPreferredSize(new Dimension(200, 25));
            JPanel jPanel2 = new JPanel();
            jPanel2.setBorder(new EmptyBorder(1, 1, 1, 1));
            jPanel2.add((Component)colorPanel, "First");
            jPanel.add(colorPanel);
            ++n3;
        } while (true);
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

