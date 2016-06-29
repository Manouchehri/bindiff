package com.google.security.zynamics.bindiff.graph.layout.util;

import java.util.*;
import y.f.*;
import com.google.security.zynamics.bindiff.graph.*;
import y.f.c.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import y.h.*;
import y.c.*;

public class PortConstraints
{
    private static Collection createLeftPorts(final q q, final X x) {
        final double n = x.p(q) * 0.5;
        final double n2 = x.q(q) * 0.5;
        final D d = new D();
        d.add(ax.a(-n, -n2, 1));
        d.add(ax.a(-n, n2, 2));
        return d;
    }
    
    private static Collection createMiddlePorts(final q q, final X x) {
        final double n = x.q(q) * 0.5;
        final D d = new D();
        d.add(ax.a(0.0, -n, 1));
        d.add(ax.a(0.0, n, 2));
        return d;
    }
    
    private static Collection createRightPorts(final q q, final X x) {
        final double n = x.p(q) * 0.5;
        final double n2 = x.q(q) * 0.5;
        final D d = new D();
        d.add(ax.a(n, -n2, 1));
        d.add(ax.a(n, n2, 2));
        return d;
    }
    
    public static void configureConstraints(final CombinedGraph combinedGraph) {
        final GraphLayoutSettings layoutSettings = combinedGraph.getSettings().getLayoutSettings();
        if (layoutSettings.getCurrentLayouter() instanceof M && layoutSettings.getHierarchicOrientation() == ELayoutOrientation.HORIZONTAL) {
            final bu graph = combinedGraph.getGraph();
            final h b = y.g.M.b();
            graph.a(ax.a, b);
            final h b2 = y.g.M.b();
            graph.a(ax.b, b2);
            final e p = graph.p();
            while (p.f()) {
                final d a = p.a();
                final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(a.c());
                final CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(a.d());
                if (combinedDiffNode == null || combinedDiffNode2 == null) {
                    b.a(a, createMiddlePorts(a.c(), graph));
                    b2.a(a, createMiddlePorts(a.d(), graph));
                }
                else {
                    final EMatchState matchState = ((CombinedViewEdge)((CombinedDiffEdge)combinedGraph.getEdge(a)).getRawEdge()).getMatchState();
                    if (combinedDiffNode.getPrimaryDiffNode() == null || combinedDiffNode.getSecondaryDiffNode() == null) {
                        b.a(a, createMiddlePorts(a.c(), graph));
                    }
                    else if (matchState == EMatchState.MATCHED) {
                        b.a(a, createMiddlePorts(a.c(), graph));
                    }
                    else if (matchState == EMatchState.PRIMARY_UNMATCHED) {
                        b.a(a, createLeftPorts(a.c(), graph));
                    }
                    else {
                        b.a(a, createRightPorts(a.c(), graph));
                    }
                    if (combinedDiffNode2.getPrimaryDiffNode() == null || combinedDiffNode2.getSecondaryDiffNode() == null) {
                        b2.a(a, createMiddlePorts(a.d(), graph));
                    }
                    else if (matchState == EMatchState.MATCHED) {
                        b2.a(a, createMiddlePorts(a.d(), graph));
                    }
                    else if (matchState == EMatchState.PRIMARY_UNMATCHED) {
                        b2.a(a, createLeftPorts(a.d(), graph));
                    }
                    else {
                        b2.a(a, createRightPorts(a.d(), graph));
                    }
                }
                p.g();
            }
        }
    }
}
