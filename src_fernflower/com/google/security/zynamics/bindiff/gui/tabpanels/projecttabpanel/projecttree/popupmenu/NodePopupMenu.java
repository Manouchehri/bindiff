package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$InternalWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.util.HashSet;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class NodePopupMenu extends JPopupMenu {
   private final WorkspaceTabPanelFunctions controller;
   private final JMenuItem openDiff;
   private final JMenuItem closeDiff;
   private final JMenuItem deleteDiff;
   private final JMenuItem closeViews;
   private final NodePopupMenu$InternalWorkspaceTreeListener workspaceTreeListener = new NodePopupMenu$InternalWorkspaceTreeListener(this, (NodePopupMenu$1)null);
   private final NodePopupMenu$InternalDiffListener diffListener = new NodePopupMenu$InternalDiffListener(this, (NodePopupMenu$1)null);
   private Diff lastSelectedDiff = null;

   public NodePopupMenu(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.openDiff = GuiUtils.buildMenuItem("Open Diff", new LoadDiffAction(var1));
      this.closeDiff = GuiUtils.buildMenuItem("Close Diff", new CloseDiffAction(var1));
      this.deleteDiff = GuiUtils.buildMenuItem("Delete Diff", new DeleteDiffAction(var1));
      this.closeViews = GuiUtils.buildMenuItem("Close Views", new CloseViewsAction(var1));
      this.add(this.openDiff);
      this.add(this.closeDiff);
      this.add(new JSeparator());
      this.add(this.deleteDiff);
      this.add(new JSeparator());
      this.add(this.closeViews);
      this.openDiff.setEnabled(true);
      this.closeDiff.setEnabled(false);
      this.closeViews.setEnabled(false);
      this.controller.getWorkspaceTree().addListener(this.workspaceTreeListener);
   }

   private void registerCurrentDiffListener(Diff var1) {
      this.unregisterCurrentDiffListener();
      this.lastSelectedDiff = var1;
      this.lastSelectedDiff.addListener(this.diffListener);
   }

   private void unregisterCurrentDiffListener() {
      if(this.lastSelectedDiff != null) {
         this.lastSelectedDiff.removeListener(this.diffListener);
         this.lastSelectedDiff = null;
      }

   }

   private void updateMenu(Diff var1) {
      this.openDiff.setEnabled(!var1.isLoaded());
      this.closeDiff.setEnabled(var1.isLoaded());
      this.deleteDiff.setEnabled(true);
      HashSet var2 = new HashSet();
      var2.add(var1);
      this.closeViews.setEnabled(this.controller.getOpenViews(var2).size() > 0);
   }

   public void dispose() {
      this.unregisterCurrentDiffListener();
      this.controller.getWorkspaceTree().removeListener(this.workspaceTreeListener);
   }

   // $FF: synthetic method
   static void access$200(NodePopupMenu var0, Diff var1) {
      var0.updateMenu(var1);
   }

   // $FF: synthetic method
   static JMenuItem access$300(NodePopupMenu var0) {
      return var0.openDiff;
   }

   // $FF: synthetic method
   static void access$400(NodePopupMenu var0) {
      var0.unregisterCurrentDiffListener();
   }

   // $FF: synthetic method
   static NodePopupMenu$InternalWorkspaceTreeListener access$500(NodePopupMenu var0) {
      return var0.workspaceTreeListener;
   }

   // $FF: synthetic method
   static WorkspaceTabPanelFunctions access$600(NodePopupMenu var0) {
      return var0.controller;
   }

   // $FF: synthetic method
   static JMenuItem access$700(NodePopupMenu var0) {
      return var0.closeDiff;
   }

   // $FF: synthetic method
   static JMenuItem access$800(NodePopupMenu var0) {
      return var0.deleteDiff;
   }

   // $FF: synthetic method
   static JMenuItem access$900(NodePopupMenu var0) {
      return var0.closeViews;
   }

   // $FF: synthetic method
   static void access$1000(NodePopupMenu var0, Diff var1) {
      var0.registerCurrentDiffListener(var1);
   }
}
