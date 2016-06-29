package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import java.util.Comparator;

public class RawFunctionTypeComparator implements Comparator {
   public int compare(EFunctionType var1, EFunctionType var2) {
      return EFunctionType.getOrdinal(var1) - EFunctionType.getOrdinal(var2);
   }
}
