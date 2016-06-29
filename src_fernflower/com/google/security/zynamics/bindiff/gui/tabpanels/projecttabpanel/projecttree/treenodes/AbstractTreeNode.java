package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public abstract class AbstractTreeNode extends DefaultMutableTreeNode {
   private final WorkspaceTabPanelFunctions controller;
   private final Diff diff;

   public AbstractTreeNode(WorkspaceTabPanelFunctions var1, Diff var2) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.diff = var2;
   }

   protected abstract void createChildren();

   protected abstract void delete();

   protected WorkspaceTabPanelFunctions getController() {
      return this.controller;
   }

   protected WorkspaceTree getTree() {
      return this.controller.getWorkspaceTree();
   }

   protected WorkspaceTreeModel getTreeModel() {
      return this.controller.getWorkspaceTree().getModel();
   }

   public void deleteChildren() {
      for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
         AbstractTreeNode var2 = (AbstractTreeNode)this.getChildAt(var1);
         var2.delete();
      }

      this.removeAllChildren();
   }

   public abstract void doubleClicked();

   public abstract Component getComponent();

   public Diff getDiff() {
      return this.diff;
   }

   public abstract Icon getIcon();

   public abstract JPopupMenu getPopupMenu();

   public RootNode getRoot() {
      return this.controller.getWorkspaceTree().getModel().getRoot();
   }

   public abstract String toString();
}
