package com.google.security.zynamics.bindiff.graph.synchronizer;

import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.geom.*;
import y.h.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.*;

public class GraphViewCanvasSynchronizer
{
    private static void addListener(final GraphViewsListenerManager graphViewsListenerManager, final SingleGraph singleGraph) {
        if (singleGraph.getSide() == ESide.PRIMARY) {
            graphViewsListenerManager.addViewCanvasListener(singleGraph.getSecondaryGraph());
        }
        else {
            graphViewsListenerManager.addViewCanvasListener(singleGraph.getPrimaryGraph());
        }
    }
    
    private static void adoptViewPoint(final SingleGraph singleGraph, final Point2D point2D, final boolean b) {
        final SingleGraph targetGraph = getTargetGraph(singleGraph);
        final ch view = singleGraph.getView();
        final ch view2 = targetGraph.getView();
        final Point2D viewPoint2D = view.getViewPoint2D();
        final double n = point2D.getX() - viewPoint2D.getX();
        final double n2 = point2D.getY() - viewPoint2D.getY();
        final Point2D viewPoint2D2 = view2.getViewPoint2D();
        view2.setViewPoint2D(viewPoint2D2.getX() - n, viewPoint2D2.getY() - n2);
        if (!b) {
            view2.getGraph2D().T();
        }
    }
    
    private static void adoptZoom(final SingleGraph singleGraph) {
        final SingleGraph targetGraph = getTargetGraph(singleGraph);
        adoptSuperWorldRect(singleGraph.getSuperGraph());
        targetGraph.getView().focusView(singleGraph.getView().getZoom(), singleGraph.getView().getCenter(), false);
    }
    
    private static SingleGraph getTargetGraph(final SingleGraph singleGraph) {
        if (singleGraph == singleGraph.getPrimaryGraph()) {
            return singleGraph.getSecondaryGraph();
        }
        return singleGraph.getPrimaryGraph();
    }
    
    private static void removeListener(final GraphViewsListenerManager graphViewsListenerManager, final SingleGraph singleGraph) {
        if (singleGraph.getSide() == ESide.PRIMARY) {
            graphViewsListenerManager.removeViewCanvasListener(singleGraph.getSecondaryGraph());
        }
        else {
            graphViewsListenerManager.removeViewCanvasListener(singleGraph.getPrimaryGraph());
        }
    }
    
    public static void adoptSuperWorldRect(final SuperGraph superGraph) {
        if (superGraph.getSettings().isSync()) {
            final Rectangle worldRect = superGraph.getView().getWorldRect();
            final SingleGraph primaryGraph = superGraph.getPrimaryGraph();
            final SingleGraph secondaryGraph = superGraph.getSecondaryGraph();
            primaryGraph.getView().setWorldRect(worldRect.x, worldRect.y, worldRect.width, worldRect.height);
            secondaryGraph.getView().setWorldRect(worldRect.x, worldRect.y, worldRect.width, worldRect.height);
        }
    }
    
    public static void adoptViewPoint(final GraphViewsListenerManager graphViewsListenerManager, final SingleGraph singleGraph, final Point2D point2D, final boolean b) {
        if (singleGraph.getSettings().isSync()) {
            removeListener(graphViewsListenerManager, singleGraph);
            adoptViewPoint(singleGraph, point2D, b);
            addListener(graphViewsListenerManager, singleGraph);
        }
    }
    
    public static void adoptZoom(final GraphViewsListenerManager graphViewsListenerManager, final SingleGraph singleGraph) {
        if (singleGraph.getSettings().isSync()) {
            removeListener(graphViewsListenerManager, singleGraph);
            adoptZoom(singleGraph);
            addListener(graphViewsListenerManager, singleGraph);
        }
    }
}
