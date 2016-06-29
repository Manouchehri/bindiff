package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class BasicBlockMatchData implements IAddressPair {
   private final IAddressPair addrPair;
   private final int algoId;
   private final Matches instructionMatches;

   public BasicBlockMatchData(long var1, long var3, int var5, Matches var6) {
      this.addrPair = new AddressPair(var1, var3);
      this.algoId = var5;
      this.instructionMatches = var6;
   }

   public long getAddress(ESide var1) {
      return this.addrPair.getAddress(var1);
   }

   public int getAlgorithmId() {
      return this.algoId;
   }

   public IAddress getIAddress(ESide var1) {
      return new CAddress(this.getAddress(var1));
   }

   public InstructionMatchData getInstructionMatch(IAddress var1, ESide var2) {
      return (InstructionMatchData)this.instructionMatches.get(var1, var2);
   }

   public InstructionMatchData[] getInstructionMatches() {
      return (InstructionMatchData[])this.instructionMatches.getMatches().toArray(new InstructionMatchData[0]);
   }

   public IAddress getPrimaryInstructionAddr(IAddress var1) {
      InstructionMatchData var2 = (InstructionMatchData)this.instructionMatches.get(var1, ESide.SECONDARY);
      return var2 != null?var2.getIAddress(ESide.PRIMARY):null;
   }

   public IAddress getSecondaryInstructionAddr(IAddress var1) {
      InstructionMatchData var2 = (InstructionMatchData)this.instructionMatches.get(var1, ESide.PRIMARY);
      return var2 != null?var2.getIAddress(ESide.SECONDARY):null;
   }

   public int getSizeOfMatchedInstructions() {
      return this.instructionMatches.size();
   }

   public boolean isInstructionMatch(IAddress var1) {
      IAddress var2 = this.getSecondaryInstructionAddr(var1);
      return var2 != null && var2.equals(var1);
   }
}
