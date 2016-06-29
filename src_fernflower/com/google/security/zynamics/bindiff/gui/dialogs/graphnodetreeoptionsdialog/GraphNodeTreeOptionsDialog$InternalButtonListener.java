package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphNodeTreeOptionsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final GraphNodeTreeOptionsDialog this$0;

   private GraphNodeTreeOptionsDialog$InternalButtonListener(GraphNodeTreeOptionsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(GraphNodeTreeOptionsDialog.access$100(this.this$0))) {
         GraphNodeTreeOptionsDialog.access$202(this.this$0, true);
         this.this$0.setVisible(false);
      } else if(var1.getSource().equals(GraphNodeTreeOptionsDialog.access$300(this.this$0))) {
         GraphNodeTreeOptionsDialog.access$400(this.this$0).restoreInitialSettings();
         GraphNodeTreeOptionsDialog.access$500(this.this$0).restoreInitialSettings();
         GraphNodeTreeOptionsDialog.access$600(this.this$0).restoreInitialSettings();
         this.this$0.setVisible(false);
      } else if(var1.getSource().equals(GraphNodeTreeOptionsDialog.access$700(this.this$0))) {
         this.this$0.setDefaults(this.this$0.tab.getSelectedIndex());
      }

   }

   // $FF: synthetic method
   GraphNodeTreeOptionsDialog$InternalButtonListener(GraphNodeTreeOptionsDialog var1, GraphNodeTreeOptionsDialog$1 var2) {
      this(var1);
   }
}
