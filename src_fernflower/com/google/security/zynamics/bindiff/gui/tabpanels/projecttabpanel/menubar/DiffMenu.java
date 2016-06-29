package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.AddDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DirectoryDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.NewDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class DiffMenu extends JMenu {
   private final JMenuItem newDiff;
   private final JMenuItem dirDiff;
   private final JMenuItem addDiff;
   private final JMenuItem openDiff;
   private final JMenuItem closeDiff;
   private final JMenuItem deleteDiff;
   private final DiffMenu$InternalWorkspaceTreeListener workspaceTreeListener = new DiffMenu$InternalWorkspaceTreeListener(this, (DiffMenu$1)null);
   private final DiffMenu$InternalWorkspaceListener workspaceListener = new DiffMenu$InternalWorkspaceListener(this, (DiffMenu$1)null);
   private final DiffMenu$InternalDiffListener diffListener = new DiffMenu$InternalDiffListener(this, (DiffMenu$1)null);
   private final WorkspaceTabPanelFunctions controller;
   private Diff lastSelectedDiff = null;

   public DiffMenu(WorkspaceTabPanelFunctions var1) {
      super("Diffs");
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.setMnemonic('D');
      this.setEnabled(false);
      int var2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', 78, var2, new NewDiffAction(var1));
      this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', 65, var2, new AddDiffAction(var1));
      this.dirDiff = GuiUtils.buildMenuItem("New Directory Diff...", 'N', new DirectoryDiffAction(var1));
      this.openDiff = GuiUtils.buildMenuItem("Open Diff", 'O', new LoadDiffAction(var1));
      this.closeDiff = GuiUtils.buildMenuItem("Close Diff", 'C', new CloseDiffAction(var1));
      this.deleteDiff = GuiUtils.buildMenuItem("Delete Diff", 'D', new DeleteDiffAction(var1));
      this.add(this.newDiff);
      this.add(this.addDiff);
      this.add(this.dirDiff);
      this.add(new JSeparator());
      this.add(this.openDiff);
      this.add(this.closeDiff);
      this.add(new JSeparator());
      this.add(this.deleteDiff);
      var1.getWorkspace().addListener(this.workspaceListener);
      var1.getWorkspaceTree().addListener(this.workspaceTreeListener);
   }

   private void registerCurrentDiffListener(Diff var1) {
      this.unregisterCurrentDiffListener();
      this.lastSelectedDiff = var1;
      this.lastSelectedDiff.addListener(this.diffListener);
      this.unregisterCurrentDiffListener();
   }

   private void unregisterCurrentDiffListener() {
      if(this.lastSelectedDiff != null) {
         this.lastSelectedDiff.removeListener(this.diffListener);
         this.lastSelectedDiff = null;
      }

   }

   // $FF: synthetic method
   static JMenuItem access$300(DiffMenu var0) {
      return var0.openDiff;
   }

   // $FF: synthetic method
   static JMenuItem access$400(DiffMenu var0) {
      return var0.closeDiff;
   }

   // $FF: synthetic method
   static DiffMenu$InternalWorkspaceTreeListener access$500(DiffMenu var0) {
      return var0.workspaceTreeListener;
   }

   // $FF: synthetic method
   static WorkspaceTabPanelFunctions access$600(DiffMenu var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static void access$700(DiffMenu var0) {
      var0.unregisterCurrentDiffListener();
   }

   // $FF: synthetic method
   static JMenuItem access$800(DiffMenu var0) {
      return var0.newDiff;
   }

   // $FF: synthetic method
   static JMenuItem access$900(DiffMenu var0) {
      return var0.addDiff;
   }

   // $FF: synthetic method
   static JMenuItem access$1000(DiffMenu var0) {
      return var0.deleteDiff;
   }

   // $FF: synthetic method
   static void access$1100(DiffMenu var0, Diff var1) {
      var0.registerCurrentDiffListener(var1);
   }
}
