package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import javax.swing.tree.DefaultTreeModel;

public final class WorkspaceTreeModel extends DefaultTreeModel {
   private final RootNode rootNode;
   private final WorkspaceTree tree;

   public WorkspaceTreeModel(WorkspaceTree var1, RootNode var2) {
      super(var2);
      if(var1 == null) {
         throw new IllegalArgumentException("Project tree cannot be null.)");
      } else {
         this.tree = var1;
         this.rootNode = var2;
      }
   }

   public RootNode getRoot() {
      return this.rootNode;
   }

   public WorkspaceTree getTree() {
      return this.tree;
   }
}
