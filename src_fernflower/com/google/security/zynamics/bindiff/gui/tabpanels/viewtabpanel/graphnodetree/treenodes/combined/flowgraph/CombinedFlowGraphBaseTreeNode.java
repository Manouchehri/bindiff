package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
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

public class CombinedFlowGraphBaseTreeNode extends AbstractBaseTreeNode {
   private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private final IMatchesChangeListener matchesChangeListener = new CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, (CombinedFlowGraphBaseTreeNode$1)null);
   private final List basicblockTreeNodes = new ArrayList();
   private CombinedDiffNode lastSelectedTreeNode;

   public CombinedFlowGraphBaseTreeNode(CombinedFlowGraphRootTreeNode var1) {
      super(var1);
      this.createChildren();
      this.getDiff().getMatches().addListener(this.matchesChangeListener);
   }

   protected void delete() {
      this.getDiff().getMatches().removeListener(this.matchesChangeListener);
      super.delete();
   }

   protected void updateTreeNodes(boolean var1) {
      TreeNodeSearcher var2 = this.getSearcher();
      GraphNodeMultiFilter var3 = this.getFilter();
      ArrayList var4 = new ArrayList();
      if(var2.getUseTemporaryResults() && !"".equals(var2.getSearchString())) {
         for(int var5 = 0; var5 < this.getChildCount(); ++var5) {
            var4.add((CombinedFlowGraphBasicBlockTreeNode)this.getChildAt(var5));
         }
      } else {
         var4.addAll(this.basicblockTreeNodes);
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
               var4.add((CombinedFlowGraphBasicBlockTreeNode)var7);
            }
         } else {
            var2.search((List)null);
         }
      }

      ArrayList var10 = new ArrayList();
      Iterator var11 = var4.iterator();

      while(true) {
         while(true) {
            CombinedFlowGraphBasicBlockTreeNode var8;
            do {
               if(!var11.hasNext()) {
                  var11 = this.getRootNode().getSorter().getCombinedBasicblockTreeNodeComparatorList().iterator();

                  while(var11.hasNext()) {
                     Comparator var12 = (Comparator)var11.next();
                     Collections.sort(var10, var12);
                  }

                  var11 = var10.iterator();

                  while(var11.hasNext()) {
                     var8 = (CombinedFlowGraphBasicBlockTreeNode)var11.next();
                     this.add(var8);
                  }

                  this.getTree().getModel().nodeStructureChanged(this);
                  this.getTree().updateUI();
                  return;
               }

               var8 = (CombinedFlowGraphBasicBlockTreeNode)var11.next();
            } while(!var3.filterRawCombinedBasicblock(var8.getCombinedBasicblock()));

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
      CombinedFlowGraphRootTreeNode var1 = this.getRootNode();
      this.basicblockTreeNodes.clear();
      Iterator var2 = var1.getGraph().getNodes().iterator();

      while(var2.hasNext()) {
         CombinedDiffNode var3 = (CombinedDiffNode)var2.next();
         this.basicblockTreeNodes.add(new CombinedFlowGraphBasicBlockTreeNode(var1, var3));
      }

      this.updateTreeNodes(false);
   }

   public Icon getIcon() {
      CombinedFlowGraphRootTreeNode var1 = this.getRootNode();
      FlowGraphViewData var2 = var1.getView();
      RawFlowGraph var3 = var2.getRawGraph(ESide.PRIMARY);
      RawFlowGraph var4 = var2.getRawGraph(ESide.SECONDARY);
      RawFunction var5 = GraphGetter.getFunction(this.getDiff(), var3);
      RawFunction var6 = GraphGetter.getFunction(this.getDiff(), var4);
      return var6 == null?PRIMARY_UNMATCHED_FUNCTION_ICON:(var5 == null?SECONDRAY_UNMATCHED_FUNCNTION_ICON:(var5.isChangedInstructionsOnlyMatch()?MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON:(var5.isChangedStructuralMatch()?MATCHED_STRUCTURALCHANGED_FUNCTION_ICON:MATCHED_IDENTICAL_FUNCTION_ICON)));
   }

   public CombinedDiffNode getLastSelectedGraphNode() {
      return this.lastSelectedTreeNode;
   }

   public JPopupMenu getPopupMenu() {
      JPopupMenu var1 = new JPopupMenu();
      JMenuItem var2 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$1(this, "Copy Primary Function Address"));
      JMenuItem var3 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$2(this, "Copy Primary Function Name"));
      JMenuItem var4 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$3(this, "Copy Secondary Function Address"));
      JMenuItem var5 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$4(this, "Copy Secondary Function Name"));
      var1.add(var2);
      var1.add(var3);
      var1.add(var4);
      var1.add(var5);
      return var1;
   }

   public CombinedFlowGraphRootTreeNode getRootNode() {
      return (CombinedFlowGraphRootTreeNode)this.getAbstractRootNode();
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

   public void setLastSelectedGraphNode(CombinedDiffNode var1) {
      this.lastSelectedTreeNode = var1;
   }

   public String toString() {
      FlowGraphViewData var1 = this.getRootNode().getView();
      RawFlowGraph var2 = var1.getRawGraph(ESide.PRIMARY);
      RawFlowGraph var3 = var1.getRawGraph(ESide.SECONDARY);
      String var4 = "missing";
      String var5 = "missing";
      if(var2 != null) {
         var4 = var2.getName();
      }

      if(var3 != null) {
         var5 = var3.getName();
      }

      return String.format("%s ↔ %s (%d / %d)", new Object[]{var4, var5, Integer.valueOf(this.getChildCount()), Integer.valueOf(this.basicblockTreeNodes.size())});
   }

   // $FF: synthetic method
   static ViewData access$100(CombinedFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static ViewData access$200(CombinedFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static ViewData access$300(CombinedFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static ViewData access$400(CombinedFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static List access$500(CombinedFlowGraphBaseTreeNode var0) {
      return var0.basicblockTreeNodes;
   }
}
