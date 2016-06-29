/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class CombinedDiffEdge
extends ZyGraphEdge {
    private final SingleDiffEdge primaryDiffEdge;
    private final SingleDiffEdge secondaryDiffEdge;
    private final SuperDiffEdge superDiffEdge;

    public CombinedDiffEdge(CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2, d d2, ZyEdgeRealizer zyEdgeRealizer, CombinedViewEdge combinedViewEdge, SuperDiffEdge superDiffEdge) {
        super(combinedDiffNode, combinedDiffNode2, d2, zyEdgeRealizer, combinedViewEdge);
        this.superDiffEdge = (SuperDiffEdge)Preconditions.checkNotNull(superDiffEdge);
        this.primaryDiffEdge = superDiffEdge.getPrimaryDiffEdge();
        this.secondaryDiffEdge = superDiffEdge.getSecondaryDiffEdge();
    }

    public SingleDiffEdge getPrimaryDiffEdge() {
        return this.primaryDiffEdge;
    }

    public SingleDiffEdge getSecondaryDiffEdge() {
        return this.secondaryDiffEdge;
    }

    public SuperDiffEdge getSuperDiffEdge() {
        return this.superDiffEdge;
    }
}

