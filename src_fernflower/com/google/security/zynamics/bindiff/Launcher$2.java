package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.common.config.ConfigHelper;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileException;

final class Launcher$2 implements Runnable {
   // $FF: synthetic field
   final String[] val$args;

   Launcher$2(String[] var1) {
      this.val$args = var1;
   }

   public void run() {
      System.setProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY, "BinDiff");
      Launcher.access$000();
      Launcher.access$100();
      Logger.logInfo("Starting %s", new Object[]{"4.2.0"});
      String var1 = String.valueOf(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml"));
      Logger.logInfo((new StringBuilder(15 + String.valueOf(var1).length())).append("Initialized ").append(var1).append("...").toString(), new Object[0]);
      Launcher.access$200();
      Launcher.access$300(this.val$args);
      Launcher.access$400();
      Launcher.access$500();
      Workspace var5 = new Workspace();
      MainWindow var2 = new MainWindow(var5);
      var5.setParentWindow(var2);
      var2.setVisible(true);
      GuiHelper.applyWindowFix(var2);
      Launcher.access$600(var2);

      try {
         Launcher.access$700(var2);
      } catch (CLicenseFileException var4) {
         Logger.logException(var4, "Error while reading license file.");
      }

      if(Launcher.access$800() != null) {
         var2.getController().getTabPanelManager().getWorkspaceTabPanel().getController().loadWorkspace(Launcher.access$800());
      }

   }
}
