package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class InitialCallGraphSettingsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final InitialCallGraphSettingsDialog this$0;

   private InitialCallGraphSettingsDialog$InternalButtonListener(InitialCallGraphSettingsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getActionCommand().equals("Ok")) {
         try {
            InitialCallGraphSettingsDialog.access$100(this.this$0);
         } catch (IOException var3) {
            CMessageBox.showError(this.this$0, "Couldn\'t save inital call graph settings.");
            Logger.logException(var3, "Couldn\'t save inital call graph settings.");
         }
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   InitialCallGraphSettingsDialog$InternalButtonListener(InitialCallGraphSettingsDialog var1, InitialCallGraphSettingsDialog$1 var2) {
      this(var1);
   }
}
