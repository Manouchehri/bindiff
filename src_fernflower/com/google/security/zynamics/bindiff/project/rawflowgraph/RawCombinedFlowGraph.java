package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Iterator;
import java.util.List;

public class RawCombinedFlowGraph extends MutableDirectedGraph {
   private final RawFlowGraph primaryFlowgraph;
   private final RawFlowGraph secondaryFlowgraph;

   public RawCombinedFlowGraph(List var1, List var2, RawFlowGraph var3, RawFlowGraph var4) {
      super(var1, var2);
      if(var3 == null && var4 == null) {
         throw new IllegalArgumentException("Primary and secondary flow graphs cannot both be null.");
      } else {
         this.primaryFlowgraph = var3;
         this.secondaryFlowgraph = var4;
      }
   }

   public EMatchState getMatchState() {
      return this.secondaryFlowgraph == null?EMatchState.PRIMARY_UNMATCHED:(this.primaryFlowgraph == null?EMatchState.SECONDRAY_UNMATCHED:EMatchState.MATCHED);
   }

   public IAddress getPrimaryAddress() {
      return this.primaryFlowgraph == null?null:this.primaryFlowgraph.getAddress();
   }

   public RawFlowGraph getPrimaryFlowgraph() {
      return this.primaryFlowgraph;
   }

   public String getPrimaryName() {
      return this.primaryFlowgraph == null?"":this.primaryFlowgraph.getName();
   }

   public IAddress getSecondaryAddress() {
      return this.secondaryFlowgraph == null?null:this.secondaryFlowgraph.getAddress();
   }

   public RawFlowGraph getSecondaryFlowgraph() {
      return this.secondaryFlowgraph;
   }

   public String getSecondaryName() {
      return this.secondaryFlowgraph == null?"":this.secondaryFlowgraph.getName();
   }

   public void removeNode(RawCombinedBasicBlock var1) {
      Iterator var2 = var1.getIncomingEdges().iterator();

      CombinedViewEdge var3;
      while(var2.hasNext()) {
         var3 = (CombinedViewEdge)var2.next();
         CombinedViewNode.unlink((CombinedViewNode)var3.getSource(), (CombinedViewNode)var3.getTarget());
         ((CombinedViewNode)var3.getSource()).removeOutgoingEdge(var3);
         ((CombinedViewNode)var3.getTarget()).removeIncomingEdge(var3);
      }

      var2 = var1.getOutgoingEdges().iterator();

      while(var2.hasNext()) {
         var3 = (CombinedViewEdge)var2.next();
         CombinedViewNode.unlink((CombinedViewNode)var3.getSource(), (CombinedViewNode)var3.getTarget());
         ((CombinedViewNode)var3.getTarget()).removeIncomingEdge(var3);
         ((CombinedViewNode)var3.getSource()).removeOutgoingEdge(var3);
      }

      super.removeNode(var1);
   }
}
