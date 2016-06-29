package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DefaultTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public final class RootNode extends AbstractTreeNode {
   private Workspace workspace = null;
   private final WorkspaceTree tree;
   private final DefaultTreeNodeContextPanel component = new DefaultTreeNodeContextPanel();

   public RootNode(WorkspaceTree var1, WorkspaceTabPanelFunctions var2) {
      super(var2, (Diff)null);
      this.tree = (WorkspaceTree)Preconditions.checkNotNull(var1);
      this.createChildren();
   }

   protected void createChildren() {
      if(this.workspace != null) {
         this.add(new AllFunctionDiffViewsNode(this.getController()));
         Iterator var1 = this.workspace.getDiffList().iterator();

         while(var1.hasNext()) {
            Diff var2 = (Diff)var1.next();
            if(var2 == null) {
               throw new RuntimeException("Diff cannot be null.");
            }

            if(!var2.isFunctionDiff()) {
               this.add(new DiffNode(var2, this.getController()));
            }
         }
      }

   }

   protected void delete() {
      this.deleteChildren();
   }

   protected WorkspaceTree getTree() {
      return this.tree;
   }

   public void addDiff(Diff var1) {
      if(!var1.isFunctionDiff()) {
         this.add(new DiffNode(var1, this.getController()));
      }

   }

   public void doubleClicked() {
   }

   public Component getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return null;
   }

   public JPopupMenu getPopupMenu() {
      return null;
   }

   public void setWorkspace(Workspace var1) {
      this.workspace = var1;
      this.createChildren();
   }

   public String toString() {
      return "";
   }
}
