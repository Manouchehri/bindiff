package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FunctionMatchData implements IAddressPair {
   private final int id;
   private final IAddressPair addrPair;
   private final double similarity;
   private final double confidence;
   private final int flags;
   private final int algoId;
   private Matches basicblockMatches = null;
   private int matchedBasicblocks;
   private int matchedJumps;
   private int matchedInstructions;

   public FunctionMatchData(int var1, long var2, long var4, double var6, double var8, int var10, int var11, int var12, int var13, int var14) {
      this.id = var1;
      this.addrPair = new AddressPair(var2, var4);
      this.similarity = var6;
      this.confidence = var8;
      this.flags = var10;
      this.algoId = var11;
      this.matchedBasicblocks = var12;
      this.matchedJumps = var13;
      this.matchedInstructions = var14;
   }

   protected int getId() {
      return this.id;
   }

   public void addBasicblockMatch(Diff var1, BasicBlockMatchData var2, RawCombinedBasicBlock var3) {
      this.basicblockMatches.put(var2);
      HashSet var4 = new HashSet();
      var4.addAll(var3.getIncomingEdges());
      var4.addAll(var3.getOutgoingEdges());
      int var5 = 0;
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         CombinedViewEdge var7 = (CombinedViewEdge)var6.next();
         if(var7.getMatchState() == EMatchState.MATCHED) {
            ++var5;
         }
      }

      int var8 = var2.getInstructionMatches().length;
      this.matchedInstructions += var8;
      this.matchedJumps += var5;
      ++this.matchedBasicblocks;
      MatchData var9 = var1.getMatches();
      var9.setSizeOfMatchedBasicblocks(var9.getSizeOfMatchedBasicblocks() + 1);
      var9.setSizeOfMatchedJumps(var9.getSizeOfMatchedJumps() + var5);
      var9.setSizeOfMatchedInstructions(var9.getSizeOfMatchedInstructions() + var8);
   }

   public long getAddress(ESide var1) {
      return this.addrPair.getAddress(var1);
   }

   public int getAlgorithmId() {
      return this.algoId;
   }

   public String getAlgorithmName() {
      return "TODO";
   }

   public BasicBlockMatchData getBasicblockMatch(IAddress var1, ESide var2) {
      return this.basicblockMatches != null?(BasicBlockMatchData)this.basicblockMatches.get(var1, var2):null;
   }

   public Collection getBasicblockMatches() {
      return this.basicblockMatches != null?this.basicblockMatches.getMatches():null;
   }

   public double getConfidence() {
      return this.confidence;
   }

   public int getFlags() {
      return this.flags;
   }

   public IAddress getIAddress(ESide var1) {
      return new CAddress(this.addrPair.getAddress(var1));
   }

   public Map getInstructionsAddressMap(ESide var1) {
      if(this.basicblockMatches == null) {
         return null;
      } else {
         HashMap var2 = new HashMap();
         Iterator var3 = this.basicblockMatches.getMatches().iterator();

         while(var3.hasNext()) {
            BasicBlockMatchData var4 = (BasicBlockMatchData)var3.next();
            InstructionMatchData[] var5 = var4.getInstructionMatches();
            InstructionMatchData[] var6 = var5;
            int var7 = var5.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               InstructionMatchData var9 = var6[var8];
               ESide var10 = var1 == ESide.PRIMARY?ESide.SECONDARY:ESide.PRIMARY;
               var2.put(var9.getIAddress(var1), var9.getIAddress(var10));
            }
         }

         return var2;
      }
   }

   public IAddress getPrimaryBasicblockAddr(IAddress var1) {
      if(this.basicblockMatches != null) {
         BasicBlockMatchData var2 = (BasicBlockMatchData)this.basicblockMatches.get(var1, ESide.SECONDARY);
         return var2 != null?var2.getIAddress(ESide.PRIMARY):null;
      } else {
         return null;
      }
   }

   public IAddress getSecondaryBasicblockAddr(IAddress var1) {
      if(this.basicblockMatches != null) {
         BasicBlockMatchData var2 = (BasicBlockMatchData)this.basicblockMatches.get(var1, ESide.PRIMARY);
         return var2 != null?var2.getIAddress(ESide.SECONDARY):null;
      } else {
         return null;
      }
   }

   public double getSimilarity() {
      return this.similarity;
   }

   public int getSizeOfMatchedBasicblocks() {
      return this.matchedBasicblocks;
   }

   public int getSizeOfMatchedInstructions() {
      return this.matchedInstructions;
   }

   public int getSizeOfMatchedJumps() {
      return this.matchedJumps;
   }

   public boolean isBasicblockMatch(IAddress var1, IAddress var2) {
      IAddress var3 = this.getSecondaryBasicblockAddr(var1);
      return var3 != null && var3.equals(var2);
   }

   public boolean isLoaded() {
      return this.basicblockMatches != null;
   }

   public void loadBasicblockMatches(List var1) {
      this.basicblockMatches = new Matches(var1);
   }

   public void removeBasicblockMatch(Diff var1, RawCombinedBasicBlock var2) {
      IAddress var3 = var2.getAddress(ESide.PRIMARY);
      IAddress var4 = var2.getAddress(ESide.SECONDARY);
      BasicBlockMatchData var5 = (BasicBlockMatchData)this.basicblockMatches.remove(var3, var4);
      if(var5 != null) {
         int var6 = var5.getSizeOfMatchedInstructions();
         HashSet var7 = new HashSet();
         var7.addAll(var2.getOutgoingEdges());
         var7.addAll(var2.getIncomingEdges());
         int var8 = 0;
         Iterator var9 = var7.iterator();

         while(var9.hasNext()) {
            CombinedViewEdge var10 = (CombinedViewEdge)var9.next();
            if(((RawCombinedJump)var10).getMatchState() == EMatchState.MATCHED) {
               ++var8;
            }
         }

         this.matchedInstructions -= var6;
         this.matchedJumps -= var8;
         --this.matchedBasicblocks;
         MatchData var11 = var1.getMatches();
         var11.setSizeOfMatchedBasicblocks(var11.getSizeOfMatchedBasicblocks() - 1);
         var11.setSizeOfMatchedJumps(var11.getSizeOfMatchedJumps() - var8);
         var11.setSizeOfMatchedInstructions(var11.getSizeOfMatchedInstructions() - var6);
      }

   }

   public void setSizeOfMatchedBasicblocks(int var1) {
      this.matchedBasicblocks = var1;
   }

   public void setSizeOfMatchedInstructions(int var1) {
      this.matchedInstructions = var1;
   }

   public void setSizeOfMatchedJumps(int var1) {
      this.matchedJumps = var1;
   }
}
