package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Iterator;

class SelectionHistory$InternalMatchedChangedListener implements IMatchesChangeListener {
   // $FF: synthetic field
   final SelectionHistory this$0;

   private SelectionHistory$InternalMatchedChangedListener(SelectionHistory var1) {
      this.this$0 = var1;
   }

   private BinDiffGraph getGraph() {
      return (BinDiffGraph)(SelectionHistory.access$100(this.this$0) != null?SelectionHistory.access$100(this.this$0):SelectionHistory.access$200(this.this$0));
   }

   private SingleDiffNode getNewDiffNode(IAddress var1) {
      Iterator var2 = SelectionHistory.access$100(this.this$0).getNodes().iterator();

      SingleDiffNode var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (SingleDiffNode)var2.next();
      } while(!var3.getRawNode().getAddress().equals(var1));

      return var3;
   }

   private CombinedDiffNode getNewDiffNode(IAddress var1, ESide var2) {
      Iterator var3 = SelectionHistory.access$200(this.this$0).getNodes().iterator();

      CombinedDiffNode var4;
      RawCombinedBasicBlock var5;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (CombinedDiffNode)var3.next();
         var5 = (RawCombinedBasicBlock)var4.getRawNode();
      } while(!var1.equals(var5.getAddress(var2)));

      return var4;
   }

   private void refreshSnapshots(CombinedDiffNode var1, CombinedDiffNode var2) {
      Preconditions.checkNotNull(var1, "Primary unmatched combined diff node can\'t be null.");
      Preconditions.checkNotNull(var2, "Secondary unmatched combined diff node can\'t be null.");
      IAddress var3 = var1.getRawNode().getAddress(ESide.PRIMARY);
      IAddress var4 = var2.getRawNode().getAddress(ESide.SECONDARY);
      Iterator var5 = SelectionHistory.access$300(this.this$0).iterator();

      while(true) {
         while(var5.hasNext()) {
            SelectionSnapshot var6 = (SelectionSnapshot)var5.next();
            Iterator var7 = var6.getCombinedGraphSelection().iterator();

            while(var7.hasNext()) {
               CombinedDiffNode var8 = (CombinedDiffNode)var7.next();
               if(var3.equals(var8.getRawNode().getAddress(ESide.PRIMARY)) && var4.equals(var8.getRawNode().getAddress(ESide.SECONDARY))) {
                  var6.remove(var8);
                  var6.add(var1);
                  var6.add(var2);
                  var6.modicationFinished();
                  break;
               }
            }
         }

         return;
      }
   }

   private void refreshSnapshots(SingleDiffNode var1) {
      Preconditions.checkNotNull(var1, "New unmatched diff node cann\'t be null.");
      IAddress var2 = var1.getRawNode().getAddress();
      Iterator var3 = SelectionHistory.access$300(this.this$0).iterator();

      while(true) {
         while(var3.hasNext()) {
            SelectionSnapshot var4 = (SelectionSnapshot)var3.next();
            Iterator var5 = var4.getSingleGraphSelection().iterator();

            while(var5.hasNext()) {
               SingleDiffNode var6 = (SingleDiffNode)var5.next();
               if(var6.getRawNode().getAddress().equals(var2)) {
                  var4.remove(var6);
                  var4.add(var1);
                  var4.modicationFinished();
                  break;
               }
            }
         }

         return;
      }
   }

   private void updateSnapshots(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      BinDiffGraph var5 = this.getGraph();
      if(var5.getGraphType() != EGraphType.CALLGRAPH) {
         if(var1.equals(var5.getPrimaryGraph().getFunctionAddress()) && var2.equals(var5.getSecondaryGraph().getFunctionAddress())) {
            if(SelectionHistory.access$100(this.this$0) != null) {
               this.refreshSnapshots(this.getNewDiffNode(SelectionHistory.access$100(this.this$0).getSide() == ESide.PRIMARY?var3:var4));
            } else {
               this.refreshSnapshots(this.getNewDiffNode(var3, ESide.PRIMARY), this.getNewDiffNode(var4, ESide.SECONDARY));
            }
         }

      }
   }

   public void addedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      this.updateSnapshots(var1, var2, var3, var4);
   }

   public void removedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      this.updateSnapshots(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   SelectionHistory$InternalMatchedChangedListener(SelectionHistory var1, SelectionHistory$1 var2) {
      this(var1);
   }
}
