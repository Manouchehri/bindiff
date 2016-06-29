package com.google.security.zynamics.zylib.gui.sliders;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class DoubleLabeledSlider extends JPanel
{
    private static final long serialVersionUID = 3181291967149555468L;
    private final JSlider m_slider;
    
    public DoubleLabeledSlider(final String s, final String s2, final int n, final int n2) {
        this.setLayout(new BorderLayout());
        final JLabel label = new JLabel(s);
        (this.m_slider = new JSlider(n, n2)).setMinorTickSpacing(1);
        this.m_slider.setPaintTicks(true);
        this.m_slider.setPaintLabels(true);
        final JLabel label2 = new JLabel(s2);
        this.add(label, "West");
        this.add(this.m_slider);
        this.add(label2, "East");
    }
    
    public DoubleLabeledSlider(final String s, final String s2, final int n, final int n2, final boolean paintTrack, final Border border) {
        this(s, s2, n, n2);
        this.m_slider.setPaintTrack(paintTrack);
        this.setBorder(border);
    }
    
    public static void main(final String[] array) {
        final JFrame frame = new JFrame();
        frame.add(new DoubleLabeledSlider("Low", "High", 0, 5));
        frame.setDefaultCloseOperation(3);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    
    public int getValue() {
        return this.m_slider.getValue();
    }
    
    public void setInverted(final boolean inverted) {
        this.m_slider.setInverted(inverted);
    }
    
    public void setValue(final int value) {
        this.m_slider.setValue(value);
    }
}
