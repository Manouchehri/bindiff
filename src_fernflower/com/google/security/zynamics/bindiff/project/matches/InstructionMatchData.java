package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class InstructionMatchData implements IAddressPair {
   private final IAddressPair addrPair;

   public InstructionMatchData(long var1, long var3) {
      this.addrPair = new AddressPair(var1, var3);
   }

   public long getAddress(ESide var1) {
      return this.addrPair.getAddress(var1);
   }

   public IAddress getIAddress(ESide var1) {
      return new CAddress(this.getAddress(var1));
   }
}
