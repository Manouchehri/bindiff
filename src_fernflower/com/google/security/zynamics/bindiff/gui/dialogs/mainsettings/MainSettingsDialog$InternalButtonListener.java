package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class MainSettingsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final MainSettingsDialog this$0;

   private MainSettingsDialog$InternalButtonListener(MainSettingsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == MainSettingsDialog.access$100(this.this$0).getFirstButton()) {
         try {
            MainSettingsDialog.access$200(this.this$0);
         } catch (IOException var3) {
            CMessageBox.showError(this.this$0, "Couldn\'t save main settings.");
            Logger.logException(var3, "Couldn\'t save main settings.");
         }
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   MainSettingsDialog$InternalButtonListener(MainSettingsDialog var1, MainSettingsDialog$1 var2) {
      this(var1);
   }
}
