package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Serializable, Comparator {
   private static final long serialVersionUID = -846090338272302586L;

   public int compare(Date var1, Date var2) {
      return var1.before(var2)?-1:(var1.equals(var2)?0:1);
   }
}
