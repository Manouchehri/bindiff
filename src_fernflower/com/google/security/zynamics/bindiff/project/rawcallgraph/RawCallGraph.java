package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph$1;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Iterator;
import java.util.List;

public class RawCallGraph extends MutableDirectedGraph {
   private final ImmutableMap addressToFunction;
   private final ESide side;

   public RawCallGraph(List var1, List var2, ESide var3) {
      super(var1, var2);
      this.side = (ESide)Preconditions.checkNotNull(var3);
      this.addressToFunction = Maps.uniqueIndex((Iterable)var1, new RawCallGraph$1(this));
   }

   public RawFunction getFunction(IAddress var1) {
      return (RawFunction)this.addressToFunction.get(var1);
   }

   public ESide getSide() {
      return this.side;
   }

   public void resetVisibilityAndSelection() {
      Iterator var1 = this.getEdges().iterator();

      while(var1.hasNext()) {
         RawCall var2 = (RawCall)var1.next();
         var2.removeAllListeners();
         var2.setVisible(true);
         var2.setSelected(false);
      }

      var1 = this.getNodes().iterator();

      while(var1.hasNext()) {
         RawFunction var3 = (RawFunction)var1.next();
         var3.removeAllListeners();
         var3.setVisible(true);
         var3.setSelected(false);
      }

   }
}
