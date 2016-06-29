/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.q;
import y.f.X;
import y.f.ax;
import y.f.c;
import y.g.M;
import y.h.bu;

public class PortConstraints {
    private static Collection createLeftPorts(q q2, X x2) {
        double d2 = x2.p(q2) * 0.5;
        double d3 = x2.q(q2) * 0.5;
        D d4 = new D();
        d4.add(ax.a(- d2, - d3, 1));
        d4.add(ax.a(- d2, d3, 2));
        return d4;
    }

    private static Collection createMiddlePorts(q q2, X x2) {
        double d2 = x2.q(q2) * 0.5;
        D d3 = new D();
        d3.add(ax.a(0.0, - d2, 1));
        d3.add(ax.a(0.0, d2, 2));
        return d3;
    }

    private static Collection createRightPorts(q q2, X x2) {
        double d2 = x2.p(q2) * 0.5;
        double d3 = x2.q(q2) * 0.5;
        D d4 = new D();
        d4.add(ax.a(d2, - d3, 1));
        d4.add(ax.a(d2, d3, 2));
        return d4;
    }

    public static void configureConstraints(CombinedGraph combinedGraph) {
        GraphLayoutSettings graphLayoutSettings = combinedGraph.getSettings().getLayoutSettings();
        if (!(graphLayoutSettings.getCurrentLayouter() instanceof y.f.c.M)) return;
        if (graphLayoutSettings.getHierarchicOrientation() != ELayoutOrientation.HORIZONTAL) return;
        bu bu2 = combinedGraph.getGraph();
        h h2 = M.b();
        bu2.a(ax.a, h2);
        h h3 = M.b();
        bu2.a(ax.b, h3);
        e e2 = bu2.p();
        while (e2.f()) {
            d d2 = e2.a();
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(d2.c());
            CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(d2.d());
            if (combinedDiffNode == null || combinedDiffNode2 == null) {
                h2.a((Object)d2, PortConstraints.createMiddlePorts(d2.c(), bu2));
                h3.a((Object)d2, PortConstraints.createMiddlePorts(d2.d(), bu2));
            } else {
                CombinedDiffEdge combinedDiffEdge = (CombinedDiffEdge)combinedGraph.getEdge(d2);
                EMatchState eMatchState = ((CombinedViewEdge)combinedDiffEdge.getRawEdge()).getMatchState();
                if (combinedDiffNode.getPrimaryDiffNode() == null || combinedDiffNode.getSecondaryDiffNode() == null) {
                    h2.a((Object)d2, PortConstraints.createMiddlePorts(d2.c(), bu2));
                } else if (eMatchState == EMatchState.MATCHED) {
                    h2.a((Object)d2, PortConstraints.createMiddlePorts(d2.c(), bu2));
                } else if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
                    h2.a((Object)d2, PortConstraints.createLeftPorts(d2.c(), bu2));
                } else {
                    h2.a((Object)d2, PortConstraints.createRightPorts(d2.c(), bu2));
                }
                if (combinedDiffNode2.getPrimaryDiffNode() == null || combinedDiffNode2.getSecondaryDiffNode() == null) {
                    h3.a((Object)d2, PortConstraints.createMiddlePorts(d2.d(), bu2));
                } else if (eMatchState == EMatchState.MATCHED) {
                    h3.a((Object)d2, PortConstraints.createMiddlePorts(d2.d(), bu2));
                } else if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
                    h3.a((Object)d2, PortConstraints.createLeftPorts(d2.d(), bu2));
                } else {
                    h3.a((Object)d2, PortConstraints.createRightPorts(d2.d(), bu2));
                }
            }
            e2.g();
        }
    }
}

