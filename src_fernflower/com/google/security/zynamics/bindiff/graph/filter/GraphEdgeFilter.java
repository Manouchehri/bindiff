package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.bindiff.graph.filter.GraphEdgeFilter$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;

public class GraphEdgeFilter {
   public static Collection filterInvisibleEdges(AbstractZyGraph var0) {
      ArrayList var1 = new ArrayList();
      var0.iterateEdges(new GraphEdgeFilter$1(var1));
      return var1;
   }
}
