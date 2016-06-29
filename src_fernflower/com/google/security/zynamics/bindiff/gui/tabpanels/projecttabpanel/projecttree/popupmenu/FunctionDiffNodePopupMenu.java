package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteFunctionDiffViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffNodePopupMenu extends JPopupMenu {
   public FunctionDiffNodePopupMenu(FunctionDiffViewsNode var1) {
      FunctionDiffViewsNodeContextPanel var2 = var1.getComponent();
      FunctionDiffViewsTable var3 = (FunctionDiffViewsTable)var2.getTables().get(0);
      this.add(GuiUtils.buildMenuItem("Delete Function Diffs", new DeleteFunctionDiffViewsAction(var1)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(var3), this.isCloseViewsEnabled(var3)));
   }

   private boolean isCloseViewsEnabled(FunctionDiffViewsTable var1) {
      WorkspaceTabPanelFunctions var2 = var1.getController();
      TabPanelManager var3 = var2.getMainWindow().getController().getTabPanelManager();
      HashSet var4 = new HashSet();
      Iterator var5 = var3.getViewTabPanels(true).iterator();

      while(var5.hasNext()) {
         ViewTabPanel var6 = (ViewTabPanel)var5.next();
         var4.add(var6.getDiff());
      }

      for(int var7 = 0; var7 < var1.getRowCount(); ++var7) {
         if(var4.contains(AbstractTable.getRowDiff(var1, var7))) {
            return true;
         }
      }

      return false;
   }
}
