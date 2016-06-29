package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.CallGraphNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$InternalDiffModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.MatchedFunctionViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.UnmatchedFunctionViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class DiffNode extends AbstractTreeNode {
   private static final ImageIcon ICON_UNLOADED = ImageUtils.getImageIcon("data/treeicons/diff-unloaded.png");
   private static final ImageIcon ICON_LOADED = ImageUtils.getImageIcon("data/treeicons/diff.png");
   private static final ImageIcon ICON_MISSING_DIFF_BINARAY = ImageUtils.getImageIcon("data/treeicons/missing-diff-db.png");
   private final DiffNode$InternalDiffModelListener diffModelListener = new DiffNode$InternalDiffModelListener(this, (DiffNode$1)null);
   private final WorkspaceTabPanelFunctions controller;
   private final NodePopupMenu popupMenu;
   private final DiffTreeNodeContextPanel component;

   public DiffNode(Diff var1, WorkspaceTabPanelFunctions var2) {
      super(var2, var1);
      this.controller = var2;
      this.popupMenu = new NodePopupMenu(var2);
      this.component = new DiffTreeNodeContextPanel(var1, var2);
      var1.addListener(this.diffModelListener);
   }

   protected void createChildren() {
      this.add(new CallGraphNode(this.getController(), this.getDiff()));
      this.add(new MatchedFunctionViewsNode(this.getController(), this.getDiff()));
      this.add(new UnmatchedFunctionViewsNode(this.getController(), this.getDiff(), ESide.PRIMARY));
      this.add(new UnmatchedFunctionViewsNode(this.getController(), this.getDiff(), ESide.SECONDARY));
   }

   protected void delete() {
      this.getDiff().removeListener(this.diffModelListener);
      this.popupMenu.dispose();
      this.deleteChildren();
   }

   public void doubleClicked() {
      this.controller.loadDiff(this.getDiff());
   }

   public Component getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return this.getDiff().getMatchesDatabase().exists() && this.getDiff().getExportFile(ESide.PRIMARY).exists() && this.getDiff().getExportFile(ESide.SECONDARY).exists()?(this.getDiff().isLoaded()?ICON_LOADED:ICON_UNLOADED):ICON_MISSING_DIFF_BINARAY;
   }

   public JPopupMenu getPopupMenu() {
      return this.popupMenu;
   }

   public String toString() {
      return this.getDiff().getMatchesDatabase().getParentFile().getName();
   }
}
