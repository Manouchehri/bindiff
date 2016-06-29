package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import javax.swing.tree.TreePath;

class WorkspaceTree$InternalWorkspaceModelListener extends WorkspaceAdapter {
   // $FF: synthetic field
   final WorkspaceTree this$0;

   private WorkspaceTree$InternalWorkspaceModelListener(WorkspaceTree var1) {
      this.this$0 = var1;
   }

   public void addedDiff(Diff var1) {
      if(!var1.isFunctionDiff()) {
         WorkspaceTree.access$600(this.this$0).addDiff(var1);
         this.this$0.updateTree();
      } else {
         AllFunctionDiffViewsNode var2 = (AllFunctionDiffViewsNode)WorkspaceTree.access$600(this.this$0).getFirstChild();
         ((FunctionDiffViewsContainerTable)var2.getComponent().getTables().get(0)).addRow(var1);
         TreePath var3 = new TreePath(var2.getPath());
         boolean var4 = this.this$0.isExpanded(var3);
         TreePath var5 = this.this$0.getSelectionPath();
         var2.addDiff(var1);
         this.this$0.updateTree();

         for(int var6 = 0; var6 < var2.getChildCount(); ++var6) {
            FunctionDiffViewsNode var7 = (FunctionDiffViewsNode)var2.getChildAt(var6);
            if(var7.getViewDirectory().equals(var1.getMatchesDatabase().getParentFile())) {
               ((FunctionDiffViewsTable)var7.getComponent().getTables().get(0)).addRow(var1);
               break;
            }
         }

         if(var4) {
            this.this$0.expandPath(new TreePath(var2.getPath()));
         }

         this.this$0.setSelectionPath(var5);
      }

   }

   public void closedWorkspace() {
      WorkspaceTree.access$600(this.this$0).deleteChildren();
      TreePath var1 = new TreePath(WorkspaceTree.access$600(this.this$0).getPath());
      this.this$0.getSelectionModel().setSelectionPath(var1);
      this.this$0.updateTree();
   }

   public void loadedWorkspace(Workspace var1) {
      WorkspaceTree.access$600(this.this$0).setWorkspace(var1);
      this.this$0.getModel().nodeStructureChanged(WorkspaceTree.access$600(this.this$0));
   }

   public void removedDiff(Diff var1) {
      if(var1.isFunctionDiff()) {
         AllFunctionDiffViewsNode var2 = (AllFunctionDiffViewsNode)WorkspaceTree.access$600(this.this$0).getFirstChild();
         FunctionDiffViewsContainerTable var3 = (FunctionDiffViewsContainerTable)var2.getComponent().getTables().get(0);
         var3.removeRow(var1);

         int var4;
         FunctionDiffViewsNode var5;
         for(var4 = 0; var4 < var2.getChildCount(); ++var4) {
            var5 = (FunctionDiffViewsNode)var2.getChildAt(var4);
            if(var5.getViewDirectory().equals(var1.getMatchesDatabase().getParentFile())) {
               ((FunctionDiffViewsTable)var5.getComponent().getTables().get(0)).removeRow(var1);
               break;
            }
         }

         for(var4 = 0; var4 < var2.getChildCount(); ++var4) {
            var5 = (FunctionDiffViewsNode)var2.getChildAt(var4);
            if(var5.getViewDirectory().equals(var1.getMatchesDatabase().getParentFile())) {
               ((FunctionDiffViewsTable)var5.getComponent().getTables().get(0)).addRow(var1);
               break;
            }
         }
      }

   }

   // $FF: synthetic method
   WorkspaceTree$InternalWorkspaceModelListener(WorkspaceTree var1, WorkspaceTree$1 var2) {
      this(var1);
   }
}
