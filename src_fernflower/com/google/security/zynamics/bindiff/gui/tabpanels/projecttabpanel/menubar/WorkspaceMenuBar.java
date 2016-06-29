package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.SettingsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class WorkspaceMenuBar extends JMenuBar {
   private final JMenu workspaceMenu;
   private final JMenu diffMenu;
   private final JMenu settingsMenu;
   private final JMenu aboutMenu;

   public WorkspaceMenuBar(WorkspaceTabPanelFunctions var1) {
      this.workspaceMenu = new WorkspaceMenu(var1);
      this.diffMenu = new DiffMenu(var1);
      this.settingsMenu = new SettingsMenu(var1);
      this.aboutMenu = new HelpMenu(var1);
      this.add(this.workspaceMenu);
      this.add(this.diffMenu);
      this.add(this.settingsMenu);
      this.add(this.aboutMenu);
   }

   public String[] getRecentWorkspaces() {
      return ((WorkspaceMenu)this.workspaceMenu).getRecentWorkspaces();
   }
}
