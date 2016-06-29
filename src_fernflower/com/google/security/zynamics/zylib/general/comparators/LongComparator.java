package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class LongComparator implements Serializable, Comparator {
   private static final long serialVersionUID = 2814764330420080628L;

   public int compare(Long var1, Long var2) {
      long var3 = var1.longValue() - var2.longValue();
      return var3 > 0L?1:(var3 < 0L?-1:0);
   }
}
