package com.google.security.zynamics.bindiff.gui.window;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenuBar;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JTabbedPane;

public class CWindowFunctions {
   private final TabPanelManager tabPanelManager;
   private final MainWindow window;

   public CWindowFunctions(MainWindow var1, Workspace var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.tabPanelManager = new TabPanelManager(var1, var2);
      WorkspaceTabPanel var3 = new WorkspaceTabPanel(var1, var2);
      this.tabPanelManager.addTab(var3);
      this.window = var1;
   }

   private void saveConfigFile() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      Point var3 = this.window.getLocation();
      var2.setWindowXPos((int)var3.getX());
      var2.setWindowYPos((int)var3.getY());
      var2.setWindowWidth(this.window.getWidth());
      var2.setWindowHeight(this.window.getHeight());
      var2.setWindowStateWasMaximized(this.window.getExtendedState() == 6);
      var2.setWorkspaceTreeDividerPosition(this.tabPanelManager.getWorkspaceTabPanel().getDividerLocation());
      var2.setScreenWidth(Toolkit.getDefaultToolkit().getScreenSize().width);
      var2.setScreenHeight(Toolkit.getDefaultToolkit().getScreenSize().height);
      WorkspaceMenuBar var4 = (WorkspaceMenuBar)this.tabPanelManager.getWorkspaceTabPanel().getMenuBar();
      String[] var5 = var4.getRecentWorkspaces();
      var2.setLastWorkspaceDirectory1((new File(var5[0])).exists()?var5[0]:"");
      var2.setLastWorkspaceDirectory2((new File(var5[1])).exists()?var5[1]:"");
      var2.setLastWorkspaceDirectory3((new File(var5[2])).exists()?var5[2]:"");
      var2.setLastWorkspaceDirectory4((new File(var5[3])).exists()?var5[3]:"");

      try {
         BinDiffConfigFile.getInstance().write();
      } catch (IOException var7) {
         Logger.logException(var7, "Couldn\'t save configuration file.");
         CMessageBox.showError(this.window, "Couldn\'t save configuration file.");
      }

   }

   public void exitBinDiff() {
      WorkspaceTabPanelFunctions var1 = this.tabPanelManager.getWorkspaceTabPanel().getController();
      if(this.tabPanelManager.getWorkspaceTabPanel().getController().closeWorkspace()) {
         var1.closeDialogs();
         this.saveConfigFile();
         Logger.logInfo("BinDiff closed normally.", new Object[0]);
      }

      System.exit(0);
   }

   public JTabbedPane getTabbedPanel() {
      return this.tabPanelManager.getTabbedPane();
   }

   public TabPanelManager getTabPanelManager() {
      return this.tabPanelManager;
   }
}
