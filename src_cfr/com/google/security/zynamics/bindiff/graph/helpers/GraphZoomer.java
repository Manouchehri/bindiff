/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphAnimator;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer$1;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.SwingUtilities;
import y.h.bu;
import y.h.ch;

public class GraphZoomer {
    public static final double ZOOM_OUT_FACTOR = 0.95;

    private static void fitContent(ch ch2) {
        ch2.fitContent();
        ch2.setZoom(ch2.getZoom() * 0.95);
    }

    private static void zoomToArea(BinDiffGraph binDiffGraph, Rectangle2D rectangle2D) {
        ch ch2 = binDiffGraph.getView();
        double d2 = ch2.getZoom();
        Point2D point2D = ch2.getCenter();
        ch2.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        ch2.setZoom(ch2.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(ch2);
        double d3 = ch2.getZoom();
        Point2D.Double double_ = new Point2D.Double(ch2.getCenter().getX(), ch2.getCenter().getY());
        ch2.setZoom(d2);
        ch2.setCenter(point2D.getX(), point2D.getY());
        GraphAnimator.zoomGraph(binDiffGraph, double_, d3);
        ch2.getGraph2D().T();
    }

    private static void zoomToArea(SuperGraph superGraph, Rectangle2D rectangle2D, Collection collection) {
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        ch ch2 = superGraph.getPrimaryGraph().getView();
        ch ch3 = superGraph.getSecondaryGraph().getView();
        double d2 = ch2.getZoom();
        Point2D point2D = ch2.getViewPoint2D();
        ch2.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        ch2.setZoom(ch2.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(ch2);
        double d3 = ch2.getZoom();
        ch2.setZoom(d2);
        ch2.setViewPoint2D(point2D.getX(), point2D.getY());
        double d4 = ch3.getZoom();
        Point2D point2D2 = ch3.getViewPoint2D();
        ch3.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        ch3.setZoom(ch3.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(ch3);
        double d5 = ch3.getZoom();
        ch3.setZoom(d4);
        ch3.setViewPoint2D(point2D2.getX(), point2D2.getY());
        GraphAnimator.zoomGraph(superGraph, rectangle2D, d3, d5);
        ch2.getGraph2D().T();
        ch3.getGraph2D().T();
    }

    private static void zoomToNodes(BinDiffGraph binDiffGraph, Collection collection) {
        if (collection.size() == 0) {
            return;
        }
        Rectangle2D rectangle2D = GraphHelpers.calculateBoundingBox(collection);
        GraphZoomer.zoomToArea(binDiffGraph, rectangle2D);
    }

    public static void fitContent(BinDiffGraph binDiffGraph) {
        GraphZoomer.fitContent(binDiffGraph.getView());
        binDiffGraph.getGraph().T();
    }

    public static void fitContent(SuperGraph superGraph) {
        GraphSettings graphSettings = superGraph.getSettings();
        if (graphSettings.isSync()) {
            superGraph.getView().fitContent();
            GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
            GraphViewFitter.fitSingleViewToSuperViewContent(superGraph);
        } else if (graphSettings.getFocus() == ESide.PRIMARY) {
            GraphZoomer.fitContent(superGraph.getPrimaryGraph().getView());
        } else {
            GraphZoomer.fitContent(superGraph.getSecondaryGraph().getView());
        }
        superGraph.getPrimaryGraph().getGraph().T();
        superGraph.getSecondaryGraph().getGraph().T();
    }

    public static void zoomToNode(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkNotNull(zyGraphNode);
        if (!zyGraphNode.isVisible()) {
            GraphLayoutEventHandler.handleUnhideInvisibleNode(binDiffGraph, zyGraphNode);
        }
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        arrayList.add(zyGraphNode);
        SwingUtilities.invokeLater(new GraphZoomer$1(binDiffGraph, arrayList));
    }

    public static void zoomToNodes(CombinedGraph combinedGraph, Collection collection) {
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(collection);
        for (CombinedDiffNode combinedDiffNode : collection) {
            if (combinedDiffNode.isVisible()) continue;
            throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
        }
        if (collection.size() == 0) {
            return;
        }
        Rectangle2D rectangle2D = GraphHelpers.calculateBoundingBox(collection);
        GraphZoomer.zoomToArea(combinedGraph, rectangle2D);
    }

    public static void zoomToNodes(SuperGraph superGraph, Collection collection) {
        Preconditions.checkNotNull(superGraph);
        Preconditions.checkNotNull(collection);
        for (SuperDiffNode superDiffNode : collection) {
            if (superDiffNode.isVisible()) continue;
            throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
        }
        if (collection.size() == 0) {
            return;
        }
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        Rectangle2D rectangle2D = GraphHelpers.calculateBoundingBox(collection);
        if (superGraph.getSettings().isSync()) {
            GraphZoomer.zoomToArea(superGraph, rectangle2D, collection);
        } else if (superGraph.getSettings().getFocus() == ESide.PRIMARY) {
            GraphZoomer.zoomToArea(superGraph.getPrimaryGraph(), rectangle2D);
        } else {
            GraphZoomer.zoomToArea(superGraph.getSecondaryGraph(), rectangle2D);
        }
        superGraph.getPrimaryGraph().getGraph().T();
        superGraph.getSecondaryGraph().getGraph().T();
    }

    static /* synthetic */ void access$000(BinDiffGraph binDiffGraph, Collection collection) {
        GraphZoomer.zoomToNodes(binDiffGraph, collection);
    }
}

