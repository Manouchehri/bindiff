package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.ColorPanel.IColorPanelListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorCriteriumPanel$InternalColorPanelListener extends MouseAdapter implements IColorPanelListener {
   // $FF: synthetic field
   final ColorCriteriumPanel this$0;

   private ColorCriteriumPanel$InternalColorPanelListener(ColorCriteriumPanel var1) {
      this.this$0 = var1;
   }

   public void changedColor(ColorPanel var1) {
      ColorCriteriumPanel.access$100(this.this$0).update();
   }

   public void mousePressed(MouseEvent var1) {
      if(var1.getButton() == 1) {
         ColorPanel var2 = (ColorPanel)var1.getSource();
         Color var3 = var2.getColor();
         if(var3 != null) {
            ColorCriteriumPanel.access$200(this.this$0).setColor(var3);
         }
      }

   }

   // $FF: synthetic method
   ColorCriteriumPanel$InternalColorPanelListener(ColorCriteriumPanel var1, ColorCriteriumPanel$1 var2) {
      this(var1);
   }
}
