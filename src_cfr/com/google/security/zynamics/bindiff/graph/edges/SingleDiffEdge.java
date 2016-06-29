/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class SingleDiffEdge
extends ZyGraphEdge {
    private SingleDiffEdge otherDiffEdge;
    private SuperDiffEdge superDiffEdge;
    private CombinedDiffEdge combinedDiffEdge;
    private final ESide side;

    public SingleDiffEdge(SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, d d2, ZyEdgeRealizer zyEdgeRealizer, SingleViewEdge singleViewEdge, ESide eSide) {
        super(singleDiffNode, singleDiffNode2, d2, zyEdgeRealizer, singleViewEdge);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
    }

    public CombinedDiffEdge getCombinedDiffEdge() {
        return this.combinedDiffEdge;
    }

    public SingleDiffEdge getOtherSideDiffEdge() {
        return this.otherDiffEdge;
    }

    public ESide getSide() {
        return this.side;
    }

    public SuperDiffEdge getSuperDiffEdge() {
        return this.superDiffEdge;
    }

    public void setCombinedDiffEdge(CombinedDiffEdge combinedDiffEdge) {
        this.combinedDiffEdge = combinedDiffEdge;
        this.superDiffEdge = combinedDiffEdge.getSuperDiffEdge();
        this.otherDiffEdge = this.side == ESide.PRIMARY ? combinedDiffEdge.getSecondaryDiffEdge() : combinedDiffEdge.getPrimaryDiffEdge();
    }
}

