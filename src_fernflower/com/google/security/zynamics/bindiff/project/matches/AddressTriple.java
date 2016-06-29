package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.project.matches.AddressTriple$1;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple$EIndex;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class AddressTriple {
   private final long firstAddr;
   private final long secondAddr;
   private final long thirdAddr;

   public AddressTriple(long var1, long var3, long var5) {
      this.firstAddr = var1;
      this.secondAddr = var3;
      this.thirdAddr = var5;
   }

   public boolean equals(Object var1) {
      return this.firstAddr == ((AddressTriple)var1).getAddress(AddressTriple$EIndex.FIRST) && this.secondAddr == ((AddressTriple)var1).getAddress(AddressTriple$EIndex.SECOND) && this.thirdAddr == ((AddressTriple)var1).getAddress(AddressTriple$EIndex.THIRD);
   }

   public long getAddress(AddressTriple$EIndex var1) {
      switch(AddressTriple$1.$SwitchMap$com$google$security$zynamics$bindiff$project$matches$AddressTriple$EIndex[var1.ordinal()]) {
      case 1:
         return this.firstAddr;
      case 2:
         return this.secondAddr;
      case 3:
         return this.thirdAddr;
      default:
         throw new IllegalArgumentException("Illegal argument.");
      }
   }

   public IAddress getIAddress(AddressTriple$EIndex var1) {
      return new CAddress(this.getAddress(var1));
   }

   public int hashCode() {
      return (int)((this.firstAddr ^ this.firstAddr >>> 32) * (this.firstAddr ^ this.secondAddr >>> 32) * (this.thirdAddr ^ this.thirdAddr >>> 32));
   }
}
