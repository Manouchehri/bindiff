package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class LexicalComparator implements Serializable, Comparator {
   public int compare(String var1, String var2) {
      return var1.compareToIgnoreCase(var2);
   }
}
