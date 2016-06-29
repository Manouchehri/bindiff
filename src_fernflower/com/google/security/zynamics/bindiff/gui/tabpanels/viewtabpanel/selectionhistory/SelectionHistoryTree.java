package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeCellRenderer;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.awt.event.MouseEvent;
import javax.swing.JTree;

public class SelectionHistoryTree extends JTree {
   private final SelectionHistoryTree$InternalMouseListener mouseListener = new SelectionHistoryTree$InternalMouseListener(this, (SelectionHistoryTree$1)null);

   public SelectionHistoryTree(SelectionHistoryRootNode var1) {
      super(var1);
      this.addMouseListener(this.mouseListener);
      this.setCellRenderer(new SelectionHistoryTreeCellRenderer(var1.getGraph()));
   }

   private void handleMouseEvent(MouseEvent var1) {
      AbstractSelectionHistoryTreeNode var2 = (AbstractSelectionHistoryTreeNode)TreeHelpers.getNodeAt(this, var1.getX(), var1.getY());
      if(var2 != null) {
         var2.handleMouseEvent(var1);
      }
   }

   public void dispose() {
      this.removeMouseListener(this.mouseListener);
   }

   // $FF: synthetic method
   static void access$100(SelectionHistoryTree var0, MouseEvent var1) {
      var0.handleMouseEvent(var1);
   }
}
