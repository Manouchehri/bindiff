package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class AddressPair implements IAddressPair {
   private final long priAddr;
   private final long secAddr;

   public AddressPair(long var1, long var3) {
      this.priAddr = var1;
      this.secAddr = var3;
   }

   public boolean equals(Object var1) {
      return this.priAddr == ((AddressPair)var1).getAddress(ESide.PRIMARY) && this.secAddr == ((AddressPair)var1).getAddress(ESide.SECONDARY);
   }

   public long getAddress(ESide var1) {
      return var1 == ESide.PRIMARY?this.priAddr:this.secAddr;
   }

   public IAddress getIAddress(ESide var1) {
      return new CAddress(this.getAddress(var1));
   }

   public int hashCode() {
      return (int)((this.priAddr ^ this.priAddr >>> 32) * (this.secAddr ^ this.secAddr >>> 32));
   }
}
