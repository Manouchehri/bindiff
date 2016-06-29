package com.google.security.zynamics.bindiff.graph;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;

class GraphsContainer$1 extends ArrayList
{
    final /* synthetic */ SingleGraph val$primaryGraph;
    final /* synthetic */ SingleGraph val$secondaryGraph;
    final /* synthetic */ CombinedGraph val$combinedGraph;
    final /* synthetic */ SuperGraph val$superGraph;
    final /* synthetic */ GraphsContainer this$0;
    
    GraphsContainer$1(final GraphsContainer this$0, final int n, final SingleGraph val$primaryGraph, final SingleGraph val$secondaryGraph, final CombinedGraph val$combinedGraph, final SuperGraph val$superGraph) {
        this.this$0 = this$0;
        this.val$primaryGraph = val$primaryGraph;
        this.val$secondaryGraph = val$secondaryGraph;
        this.val$combinedGraph = val$combinedGraph;
        this.val$superGraph = val$superGraph;
        super(n);
        this.add(EGraph.PRIMARY_GRAPH.ordinal(), this.val$primaryGraph);
        this.add(EGraph.SECONDARY_GRAPH.ordinal(), this.val$secondaryGraph);
        this.add(EGraph.COMBINED_GRAPH.ordinal(), this.val$combinedGraph);
        this.add(EGraph.SUPER_GRAPH.ordinal(), this.val$superGraph);
    }
}
