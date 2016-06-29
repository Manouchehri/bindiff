package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public final class WorkspaceMenu extends JMenu {
   public static final int MAX_RECENT = 4;
   private final List recentWorkspaces = new ArrayList(4);
   private final WorkspaceTabPanelFunctions controller;
   private final WorkspaceMenu$InternalWorkspaceListener workspaceModelListener = new WorkspaceMenu$InternalWorkspaceListener(this, (WorkspaceMenu$1)null);
   private JMenuItem newWorkspace;
   private JMenuItem loadWorkspace;
   private JMenuItem closeWorkspace;
   private JMenuItem exit;

   public WorkspaceMenu(WorkspaceTabPanelFunctions var1) {
      super("File");
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.setMnemonic('F');
      this.loadRecentWorkspacesFromConfig();
      this.initItems();
      var1.getWorkspace().addListener(this.workspaceModelListener);
      this.enableSubmenus(false);
   }

   private void addRecentWorkspaces() {
      boolean var1 = true;
      Iterator var2 = this.recentWorkspaces.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(!var3.isEmpty()) {
            if(var1) {
               this.add(new JSeparator());
               var1 = false;
            }

            JMenuItem var4 = GuiUtils.buildMenuItem(this.minimizeWorkspacePath(var3), new WorkspaceMenu$1(this, var3));
            this.add(var4);
         }
      }

   }

   private void addSubmenuEntries() {
      this.add(this.newWorkspace);
      this.add(this.loadWorkspace);
      this.add(this.closeWorkspace);
      this.addRecentWorkspaces();
      this.add(new JSeparator());
      this.add(this.exit);
   }

   private void initItems() {
      int var1 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      this.newWorkspace = GuiUtils.buildMenuItem("New Workspace...", 'N', 78, var1 | 1, new WorkspaceMenu$2(this));
      this.loadWorkspace = GuiUtils.buildMenuItem("Open Workspace...", 'O', 79, var1, new WorkspaceMenu$3(this));
      this.closeWorkspace = GuiUtils.buildMenuItem("Close Workspace", 'W', 87, var1, new WorkspaceMenu$4(this));
      this.exit = GuiUtils.buildMenuItem("Exit", 'Q', 81, var1, new WorkspaceMenu$5(this));
      this.addSubmenuEntries();
   }

   private void loadRecentWorkspacesFromConfig() {
      GeneralSettingsConfigItem var1 = BinDiffConfigFile.getInstance().getMainSettings();
      this.recentWorkspaces.add((new File(var1.getLastWorkspaceDirectory1())).exists()?var1.getLastWorkspaceDirectory1():"");
      this.recentWorkspaces.add((new File(var1.getLastWorkspaceDirectory2())).exists()?var1.getLastWorkspaceDirectory2():"");
      this.recentWorkspaces.add((new File(var1.getLastWorkspaceDirectory3())).exists()?var1.getLastWorkspaceDirectory3():"");
      this.recentWorkspaces.add((new File(var1.getLastWorkspaceDirectory4())).exists()?var1.getLastWorkspaceDirectory4():"");
   }

   private String minimizeWorkspacePath(String var1) {
      // $FF: Couldn't be decompiled
   }

   private void updateworkspaceMenu() {
      this.removeAll();
      this.addSubmenuEntries();
   }

   public void dispose() {
      this.controller.getWorkspace().removeListener(this.workspaceModelListener);
   }

   public void enableSubmenus(boolean var1) {
      this.closeWorkspace.setEnabled(var1);
   }

   public String[] getRecentWorkspaces() {
      return (String[])this.recentWorkspaces.toArray(new String[0]);
   }

   // $FF: synthetic method
   static WorkspaceTabPanelFunctions access$100(WorkspaceMenu var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static List access$200(WorkspaceMenu var0) {
      return var0.recentWorkspaces;
   }

   // $FF: synthetic method
   static void access$300(WorkspaceMenu var0) {
      var0.updateworkspaceMenu();
   }
}
