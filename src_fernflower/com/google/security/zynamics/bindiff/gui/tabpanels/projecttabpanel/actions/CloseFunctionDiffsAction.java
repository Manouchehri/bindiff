package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.tree.TreePath;

public class CloseFunctionDiffsAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;

   public CloseFunctionDiffsAction(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      HashSet var2 = new HashSet();
      var2.addAll(this.controller.getWorkspace().getDiffList(true));
      this.controller.closeDiffs(var2);
      WorkspaceTree var3 = this.controller.getWorkspaceTree();
      RootNode var4 = var3.getModel().getRoot();
      AllFunctionDiffViewsNode var5 = (AllFunctionDiffViewsNode)var4.getChildAt(0);
      var5.deleteChildren();
      var3.setSelectionPath(new TreePath(var5.getPath()));
      var3.updateTree();
   }
}
