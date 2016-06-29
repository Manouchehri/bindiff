package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Sort$Comparable;
import org.ibex.nestedvm.util.Sort$CompareFunc;

class Sort$1 implements Sort$CompareFunc {
   public int compare(Object var1, Object var2) {
      return ((Sort$Comparable)var1).compareTo(var2);
   }
}
