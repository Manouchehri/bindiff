/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.synchronizer;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphViewsListenerManager;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import y.h.bu;
import y.h.ch;

public class GraphViewCanvasSynchronizer {
    private static void addListener(GraphViewsListenerManager graphViewsListenerManager, SingleGraph singleGraph) {
        if (singleGraph.getSide() == ESide.PRIMARY) {
            graphViewsListenerManager.addViewCanvasListener(singleGraph.getSecondaryGraph());
            return;
        }
        graphViewsListenerManager.addViewCanvasListener(singleGraph.getPrimaryGraph());
    }

    private static void adoptViewPoint(SingleGraph singleGraph, Point2D point2D, boolean bl2) {
        SingleGraph singleGraph2 = GraphViewCanvasSynchronizer.getTargetGraph(singleGraph);
        ch ch2 = singleGraph.getView();
        ch ch3 = singleGraph2.getView();
        Point2D point2D2 = ch2.getViewPoint2D();
        double d2 = point2D.getX() - point2D2.getX();
        double d3 = point2D.getY() - point2D2.getY();
        Point2D point2D3 = ch3.getViewPoint2D();
        ch3.setViewPoint2D(point2D3.getX() - d2, point2D3.getY() - d3);
        if (bl2) return;
        ch3.getGraph2D().T();
    }

    private static void adoptZoom(SingleGraph singleGraph) {
        SingleGraph singleGraph2 = GraphViewCanvasSynchronizer.getTargetGraph(singleGraph);
        SuperGraph superGraph = singleGraph.getSuperGraph();
        GraphViewCanvasSynchronizer.adoptSuperWorldRect(superGraph);
        singleGraph2.getView().focusView(singleGraph.getView().getZoom(), singleGraph.getView().getCenter(), false);
    }

    private static SingleGraph getTargetGraph(SingleGraph singleGraph) {
        if (singleGraph != singleGraph.getPrimaryGraph()) return singleGraph.getPrimaryGraph();
        return singleGraph.getSecondaryGraph();
    }

    private static void removeListener(GraphViewsListenerManager graphViewsListenerManager, SingleGraph singleGraph) {
        if (singleGraph.getSide() == ESide.PRIMARY) {
            graphViewsListenerManager.removeViewCanvasListener(singleGraph.getSecondaryGraph());
            return;
        }
        graphViewsListenerManager.removeViewCanvasListener(singleGraph.getPrimaryGraph());
    }

    public static void adoptSuperWorldRect(SuperGraph superGraph) {
        if (!superGraph.getSettings().isSync()) return;
        Rectangle rectangle = superGraph.getView().getWorldRect();
        SingleGraph singleGraph = superGraph.getPrimaryGraph();
        SingleGraph singleGraph2 = superGraph.getSecondaryGraph();
        singleGraph.getView().setWorldRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        singleGraph2.getView().setWorldRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public static void adoptViewPoint(GraphViewsListenerManager graphViewsListenerManager, SingleGraph singleGraph, Point2D point2D, boolean bl2) {
        if (!singleGraph.getSettings().isSync()) return;
        GraphViewCanvasSynchronizer.removeListener(graphViewsListenerManager, singleGraph);
        GraphViewCanvasSynchronizer.adoptViewPoint(singleGraph, point2D, bl2);
        GraphViewCanvasSynchronizer.addListener(graphViewsListenerManager, singleGraph);
    }

    public static void adoptZoom(GraphViewsListenerManager graphViewsListenerManager, SingleGraph singleGraph) {
        if (!singleGraph.getSettings().isSync()) return;
        GraphViewCanvasSynchronizer.removeListener(graphViewsListenerManager, singleGraph);
        GraphViewCanvasSynchronizer.adoptZoom(singleGraph);
        GraphViewCanvasSynchronizer.addListener(graphViewsListenerManager, singleGraph);
    }
}

