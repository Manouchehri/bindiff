package com.google.security.zynamics.bindiff.types;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.Comparator;

public class AddressPairComparator implements Comparator {
   final ESide sortBySide;

   public AddressPairComparator(ESide var1) {
      this.sortBySide = var1;
   }

   public int compare(Pair var1, Pair var2) {
      IAddress var3 = this.sortBySide == ESide.PRIMARY?(IAddress)var1.first():(IAddress)var1.second();
      IAddress var4 = this.sortBySide == ESide.PRIMARY?(IAddress)var2.first():(IAddress)var2.second();
      return var3.compareTo(var4);
   }
}
