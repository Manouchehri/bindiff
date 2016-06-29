package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class DoubleComparator implements Serializable, Comparator {
   public int compare(Double var1, Double var2) {
      return Double.compare(var1.doubleValue(), var2.doubleValue());
   }
}
