/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyRegenerateableNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public final class CEditNodeHelper {
    private CEditNodeHelper() {
    }

    public static void removeCaret(AbstractZyGraph abstractZyGraph) {
        CDefaultLabelEventHandler cDefaultLabelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (!cDefaultLabelEventHandler.isActive()) return;
        cDefaultLabelEventHandler.deactivateLabelContent();
    }

    public static void select(AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)abstractZyGraph.getGraph().t(q2));
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        CDefaultLabelEventHandler cDefaultLabelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (!zyLabelContent.isSelectable()) return;
        double d4 = abstractZyGraph.getView().getZoom();
        double d5 = iZyNodeRealizer.getRealizer().getX();
        double d6 = iZyNodeRealizer.getRealizer().getY();
        cDefaultLabelEventHandler.handleMouseDraggedEvent(d5, d6, d2, d3, d4);
    }

    public static void setCaretEnd(AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)abstractZyGraph.getGraph().t(q2));
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        CDefaultLabelEventHandler cDefaultLabelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (!zyLabelContent.isSelectable()) return;
        double d4 = abstractZyGraph.getView().getZoom();
        double d5 = iZyNodeRealizer.getRealizer().getX();
        double d6 = iZyNodeRealizer.getRealizer().getY();
        cDefaultLabelEventHandler.handleMouseReleasedEvent(d5, d6, d2, d3, d4, mouseEvent.getClickCount());
    }

    public static void setCaretStart(AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)abstractZyGraph.getGraph().t(q2));
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        CDefaultLabelEventHandler cDefaultLabelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        abstractZyGraph.getEditMode().getLabelEventHandler().activateLabelContent(zyLabelContent, new ZyRegenerateableNodeRealizer(iZyNodeRealizer));
        if (!zyLabelContent.isSelectable()) return;
        double d4 = abstractZyGraph.getView().getZoom();
        double d5 = iZyNodeRealizer.getRealizer().getX();
        double d6 = iZyNodeRealizer.getRealizer().getY();
        cDefaultLabelEventHandler.handleMousePressedEvent(d5, d6, d2, d3, d4);
    }
}

