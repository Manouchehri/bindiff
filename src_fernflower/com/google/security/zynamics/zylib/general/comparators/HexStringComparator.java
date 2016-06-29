package com.google.security.zynamics.zylib.general.comparators;

import com.google.security.zynamics.zylib.disassembly.CAddress;
import java.io.Serializable;
import java.util.Comparator;

public class HexStringComparator implements Serializable, Comparator {
   private static final long serialVersionUID = 8204731939693038511L;

   public int compare(String var1, String var2) {
      return !var1.isEmpty() && !var2.isEmpty()?CAddress.compare(Long.valueOf(var1, 16).longValue(), Long.valueOf(var2, 16).longValue()):(var1.equals(var2)?0:(var2.isEmpty()?1:-1));
   }
}
