package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public abstract class AbstractTreeNode extends DefaultMutableTreeNode {
   private AbstractRootTreeNode rootNode;

   public AbstractTreeNode(AbstractRootTreeNode var1) {
      Preconditions.checkArgument(var1 != null || this instanceof AbstractRootTreeNode, "Root node cannot be null for non-root nodes");
      this.rootNode = var1;
   }

   protected void delete() {
      for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
         AbstractTreeNode var2 = (AbstractTreeNode)this.getChildAt(var1);
         var2.delete();
         var2 = null;
      }

      this.removeAllChildren();
      this.rootNode = null;
   }

   protected AbstractRootTreeNode getAbstractRootNode() {
      return this.rootNode;
   }

   protected Diff getDiff() {
      return this.rootNode.getDiff();
   }

   protected GraphNodeMultiFilter getFilter() {
      return this.getRootNode().getFilter();
   }

   protected FunctionMatchData getFunctionMatch() {
      return this.rootNode.getFunctionMatch();
   }

   protected BinDiffGraph getGraph() {
      return this.getTree().getGraph();
   }

   protected TreeNodeSearcher getSearcher() {
      return this.rootNode.getSearcher();
   }

   protected TreeNodeMultiSorter getSorter() {
      return this.getRootNode().getSorter();
   }

   protected AbstractGraphNodeTree getTree() {
      return this.rootNode.getTree();
   }

   protected ViewData getView() {
      return this.rootNode.getView();
   }

   public void createChildren() {
   }

   public abstract Icon getIcon();

   public JPopupMenu getPopupMenu() {
      return null;
   }

   public AbstractRootTreeNode getRootNode() {
      return this.getAbstractRootNode();
   }

   public String getTooltipText() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 3 && var1.isPopupTrigger()) {
         JPopupMenu var2 = this.getPopupMenu();
         if(var2 != null) {
            var2.show(this.getTree(), var1.getX(), var1.getY());
         }

      }
   }

   public boolean isSelected() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public abstract String toString();
}
