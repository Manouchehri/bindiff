package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class DiffTreeNodeContextPanel$InternalKeyListener implements KeyListener {
   private final int KEY_TYPED_SAVE_THRESHOLD;
   private int typedCount;
   // $FF: synthetic field
   final DiffTreeNodeContextPanel this$0;

   private DiffTreeNodeContextPanel$InternalKeyListener(DiffTreeNodeContextPanel var1) {
      this.this$0 = var1;
      this.KEY_TYPED_SAVE_THRESHOLD = 50;
      this.typedCount = 0;
   }

   public void keyPressed(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyTyped(KeyEvent var1) {
      ++this.typedCount;
      if(this.typedCount > 50) {
         DiffTreeNodeContextPanel.access$300(this.this$0);
         this.typedCount = 0;
      }

   }

   // $FF: synthetic method
   DiffTreeNodeContextPanel$InternalKeyListener(DiffTreeNodeContextPanel var1, DiffTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
