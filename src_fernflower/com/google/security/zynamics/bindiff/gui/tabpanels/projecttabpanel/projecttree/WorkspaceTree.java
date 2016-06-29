package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalWorkspaceModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.NodeRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class WorkspaceTree extends JTree {
   private final JPopupMenu popup;
   private final WorkspaceTreeModel workspaceTreeModel;
   private final RootNode rootNode;
   private final WorkspaceTabPanelFunctions controller;
   private final WorkspaceTree$InternalTreeSelectionListener treeSelectionListener = new WorkspaceTree$InternalTreeSelectionListener(this, (WorkspaceTree$1)null);
   private final WorkspaceTree$InternalMouseListener mouseListener = new WorkspaceTree$InternalMouseListener(this, (WorkspaceTree$1)null);
   private final WorkspaceTree$InternalWorkspaceModelListener mainWindowModelListener = new WorkspaceTree$InternalWorkspaceModelListener(this, (WorkspaceTree$1)null);
   private final ListenerProvider listeners = new ListenerProvider();

   public WorkspaceTree(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.controller.setWorkspaceTree(this);
      this.rootNode = new RootNode(this, this.controller);
      this.popup = new NoNodePopupMenu(this.controller);
      this.setRootVisible(false);
      this.workspaceTreeModel = new WorkspaceTreeModel(this, this.rootNode);
      this.setModel(this.workspaceTreeModel);
      this.setCellRenderer(new NodeRenderer());
      DefaultTreeSelectionModel var2 = new DefaultTreeSelectionModel();
      var2.setSelectionMode(1);
      this.setSelectionModel(var2);
      this.setBorder(new EmptyBorder(2, 4, 2, 2));
      this.addTreeSelectionListener(this.treeSelectionListener);
      this.addMouseListener(this.mouseListener);
      this.controller.getWorkspace().addListener(this.mainWindowModelListener);
   }

   public static boolean hasFunctionDiffRelatives(WorkspaceTree var0, Diff var1) {
      if(!var1.isFunctionDiff()) {
         return false;
      } else {
         TreeNode var2 = var0.getModel().getRoot().getChildAt(0);
         if(var2.isLeaf()) {
            return false;
         } else {
            File var3 = var1.getMatchesDatabase().getParentFile();

            for(int var4 = 0; var4 < var2.getChildCount(); ++var4) {
               FunctionDiffViewsNode var5 = (FunctionDiffViewsNode)var2.getChildAt(var4);
               FunctionDiffViewsNodeContextPanel var6 = var5.getComponent();
               FunctionDiffViewsTable var7 = (FunctionDiffViewsTable)var6.getTables().get(0);
               if(var7.getRowCount() > 0 && var3.equals(AbstractTable.getRowDiff(var7, 0).getMatchesDatabase().getParentFile())) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   private void handleDoubleClick(MouseEvent var1) {
      AbstractTreeNode var2 = (AbstractTreeNode)TreeHelpers.getNodeAt(this, var1.getX(), var1.getY());
      if(var2 != null) {
         var2.doubleClicked();
      }
   }

   private void nodeSelected(AbstractTreeNode var1) {
      this.controller.setTreeNodeContextComponent(var1.getComponent());
   }

   private void showPopupMenu(MouseEvent var1) {
      AbstractTreeNode var2 = (AbstractTreeNode)TreeHelpers.getNodeAt(this, var1.getX(), var1.getY());
      if(var2 != null) {
         this.setSelectionPath(new TreePath(var2.getPath()));
         JPopupMenu var3 = var2.getPopupMenu();
         if(var3 != null) {
            var3.show(this, var1.getX(), var1.getY());
         }
      } else {
         this.popup.show(this, var1.getX(), var1.getY());
      }

   }

   public void addListener(IWorkspaceTreeListener var1) {
      this.listeners.addListener(var1);
   }

   public void closeFunctionDiffs() {
      AllFunctionDiffViewsNode var1 = (AllFunctionDiffViewsNode)this.rootNode.getFirstChild();
      var1.deleteChildren();
      this.updateTree();
   }

   public void dispose() {
      this.removeTreeSelectionListener(this.treeSelectionListener);
      this.removeMouseListener(this.mouseListener);
      this.controller.getWorkspace().removeListener(this.mainWindowModelListener);
   }

   public WorkspaceTreeModel getModel() {
      return this.workspaceTreeModel;
   }

   public void removeListener(IWorkspaceTreeListener var1) {
      this.listeners.removeListener(var1);
   }

   public void updateTree() {
      this.getModel().nodeStructureChanged(this.rootNode);
   }

   // $FF: synthetic method
   static void access$300(WorkspaceTree var0, MouseEvent var1) {
      var0.showPopupMenu(var1);
   }

   // $FF: synthetic method
   static void access$400(WorkspaceTree var0, MouseEvent var1) {
      var0.handleDoubleClick(var1);
   }

   // $FF: synthetic method
   static void access$500(WorkspaceTree var0, AbstractTreeNode var1) {
      var0.nodeSelected(var1);
   }

   // $FF: synthetic method
   static RootNode access$600(WorkspaceTree var0) {
      return var0.rootNode;
   }

   // $FF: synthetic method
   static ListenerProvider access$700(WorkspaceTree var0) {
      return var0.listeners;
   }
}
