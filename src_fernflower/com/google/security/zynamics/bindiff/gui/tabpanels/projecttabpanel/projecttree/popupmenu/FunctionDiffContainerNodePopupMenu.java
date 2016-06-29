package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadFunctionDiffsAction;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.util.Iterator;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffContainerNodePopupMenu extends JPopupMenu {
   public FunctionDiffContainerNodePopupMenu(WorkspaceTabPanelFunctions var1) {
      Preconditions.checkNotNull(var1);
      this.add(GuiUtils.buildMenuItem("Open Function Diffs", new LoadFunctionDiffsAction(var1), this.isOpenDiffsEnabled(var1)));
      this.add(GuiUtils.buildMenuItem("Close Function Diffs", new CloseFunctionDiffsAction(var1), this.isCloseDiffsEnabled(var1)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(var1), this.isCloseViewsEnabled(var1)));
   }

   private boolean isCloseDiffsEnabled(WorkspaceTabPanelFunctions var1) {
      Iterator var2 = var1.getWorkspace().getDiffList(true).iterator();

      Diff var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (Diff)var2.next();
      } while(!var3.isLoaded());

      return true;
   }

   private boolean isCloseViewsEnabled(WorkspaceTabPanelFunctions var1) {
      TabPanelManager var2 = var1.getMainWindow().getController().getTabPanelManager();
      return var2.getViewTabPanels(true).size() > 0;
   }

   private boolean isOpenDiffsEnabled(WorkspaceTabPanelFunctions var1) {
      Iterator var2 = var1.getWorkspace().getDiffList(true).iterator();

      Diff var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (Diff)var2.next();
      } while(var3.isLoaded());

      return true;
   }
}
