package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.FunctionDiffNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.io.File;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class FunctionDiffViewsNode extends AbstractTreeNode {
   private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/function-diff-views.png");
   private final FunctionDiffViewsNodeContextPanel component;
   private final File viewDirectory;

   public FunctionDiffViewsNode(WorkspaceTabPanelFunctions var1, File var2, List var3) {
      super(var1, (Diff)null);
      this.viewDirectory = (File)Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.component = new FunctionDiffViewsNodeContextPanel(this.getController(), var3);
   }

   protected void createChildren() {
   }

   public void delete() {
      this.component.dispose();
   }

   public void doubleClicked() {
   }

   public FunctionDiffViewsNodeContextPanel getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return ICON;
   }

   public JPopupMenu getPopupMenu() {
      return new FunctionDiffNodePopupMenu(this);
   }

   public File getViewDirectory() {
      return this.viewDirectory;
   }

   public String toString() {
      return String.format("%s (%d)", new Object[]{this.viewDirectory.getName(), Integer.valueOf(this.component.getFunctionViewsTableModel().getRowCount())});
   }
}
