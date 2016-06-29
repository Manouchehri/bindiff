package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;

public class DeleteFunctionDiffViewsAction extends AbstractAction {
   private final FunctionDiffViewsNode viewsNode;

   public DeleteFunctionDiffViewsAction(FunctionDiffViewsNode var1) {
      this.viewsNode = (FunctionDiffViewsNode)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      FunctionDiffViewsNodeContextPanel var2 = this.viewsNode.getComponent();
      FunctionDiffViewsTable var3 = (FunctionDiffViewsTable)var2.getTables().get(0);
      WorkspaceTabPanelFunctions var4 = var3.getController();
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var3.getRowCount(); ++var6) {
         var5.add(AbstractTable.getRowDiff(var3, var6));
      }

      var4.deleteFunctionDiffs(var5);

      try {
         if(this.viewsNode.getViewDirectory().exists()) {
            CFileUtils.deleteDirectory(this.viewsNode.getViewDirectory());
         }
      } catch (IOException var7) {
         Logger.logException(var7, "Couldn\'t delete function diff\'s directory.");
         CMessageBox.showError(var4.getMainWindow(), "Couldn\'t delete function diff\'s directory.");
      }

   }
}
