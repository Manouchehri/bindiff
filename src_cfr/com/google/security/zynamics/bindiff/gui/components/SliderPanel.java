/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.bindiff.gui.components.SliderPanel$1;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel$InternalSliderListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;

public class SliderPanel
extends JPanel {
    private final JSlider slider;
    private final JLabel value;
    private final int maxVal;
    private final int minVal;
    private final boolean showInfinityOnMax;
    private final ChangeListener sliderListener;

    public SliderPanel(int n2, int n3, int n4, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n5, int n6) {
        super(new BorderLayout());
        this.sliderListener = new SliderPanel$InternalSliderListener(this, null);
        this.validateValue(n2);
        this.maxVal = n4;
        this.minVal = n3;
        this.showInfinityOnMax = bl2;
        this.slider = new JSlider(n3, n4);
        this.slider.setValue(n2);
        this.slider.setMinorTickSpacing(1);
        this.slider.setPaintTicks(bl3);
        this.slider.setPaintTrack(bl4);
        this.slider.setPaintLabels(false);
        this.slider.addChangeListener(this.sliderListener);
        this.value = new JLabel();
        this.value.setText(Integer.toString(n2));
        this.value.setBorder(new EmptyBorder(0, 2, 0, 0));
        if (bl5) {
            this.setBorder(new LineBorder(Color.GRAY));
        }
        this.add((Component)this.value, "West");
        this.add((Component)this.slider, "Center");
        this.value.setPreferredSize(new Dimension(n5, n6));
    }

    private void validateValue(int n2) {
        if (n2 > this.maxVal) throw new IllegalArgumentException("Value is out of range.");
        if (n2 >= this.minVal) return;
        throw new IllegalArgumentException("Value is out of range.");
    }

    public void dispose() {
        this.slider.removeChangeListener(this.sliderListener);
    }

    public int getValue() {
        return this.slider.getValue();
    }

    public void setValue(int n2) {
        this.validateValue(n2);
        this.slider.setValue(n2);
    }

    public void setValueText(String string) {
        this.value.setText(string);
    }

    static /* synthetic */ JSlider access$100(SliderPanel sliderPanel) {
        return sliderPanel.slider;
    }

    static /* synthetic */ int access$200(SliderPanel sliderPanel) {
        return sliderPanel.maxVal;
    }

    static /* synthetic */ boolean access$300(SliderPanel sliderPanel) {
        return sliderPanel.showInfinityOnMax;
    }
}

