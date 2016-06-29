/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.bindiff.gui.components.SliderPanel;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel$1;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SliderPanel$InternalSliderListener
implements ChangeListener {
    final /* synthetic */ SliderPanel this$0;

    private SliderPanel$InternalSliderListener(SliderPanel sliderPanel) {
        this.this$0 = sliderPanel;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        this.this$0.setValueText(SliderPanel.access$100(this.this$0).getValue() == SliderPanel.access$200(this.this$0) && SliderPanel.access$300(this.this$0) ? "<html>&infin;</html>" : Integer.toString(SliderPanel.access$100(this.this$0).getValue()));
    }

    /* synthetic */ SliderPanel$InternalSliderListener(SliderPanel sliderPanel, SliderPanel$1 sliderPanel$1) {
        this(sliderPanel);
    }
}

