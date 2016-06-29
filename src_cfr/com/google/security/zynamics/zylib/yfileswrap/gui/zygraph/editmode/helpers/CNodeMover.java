/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Set;
import y.c.d;
import y.c.e;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.x;
import y.h.y;

public class CNodeMover {
    public static boolean isDraggedFar(double d2, double d3, double d4, double d5) {
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        if (Math.abs(d6) > 15.0) return true;
        if (Math.abs(d7) > 15.0) return true;
        return false;
    }

    public static void moveNode(AbstractZyGraph abstractZyGraph, ZyGraphNode zyGraphNode, double d2, double d3, Set set) {
        abstractZyGraph.getGraph().t(zyGraphNode.getNode()).moveBy(d2, d3);
        e e2 = zyGraphNode.getNode().j();
        while (e2.f()) {
            d d4 = e2.a();
            y y2 = abstractZyGraph.getGraph().i(d4).bends();
            while (y2.f()) {
                x x2 = y2.a();
                if (!set.contains(x2)) {
                    x2.b(d2, d3);
                    set.add(x2);
                }
                y2.g();
            }
            e2.g();
        }
    }
}

