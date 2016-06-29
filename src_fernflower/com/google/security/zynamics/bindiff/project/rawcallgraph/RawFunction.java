package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RawFunction extends SingleViewNode {
   private final String name;
   private final EFunctionType type;
   private final ESide side;
   private FunctionMatchData match = null;
   private RawFunction matchedFunction = null;
   private int basicblocks = -1;
   private int jumps = -1;
   private int instructions = -1;
   private String comment = "";

   public RawFunction(IAddress var1, String var2, EFunctionType var3, ESide var4) {
      super(var1, -1, 0.0D, 0.0D, Color.WHITE, Color.BLACK, false, true);
      this.name = (String)Preconditions.checkNotNull(var2);
      this.type = (EFunctionType)Preconditions.checkNotNull(var3);
      this.side = (ESide)Preconditions.checkNotNull(var4);
   }

   public Set getCallees() {
      List var1 = this.getChildren();
      HashSet var2 = new HashSet();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         SingleViewNode var4 = (SingleViewNode)var3.next();
         var2.add((RawFunction)var4);
      }

      return var2;
   }

   public Set getCallers() {
      List var1 = this.getParents();
      HashSet var2 = new HashSet();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         SingleViewNode var4 = (SingleViewNode)var3.next();
         var2.add((RawFunction)var4);
      }

      return var2;
   }

   public String getComment() {
      return this.comment;
   }

   public FunctionMatchData getFunctionMatch() {
      return this.match;
   }

   public EFunctionType getFunctionType() {
      return this.type;
   }

   public FunctionMatchData getMatch() {
      return this.match;
   }

   public RawFunction getMatchedFunction() {
      return this.matchedFunction;
   }

   public IAddress getMatchedFunctionAddress() {
      return this.getMatchState() == EMatchState.MATCHED?this.match.getIAddress(this.side == ESide.PRIMARY?ESide.SECONDARY:ESide.PRIMARY):null;
   }

   public EMatchState getMatchState() {
      return this.match == null?(this.side == ESide.PRIMARY?EMatchState.PRIMARY_UNMATCHED:EMatchState.SECONDRAY_UNMATCHED):EMatchState.MATCHED;
   }

   public String getName() {
      return this.name;
   }

   public ESide getSide() {
      return this.side;
   }

   public int getSizeOfBasicblocks() {
      return this.basicblocks;
   }

   public int getSizeOfInstructions() {
      return this.instructions;
   }

   public int getSizeOfJumps() {
      return this.jumps;
   }

   public int getSizeOfMatchedBasicblocks() {
      return this.match == null?0:this.match.getSizeOfMatchedBasicblocks();
   }

   public int getSizeOfMatchedInstructions() {
      return this.match == null?0:this.match.getSizeOfMatchedInstructions();
   }

   public int getSizeOfMatchedJumps() {
      return this.match == null?0:this.match.getSizeOfMatchedJumps();
   }

   public int getSizeOfUnmatchedBasicblocks() {
      return this.basicblocks - this.match.getSizeOfMatchedBasicblocks();
   }

   public int getSizeOfUnmatchedInstructions() {
      return this.instructions - this.match.getSizeOfMatchedInstructions();
   }

   public int getSizeOfUnmatchedJumps() {
      return this.jumps - this.match.getSizeOfMatchedJumps();
   }

   public boolean isChanged() {
      if(this.getMatchState() != EMatchState.MATCHED) {
         return false;
      } else {
         boolean var1 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
         boolean var2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
         boolean var3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
         return !var1 || !var2 || !var3;
      }
   }

   public boolean isChangedInstructionsOnlyMatch() {
      if(this.getMatchState() != EMatchState.MATCHED) {
         return false;
      } else {
         boolean var1 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
         boolean var2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
         boolean var3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
         return var1 && var2 && !var3;
      }
   }

   public boolean isChangedStructuralMatch() {
      if(this.getMatchState() != EMatchState.MATCHED) {
         return false;
      } else {
         boolean var1 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
         boolean var2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
         return !var1 || !var2;
      }
   }

   public boolean isIdenticalMatch() {
      if(this.getMatchState() != EMatchState.MATCHED) {
         return false;
      } else {
         boolean var1 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
         boolean var2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
         boolean var3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
         return var1 && var2 && var3;
      }
   }

   public void setComment(String var1) {
      this.comment = var1;
   }

   public void setMatch(RawFunction var1, FunctionMatchData var2) {
      this.matchedFunction = var1;
      this.match = var2;
   }

   public void setSizeOfBasicblocks(int var1) {
      this.basicblocks = var1;
   }

   public void setSizeOfInstructions(int var1) {
      this.instructions = var1;
   }

   public void setSizeOfJumps(int var1) {
      this.jumps = var1;
   }
}
