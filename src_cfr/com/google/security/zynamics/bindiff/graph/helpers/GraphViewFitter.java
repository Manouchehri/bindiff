/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Collection;
import y.h.bu;
import y.h.ch;

public class GraphViewFitter {
    public static void adoptSuperViewCanvasProperties(SuperGraph superGraph) {
        if (!superGraph.getSettings().isSync()) return;
        SingleGraph singleGraph = superGraph.getPrimaryGraph();
        SingleGraph singleGraph2 = superGraph.getSecondaryGraph();
        ch ch2 = superGraph.getView();
        Rectangle rectangle = ch2.getWorldRect();
        Point2D point2D = ch2.getViewPoint2D();
        ch ch3 = singleGraph.getView();
        ch3.setWorldRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
        ch3.setZoom(ch2.getZoom());
        ch ch4 = singleGraph2.getView();
        ch4.setWorldRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
        ch4.setZoom(ch2.getZoom());
        if (ch3.getWidth() > ch4.getWidth()) {
            ch3.setViewPoint((int)point2D.getX(), (int)point2D.getY());
            ch4.setCenter(ch2.getCenter().getX(), ch2.getCenter().getY());
            return;
        }
        if (ch3.getWidth() < ch4.getWidth()) {
            ch4.setViewPoint((int)point2D.getX(), (int)point2D.getY());
            ch3.setCenter(ch2.getCenter().getX(), ch2.getCenter().getY());
            return;
        }
        ch3.setViewPoint((int)point2D.getX(), (int)point2D.getY());
        ch4.setViewPoint((int)point2D.getX(), (int)point2D.getY());
    }

    public static void fitSingleViewToSuperViewContent(SuperGraph superGraph) {
        int n2;
        if (!superGraph.getSettings().isSync()) return;
        SingleGraph singleGraph = superGraph.getPrimaryGraph();
        SingleGraph singleGraph2 = superGraph.getSecondaryGraph();
        int n3 = (int)Math.round(singleGraph.getView().getSize().getWidth());
        if (n3 > (n2 = (int)Math.round(singleGraph2.getView().getSize().getWidth())) && singleGraph.getNodes().size() > 0) {
            bu bu2 = singleGraph.getView().getGraph2D();
            singleGraph.getView().setGraph2D(superGraph.getGraph());
            singleGraph.getGraph().T();
            singleGraph.getView().fitContent();
            double d2 = singleGraph.getView().getZoom();
            Point point = singleGraph.getView().getViewPoint();
            singleGraph.getView().setGraph2D(bu2);
            singleGraph.getView().setViewPoint2D(point.getX(), point.getY());
            singleGraph.getView().setZoom(d2 * 0.95);
            return;
        }
        bu bu3 = singleGraph2.getView().getGraph2D();
        singleGraph2.getView().setGraph2D(superGraph.getGraph());
        singleGraph2.getGraph().T();
        singleGraph2.getView().fitContent();
        double d3 = singleGraph2.getView().getZoom();
        Point point = singleGraph2.getView().getViewPoint();
        singleGraph2.getView().setGraph2D(bu3);
        singleGraph2.getView().setViewPoint2D(point.getX(), point.getY());
        singleGraph2.getView().setZoom(d3 * 0.95);
    }
}

