/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import y.c.d;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.fL;
import y.h.fj;

public class CEdgeClickHandler {
    private static void zoomEdgeNode(AbstractZyGraph abstractZyGraph, d d2, double d3, double d4) {
        double d5;
        assert (d2 != null);
        AbstractZyGraphSettings abstractZyGraphSettings = abstractZyGraph.getSettings();
        boolean bl2 = abstractZyGraphSettings.getLayoutSettings().getAnimateLayout();
        aB aB2 = abstractZyGraph.getGraph().i(d2);
        fj fj2 = abstractZyGraph.getGraph().t(d2.c());
        fj fj3 = abstractZyGraph.getGraph().t(d2.d());
        double d6 = aB2.getSourcePort().a(fj2);
        double d7 = aB2.getSourcePort().b(fj2);
        double d8 = aB2.getSourcePort().a(fj3);
        double d9 = aB2.getSourcePort().b(fj3);
        double d10 = Math.abs(d6 - d3);
        double d11 = Math.abs(d7 - d4);
        double d12 = Math.abs(d8 - d3);
        double d13 = Math.abs(d9 - d4);
        double d14 = Math.sqrt(Math.pow(d10, 2.0) + Math.pow(d11, 2.0));
        if (d14 > (d5 = Math.sqrt(Math.pow(d12, 2.0) + Math.pow(d13, 2.0)))) {
            Point2D.Double double_ = new Point2D.Double(fj2.getCenterX(), fj2.getCenterY());
            abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), double_, bl2);
            return;
        }
        Point2D.Double double_ = new Point2D.Double(fj3.getCenterX(), fj3.getCenterY());
        abstractZyGraph.getView().focusView(abstractZyGraph.getView().getZoom(), double_, bl2);
    }

    public static void handleEdgeClicks(AbstractZyGraph abstractZyGraph, ZyGraphEdge zyGraphEdge, MouseEvent mouseEvent) {
        Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphEdge, "Error: Edge argument can not be null");
        Preconditions.checkNotNull(mouseEvent, "Error: Event argument can not be null");
        if (mouseEvent.getButton() == 1 && mouseEvent.isShiftDown()) {
            abstractZyGraph.getGraph().a(zyGraphEdge.getEdge(), !zyGraphEdge.isSelected());
            return;
        }
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.isShiftDown()) return;
        if (zyGraphEdge.getSource() == zyGraphEdge.getTarget()) return;
        double d2 = abstractZyGraph.getView().toWorldCoordX(mouseEvent.getX());
        double d3 = abstractZyGraph.getView().toWorldCoordY(mouseEvent.getY());
        CEdgeClickHandler.zoomEdgeNode(abstractZyGraph, zyGraphEdge.getEdge(), d2, d3);
    }
}

