package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;

class TabButton$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final TabButton this$0;

   private TabButton$InternalMouseListener(TabButton var1) {
      this.this$0 = var1;
   }

   public void mouseEntered(MouseEvent var1) {
      Component var2 = var1.getComponent();
      if(var2 instanceof AbstractButton) {
         AbstractButton var3 = (AbstractButton)var2;
         var3.setBorderPainted(false);
      }

   }

   public void mouseExited(MouseEvent var1) {
      Component var2 = var1.getComponent();
      if(var2 instanceof AbstractButton) {
         AbstractButton var3 = (AbstractButton)var2;
         var3.setBorderPainted(false);
      }

   }

   // $FF: synthetic method
   TabButton$InternalMouseListener(TabButton var1, TabButton$1 var2) {
      this(var1);
   }
}
