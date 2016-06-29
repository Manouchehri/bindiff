/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class SuperDiffEdge
extends ZyGraphEdge {
    private final SingleDiffEdge primaryDiffEdge;
    private final SingleDiffEdge secondaryDiffEdge;
    private CombinedDiffEdge combinedDiffEdge;

    public SuperDiffEdge(SuperDiffNode superDiffNode, SuperDiffNode superDiffNode2, d d2, ZyEdgeRealizer zyEdgeRealizer, SuperViewEdge superViewEdge, SingleDiffEdge singleDiffEdge, SingleDiffEdge singleDiffEdge2) {
        super(superDiffNode, superDiffNode2, d2, zyEdgeRealizer, superViewEdge);
        Preconditions.checkArgument(singleDiffEdge != null || singleDiffEdge2 != null, "Primary and secondary edge cannot both be null.");
        this.primaryDiffEdge = singleDiffEdge;
        this.secondaryDiffEdge = singleDiffEdge2;
    }

    public CombinedDiffEdge getCombinedDiffEdge() {
        return this.combinedDiffEdge;
    }

    public SingleDiffEdge getPrimaryDiffEdge() {
        return this.primaryDiffEdge;
    }

    @Override
    public SuperViewEdge getRawEdge() {
        return (SuperViewEdge)super.getRawEdge();
    }

    public SingleDiffEdge getSecondaryDiffEdge() {
        return this.secondaryDiffEdge;
    }

    public void setCombinedDiffEdge(CombinedDiffEdge combinedDiffEdge) {
        this.combinedDiffEdge = combinedDiffEdge;
    }
}

