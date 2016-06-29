/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.util.PortConstraints;
import y.f.O;
import y.f.c;

class GraphLayoutCalculator$InternalLayoutThread
extends Thread {
    private final BinDiffGraph graph;
    private final c layouter;
    private O graphLayout;
    private GraphLayoutException exception;
    final /* synthetic */ GraphLayoutCalculator this$0;

    protected GraphLayoutCalculator$InternalLayoutThread(GraphLayoutCalculator graphLayoutCalculator, BinDiffGraph binDiffGraph, c c2) {
        this.this$0 = graphLayoutCalculator;
        this.graphLayout = null;
        this.exception = null;
        this.graph = binDiffGraph;
        this.layouter = c2;
    }

    protected GraphLayoutException getException() {
        return this.exception;
    }

    protected O getGraphLayout() {
        return this.graphLayout;
    }

    @Override
    public void run() {
        try {
            if (this.graph instanceof CombinedGraph) {
                PortConstraints.configureConstraints((CombinedGraph)this.graph);
            }
            this.graphLayout = this.graph.calculateLayout(this.layouter);
            return;
        }
        catch (GraphLayoutException var1_1) {
            this.exception = var1_1;
            return;
        }
        finally {
            GraphLayoutCalculator.access$000(this.this$0).countDown();
        }
    }
}

