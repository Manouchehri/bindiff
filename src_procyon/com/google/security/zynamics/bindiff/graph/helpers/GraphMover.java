package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.*;
import y.c.*;
import java.awt.geom.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import java.util.*;

public class GraphMover
{
    public static void moveToEdgeNode(final BinDiffGraph binDiffGraph, final d d, final double n, final double n2) {
        final aB i = binDiffGraph.getGraph().i(d);
        final fj t = binDiffGraph.getGraph().t(d.c());
        final fj t2 = binDiffGraph.getGraph().t(d.d());
        Point2D.Double double1;
        if (Math.sqrt(Math.pow(Math.abs(i.getSourcePort().a(t) - n), 2.0) + Math.pow(Math.abs(i.getSourcePort().b(t) - n2), 2.0)) > Math.sqrt(Math.pow(Math.abs(i.getSourcePort().a(t2) - n), 2.0) + Math.pow(Math.abs(i.getSourcePort().b(t2) - n2), 2.0))) {
            double1 = new Point2D.Double(t.getCenterX(), t.getCenterY());
        }
        else {
            double1 = new Point2D.Double(t2.getCenterX(), t2.getCenterY());
        }
        GraphAnimator.moveGraph(binDiffGraph, double1);
    }
    
    public static void moveToNode(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        if (!zyGraphNode.isVisible()) {
            GraphLayoutEventHandler.handleUnhideInvisibleNode(binDiffGraph, zyGraphNode);
        }
        new ArrayList<ZyGraphNode>().add(zyGraphNode);
        final fj t = binDiffGraph.getGraph().t(zyGraphNode.getNode());
        GraphAnimator.moveGraph(binDiffGraph, new Point2D.Double(t.getCenterX(), t.getCenterY()));
    }
}
