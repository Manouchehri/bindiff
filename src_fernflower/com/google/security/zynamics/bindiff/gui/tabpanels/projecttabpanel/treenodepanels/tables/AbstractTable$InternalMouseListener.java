package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListSelectionModel;

class AbstractTable$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final AbstractTable this$0;

   private AbstractTable$InternalMouseListener(AbstractTable var1) {
      this.this$0 = var1;
   }

   public void mouseClicked(MouseEvent var1) {
      if(var1.getButton() == 1 && var1.getClickCount() == 2) {
         this.this$0.handleDoubleClick(AbstractTable.access$200(this.this$0, var1));
      }

   }

   public void mousePressed(MouseEvent var1) {
      if(var1.getButton() == 3 && !var1.isControlDown()) {
         int var2 = this.this$0.rowAtPoint(var1.getPoint());
         if(!((DefaultListSelectionModel)this.this$0.getSelectionModel()).isSelectedIndex(var2)) {
            this.this$0.getSelectionModel().clearSelection();
         }

         ((DefaultListSelectionModel)this.this$0.getSelectionModel()).addSelectionInterval(var2, var2);
      }

      if(var1.isPopupTrigger()) {
         AbstractTable.access$300(this.this$0, var1);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         AbstractTable.access$300(this.this$0, var1);
      }

   }

   // $FF: synthetic method
   AbstractTable$InternalMouseListener(AbstractTable var1, AbstractTable$1 var2) {
      this(var1);
   }
}
