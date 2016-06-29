package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CColorChooser$RecentColorsColorChooserPanel$1 extends MouseAdapter {
   // $FF: synthetic field
   final Color val$col;
   // $FF: synthetic field
   final CColorChooser$RecentColorsColorChooserPanel this$1;

   CColorChooser$RecentColorsColorChooserPanel$1(CColorChooser$RecentColorsColorChooserPanel var1, Color var2) {
      this.this$1 = var1;
      this.val$col = var2;
   }

   public void mouseClicked(MouseEvent var1) {
      if(var1.getButton() == 1) {
         this.this$1.getColorSelectionModel().setSelectedColor(this.val$col);
      }
   }
}
