package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.util.Sort$Comparable;

class UnixRuntime$GlobalState$MP implements Sort$Comparable {
   public String path;
   public UnixRuntime$FS fs;

   public UnixRuntime$GlobalState$MP(String var1, UnixRuntime$FS var2) {
      this.path = var1;
      this.fs = var2;
   }

   public int compareTo(Object var1) {
      return !(var1 instanceof UnixRuntime$GlobalState$MP)?1:-this.path.compareTo(((UnixRuntime$GlobalState$MP)var1).path);
   }
}
