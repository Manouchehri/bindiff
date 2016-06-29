package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Iterator;

class CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener implements IMatchesChangeListener {
   // $FF: synthetic field
   final CombinedFlowGraphBaseTreeNode this$0;

   private CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(CombinedFlowGraphBaseTreeNode var1) {
      this.this$0 = var1;
   }

   private boolean isAffected(IAddress var1, IAddress var2) {
      IAddress var3 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
      IAddress var4 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
      return var1.equals(var3) && var2.equals(var4);
   }

   public void addedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      if(this.isAffected(var1, var2)) {
         CombinedDiffNode var5 = null;
         Iterator var6 = this.this$0.getRootNode().getGraph().getNodes().iterator();

         while(var6.hasNext()) {
            CombinedDiffNode var7 = (CombinedDiffNode)var6.next();
            IAddress var8 = var7.getPrimaryRawNode() == null?null:var7.getPrimaryRawNode().getAddress();
            IAddress var9 = var7.getSecondaryRawNode() == null?null:var7.getSecondaryRawNode().getAddress();
            if(var3.equals(var8) && var4.equals(var9)) {
               var5 = var7;
               break;
            }
         }

         if(var5 != null) {
            boolean var11 = false;

            for(int var12 = 1; var12 < this.this$0.getChildCount(); ++var12) {
               CombinedFlowGraphBasicBlockTreeNode var13 = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(var12);
               RawCombinedBasicBlock var14 = var13.getCombinedBasicblock();
               CombinedFlowGraphBasicBlockTreeNode var10;
               if(var3.equals(var14.getAddress(ESide.PRIMARY))) {
                  CombinedFlowGraphBaseTreeNode.access$500(this.this$0).remove(var13);
                  this.this$0.remove(var13);
                  if(var11) {
                     var10 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), var5);
                     CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(var10);
                     this.this$0.add(var10);
                     break;
                  }

                  var11 = true;
               } else if(var4.equals(var14.getAddress(ESide.SECONDARY))) {
                  CombinedFlowGraphBaseTreeNode.access$500(this.this$0).remove(var13);
                  this.this$0.remove(var13);
                  if(var11) {
                     var10 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), var5);
                     CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(var10);
                     this.this$0.add(var10);
                     break;
                  }

                  var11 = true;
               }
            }

            this.this$0.updateTreeNodes(true);
         }
      }

   }

   public void removedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      if(this.isAffected(var1, var2)) {
         CombinedDiffNode var5 = null;
         CombinedDiffNode var6 = null;
         Iterator var7 = this.this$0.getRootNode().getGraph().getNodes().iterator();

         while(var7.hasNext()) {
            CombinedDiffNode var8 = (CombinedDiffNode)var7.next();
            IAddress var9 = var8.getPrimaryRawNode() == null?null:var8.getPrimaryRawNode().getAddress();
            IAddress var10 = var8.getSecondaryRawNode() == null?null:var8.getSecondaryRawNode().getAddress();
            if(var3.equals(var9) && var10 == null) {
               var5 = var8;
               if(var8 != null && var6 != null) {
                  break;
               }
            }

            if(var4.equals(var10) && var9 == null) {
               var6 = var8;
               if(var5 != null && var8 != null) {
                  break;
               }
            }
         }

         if(var5 != null && var6 != null) {
            for(int var13 = 0; var13 < this.this$0.getChildCount(); ++var13) {
               CombinedFlowGraphBasicBlockTreeNode var14 = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(var13);
               RawCombinedBasicBlock var15 = var14.getCombinedBasicblock();
               if(var3.equals(var15.getAddress(ESide.PRIMARY)) && var4.equals(var15.getAddress(ESide.SECONDARY))) {
                  CombinedFlowGraphBasicBlockTreeNode var16 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), var5);
                  CombinedFlowGraphBasicBlockTreeNode var11 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), var6);
                  this.this$0.insert(var16, var13);
                  int var12 = CombinedFlowGraphBaseTreeNode.access$500(this.this$0).indexOf(var14);
                  CombinedFlowGraphBaseTreeNode.access$500(this.this$0).set(var12, var16);
                  CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(var11);
                  break;
               }
            }

            this.this$0.updateTreeNodes(true);
         }
      }

   }

   // $FF: synthetic method
   CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(CombinedFlowGraphBaseTreeNode var1, CombinedFlowGraphBaseTreeNode$1 var2) {
      this(var1);
   }
}
