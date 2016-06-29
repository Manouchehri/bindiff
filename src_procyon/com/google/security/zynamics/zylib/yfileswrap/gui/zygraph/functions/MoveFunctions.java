package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.common.base.*;
import y.d.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;

public class MoveFunctions
{
    public static void centerEdgeLable(final AbstractZyGraph abstractZyGraph, final ZyGraphEdge zyGraphEdge) {
        Preconditions.checkNotNull(zyGraphEdge, (Object)"Error: Edge can't be null.");
        if (zyGraphEdge.isVisible()) {
            final y box = zyGraphEdge.getRealizer().getLabel().getBox();
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(box.c + box.a / 2.0, box.d + box.b / 2.0), abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
            abstractZyGraph.updateViews();
            return;
        }
        throw new IllegalStateException("Error: Edge does not belong to graph.");
    }
    
    public static void centerNode(final AbstractZyGraph abstractZyGraph, final ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Error: Node argument can't be null");
        final fj t = abstractZyGraph.getGraph().t(zyGraphNode.getNode());
        if (t.isVisible()) {
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(t.getCenterX(), t.getCenterY()), abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout());
            abstractZyGraph.updateViews();
        }
    }
    
    public static void centerNodes(final AbstractZyGraph abstractZyGraph, final Set set) {
        Preconditions.checkNotNull(set, (Object)"Error: Nodes argument is null");
        Preconditions.checkArgument(!set.isEmpty(), (Object)"Error: Nodes argument is empty");
        final Rectangle2D calculateBoundingBox = GraphHelpers.calculateBoundingBox(set);
        abstractZyGraph.getView().setCenter(calculateBoundingBox.getX() + calculateBoundingBox.getWidth() / 2.0, calculateBoundingBox.getY() + calculateBoundingBox.getHeight() / 2.0);
        abstractZyGraph.updateViews();
    }
    
    public static void pan(final AbstractZyGraph abstractZyGraph, double n, double n2) {
        final double n3 = 50.0 / abstractZyGraph.getView().getZoom();
        n *= n3;
        n2 *= n3;
        final Point2D.Double double1 = (Point2D.Double)abstractZyGraph.getView().getCenter();
        double n4 = double1.getX() + n;
        double n5 = double1.getY() + n2;
        if (n < 0.0) {
            n = (int)Math.floor(n);
        }
        else {
            n = (int)Math.ceil(n) + 2;
        }
        if (n2 < 0.0) {
            n2 = (int)Math.floor(n2);
        }
        else {
            n2 = (int)Math.ceil(n2) + 2;
        }
        final Rectangle worldRect = abstractZyGraph.getView().getWorldRect();
        final Rectangle visibleRect = abstractZyGraph.getView().getVisibleRect();
        if (visibleRect.x + (int)n < worldRect.x) {
            n4 += worldRect.x - (visibleRect.x + (int)n);
        }
        else if (visibleRect.x + visibleRect.width + (int)n > worldRect.x + worldRect.width) {
            n4 -= visibleRect.x + visibleRect.width + (int)n - (worldRect.x + worldRect.width);
        }
        if (visibleRect.y + (int)n2 < worldRect.y) {
            n5 += worldRect.y - (visibleRect.y + (int)n2);
        }
        else if (visibleRect.y + visibleRect.height + (int)n2 > worldRect.y + worldRect.height) {
            n5 -= visibleRect.y + visibleRect.height + (int)n2 - (worldRect.y + worldRect.height);
        }
        abstractZyGraph.getView().setCenter(n4, n5);
        abstractZyGraph.updateViews();
    }
}
