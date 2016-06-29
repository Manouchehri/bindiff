package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.util.Iterator;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class WorkspaceTree$InternalTreeSelectionListener implements TreeSelectionListener {
   private DefaultMutableTreeNode lastNode;
   // $FF: synthetic field
   final WorkspaceTree this$0;

   private WorkspaceTree$InternalTreeSelectionListener(WorkspaceTree var1) {
      this.this$0 = var1;
      this.lastNode = null;
   }

   public void valueChanged(TreeSelectionEvent var1) {
      AbstractTreeNode var2 = (AbstractTreeNode)this.this$0.getLastSelectedPathComponent();
      if(var2 != null) {
         WorkspaceTree.access$500(this.this$0, var2);
         this.lastNode = var2;
      } else if(this.lastNode == null || !TreeHelpers.isAncestor(this.lastNode, WorkspaceTree.access$600(this.this$0))) {
         WorkspaceTree.access$500(this.this$0, WorkspaceTree.access$600(this.this$0));
      }

      Iterator var3 = WorkspaceTree.access$700(this.this$0).iterator();

      while(var3.hasNext()) {
         IWorkspaceTreeListener var4 = (IWorkspaceTreeListener)var3.next();
         var4.changedSelection((AbstractTreeNode)(var2 != null?var2:WorkspaceTree.access$600(this.this$0)));
      }

   }

   // $FF: synthetic method
   WorkspaceTree$InternalTreeSelectionListener(WorkspaceTree var1, WorkspaceTree$1 var2) {
      this(var1);
   }
}
