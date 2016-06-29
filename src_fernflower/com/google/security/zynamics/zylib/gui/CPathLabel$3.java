package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CPathLabel$3 extends MouseAdapter {
   // $FF: synthetic field
   final CPathLabel this$0;

   CPathLabel$3(CPathLabel var1) {
      this.this$0 = var1;
   }

   private void handlePopupEvent(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         this.this$0.m_popup.show(var1.getComponent(), var1.getX(), var1.getY());
      }

   }

   public void mousePressed(MouseEvent var1) {
      this.handlePopupEvent(var1);
   }

   public void mouseReleased(MouseEvent var1) {
      this.handlePopupEvent(var1);
   }
}
