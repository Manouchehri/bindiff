package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.settings.*;
import y.h.*;
import y.b.*;
import y.g.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.geom.*;

public class GraphAnimator
{
    public static void moveGraph(final BinDiffGraph binDiffGraph, final Point2D.Double double1) {
        final GraphSettings settings = binDiffGraph.getSettings();
        final boolean animateLayout = settings.getLayoutSettings().getAnimateLayout();
        if (settings.isAsync() || !(binDiffGraph instanceof SingleGraph)) {
            binDiffGraph.getView().focusView(binDiffGraph.getView().getZoom(), double1, animateLayout);
        }
        else {
            final SingleGraph singleGraph = (SingleGraph)binDiffGraph;
            final ch view = singleGraph.getPrimaryGraph().getView();
            final ch view2 = singleGraph.getSecondaryGraph().getView();
            final e e = new e();
            e.a(false);
            e.a(view);
            e.a(view2);
            final int animationSpeed = settings.getDisplaySettings().getAnimationSpeed();
            final l a = b.a();
            final an a2 = w.a(double1);
            final d a3 = new gJ(view).a(view.getZoom(), a2, 100 * animationSpeed);
            final d a4 = new gJ(view2).a(view2.getZoom(), a2, 100 * animationSpeed);
            a.a(a3);
            a.a(a4);
            e.a(a);
        }
    }
    
    public static void zoomGraph(final BinDiffGraph binDiffGraph, final Point2D.Double double1, final double n) {
        final GraphSettings settings = binDiffGraph.getSettings();
        final boolean animateLayout = settings.getLayoutSettings().getAnimateLayout();
        if (settings.isAsync() || !(binDiffGraph instanceof SingleGraph)) {
            binDiffGraph.getView().focusView(n, double1, animateLayout);
        }
        else {
            final SingleGraph singleGraph = (SingleGraph)binDiffGraph;
            final ch view = singleGraph.getPrimaryGraph().getView();
            final ch view2 = singleGraph.getSecondaryGraph().getView();
            final e e = new e();
            e.a(false);
            e.a(view);
            e.a(view2);
            final int animationSpeed = settings.getDisplaySettings().getAnimationSpeed();
            final l a = b.a();
            final an a2 = w.a(double1);
            final d a3 = new gJ(view).a(n, a2, 100 * animationSpeed);
            final d a4 = new gJ(view2).a(n, a2, 100 * animationSpeed);
            a.a(a3);
            a.a(a4);
            e.a(a);
        }
    }
    
    public static void zoomGraph(final SuperGraph superGraph, final Rectangle2D rectangle2D, final double n, final double n2) {
        final ch view = superGraph.getPrimaryGraph().getView();
        final ch view2 = superGraph.getSecondaryGraph().getView();
        final w a = w.a(rectangle2D.getCenterX(), rectangle2D.getCenterY());
        final int n3 = 100 * superGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        final d a2 = new gJ(view).a(Math.max(n, n2), a, n3);
        final d a3 = new gJ(view2).a(Math.max(n, n2), a, n3);
        final l a4 = b.a();
        a4.a(a2);
        a4.a(a3);
        final e e = new e();
        e.a(false);
        e.a(view);
        e.a(view2);
        e.a(a4);
    }
}
