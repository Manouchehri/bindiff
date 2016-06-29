package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public abstract class AbstractSelectionHistoryTreeNode extends DefaultMutableTreeNode {
   public AbstractSelectionHistoryTreeNode(String var1) {
      super(var1);
   }

   public ViewTabPanelFunctions getController() {
      return this.getRootNode().getController();
   }

   public abstract Icon getIcon();

   public abstract JPopupMenu getPopupMenu();

   public SelectionHistoryRootNode getRootNode() {
      return (SelectionHistoryRootNode)this.getRoot();
   }

   public JTree getTree() {
      return this.getRootNode().getTree();
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 3 && var1.isPopupTrigger()) {
         JPopupMenu var2 = this.getPopupMenu();
         if(var2 != null) {
            var2.show(this.getTree(), var1.getX(), var1.getY());
         }

      }
   }
}
