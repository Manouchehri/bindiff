package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import y.d.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.awt.geom.*;

public class ZoomFunctions
{
    public static void zoomToEdgeLabel(final AbstractZyGraph abstractZyGraph, final ZyGraphEdge zyGraphEdge) {
        final y box = zyGraphEdge.getRealizer().getLabel().getBox();
        final Rectangle bounds = abstractZyGraph.getView().getBounds();
        final double n = bounds.getWidth() / box.a();
        final double n2 = bounds.getHeight() / box.b();
        final double zoom = abstractZyGraph.getView().getZoom();
        abstractZyGraph.getView().setZoom(0.8 * Math.min(n, n2));
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        final double zoom2 = abstractZyGraph.getView().getZoom();
        abstractZyGraph.getView().setZoom(zoom);
        abstractZyGraph.getView().focusView(zoom2, new Point2D.Double(box.c() + 0.5 * box.a(), box.d() + 0.5 * box.b()), true);
        abstractZyGraph.updateViews();
    }
    
    public static void zoomToNode(final AbstractZyGraph abstractZyGraph, final ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Error: Node argument can't be null");
        final fj t = abstractZyGraph.getGraph().t(zyGraphNode.getNode());
        Preconditions.checkNotNull(t, (Object)"Error: Node does not belong to the graph");
        if (!zyGraphNode.isVisible()) {
            abstractZyGraph.showNode(zyGraphNode, true);
        }
        final double zoom = abstractZyGraph.getView().getZoom();
        final Point2D viewPoint2D = abstractZyGraph.getView().getViewPoint2D();
        abstractZyGraph.getView().zoomToArea(t.getCenterX() - t.getWidth(), t.getCenterY() - t.getHeight(), t.getWidth() * 2.0, t.getHeight() * 2.0);
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        final double zoom2 = abstractZyGraph.getView().getZoom();
        final Point2D center = abstractZyGraph.getView().getCenter();
        abstractZyGraph.getView().setZoom(zoom);
        abstractZyGraph.getView().setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
        abstractZyGraph.getView().focusView(zoom2, center, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }
    
    public static void zoomToNode(final AbstractZyGraph abstractZyGraph, final ZyGraphNode zyGraphNode, final int n, final boolean b) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Error: Node argument can't be null");
        final IZyNodeRealizer realizer = zyGraphNode.getRealizer();
        Preconditions.checkNotNull(realizer, (Object)"Error: Node does not belong to the graph");
        final double n2 = realizer.getNodeContent().getLineHeight() * n;
        final Point2D viewPoint2D = abstractZyGraph.getView().getViewPoint2D();
        abstractZyGraph.getView().setCenter(realizer.getCenterX(), realizer.getCenterY() - realizer.getHeight() / 2.0 + n2);
        if (b) {
            final Point2D center = abstractZyGraph.getView().getCenter();
            abstractZyGraph.getView().setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), center, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        }
        abstractZyGraph.updateViews();
    }
    
    public static void zoomToNodes(final AbstractZyGraph abstractZyGraph, final Collection collection) {
        Preconditions.checkNotNull(collection, (Object)"Error: nodes argument can not be null");
        if (collection.size() == 0) {
            return;
        }
        final double zoom = abstractZyGraph.getView().getZoom();
        final Point2D viewPoint2D = abstractZyGraph.getView().getViewPoint2D();
        final Rectangle2D calculateBoundingBox = GraphHelpers.calculateBoundingBox(collection);
        abstractZyGraph.getView().zoomToArea(calculateBoundingBox.getX(), calculateBoundingBox.getY(), calculateBoundingBox.getWidth(), calculateBoundingBox.getHeight());
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        abstractZyGraph.zoomOut();
        final double zoom2 = abstractZyGraph.getView().getZoom();
        final Point2D center = abstractZyGraph.getView().getCenter();
        abstractZyGraph.getView().setZoom(zoom);
        abstractZyGraph.getView().setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
        abstractZyGraph.getView().focusView(zoom2, center, abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
        abstractZyGraph.updateViews();
    }
    
    public static void zoomToScreen(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().fitContent();
        ZoomHelpers.keepZoomValid(abstractZyGraph.getView());
        abstractZyGraph.updateViews();
    }
}
