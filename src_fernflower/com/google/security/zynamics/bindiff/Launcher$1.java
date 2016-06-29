package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.socketserver.SocketServer;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.io.IOException;

final class Launcher$1 implements Runnable {
   // $FF: synthetic field
   final MainWindow val$window;

   Launcher$1(MainWindow var1) {
      this.val$window = var1;
   }

   public void run() {
      int var1 = Constants.getSocketPort();

      try {
         (new SocketServer(var1, this.val$window.getController().getTabPanelManager().getWorkspaceTabPanel().getController())).startListening();
      } catch (IOException var3) {
         CMessageBox.showError(this.val$window, String.format("Could not listen on port %s. BinDiff exits.", new Object[]{Integer.valueOf(var1)}));
         System.exit(1);
      }

   }
}
