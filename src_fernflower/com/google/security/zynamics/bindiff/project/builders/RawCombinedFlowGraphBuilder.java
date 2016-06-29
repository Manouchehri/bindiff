package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class RawCombinedFlowGraphBuilder {
   private static RawCombinedFlowGraph buildMatchedCombinedFlowgraph(FunctionMatchData var0, RawFlowGraph var1, RawFlowGraph var2) {
      IAddress var3 = var1.getAddress();
      IAddress var4 = var2.getAddress();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      HashMap var7 = new HashMap();
      Iterator var8 = var1.iterator();

      RawBasicBlock var9;
      IAddress var10;
      IAddress var11;
      while(var8.hasNext()) {
         var9 = (RawBasicBlock)var8.next();
         var10 = var9.getAddress();
         var11 = var0.getSecondaryBasicblockAddr(var10);
         RawBasicBlock var12 = null;
         if(var11 != null) {
            var12 = var2.getBasicblock(var11);
         }

         BasicBlockMatchData var13 = var0.getBasicblockMatch(var10, ESide.PRIMARY);
         RawCombinedBasicBlock var14 = new RawCombinedBasicBlock(var9, var12, var13, var3, var4);
         var7.put(new Pair(var10, var11), var14);
         var5.add(var14);
      }

      var8 = var2.iterator();

      while(var8.hasNext()) {
         var9 = (RawBasicBlock)var8.next();
         var10 = var9.getAddress();
         var11 = var0.getPrimaryBasicblockAddr(var10);
         if(var11 == null) {
            RawCombinedBasicBlock var26 = new RawCombinedBasicBlock((RawBasicBlock)null, var9, (BasicBlockMatchData)null, var3, var4);
            var7.put(new Pair((Object)null, var10), var26);
            var5.add(var26);
         }
      }

      var8 = var1.getEdges().iterator();

      Pair var15;
      RawCombinedBasicBlock var18;
      IAddress var27;
      IAddress var28;
      while(var8.hasNext()) {
         RawJump var22 = (RawJump)var8.next();
         var10 = var22.getSource().getAddress();
         var11 = var22.getTarget().getAddress();
         var27 = var0.getSecondaryBasicblockAddr(var10);
         var28 = var0.getSecondaryBasicblockAddr(var11);
         Pair var29 = new Pair(var10, var27);
         var15 = new Pair(var11, var28);
         RawJump var16 = var2.getJump(var27, var28);
         RawCombinedBasicBlock var17 = (RawCombinedBasicBlock)var7.get(var29);
         var18 = (RawCombinedBasicBlock)var7.get(var15);
         RawCombinedJump var19 = new RawCombinedJump(var17, var18, var22, var16);
         var6.add(var19);
      }

      HashSet var21 = new HashSet();
      Iterator var23 = var1.getEdges().iterator();

      while(var23.hasNext()) {
         IGraphEdge var24 = (IGraphEdge)var23.next();
         var21.add(var24);
      }

      var23 = var2.getEdges().iterator();

      while(var23.hasNext()) {
         RawJump var25 = (RawJump)var23.next();
         var11 = var25.getSource().getAddress();
         var27 = var25.getTarget().getAddress();
         var28 = var0.getPrimaryBasicblockAddr(var11);
         IAddress var30 = var0.getPrimaryBasicblockAddr(var27);
         var15 = new Pair(var28, var11);
         Pair var31 = new Pair(var30, var27);
         boolean var32 = false;
         if(var1 == null) {
            var32 = true;
         } else {
            RawJump var33 = var1.getJump(var28, var30);
            if(!var21.contains(var33)) {
               var32 = true;
            }
         }

         if(var32) {
            var18 = (RawCombinedBasicBlock)var7.get(var15);
            RawCombinedBasicBlock var34 = (RawCombinedBasicBlock)var7.get(var31);
            RawCombinedJump var20 = new RawCombinedJump(var18, var34, (RawJump)null, var25);
            var6.add(var20);
         }
      }

      return new RawCombinedFlowGraph(var5, var6, var1, var2);
   }

   private static RawCombinedFlowGraph buildPrimaryUnmatchedCombinedFlowgraph(RawFlowGraph var0) {
      IAddress var1 = var0.getAddress();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      HashMap var4 = new HashMap();
      Iterator var5 = var0.iterator();

      RawCombinedBasicBlock var7;
      while(var5.hasNext()) {
         RawBasicBlock var6 = (RawBasicBlock)var5.next();
         var7 = new RawCombinedBasicBlock(var6, (RawBasicBlock)null, (BasicBlockMatchData)null, var1, (IAddress)null);
         var4.put(var6.getAddress(), var7);
         var2.add(var7);
      }

      var5 = var0.getEdges().iterator();

      while(var5.hasNext()) {
         RawJump var10 = (RawJump)var5.next();
         var7 = (RawCombinedBasicBlock)var4.get(var10.getSource().getAddress());
         RawCombinedBasicBlock var8 = (RawCombinedBasicBlock)var4.get(var10.getTarget().getAddress());
         RawCombinedJump var9 = new RawCombinedJump(var7, var8, var10, (RawJump)null);
         var3.add(var9);
      }

      return new RawCombinedFlowGraph(var2, var3, var0, (RawFlowGraph)null);
   }

   private static RawCombinedFlowGraph buildSecondaryUnmatchedCombinedFlowgraph(RawFlowGraph var0) {
      IAddress var1 = var0.getAddress();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      HashMap var4 = new HashMap();
      Iterator var5 = var0.iterator();

      RawCombinedBasicBlock var7;
      while(var5.hasNext()) {
         RawBasicBlock var6 = (RawBasicBlock)var5.next();
         var7 = new RawCombinedBasicBlock((RawBasicBlock)null, var6, (BasicBlockMatchData)null, (IAddress)null, var1);
         var4.put(var6.getAddress(), var7);
         var2.add(var7);
      }

      var5 = var0.getEdges().iterator();

      while(var5.hasNext()) {
         RawJump var10 = (RawJump)var5.next();
         var7 = (RawCombinedBasicBlock)var4.get(var10.getSource().getAddress());
         RawCombinedBasicBlock var8 = (RawCombinedBasicBlock)var4.get(var10.getTarget().getAddress());
         RawCombinedJump var9 = new RawCombinedJump(var7, var8, (RawJump)null, var10);
         var3.add(var9);
      }

      return new RawCombinedFlowGraph(var2, var3, (RawFlowGraph)null, var0);
   }

   public static RawCombinedFlowGraph buildRawCombinedFlowgraph(FunctionMatchData var0, RawFlowGraph var1, RawFlowGraph var2) {
      Logger.logInfo(" - Building combined flow graphs", new Object[0]);

      try {
         if(var1 != null && var2 != null) {
            return buildMatchedCombinedFlowgraph(var0, var1, var2);
         } else if(var1 != null && var2 == null) {
            return buildPrimaryUnmatchedCombinedFlowgraph(var1);
         } else if(var1 == null && var2 != null) {
            return buildSecondaryUnmatchedCombinedFlowgraph(var2);
         } else {
            throw new GraphCreationException("Primary and secondary flowgraph cannot both be null. Combined flow graphs creation failed.");
         }
      } catch (GraphCreationException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new GraphCreationException("Combined flow graphs creation failed.");
      }
   }
}
