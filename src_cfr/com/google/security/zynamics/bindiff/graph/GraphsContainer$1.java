/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import java.util.ArrayList;

class GraphsContainer$1
extends ArrayList {
    final /* synthetic */ SingleGraph val$primaryGraph;
    final /* synthetic */ SingleGraph val$secondaryGraph;
    final /* synthetic */ CombinedGraph val$combinedGraph;
    final /* synthetic */ SuperGraph val$superGraph;
    final /* synthetic */ GraphsContainer this$0;

    GraphsContainer$1(GraphsContainer graphsContainer, int n2, SingleGraph singleGraph, SingleGraph singleGraph2, CombinedGraph combinedGraph, SuperGraph superGraph) {
        this.this$0 = graphsContainer;
        this.val$primaryGraph = singleGraph;
        this.val$secondaryGraph = singleGraph2;
        this.val$combinedGraph = combinedGraph;
        this.val$superGraph = superGraph;
        super(n2);
        this.add(EGraph.PRIMARY_GRAPH.ordinal(), this.val$primaryGraph);
        this.add(EGraph.SECONDARY_GRAPH.ordinal(), this.val$secondaryGraph);
        this.add(EGraph.COMBINED_GRAPH.ordinal(), this.val$combinedGraph);
        this.add(EGraph.SUPER_GRAPH.ordinal(), this.val$superGraph);
    }
}

