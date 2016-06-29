package com.google.security.zynamics.bindiff.graph.helpers;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import java.awt.geom.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class GraphZoomer
{
    public static final double ZOOM_OUT_FACTOR = 0.95;
    
    private static void fitContent(final ch ch) {
        ch.fitContent();
        ch.setZoom(ch.getZoom() * 0.95);
    }
    
    private static void zoomToArea(final BinDiffGraph binDiffGraph, final Rectangle2D rectangle2D) {
        final ch view = binDiffGraph.getView();
        final double zoom = view.getZoom();
        final Point2D center = view.getCenter();
        view.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        view.setZoom(view.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(view);
        final double zoom2 = view.getZoom();
        final Point2D.Double double1 = new Point2D.Double(view.getCenter().getX(), view.getCenter().getY());
        view.setZoom(zoom);
        view.setCenter(center.getX(), center.getY());
        GraphAnimator.zoomGraph(binDiffGraph, double1, zoom2);
        view.getGraph2D().T();
    }
    
    private static void zoomToArea(final SuperGraph superGraph, final Rectangle2D rectangle2D, final Collection collection) {
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        final ch view = superGraph.getPrimaryGraph().getView();
        final ch view2 = superGraph.getSecondaryGraph().getView();
        final double zoom = view.getZoom();
        final Point2D viewPoint2D = view.getViewPoint2D();
        view.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        view.setZoom(view.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(view);
        final double zoom2 = view.getZoom();
        view.setZoom(zoom);
        view.setViewPoint2D(viewPoint2D.getX(), viewPoint2D.getY());
        final double zoom3 = view2.getZoom();
        final Point2D viewPoint2D2 = view2.getViewPoint2D();
        view2.zoomToArea(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        view2.setZoom(view2.getZoom() * 0.95);
        ZoomHelpers.keepZoomValid(view2);
        final double zoom4 = view2.getZoom();
        view2.setZoom(zoom3);
        view2.setViewPoint2D(viewPoint2D2.getX(), viewPoint2D2.getY());
        GraphAnimator.zoomGraph(superGraph, rectangle2D, zoom2, zoom4);
        view.getGraph2D().T();
        view2.getGraph2D().T();
    }
    
    private static void zoomToNodes(final BinDiffGraph binDiffGraph, final Collection collection) {
        if (collection.size() == 0) {
            return;
        }
        zoomToArea(binDiffGraph, GraphHelpers.calculateBoundingBox(collection));
    }
    
    public static void fitContent(final BinDiffGraph binDiffGraph) {
        fitContent(binDiffGraph.getView());
        binDiffGraph.getGraph().T();
    }
    
    public static void fitContent(final SuperGraph superGraph) {
        final GraphSettings settings = superGraph.getSettings();
        if (settings.isSync()) {
            superGraph.getView().fitContent();
            GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
            GraphViewFitter.fitSingleViewToSuperViewContent(superGraph);
        }
        else if (settings.getFocus() == ESide.PRIMARY) {
            fitContent(superGraph.getPrimaryGraph().getView());
        }
        else {
            fitContent(superGraph.getSecondaryGraph().getView());
        }
        superGraph.getPrimaryGraph().getGraph().T();
        superGraph.getSecondaryGraph().getGraph().T();
    }
    
    public static void zoomToNode(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkNotNull(zyGraphNode);
        if (!zyGraphNode.isVisible()) {
            GraphLayoutEventHandler.handleUnhideInvisibleNode(binDiffGraph, zyGraphNode);
        }
        final ArrayList<ZyGraphNode> list = new ArrayList<ZyGraphNode>();
        list.add(zyGraphNode);
        SwingUtilities.invokeLater(new GraphZoomer$1(binDiffGraph, list));
    }
    
    public static void zoomToNodes(final CombinedGraph combinedGraph, final Collection collection) {
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(collection);
        final Iterator<CombinedDiffNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isVisible()) {
                throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
            }
        }
        if (collection.size() == 0) {
            return;
        }
        zoomToArea(combinedGraph, GraphHelpers.calculateBoundingBox(collection));
    }
    
    public static void zoomToNodes(final SuperGraph superGraph, final Collection collection) {
        Preconditions.checkNotNull(superGraph);
        Preconditions.checkNotNull(collection);
        final Iterator<SuperDiffNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isVisible()) {
                throw new IllegalArgumentException("This function does not handle invisible nodes. Each node must be visible.");
            }
        }
        if (collection.size() == 0) {
            return;
        }
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        final Rectangle2D calculateBoundingBox = GraphHelpers.calculateBoundingBox(collection);
        if (superGraph.getSettings().isSync()) {
            zoomToArea(superGraph, calculateBoundingBox, collection);
        }
        else if (superGraph.getSettings().getFocus() == ESide.PRIMARY) {
            zoomToArea(superGraph.getPrimaryGraph(), calculateBoundingBox);
        }
        else {
            zoomToArea(superGraph.getSecondaryGraph(), calculateBoundingBox);
        }
        superGraph.getPrimaryGraph().getGraph().T();
        superGraph.getSecondaryGraph().getGraph().T();
    }
}
