package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode$6;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class CombinedCallGraphBaseTreeNode extends AbstractBaseTreeNode {
   private static final Icon CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
   private List functionNodes = new ArrayList();
   private CombinedDiffNode lastSelectedTreeNode;

   public CombinedCallGraphBaseTreeNode(CombinedCallGraphRootTreeNode var1) {
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
            var4.add((CombinedCallGraphFunctionTreeNode)this.getChildAt(var5));
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
               var4.add((CombinedCallGraphFunctionTreeNode)var7);
            }
         } else {
            var2.search((List)null);
         }
      }

      ArrayList var10 = new ArrayList();
      Iterator var11 = var4.iterator();

      while(true) {
         while(true) {
            CombinedCallGraphFunctionTreeNode var8;
            do {
               if(!var11.hasNext()) {
                  var11 = this.getRootNode().getSorter().getCombinedFunctionTreeNodeComparatorList().iterator();

                  while(var11.hasNext()) {
                     Comparator var12 = (Comparator)var11.next();
                     Collections.sort(var10, var12);
                  }

                  var11 = var10.iterator();

                  while(var11.hasNext()) {
                     var8 = (CombinedCallGraphFunctionTreeNode)var11.next();
                     this.add(var8);
                  }

                  this.getTree().getModel().nodeStructureChanged(this);
                  this.getTree().updateUI();
                  return;
               }

               var8 = (CombinedCallGraphFunctionTreeNode)var11.next();
            } while(!var3.filterRawCombinedFunction(var8.getCombinedFunction()));

            if(!var1 && !"".equals(var2.getSearchString())) {
               if(var2.isSearchHit(var8.getCombinedDiffNode())) {
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
         CombinedDiffNode var2 = (CombinedDiffNode)var1.next();
         this.functionNodes.add(new CombinedCallGraphFunctionTreeNode(this.getRootNode(), var2));
      }

      this.updateTreeNodes(false);
   }

   public Icon getIcon() {
      return CALLGRAPH_ICON;
   }

   public CombinedDiffNode getLastSelectedGraphNode() {
      return this.lastSelectedTreeNode;
   }

   public JPopupMenu getPopupMenu() {
      JPopupMenu var1 = new JPopupMenu();
      JMenuItem var2 = new JMenuItem(new CombinedCallGraphBaseTreeNode$1(this, "Copy Primary Image Name"));
      JMenuItem var3 = new JMenuItem(new CombinedCallGraphBaseTreeNode$2(this, "Copy Secondary Image Name"));
      JMenuItem var4 = new JMenuItem(new CombinedCallGraphBaseTreeNode$3(this, "Copy Primary Image Hash"));
      JMenuItem var5 = new JMenuItem(new CombinedCallGraphBaseTreeNode$4(this, "Copy Secondary Image Hash"));
      JMenuItem var6 = new JMenuItem(new CombinedCallGraphBaseTreeNode$5(this, "Copy Primary IDB Name"));
      JMenuItem var7 = new JMenuItem(new CombinedCallGraphBaseTreeNode$6(this, "Copy Secondary IDB Name"));
      var1.add(var2);
      var1.add(var4);
      var1.add(var6);
      var1.add(new JSeparator());
      var1.add(var3);
      var1.add(var5);
      var1.add(var7);
      return var1;
   }

   public CombinedCallGraphRootTreeNode getRootNode() {
      return (CombinedCallGraphRootTreeNode)this.getAbstractRootNode();
   }

   public void setLastSelectedGraphNode(CombinedDiffNode var1) {
      this.lastSelectedTreeNode = var1;
   }

   public String toString() {
      return String.format("%s (%d / %d)", new Object[]{"Combined Call Graph", Integer.valueOf(this.getChildCount()), Integer.valueOf(this.functionNodes.size())});
   }

   // $FF: synthetic method
   static Diff access$000(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$100(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$200(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$300(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$400(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }

   // $FF: synthetic method
   static Diff access$500(CombinedCallGraphBaseTreeNode var0) {
      return var0.getDiff();
   }
}
