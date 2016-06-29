package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public final class CallGraphNode extends AbstractTreeNode {
   private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
   private final NodePopupMenu popupMenu;
   private final CallGraphsTreeNodeContextPanel component;

   public CallGraphNode(WorkspaceTabPanelFunctions var1, Diff var2) {
      super(var1, var2);
      this.popupMenu = new NodePopupMenu(var1);
      this.component = new CallGraphsTreeNodeContextPanel(this.getDiff(), this.getController());
   }

   protected void createChildren() {
   }

   protected void delete() {
      this.popupMenu.dispose();
      this.component.dipose();
   }

   public void doubleClicked() {
      WorkspaceTabPanelFunctions var1 = this.getController();
      var1.openCallgraphView(var1.getMainWindow(), this.getDiff());
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
      MatchData var1 = this.getDiff().getMatches();
      return String.format("Call Graph (%d/%d)", new Object[]{Integer.valueOf(var1.getSizeOfFunctions(ESide.PRIMARY)), Integer.valueOf(var1.getSizeOfFunctions(ESide.SECONDARY))});
   }
}
