package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphSettingsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final GraphSettingsDialog this$0;

   private GraphSettingsDialog$InternalButtonListener(GraphSettingsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getActionCommand().equals("Ok")) {
         GraphSettingsDialog.access$100(this.this$0);
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   GraphSettingsDialog$InternalButtonListener(GraphSettingsDialog var1, GraphSettingsDialog$1 var2) {
      this(var1);
   }
}
