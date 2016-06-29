package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.AddDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.NewDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class NoNodePopupMenu extends JPopupMenu {
   private final WorkspaceTabPanelFunctions controller;
   private final JMenuItem newDiff;
   private final JMenuItem addDiff;
   private final NoNodePopupMenu$InternalWorkspaceListener workspaceListener = new NoNodePopupMenu$InternalWorkspaceListener(this, (NoNodePopupMenu$1)null);

   public NoNodePopupMenu(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', new NewDiffAction(var1));
      this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', new AddDiffAction(var1));
      this.add(this.newDiff);
      this.add(this.addDiff);
      this.enableMenu(false);
      var1.getWorkspace().addListener(this.workspaceListener);
   }

   private void enableMenu(boolean var1) {
      this.newDiff.setEnabled(var1);
      this.addDiff.setEnabled(var1);
   }

   public void dispose() {
      this.controller.getWorkspace().addListener(this.workspaceListener);
   }

   // $FF: synthetic method
   static void access$100(NoNodePopupMenu var0, boolean var1) {
      var0.enableMenu(var1);
   }
}
