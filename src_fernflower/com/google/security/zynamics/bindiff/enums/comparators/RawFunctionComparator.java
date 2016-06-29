package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import java.util.Comparator;

public class RawFunctionComparator implements Comparator {
   public int compare(RawFunction var1, RawFunction var2) {
      return var1.getAddress().compareTo(var2.getAddress());
   }
}
