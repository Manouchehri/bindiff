/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Set;
import y.c.q;
import y.d.y;
import y.h.aA;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public class MoveFunctions {
    public static void centerEdgeLable(AbstractZyGraph abstractZyGraph, ZyGraphEdge zyGraphEdge) {
        Preconditions.checkNotNull(zyGraphEdge, "Error: Edge can't be null.");
        if (!zyGraphEdge.isVisible()) throw new IllegalStateException("Error: Edge does not belong to graph.");
        y y2 = zyGraphEdge.getRealizer().getLabel().getBox();
        double d2 = y2.c + y2.a / 2.0;
        double d3 = y2.d + y2.b / 2.0;
        abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(d2, d3), abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }

    public static void centerNode(AbstractZyGraph abstractZyGraph, ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can't be null");
        fj fj2 = abstractZyGraph.getGraph().t(zyGraphNode.getNode());
        if (!fj2.isVisible()) return;
        abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(fj2.getCenterX(), fj2.getCenterY()), abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }

    public static void centerNodes(AbstractZyGraph abstractZyGraph, Set set) {
        Preconditions.checkNotNull(set, "Error: Nodes argument is null");
        Preconditions.checkArgument(!set.isEmpty(), "Error: Nodes argument is empty");
        Rectangle2D rectangle2D = GraphHelpers.calculateBoundingBox(set);
        abstractZyGraph.getView().setCenter(rectangle2D.getX() + rectangle2D.getWidth() / 2.0, rectangle2D.getY() + rectangle2D.getHeight() / 2.0);
        abstractZyGraph.updateViews();
    }

    public static void pan(AbstractZyGraph abstractZyGraph, double d2, double d3) {
        double d4 = 50.0 / abstractZyGraph.getView().getZoom();
        Point2D.Double double_ = (Point2D.Double)abstractZyGraph.getView().getCenter();
        double d5 = double_.getX() + (d2 *= d4);
        double d6 = double_.getY() + (d3 *= d4);
        d2 = d2 < 0.0 ? (double)((int)Math.floor(d2)) : (double)((int)Math.ceil(d2) + 2);
        d3 = d3 < 0.0 ? (double)((int)Math.floor(d3)) : (double)((int)Math.ceil(d3) + 2);
        Rectangle rectangle = abstractZyGraph.getView().getWorldRect();
        Rectangle rectangle2 = abstractZyGraph.getView().getVisibleRect();
        if (rectangle2.x + (int)d2 < rectangle.x) {
            d5 += (double)(rectangle.x - (rectangle2.x + (int)d2));
        } else if (rectangle2.x + rectangle2.width + (int)d2 > rectangle.x + rectangle.width) {
            d5 -= (double)(rectangle2.x + rectangle2.width + (int)d2 - (rectangle.x + rectangle.width));
        }
        if (rectangle2.y + (int)d3 < rectangle.y) {
            d6 += (double)(rectangle.y - (rectangle2.y + (int)d3));
        } else if (rectangle2.y + rectangle2.height + (int)d3 > rectangle.y + rectangle.height) {
            d6 -= (double)(rectangle2.y + rectangle2.height + (int)d3 - (rectangle.y + rectangle.height));
        }
        abstractZyGraph.getView().setCenter(d5, d6);
        abstractZyGraph.updateViews();
    }
}

