/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphAnimator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import y.c.d;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.fL;
import y.h.fj;

public class GraphMover {
    public static void moveToEdgeNode(BinDiffGraph binDiffGraph, d d2, double d3, double d4) {
        double d5;
        aB aB2 = binDiffGraph.getGraph().i(d2);
        fj fj2 = binDiffGraph.getGraph().t(d2.c());
        fj fj3 = binDiffGraph.getGraph().t(d2.d());
        double d6 = aB2.getSourcePort().a(fj2);
        double d7 = aB2.getSourcePort().b(fj2);
        double d8 = aB2.getSourcePort().a(fj3);
        double d9 = aB2.getSourcePort().b(fj3);
        double d10 = Math.abs(d6 - d3);
        double d11 = Math.abs(d7 - d4);
        double d12 = Math.abs(d8 - d3);
        double d13 = Math.abs(d9 - d4);
        double d14 = Math.sqrt(Math.pow(d10, 2.0) + Math.pow(d11, 2.0));
        Point2D.Double double_ = d14 > (d5 = Math.sqrt(Math.pow(d12, 2.0) + Math.pow(d13, 2.0))) ? new Point2D.Double(fj2.getCenterX(), fj2.getCenterY()) : new Point2D.Double(fj3.getCenterX(), fj3.getCenterY());
        GraphAnimator.moveGraph(binDiffGraph, double_);
    }

    public static void moveToNode(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        if (!zyGraphNode.isVisible()) {
            GraphLayoutEventHandler.handleUnhideInvisibleNode(binDiffGraph, zyGraphNode);
        }
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        arrayList.add(zyGraphNode);
        q q2 = zyGraphNode.getNode();
        fj fj2 = binDiffGraph.getGraph().t(q2);
        Point2D.Double double_ = new Point2D.Double(fj2.getCenterX(), fj2.getCenterY());
        GraphAnimator.moveGraph(binDiffGraph, double_);
    }
}

