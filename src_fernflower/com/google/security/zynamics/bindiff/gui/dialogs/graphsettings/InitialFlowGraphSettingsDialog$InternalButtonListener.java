package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class InitialFlowGraphSettingsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final InitialFlowGraphSettingsDialog this$0;

   private InitialFlowGraphSettingsDialog$InternalButtonListener(InitialFlowGraphSettingsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getActionCommand().equals("Ok")) {
         try {
            InitialFlowGraphSettingsDialog.access$100(this.this$0);
         } catch (IOException var3) {
            CMessageBox.showError(this.this$0, "Couldn\'t save inital flow graph settings.");
            Logger.logException(var3, "Couldn\'t save inital flow graph settings.");
         }
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   InitialFlowGraphSettingsDialog$InternalButtonListener(InitialFlowGraphSettingsDialog var1, InitialFlowGraphSettingsDialog$1 var2) {
      this(var1);
   }
}
