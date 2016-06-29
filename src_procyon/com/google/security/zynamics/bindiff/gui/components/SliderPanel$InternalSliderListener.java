package com.google.security.zynamics.bindiff.gui.components;

import javax.swing.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class SliderPanel$InternalSliderListener implements ChangeListener
{
    final /* synthetic */ SliderPanel this$0;
    
    private SliderPanel$InternalSliderListener(final SliderPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void stateChanged(final ChangeEvent changeEvent) {
        this.this$0.setValueText((this.this$0.slider.getValue() == this.this$0.maxVal && this.this$0.showInfinityOnMax) ? "<html>&infin;</html>" : Integer.toString(this.this$0.slider.getValue()));
    }
}
