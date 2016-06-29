package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SingleCallGraphBaseTreeNode extends AbstractBaseTreeNode {
   private static final Icon CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
   private List functionNodes = new ArrayList();
   private SingleDiffNode lastSelectedTreeNode;

   public SingleCallGraphBaseTreeNode(SingleCallGraphRootTreeNode var1) {
      super(var1);
      this.createChildren();
   }

   protected void delete() {
      super.delete();
      this.functionNodes.clear();
      this.functionNodes = null;
      this.lastSelectedTreeNode = null;
   }

   protected void updateTreeNodes(boolean var1) {
      TreeNodeSearcher var2 = this.getSearcher();
      GraphNodeMultiFilter var3 = this.getFilter();
      ArrayList var4 = new ArrayList();
      if(var2.getUseTemporaryResults() && !"".equals(var2.getSearchString())) {
         for(int var5 = 1; var5 < this.getChildCount(); ++var5) {
            var4.add((SingleCallGraphFunctionTreeNode)this.getChildAt(var5));
         }
      } else {
         var4.addAll(this.functionNodes);
      }

      this.removeAllChildren();
      new ArrayList();
      if(var1) {
         if(!"".equals(var2.getSearchString())) {
            List var9 = var2.search((List)var4);
            var4.clear();
            Iterator var6 = var9.iterator();

            while(var6.hasNext()) {
               ISearchableTreeNode var7 = (ISearchableTreeNode)var6.next();
               var4.add((SingleCallGraphFunctionTreeNode)var7);
            }
         } else {
            var2.search((List)null);
         }
      }

      ArrayList var10 = new ArrayList();
      Iterator var11 = var4.iterator();

      while(true) {
         while(true) {
            SingleCallGraphFunctionTreeNode var8;
            do {
               if(!var11.hasNext()) {
                  var11 = this.getRootNode().getSorter().getSingleFunctionTreeNodeComparatorList().iterator();

                  while(var11.hasNext()) {
                     Comparator var12 = (Comparator)var11.next();
                     Collections.sort(var10, var12);
                  }

                  var11 = var10.iterator();

                  while(var11.hasNext()) {
                     var8 = (SingleCallGraphFunctionTreeNode)var11.next();
                     this.add(var8);
                  }

                  this.getTree().getModel().nodeStructureChanged(this);
                  this.getTree().updateUI();
                  return;
               }

               var8 = (SingleCallGraphFunctionTreeNode)var11.next();
            } while(!var3.filterRawFunction(var8.getFunction()));

            if(!var1 && !"".equals(var2.getSearchString())) {
               if(var2.isSearchHit(var8.getSingleDiffNode())) {
                  var10.add(var8);
               }
            } else {
               var10.add(var8);
            }
         }
      }
   }

   public void createChildren() {
      this.functionNodes.clear();
      Iterator var1 = this.getRootNode().getGraph().getNodes().iterator();

      while(var1.hasNext()) {
         SingleDiffNode var2 = (SingleDiffNode)var1.next();
         this.functionNodes.add(new SingleCallGraphFunctionTreeNode(this.getRootNode(), var2));
      }

      this.updateTreeNodes(false);
   }

   public Icon getIcon() {
      return CALLGRAPH_ICON;
   }

   public SingleDiffNode getLastSelectedGraphNode() {
      return this.lastSelectedTreeNode;
   }

   public JPopupMenu getPopupMenu() {
      JPopupMenu var1 = new JPopupMenu();
      ESide var2 = this.getRootNode().getSide();
      JMenuItem var3 = new JMenuItem(new SingleCallGraphBaseTreeNode$1(this, "Copy Image Name", var2));
      JMenuItem var4 = new JMenuItem(new SingleCallGraphBaseTreeNode$2(this, "Copy Image Hash", var2));
      JMenuItem var5 = new JMenuItem(new SingleCallGraphBaseTreeNode$3(this, "Copy IDB Name", var2));
      var1.add(var3);
      var1.add(var4);
      var1.add(var5);
      return var1;
   }

   public SingleCallGraphRootTreeNode getRootNode() {
      return (SingleCallGraphRootTreeNode)this.getAbstractRootNode();
   }

   public String getTooltipText() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         this.getPopupMenu().show(this.getTree(), var1.getX(), var1.getY());
      }

   }

   public boolean isSelected() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public void setLastSelectedGraphNode(SingleDiffNode var1) {
      this.lastSelectedTreeNode = var1;
   }

   public String toString() {
      return String.format("%s (%d / %d)", new Object[]{"Call Graph", Integer.valueOf(this.getChildCount()), Integer.valueOf(this.functionNodes.size())});
   }

   // $FF: synthetic method
   static Diff access$000(SingleCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$100(SingleCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$200(SingleCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }
}
