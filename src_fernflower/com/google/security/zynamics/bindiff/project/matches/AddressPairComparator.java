package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import java.util.Comparator;

public class AddressPairComparator implements Comparator {
   final ESide sortBySide;

   public AddressPairComparator(ESide var1) {
      this.sortBySide = var1;
   }

   public int compare(IAddressPair var1, IAddressPair var2) {
      return CAddress.compare(var1.getAddress(this.sortBySide), var2.getAddress(this.sortBySide));
   }
}
