package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import java.awt.geom.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import java.awt.event.*;
import com.google.common.base.*;

public class CEdgeClickHandler
{
    private static void zoomEdgeNode(final AbstractZyGraph abstractZyGraph, final d d, final double n, final double n2) {
        assert d != null;
        final boolean animateLayout = abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout();
        final aB i = abstractZyGraph.getGraph().i(d);
        final fj t = abstractZyGraph.getGraph().t(d.c());
        final fj t2 = abstractZyGraph.getGraph().t(d.d());
        if (Math.sqrt(Math.pow(Math.abs(i.getSourcePort().a(t) - n), 2.0) + Math.pow(Math.abs(i.getSourcePort().b(t) - n2), 2.0)) > Math.sqrt(Math.pow(Math.abs(i.getSourcePort().a(t2) - n), 2.0) + Math.pow(Math.abs(i.getSourcePort().b(t2) - n2), 2.0))) {
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(t.getCenterX(), t.getCenterY()), animateLayout);
        }
        else {
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), new Point2D.Double(t2.getCenterX(), t2.getCenterY()), animateLayout);
        }
    }
    
    public static void handleEdgeClicks(final AbstractZyGraph abstractZyGraph, final ZyGraphEdge zyGraphEdge, final MouseEvent mouseEvent) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphEdge, (Object)"Error: Edge argument can not be null");
        Preconditions.checkNotNull(mouseEvent, (Object)"Error: Event argument can not be null");
        if (mouseEvent.getButton() == 1 && mouseEvent.isShiftDown()) {
            abstractZyGraph.getGraph().a(zyGraphEdge.getEdge(), !zyGraphEdge.isSelected());
        }
        else if (mouseEvent.getButton() == 1 && !mouseEvent.isShiftDown() && zyGraphEdge.getSource() != zyGraphEdge.getTarget()) {
            zoomEdgeNode(abstractZyGraph, zyGraphEdge.getEdge(), abstractZyGraph.getView().toWorldCoordX(mouseEvent.getX()), abstractZyGraph.getView().toWorldCoordY(mouseEvent.getY()));
        }
    }
}
