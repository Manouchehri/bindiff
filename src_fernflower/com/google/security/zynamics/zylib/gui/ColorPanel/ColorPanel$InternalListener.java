package com.google.security.zynamics.zylib.gui.ColorPanel;

import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorPanel$InternalListener extends MouseAdapter {
   // $FF: synthetic field
   final ColorPanel this$0;

   private ColorPanel$InternalListener(ColorPanel var1) {
      this.this$0 = var1;
   }

   public void mouseClicked(MouseEvent var1) {
      if(ColorPanel.access$100(this.this$0) && var1.getButton() == 1 && var1.getClickCount() == 1) {
         ColorPanel.access$200(this.this$0);
      }

   }

   // $FF: synthetic method
   ColorPanel$InternalListener(ColorPanel var1, ColorPanel$1 var2) {
      this(var1);
   }
}
