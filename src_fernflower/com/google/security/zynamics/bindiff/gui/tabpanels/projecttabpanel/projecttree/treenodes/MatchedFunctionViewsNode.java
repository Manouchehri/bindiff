package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class MatchedFunctionViewsNode extends AbstractTreeNode {
   private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
   private NodePopupMenu popupMenu;
   private final MatchedFunctionsTreeNodeContextPanel component;

   public MatchedFunctionViewsNode(WorkspaceTabPanelFunctions var1, Diff var2) {
      super(var1, var2);
      this.popupMenu = new NodePopupMenu(var1);
      this.component = new MatchedFunctionsTreeNodeContextPanel(var1, var2);
   }

   protected void createChildren() {
   }

   protected void delete() {
      this.component.dispose();
      this.popupMenu.dispose();
      this.popupMenu = null;
   }

   public void doubleClicked() {
   }

   public Component getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return ICON;
   }

   public JPopupMenu getPopupMenu() {
      return this.popupMenu;
   }

   public String toString() {
      return String.format("Matched Functions (%d)", new Object[]{Integer.valueOf(this.getDiff().getMatches().getSizeOfMatchedFunctions())});
   }
}
