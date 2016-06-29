package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoggingPanel$InternalLogFileDirectoryListener implements ActionListener {
   // $FF: synthetic field
   final LoggingPanel this$0;

   private LoggingPanel$InternalLogFileDirectoryListener(LoggingPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = LoggingPanel.access$100(this.this$0.getParent());
      if(var2 != null) {
         LoggingPanel.access$200(this.this$0).setText(var2);
      }

   }

   // $FF: synthetic method
   LoggingPanel$InternalLogFileDirectoryListener(LoggingPanel var1, LoggingPanel$1 var2) {
      this(var1);
   }
}
