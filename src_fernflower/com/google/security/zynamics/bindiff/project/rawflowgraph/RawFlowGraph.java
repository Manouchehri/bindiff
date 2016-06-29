package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RawFlowGraph extends MutableDirectedGraph {
   private final IAddress address;
   private final String name;
   private final EFunctionType functionType;
   private final ESide side;
   private final Map addrToBasicblockMap = new HashMap();
   private final Map addrPairToJumpMap = new HashMap();

   public RawFlowGraph(IAddress var1, String var2, EFunctionType var3, List var4, List var5, ESide var6) {
      super(var4, var5);
      this.address = (IAddress)Preconditions.checkNotNull(var1);
      this.name = (String)Preconditions.checkNotNull(var2);
      this.functionType = (EFunctionType)Preconditions.checkNotNull(var3);
      this.side = (ESide)Preconditions.checkNotNull(var6);
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         RawBasicBlock var8 = (RawBasicBlock)var7.next();
         this.addrToBasicblockMap.put(var8.getAddress(), var8);
      }

      var7 = var5.iterator();

      while(var7.hasNext()) {
         RawJump var13 = (RawJump)var7.next();
         long var9 = var13.getSource().getAddress().toLong();
         long var11 = var13.getTarget().getAddress().toLong();
         this.addrPairToJumpMap.put(new AddressPair(var9, var11), var13);
      }

   }

   private void removeFromMap(SingleViewEdge var1) {
      IAddress var2 = ((SingleViewNode)var1.getSource()).getAddress();
      IAddress var3 = ((SingleViewNode)var1.getTarget()).getAddress();
      AddressPair var4 = new AddressPair(var2.toLong(), var3.toLong());
      this.addrPairToJumpMap.remove(var4);
   }

   public void addEdge(RawJump var1) {
      AddressPair var2 = new AddressPair(var1.getSource().getAddress().toLong(), var1.getTarget().getAddress().toLong());
      this.addrPairToJumpMap.put(var2, var1);
      super.addEdge(var1);
   }

   public void addNode(RawBasicBlock var1) {
      this.addrToBasicblockMap.put(var1.getAddress(), var1);
      super.addNode(var1);
   }

   public IAddress getAddress() {
      return this.address;
   }

   public RawBasicBlock getBasicblock(IAddress var1) {
      return (RawBasicBlock)this.addrToBasicblockMap.get(var1);
   }

   public EFunctionType getFunctionType() {
      return this.functionType;
   }

   public RawJump getJump(IAddress var1, IAddress var2) {
      return var1 != null && var2 != null?(RawJump)this.addrPairToJumpMap.get(new AddressPair(var1.toLong(), var2.toLong())):null;
   }

   public String getName() {
      return this.name;
   }

   public ESide getSide() {
      return this.side;
   }

   public void removeNode(RawBasicBlock var1) {
      this.addrToBasicblockMap.remove(var1.getAddress());
      Iterator var2 = var1.getIncomingEdges().iterator();

      SingleViewEdge var3;
      while(var2.hasNext()) {
         var3 = (SingleViewEdge)var2.next();
         SingleViewNode.unlink((SingleViewNode)var3.getSource(), (SingleViewNode)var3.getTarget());
         ((SingleViewNode)var3.getSource()).removeOutgoingEdge(var3);
         ((SingleViewNode)var3.getTarget()).removeIncomingEdge(var3);
         this.removeFromMap(var3);
      }

      var2 = var1.getOutgoingEdges().iterator();

      while(var2.hasNext()) {
         var3 = (SingleViewEdge)var2.next();
         SingleViewNode.unlink((SingleViewNode)var3.getSource(), (SingleViewNode)var3.getTarget());
         ((SingleViewNode)var3.getSource()).removeOutgoingEdge(var3);
         ((SingleViewNode)var3.getTarget()).removeIncomingEdge(var3);
         this.removeFromMap(var3);
      }

      super.removeNode(var1);
   }
}
