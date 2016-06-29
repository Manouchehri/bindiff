package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.bindiff.gui.components.SliderPanel;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel$1;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SliderPanel$InternalSliderListener implements ChangeListener {
   // $FF: synthetic field
   final SliderPanel this$0;

   private SliderPanel$InternalSliderListener(SliderPanel var1) {
      this.this$0 = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      this.this$0.setValueText(SliderPanel.access$100(this.this$0).getValue() == SliderPanel.access$200(this.this$0) && SliderPanel.access$300(this.this$0)?"<html>&infin;</html>":Integer.toString(SliderPanel.access$100(this.this$0).getValue()));
   }

   // $FF: synthetic method
   SliderPanel$InternalSliderListener(SliderPanel var1, SliderPanel$1 var2) {
      this(var1);
   }
}
