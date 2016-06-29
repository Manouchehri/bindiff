package com.google.security.zynamics.zylib.gui.sliders;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class DoubleLabeledSlider extends JPanel {
   private static final long serialVersionUID = 3181291967149555468L;
   private final JSlider m_slider;

   public DoubleLabeledSlider(String var1, String var2, int var3, int var4) {
      this.setLayout(new BorderLayout());
      JLabel var5 = new JLabel(var1);
      this.m_slider = new JSlider(var3, var4);
      this.m_slider.setMinorTickSpacing(1);
      this.m_slider.setPaintTicks(true);
      this.m_slider.setPaintLabels(true);
      JLabel var6 = new JLabel(var2);
      this.add(var5, "West");
      this.add(this.m_slider);
      this.add(var6, "East");
   }

   public DoubleLabeledSlider(String var1, String var2, int var3, int var4, boolean var5, Border var6) {
      this(var1, var2, var3, var4);
      this.m_slider.setPaintTrack(var5);
      this.setBorder(var6);
   }

   public static void main(String[] var0) {
      JFrame var1 = new JFrame();
      DoubleLabeledSlider var2 = new DoubleLabeledSlider("Low", "High", 0, 5);
      var1.add(var2);
      var1.setDefaultCloseOperation(3);
      var1.setSize(400, 400);
      var1.setVisible(true);
   }

   public int getValue() {
      return this.m_slider.getValue();
   }

   public void setInverted(boolean var1) {
      this.m_slider.setInverted(var1);
   }

   public void setValue(int var1) {
      this.m_slider.setValue(var1);
   }
}
