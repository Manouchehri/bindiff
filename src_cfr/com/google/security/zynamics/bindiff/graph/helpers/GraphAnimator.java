/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import y.b.b;
import y.b.c;
import y.b.d;
import y.b.e;
import y.b.l;
import y.g.an;
import y.g.w;
import y.h.ch;
import y.h.gJ;

public class GraphAnimator {
    public static void moveGraph(BinDiffGraph binDiffGraph, Point2D.Double double_) {
        GraphSettings graphSettings = binDiffGraph.getSettings();
        boolean bl2 = graphSettings.getLayoutSettings().getAnimateLayout();
        if (!graphSettings.isAsync() && binDiffGraph instanceof SingleGraph) {
            SingleGraph singleGraph = (SingleGraph)binDiffGraph;
            ch ch2 = singleGraph.getPrimaryGraph().getView();
            ch ch3 = singleGraph.getSecondaryGraph().getView();
            e e2 = new e();
            e2.a(false);
            e2.a(ch2);
            e2.a(ch3);
            int n2 = 100;
            int n3 = graphSettings.getDisplaySettings().getAnimationSpeed();
            l l2 = b.a();
            an an2 = w.a(double_);
            d d2 = new gJ(ch2).a(ch2.getZoom(), an2, 100 * n3);
            d d3 = new gJ(ch3).a(ch3.getZoom(), an2, 100 * n3);
            l2.a(d2);
            l2.a(d3);
            e2.a(l2);
            return;
        }
        binDiffGraph.getView().focusView(binDiffGraph.getView().getZoom(), double_, bl2);
    }

    public static void zoomGraph(BinDiffGraph binDiffGraph, Point2D.Double double_, double d2) {
        GraphSettings graphSettings = binDiffGraph.getSettings();
        boolean bl2 = graphSettings.getLayoutSettings().getAnimateLayout();
        if (!graphSettings.isAsync() && binDiffGraph instanceof SingleGraph) {
            SingleGraph singleGraph = (SingleGraph)binDiffGraph;
            ch ch2 = singleGraph.getPrimaryGraph().getView();
            ch ch3 = singleGraph.getSecondaryGraph().getView();
            e e2 = new e();
            e2.a(false);
            e2.a(ch2);
            e2.a(ch3);
            int n2 = 100;
            int n3 = graphSettings.getDisplaySettings().getAnimationSpeed();
            l l2 = b.a();
            an an2 = w.a(double_);
            d d3 = new gJ(ch2).a(d2, an2, 100 * n3);
            d d4 = new gJ(ch3).a(d2, an2, 100 * n3);
            l2.a(d3);
            l2.a(d4);
            e2.a(l2);
            return;
        }
        binDiffGraph.getView().focusView(d2, double_, bl2);
    }

    public static void zoomGraph(SuperGraph superGraph, Rectangle2D rectangle2D, double d2, double d3) {
        ch ch2 = superGraph.getPrimaryGraph().getView();
        ch ch3 = superGraph.getSecondaryGraph().getView();
        w w2 = w.a(rectangle2D.getCenterX(), rectangle2D.getCenterY());
        int n2 = 100 * superGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        d d4 = new gJ(ch2).a(Math.max(d2, d3), w2, n2);
        d d5 = new gJ(ch3).a(Math.max(d2, d3), w2, n2);
        l l2 = b.a();
        l2.a(d4);
        l2.a(d5);
        e e2 = new e();
        e2.a(false);
        e2.a(ch2);
        e2.a(ch3);
        e2.a(l2);
    }
}

