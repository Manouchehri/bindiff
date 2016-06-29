package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class IntComparator implements Serializable, Comparator {
   private static final long serialVersionUID = -9039204490352575348L;

   public int compare(Integer var1, Integer var2) {
      return var1.intValue() - var2.intValue();
   }
}
