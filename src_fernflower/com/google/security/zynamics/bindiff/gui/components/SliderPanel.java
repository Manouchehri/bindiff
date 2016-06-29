package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.bindiff.gui.components.SliderPanel$1;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel$InternalSliderListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;

public class SliderPanel extends JPanel {
   private final JSlider slider;
   private final JLabel value;
   private final int maxVal;
   private final int minVal;
   private final boolean showInfinityOnMax;
   private final ChangeListener sliderListener = new SliderPanel$InternalSliderListener(this, (SliderPanel$1)null);

   public SliderPanel(int var1, int var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7, int var8, int var9) {
      super(new BorderLayout());
      this.validateValue(var1);
      this.maxVal = var3;
      this.minVal = var2;
      this.showInfinityOnMax = var4;
      this.slider = new JSlider(var2, var3);
      this.slider.setValue(var1);
      this.slider.setMinorTickSpacing(1);
      this.slider.setPaintTicks(var5);
      this.slider.setPaintTrack(var6);
      this.slider.setPaintLabels(false);
      this.slider.addChangeListener(this.sliderListener);
      this.value = new JLabel();
      this.value.setText(Integer.toString(var1));
      this.value.setBorder(new EmptyBorder(0, 2, 0, 0));
      if(var7) {
         this.setBorder(new LineBorder(Color.GRAY));
      }

      this.add(this.value, "West");
      this.add(this.slider, "Center");
      this.value.setPreferredSize(new Dimension(var8, var9));
   }

   private void validateValue(int var1) {
      if(var1 > this.maxVal || var1 < this.minVal) {
         throw new IllegalArgumentException("Value is out of range.");
      }
   }

   public void dispose() {
      this.slider.removeChangeListener(this.sliderListener);
   }

   public int getValue() {
      return this.slider.getValue();
   }

   public void setValue(int var1) {
      this.validateValue(var1);
      this.slider.setValue(var1);
   }

   public void setValueText(String var1) {
      this.value.setText(var1);
   }

   // $FF: synthetic method
   static JSlider access$100(SliderPanel var0) {
      return var0.slider;
   }

   // $FF: synthetic method
   static int access$200(SliderPanel var0) {
      return var0.maxVal;
   }

   // $FF: synthetic method
   static boolean access$300(SliderPanel var0) {
      return var0.showInfinityOnMax;
   }
}
