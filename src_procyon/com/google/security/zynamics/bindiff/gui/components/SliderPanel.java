package com.google.security.zynamics.bindiff.gui.components;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;

public class SliderPanel extends JPanel
{
    private final JSlider slider;
    private final JLabel value;
    private final int maxVal;
    private final int minVal;
    private final boolean showInfinityOnMax;
    private final ChangeListener sliderListener;
    
    public SliderPanel(final int value, final int minVal, final int maxVal, final boolean showInfinityOnMax, final boolean paintTicks, final boolean paintTrack, final boolean b, final int n, final int n2) {
        super(new BorderLayout());
        this.sliderListener = new SliderPanel$InternalSliderListener(this, null);
        this.validateValue(value);
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.showInfinityOnMax = showInfinityOnMax;
        (this.slider = new JSlider(minVal, maxVal)).setValue(value);
        this.slider.setMinorTickSpacing(1);
        this.slider.setPaintTicks(paintTicks);
        this.slider.setPaintTrack(paintTrack);
        this.slider.setPaintLabels(false);
        this.slider.addChangeListener(this.sliderListener);
        (this.value = new JLabel()).setText(Integer.toString(value));
        this.value.setBorder(new EmptyBorder(0, 2, 0, 0));
        if (b) {
            this.setBorder(new LineBorder(Color.GRAY));
        }
        this.add(this.value, "West");
        this.add(this.slider, "Center");
        this.value.setPreferredSize(new Dimension(n, n2));
    }
    
    private void validateValue(final int n) {
        if (n > this.maxVal || n < this.minVal) {
            throw new IllegalArgumentException("Value is out of range.");
        }
    }
    
    public void dispose() {
        this.slider.removeChangeListener(this.sliderListener);
    }
    
    public int getValue() {
        return this.slider.getValue();
    }
    
    public void setValue(final int value) {
        this.validateValue(value);
        this.slider.setValue(value);
    }
    
    public void setValueText(final String text) {
        this.value.setText(text);
    }
}
