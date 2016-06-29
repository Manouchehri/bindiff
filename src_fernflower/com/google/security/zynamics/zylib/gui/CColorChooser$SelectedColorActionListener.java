package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CColorChooser$SelectedColorActionListener implements ActionListener {
   Color m_color;
   // $FF: synthetic field
   final CColorChooser this$0;

   CColorChooser$SelectedColorActionListener(CColorChooser var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.m_color = this.this$0.getColor();
   }

   public Color getColor() {
      return this.m_color;
   }
}
