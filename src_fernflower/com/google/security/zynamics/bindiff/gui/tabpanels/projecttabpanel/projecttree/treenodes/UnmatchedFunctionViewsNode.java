package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.UnmatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class UnmatchedFunctionViewsNode extends AbstractTreeNode {
   private static final ImageIcon PRIMARY_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private static final ImageIcon SECONDRAY_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
   private final NodePopupMenu popupMenu;
   private final ESide side;
   private final UnmatchedFunctionsTreeNodeContextPanel component;

   public UnmatchedFunctionViewsNode(WorkspaceTabPanelFunctions var1, Diff var2, ESide var3) {
      super(var1, var2);
      this.side = var3;
      this.popupMenu = new NodePopupMenu(var1);
      this.component = new UnmatchedFunctionsTreeNodeContextPanel(var2, this.getController(), var3);
   }

   protected void createChildren() {
   }

   protected void delete() {
      this.popupMenu.dispose();
   }

   public void doubleClicked() {
   }

   public Component getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return this.side == ESide.PRIMARY?PRIMARY_ICON:SECONDRAY_ICON;
   }

   public JPopupMenu getPopupMenu() {
      return this.popupMenu;
   }

   public String toString() {
      MatchData var1 = this.getDiff().getMatches();
      int var2 = var1.getSizeOfUnmatchedFunctions(this.side);
      int var3 = var1.getSizeOfFunctions(this.side);
      return this.side == ESide.PRIMARY?String.format("Primary Unmatched Functions (%d/%d)", new Object[]{Integer.valueOf(var2), Integer.valueOf(var3)}):String.format("Secondary Unmatched Functions (%d/%d)", new Object[]{Integer.valueOf(var2), Integer.valueOf(var3)});
   }
}
