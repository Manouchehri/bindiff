package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;

public class DeleteFunctionDiffViewAction extends AbstractAction {
   private final AbstractTable table;
   private final int hitRowIndex;

   public DeleteFunctionDiffViewAction(AbstractTable var1, int var2) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
      this.hitRowIndex = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      WorkspaceTabPanelFunctions var2 = this.table.getController();
      Diff var3 = AbstractTable.getRowDiff(this.table, this.hitRowIndex);
      ArrayList var4 = new ArrayList();
      var4.add(var3);
      if(var2.deleteFunctionDiffs(var4)) {
         WorkspaceTree var5 = var2.getWorkspaceTree();
         AllFunctionDiffViewsNode var6;
         if(this.table instanceof FunctionDiffViewsContainerTable) {
            ((FunctionDiffViewsContainerTable)this.table).removeRow(var3);
            var6 = (AllFunctionDiffViewsNode)var5.getModel().getRoot().getChildAt(0);

            for(int var7 = 0; var7 < var6.getChildCount(); ++var7) {
               FunctionDiffViewsNode var8 = (FunctionDiffViewsNode)var6.getChildAt(var7);
               FunctionDiffViewsNodeContextPanel var9 = var8.getComponent();
               FunctionDiffViewsTable var10 = (FunctionDiffViewsTable)var9.getTables().get(0);
               var10.removeRow(var3);
            }
         } else {
            if(!(this.table instanceof FunctionDiffViewsTable)) {
               throw new IllegalArgumentException("Table must be an instance of FunctionDiffViewsContainerTable or FunctionDiffViewsTable.");
            }

            ((FunctionDiffViewsTable)this.table).removeRow(var3);
            var6 = (AllFunctionDiffViewsNode)var5.getModel().getRoot().getChildAt(0);
            FunctionDiffViewsContainerNodeContextPanel var11 = var6.getComponent();
            FunctionDiffViewsContainerTable var12 = (FunctionDiffViewsContainerTable)var11.getTables().get(0);
            var12.removeRow(var3);
         }
      }

   }
}
