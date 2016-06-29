/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import java.util.Collection;

final class GraphZoomer$1
implements Runnable {
    final /* synthetic */ BinDiffGraph val$graph;
    final /* synthetic */ Collection val$nodes;

    GraphZoomer$1(BinDiffGraph binDiffGraph, Collection collection) {
        this.val$graph = binDiffGraph;
        this.val$nodes = collection;
    }

    @Override
    public void run() {
        GraphZoomer.access$000(this.val$graph, this.val$nodes);
    }
}

