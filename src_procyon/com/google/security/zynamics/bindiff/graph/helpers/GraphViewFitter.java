package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.*;
import java.awt.geom.*;
import y.h.*;
import java.awt.*;

public class GraphViewFitter
{
    public static void adoptSuperViewCanvasProperties(final SuperGraph superGraph) {
        if (superGraph.getSettings().isSync()) {
            final SingleGraph primaryGraph = superGraph.getPrimaryGraph();
            final SingleGraph secondaryGraph = superGraph.getSecondaryGraph();
            final ch view = superGraph.getView();
            final Rectangle worldRect = view.getWorldRect();
            final Point2D viewPoint2D = view.getViewPoint2D();
            final ch view2 = primaryGraph.getView();
            view2.setWorldRect((int)worldRect.getX(), (int)worldRect.getY(), (int)worldRect.getWidth(), (int)worldRect.getHeight());
            view2.setZoom(view.getZoom());
            final ch view3 = secondaryGraph.getView();
            view3.setWorldRect((int)worldRect.getX(), (int)worldRect.getY(), (int)worldRect.getWidth(), (int)worldRect.getHeight());
            view3.setZoom(view.getZoom());
            if (view2.getWidth() > view3.getWidth()) {
                view2.setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
                view3.setCenter(view.getCenter().getX(), view.getCenter().getY());
            }
            else if (view2.getWidth() < view3.getWidth()) {
                view3.setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
                view2.setCenter(view.getCenter().getX(), view.getCenter().getY());
            }
            else {
                view2.setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
                view3.setViewPoint((int)viewPoint2D.getX(), (int)viewPoint2D.getY());
            }
        }
    }
    
    public static void fitSingleViewToSuperViewContent(final SuperGraph superGraph) {
        if (superGraph.getSettings().isSync()) {
            final SingleGraph primaryGraph = superGraph.getPrimaryGraph();
            final SingleGraph secondaryGraph = superGraph.getSecondaryGraph();
            if ((int)Math.round(primaryGraph.getView().getSize().getWidth()) > (int)Math.round(secondaryGraph.getView().getSize().getWidth()) && primaryGraph.getNodes().size() > 0) {
                final bu graph2D = primaryGraph.getView().getGraph2D();
                primaryGraph.getView().setGraph2D(superGraph.getGraph());
                primaryGraph.getGraph().T();
                primaryGraph.getView().fitContent();
                final double zoom = primaryGraph.getView().getZoom();
                final Point viewPoint = primaryGraph.getView().getViewPoint();
                primaryGraph.getView().setGraph2D(graph2D);
                primaryGraph.getView().setViewPoint2D(viewPoint.getX(), viewPoint.getY());
                primaryGraph.getView().setZoom(zoom * 0.95);
            }
            else {
                final bu graph2D2 = secondaryGraph.getView().getGraph2D();
                secondaryGraph.getView().setGraph2D(superGraph.getGraph());
                secondaryGraph.getGraph().T();
                secondaryGraph.getView().fitContent();
                final double zoom2 = secondaryGraph.getView().getZoom();
                final Point viewPoint2 = secondaryGraph.getView().getViewPoint();
                secondaryGraph.getView().setGraph2D(graph2D2);
                secondaryGraph.getView().setViewPoint2D(viewPoint2.getX(), viewPoint2.getY());
                secondaryGraph.getView().setZoom(zoom2 * 0.95);
            }
        }
    }
}
