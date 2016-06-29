package com.google.security.zynamics.bindiff.project.matches;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.Iterator;
import java.util.List;

public class MatchData {
   private final DiffMetaData metaData;
   private Matches functionMatches;
   private final ListenerProvider listener = new ListenerProvider();

   public MatchData(List var1, DiffMetaData var2) {
      this.metaData = (DiffMetaData)Preconditions.checkNotNull(var2);
      this.functionMatches = new Matches((List)Preconditions.checkNotNull(var1));
   }

   public void addListener(IMatchesChangeListener var1) {
      this.listener.addListener(var1);
   }

   public void close() {
      this.functionMatches.clear();
   }

   public FunctionMatchData getFunctionMatch(IAddress var1, ESide var2) {
      return (FunctionMatchData)this.functionMatches.get(var1, var2);
   }

   public FunctionMatchData[] getFunctionMatches() {
      return (FunctionMatchData[])this.functionMatches.getMatches().toArray(new FunctionMatchData[0]);
   }

   public IAddress getPrimaryFunctionAddr(IAddress var1) {
      FunctionMatchData var2 = (FunctionMatchData)this.functionMatches.get(var1, ESide.SECONDARY);
      return var2 != null?var2.getIAddress(ESide.PRIMARY):null;
   }

   public IAddress getSecondaryFunctionAddr(IAddress var1) {
      FunctionMatchData var2 = (FunctionMatchData)this.functionMatches.get(var1, ESide.PRIMARY);
      return var2 != null?var2.getIAddress(ESide.SECONDARY):null;
   }

   public int getSizeOfBasicblocks(ESide var1) {
      return this.metaData.getSizeOfBasicblocks(var1);
   }

   public int getSizeOfCalls(ESide var1) {
      return this.metaData.getSizeOfCalls(var1);
   }

   public int getSizeOfChangedCalls() {
      return this.metaData.getSizeOfChangedCalls();
   }

   public int getSizeOfChangedFunctions() {
      return this.metaData.getSizeOfChangedFunctions();
   }

   public int getSizeOfFunctions(ESide var1) {
      return this.metaData.getSizeOfFunctions(var1);
   }

   public int getSizeOfInstructions(ESide var1) {
      return this.metaData.getSizeOfInstructions(var1);
   }

   public int getSizeOfJumps(ESide var1) {
      return this.metaData.getSizeOfJumps(var1);
   }

   public int getSizeOfMatchedBasicblocks() {
      return this.metaData.getSizeOfMatchedBasicblocks();
   }

   public int getSizeOfMatchedCalls() {
      return this.metaData.getSizeOfMatchedCalls();
   }

   public int getSizeOfMatchedFunctions() {
      return this.metaData.getSizeOfMatchedFunctions();
   }

   public int getSizeOfMatchedInstructions() {
      return this.metaData.getSizeOfMatchedInstructions();
   }

   public int getSizeOfMatchedJumps() {
      return this.metaData.getSizeOfMatchedJumps();
   }

   public int getSizeOfUnmatchedBasicblocks(ESide var1) {
      return this.metaData.getSizeOfUnmatchedBasicblocks(var1);
   }

   public int getSizeOfUnmatchedCalls(ESide var1) {
      return this.metaData.getSizeOfUnmatchedCalls(var1);
   }

   public int getSizeOfUnmatchedFunctions(ESide var1) {
      return this.metaData.getSizeOfUnmatchedFunctions(var1);
   }

   public int getSizeOfUnmatchedInstructions(ESide var1) {
      return this.metaData.getSizeOfUnmatchedInstructions(var1);
   }

   public int getSizeOfUnmatchedJumps(ESide var1) {
      return this.metaData.getSizeOfUnmatchedJumps(var1);
   }

   public boolean isFunctionMatch(IAddress var1, IAddress var2) {
      IAddress var3 = this.getSecondaryFunctionAddr(var1);
      return var3 != null && var3.equals(var2);
   }

   public void notifyBasicblockMatchAddedListener(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      Iterator var5 = this.listener.iterator();

      while(var5.hasNext()) {
         IMatchesChangeListener var6 = (IMatchesChangeListener)var5.next();
         var6.addedBasicblockMatch(var1, var2, var3, var4);
      }

   }

   public void notifyBasicblockMatchRemovedListener(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      Iterator var5 = this.listener.iterator();

      while(var5.hasNext()) {
         IMatchesChangeListener var6 = (IMatchesChangeListener)var5.next();
         var6.removedBasicblockMatch(var1, var2, var3, var4);
      }

   }

   public void removeListener(IMatchesChangeListener var1) {
      this.listener.removeListener(var1);
   }

   public void setSizeOfChangedCalls(int var1) {
      this.metaData.setSizeOfChangedCalls(var1);
   }

   public void setSizeOfChangedFunctions(int var1) {
      this.metaData.setSizeOfChangedFunctions(var1);
   }

   public void setSizeOfMatchedBasicblocks(int var1) {
      this.metaData.setSizeOfMatchedBasicblocks(var1);
   }

   public void setSizeOfMatchedCalls(int var1) {
      this.metaData.setSizeOfMatchedCalls(var1);
   }

   public void setSizeOfMatchedInstructions(int var1) {
      this.metaData.setSizeOfMatchedInstructions(var1);
   }

   public void setSizeOfMatchedJumps(int var1) {
      this.metaData.setSizeOfMatchedJumps(var1);
   }
}
