/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import y.c.q;
import y.d.y;
import y.h.aA;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public class ZoomFunctions {
    public static void zoomToEdgeLabel(AbstractZyGraph abstractZyGraph, ZyGraphEdge zyGraphEdge) {
        aA aA2 = zyGraphEdge.getRealizer().getLabel();
        y y2 = aA2.getBox();
        Rectangle rectangle = abstractZyGraph.getView().getBounds();
        double d2 = rectangle.getWidth() / y2.a();
        double d3 = rectangle.getHeight() / y2.b();
        double d4 = abstractZyGraph.getView().getZoom();
        abstractZyGraph.getView().setZoom(0.8 * Math.min(d2, d3));
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        double d5 = abstractZyGraph.getView().getZoom();
        abstractZyGraph.getView().setZoom(d4);
        Point2D.Double double_ = new Point2D.Double(y2.c() + 0.5 * y2.a(), y2.d() + 0.5 * y2.b());
        abstractZyGraph.getView().focusView(d5, double_, true);
        abstractZyGraph.updateViews();
    }

    public static void zoomToNode(AbstractZyGraph abstractZyGraph, ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can't be null");
        fj fj2 = abstractZyGraph.getGraph().t(zyGraphNode.getNode());
        Preconditions.checkNotNull(fj2, "Error: Node does not belong to the graph");
        if (!zyGraphNode.isVisible()) {
            abstractZyGraph.showNode(zyGraphNode, true);
        }
        double d2 = abstractZyGraph.getView().getZoom();
        Point2D point2D = abstractZyGraph.getView().getViewPoint2D();
        abstractZyGraph.getView().zoomToArea(fj2.getCenterX() - fj2.getWidth(), fj2.getCenterY() - fj2.getHeight(), fj2.getWidth() * 2.0, fj2.getHeight() * 2.0);
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        double d3 = abstractZyGraph.getView().getZoom();
        Point2D point2D2 = abstractZyGraph.getView().getCenter();
        abstractZyGraph.getView().setZoom(d2);
        abstractZyGraph.getView().setViewPoint((int)point2D.getX(), (int)point2D.getY());
        abstractZyGraph.getView().focusView(d3, point2D2, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }

    public static void zoomToNode(AbstractZyGraph abstractZyGraph, ZyGraphNode zyGraphNode, int n2, boolean bl2) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can't be null");
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        Preconditions.checkNotNull(iZyNodeRealizer, "Error: Node does not belong to the graph");
        double d2 = iZyNodeRealizer.getNodeContent().getLineHeight() * (double)n2;
        Point2D point2D = abstractZyGraph.getView().getViewPoint2D();
        abstractZyGraph.getView().setCenter(iZyNodeRealizer.getCenterX(), iZyNodeRealizer.getCenterY() - iZyNodeRealizer.getHeight() / 2.0 + d2);
        if (bl2) {
            Point2D point2D2 = abstractZyGraph.getView().getCenter();
            abstractZyGraph.getView().setViewPoint((int)point2D.getX(), (int)point2D.getY());
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), point2D2, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        }
        abstractZyGraph.updateViews();
    }

    public static void zoomToNodes(AbstractZyGraph abstractZyGraph, Collection collection) {
        Preconditions.checkNotNull(collection, "Error: nodes argument can not be null");
        if (collection.size() == 0) {
            return;
        }
        double d2 = abstractZyGraph.getView().getZoom();
        Point2D point2D = abstractZyGraph.getView().getViewPoint2D();
        Rectangle2D rectangle2D = GraphHelpers.calculateBoundingBox(collection);
        abstractZyGraph.getView().zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        abstractZyGraph.zoomOut();
        double d3 = abstractZyGraph.getView().getZoom();
        Point2D point2D2 = abstractZyGraph.getView().getCenter();
        abstractZyGraph.getView().setZoom(d2);
        abstractZyGraph.getView().setViewPoint((int)point2D.getX(), (int)point2D.getY());
        abstractZyGraph.getView().focusView(d3, point2D2, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }

    public static void zoomToScreen(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().fitContent();
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        abstractZyGraph.updateViews();
    }
}

