package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;
import javax.swing.tree.TreePath;

class DiffNode$InternalDiffModelListener extends DiffListenerAdapter {
   // $FF: synthetic field
   final DiffNode this$0;

   private DiffNode$InternalDiffModelListener(DiffNode var1) {
      this.this$0 = var1;
   }

   public void loadedDiff(Diff var1) {
      if(!var1.isFunctionDiff()) {
         this.this$0.createChildren();
         this.this$0.getTree().expandPath(new TreePath(this.this$0.getPath()));
      }

   }

   public void removedDiff(Diff var1) {
      if(!var1.isFunctionDiff()) {
         this.this$0.removeFromParent();
         this.this$0.delete();
         this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getRoot().getPath()));
         this.this$0.getTree().updateTree();
      }

   }

   public void unloadedDiff(Diff var1) {
      if(!var1.isFunctionDiff()) {
         this.this$0.deleteChildren();
         this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getPath()));
         this.this$0.getTree().updateTree();
      }

   }

   // $FF: synthetic method
   DiffNode$InternalDiffModelListener(DiffNode var1, DiffNode$1 var2) {
      this(var1);
   }
}
