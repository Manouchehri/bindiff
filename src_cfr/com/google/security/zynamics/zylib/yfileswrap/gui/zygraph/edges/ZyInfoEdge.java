/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$CInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class ZyInfoEdge
extends ZyGraphEdge {
    public ZyInfoEdge(ZyGraphNode zyGraphNode, ZyGraphNode zyGraphNode2, d d2, ZyEdgeRealizer zyEdgeRealizer) {
        super(zyGraphNode, zyGraphNode2, d2, zyEdgeRealizer, new ZyInfoEdge$CInfoEdge(null));
    }
}

