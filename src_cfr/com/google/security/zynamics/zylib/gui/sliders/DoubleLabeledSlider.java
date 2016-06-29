/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.sliders;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class DoubleLabeledSlider
extends JPanel {
    private static final long serialVersionUID = 3181291967149555468L;
    private final JSlider m_slider;

    public DoubleLabeledSlider(String string, String string2, int n2, int n3) {
        this.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel(string);
        this.m_slider = new JSlider(n2, n3);
        this.m_slider.setMinorTickSpacing(1);
        this.m_slider.setPaintTicks(true);
        this.m_slider.setPaintLabels(true);
        JLabel jLabel2 = new JLabel(string2);
        this.add((Component)jLabel, "West");
        this.add(this.m_slider);
        this.add((Component)jLabel2, "East");
    }

    public DoubleLabeledSlider(String string, String string2, int n2, int n3, boolean bl2, Border border) {
        this(string, string2, n2, n3);
        this.m_slider.setPaintTrack(bl2);
        this.setBorder(border);
    }

    public static void main(String[] arrstring) {
        JFrame jFrame = new JFrame();
        DoubleLabeledSlider doubleLabeledSlider = new DoubleLabeledSlider("Low", "High", 0, 5);
        jFrame.add(doubleLabeledSlider);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
    }

    public int getValue() {
        return this.m_slider.getValue();
    }

    public void setInverted(boolean bl2) {
        this.m_slider.setInverted(bl2);
    }

    public void setValue(int n2) {
        this.m_slider.setValue(n2);
    }
}

