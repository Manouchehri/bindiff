package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import java.util.Comparator;

public class MatchStateComparator implements Comparator {
   public int compare(EMatchState var1, EMatchState var2) {
      int var3 = EMatchState.getOrdinal(var1) - EMatchState.getOrdinal(var2);
      return var3 < 0?1:(var3 > 0?-1:0);
   }
}
