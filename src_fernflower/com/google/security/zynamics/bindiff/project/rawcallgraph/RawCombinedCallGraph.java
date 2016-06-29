package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RawCombinedCallGraph extends MutableDirectedGraph {
   private final Map addrPairToCombinedFunction = new HashMap();

   public RawCombinedCallGraph(List var1, List var2) {
      super(var1, var2);
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         RawCombinedFunction var4 = (RawCombinedFunction)var3.next();
         this.addrPairToCombinedFunction.put(new Pair(var4.getAddress(ESide.PRIMARY), var4.getAddress(ESide.SECONDARY)), var4);
      }

   }

   public RawCombinedFunction getCombinedFunction(IAddress var1, IAddress var2) {
      return (RawCombinedFunction)this.addrPairToCombinedFunction.get(new Pair(var1, var2));
   }
}
