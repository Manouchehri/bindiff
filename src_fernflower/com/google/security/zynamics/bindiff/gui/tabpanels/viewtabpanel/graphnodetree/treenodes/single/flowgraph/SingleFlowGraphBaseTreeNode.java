package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SingleFlowGraphBaseTreeNode extends AbstractBaseTreeNode {
   private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
   private final IMatchesChangeListener matchesChangeListener = new SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, (SingleFlowGraphBaseTreeNode$1)null);
   private final List basicBlockTreeNodes = new ArrayList();
   private SingleDiffNode lastSelectedTreeNode;

   public SingleFlowGraphBaseTreeNode(SingleFlowGraphRootTreeNode var1) {
      super(var1);
      this.createChildren();
      this.getDiff().getMatches().addListener(this.matchesChangeListener);
   }

   private void replaceBasicblockTreeNode(IAddress var1) {
      SingleDiffNode var2 = null;
      Iterator var3 = this.getRootNode().getGraph().getNodes().iterator();

      while(var3.hasNext()) {
         SingleDiffNode var4 = (SingleDiffNode)var3.next();
         if(var1.equals(var4.getRawNode().getAddress())) {
            var2 = var4;
            break;
         }
      }

      if(var2 != null) {
         for(int var8 = 0; var8 < this.getChildCount(); ++var8) {
            SingleFlowGraphBasicBlockTreeNode var9 = (SingleFlowGraphBasicBlockTreeNode)this.getChildAt(var8);
            RawBasicBlock var5 = var9.getBasicblock();
            if(var1.equals(var5.getAddress())) {
               SingleFlowGraphBasicBlockTreeNode var6 = new SingleFlowGraphBasicBlockTreeNode(this.getRootNode(), var2);
               this.insert(var6, var8);
               int var7 = this.basicBlockTreeNodes.indexOf(var9);
               this.basicBlockTreeNodes.set(var7, var6);
               break;
            }
         }

         this.updateTreeNodes(true);
      }

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
            var4.add((SingleFlowGraphBasicBlockTreeNode)this.getChildAt(var5));
         }
      } else {
         var4.addAll(this.basicBlockTreeNodes);
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
               var4.add((SingleFlowGraphBasicBlockTreeNode)var7);
            }
         } else {
            var2.search((List)null);
         }
      }

      ArrayList var10 = new ArrayList();
      Iterator var11 = var4.iterator();

      while(true) {
         while(true) {
            SingleFlowGraphBasicBlockTreeNode var8;
            do {
               if(!var11.hasNext()) {
                  var11 = this.getRootNode().getSorter().getSingleBasicblockTreeNodeComparatorList().iterator();

                  while(var11.hasNext()) {
                     Comparator var12 = (Comparator)var11.next();
                     Collections.sort(var10, var12);
                  }

                  var11 = var10.iterator();

                  while(var11.hasNext()) {
                     var8 = (SingleFlowGraphBasicBlockTreeNode)var11.next();
                     this.add(var8);
                  }

                  this.getTree().getModel().nodeStructureChanged(this);
                  this.getTree().updateUI();
                  return;
               }

               var8 = (SingleFlowGraphBasicBlockTreeNode)var11.next();
            } while(!var3.filterRawBasicblock(var8.getBasicblock()));

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
      this.basicBlockTreeNodes.clear();
      SingleFlowGraphRootTreeNode var1 = this.getRootNode();
      Iterator var2 = this.getRootNode().getGraph().getNodes().iterator();

      while(var2.hasNext()) {
         SingleDiffNode var3 = (SingleDiffNode)var2.next();
         this.basicBlockTreeNodes.add(new SingleFlowGraphBasicBlockTreeNode(var1, var3));
      }

      this.updateTreeNodes(false);
   }

   public Icon getIcon() {
      FlowGraphViewData var1 = this.getRootNode().getView();
      ESide var2 = this.getRootNode().getSide();
      RawFlowGraph var3 = var1.getRawGraph(var2);
      IAddress var4 = var3.getAddress();
      RawFunction var5 = this.getDiff().getCallgraph(var2).getFunction(var4);
      EMatchState var7 = var5.getMatchState();
      if(var7 == EMatchState.MATCHED) {
         IAddress var8 = var5.getMatchedFunctionAddress();
         RawFunction var6;
         if(var5.getSide() == ESide.PRIMARY) {
            var6 = var5;
         } else {
            var6 = this.getDiff().getFunction(var8, ESide.PRIMARY);
         }

         if(var6.isIdenticalMatch()) {
            return MATCHED_IDENTICAL_FUNCTION_ICON;
         }

         if(var6.isChangedInstructionsOnlyMatch()) {
            return MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
         }

         if(var6.isChangedStructuralMatch()) {
            return MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
         }
      } else if(var7 == EMatchState.PRIMARY_UNMATCHED) {
         return PRIMARY_UNMATCHED_FUNCTION_ICON;
      }

      return SECONDRAY_UNMATCHED_FUNCNTION_ICON;
   }

   public SingleDiffNode getLastSelectedGraphNode() {
      return this.lastSelectedTreeNode;
   }

   public JPopupMenu getPopupMenu() {
      JPopupMenu var1 = new JPopupMenu();
      ESide var2 = this.getRootNode().getSide();
      JMenuItem var3 = new JMenuItem(new SingleFlowGraphBaseTreeNode$1(this, "Copy Function Address", var2));
      JMenuItem var4 = new JMenuItem(new SingleFlowGraphBaseTreeNode$2(this, "Copy Function Name", var2));
      var1.add(var3);
      var1.add(var4);
      return var1;
   }

   public SingleFlowGraphRootTreeNode getRootNode() {
      return (SingleFlowGraphRootTreeNode)this.getAbstractRootNode();
   }

   public String getTooltipText() {
      return null;
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
      FlowGraphViewData var1 = this.getRootNode().getView();
      ESide var2 = this.getRootNode().getSide();
      RawFlowGraph var3 = var1.getRawGraph(var2);
      return String.format("%s (%d / %d)", new Object[]{var3.getName(), Integer.valueOf(this.getChildCount()), Integer.valueOf(this.basicBlockTreeNodes.size())});
   }

   // $FF: synthetic method
   static ViewData access$100(SingleFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static ViewData access$200(SingleFlowGraphBaseTreeNode var0) {
      return var0.getView();
   }

   // $FF: synthetic method
   static void access$300(SingleFlowGraphBaseTreeNode var0, IAddress var1) {
      var0.replaceBasicblockTreeNode(var1);
   }
}
