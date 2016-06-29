/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.synchronizer;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.HashSet;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public class GraphMouseHoverSynchronizer {
    private static void highlightEdge(d d2) {
        aB aB2 = ((bu)d2.a()).i(d2);
        dr dr2 = aB2.getLineType();
        if (dr2 == dr.b) {
            aB2.setLineType(dr.e);
            return;
        }
        if (dr2 == dr.i) {
            aB2.setLineType(dr.l);
            return;
        }
        if (dr2 == dr.n) {
            aB2.setLineType(dr.q);
            return;
        }
        if (dr2 == dr.e) {
            aB2.setLineType(dr.b);
            return;
        }
        if (dr2 == dr.l) {
            aB2.setLineType(dr.i);
            return;
        }
        if (dr2 != dr.q) return;
        aB2.setLineType(dr.n);
    }

    public static void adoptHoveredNodeState(SingleGraph singleGraph, SingleDiffNode singleDiffNode) {
        if (!singleGraph.getSettings().isSync()) return;
        SingleDiffNode singleDiffNode2 = singleDiffNode.getOtherSideDiffNode();
        if (singleDiffNode2 != null) {
            fj fj2 = singleDiffNode.getRealizer().getRealizer();
            fj fj3 = singleDiffNode2.getRealizer().getRealizer();
            fj3.setLineType(fj2.getLineType());
            HashSet<d> hashSet = new HashSet<d>();
            e e2 = singleDiffNode2.getNode().j();
            while (e2.f()) {
                if (!hashSet.contains(e2.a())) {
                    GraphMouseHoverSynchronizer.highlightEdge(e2.a());
                }
                hashSet.add(e2.a());
                e2.g();
            }
        }
        singleGraph.getSecondaryGraph().updateViews();
        singleGraph.getPrimaryGraph().updateViews();
    }
}

