/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyRegenerateableNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public final class EditCombinedNodeHelper {
    private EditCombinedNodeHelper() {
    }

    private static boolean isRightSideLabel(CombinedGraph combinedGraph, q q2, double d2) {
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q2);
        if (combinedDiffNode.getPrimaryDiffNode() == null) return false;
        if (combinedDiffNode.getSecondaryDiffNode() == null) return false;
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)combinedGraph.getGraph().t(q2));
        double d3 = iZyNodeRealizer.getCenterX();
        if (d2 < d3) return false;
        return true;
    }

    public static ZyLabelContent getLabelContent(CombinedGraph combinedGraph, q q2, MouseEvent mouseEvent) {
        int n2 = mouseEvent.getX();
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q2);
        if (combinedDiffNode.getPrimaryDiffNode() == null) return combinedDiffNode.getRealizer().getNodeContent();
        if (combinedDiffNode.getSecondaryDiffNode() == null) return combinedDiffNode.getRealizer().getNodeContent();
        bu bu2 = combinedGraph.getGraph();
        ch ch2 = combinedGraph.getView();
        double d2 = ch2.toWorldCoordX(n2);
        fj fj2 = bu2.t(q2);
        double d3 = fj2.getX();
        double d4 = fj2.getWidth();
        if (d2 <= d3) return combinedDiffNode.getSecondaryDiffNode().getRealizer().getNodeContent();
        if (d2 >= d3 + d4 / 2.0) return combinedDiffNode.getSecondaryDiffNode().getRealizer().getNodeContent();
        return combinedDiffNode.getPrimaryDiffNode().getRealizer().getNodeContent();
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
        if (EditCombinedNodeHelper.isRightSideLabel((CombinedGraph)abstractZyGraph, q2, d2)) {
            int n2 = zyLabelContent.getPaddingLeft();
            zyLabelContent.setPaddingLeft((int)Math.round((double)n2 + iZyNodeRealizer.getCenterX()));
            cDefaultLabelEventHandler.handleMouseDraggedEvent(d5, d6, d2, d3, d4);
            zyLabelContent.setPaddingLeft(n2);
            return;
        }
        cDefaultLabelEventHandler.handleMouseDraggedEvent(d5, d6, d2, d3, d4);
    }

    public static void setActiveLabelContent(CombinedGraph combinedGraph, q q2, MouseEvent mouseEvent) {
        int n2 = mouseEvent.getX();
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q2);
        if (combinedDiffNode.getPrimaryDiffNode() == null) return;
        if (combinedDiffNode.getSecondaryDiffNode() == null) return;
        bu bu2 = combinedGraph.getGraph();
        ch ch2 = combinedGraph.getView();
        double d2 = ch2.toWorldCoordX(n2);
        fj fj2 = bu2.t(q2);
        double d3 = fj2.getX();
        double d4 = fj2.getWidth();
        if (d2 > d3 && d2 < d3 + d4 / 2.0) {
            ((CombinedNodeRealizer)combinedDiffNode.getRealizer()).setActiveContent(ESide.PRIMARY);
            return;
        }
        ((CombinedNodeRealizer)combinedDiffNode.getRealizer()).setActiveContent(ESide.SECONDARY);
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
        if (EditCombinedNodeHelper.isRightSideLabel((CombinedGraph)abstractZyGraph, q2, d2)) {
            int n2 = zyLabelContent.getPaddingLeft();
            zyLabelContent.setPaddingLeft((int)Math.round((double)n2 + iZyNodeRealizer.getCenterX()));
            cDefaultLabelEventHandler.handleMouseReleasedEvent(d5, d6, d2, d3, d4, mouseEvent.getClickCount());
            zyLabelContent.setPaddingLeft(n2);
            return;
        }
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
        if (EditCombinedNodeHelper.isRightSideLabel((CombinedGraph)abstractZyGraph, q2, d2)) {
            int n2 = zyLabelContent.getPaddingLeft();
            zyLabelContent.setPaddingLeft((int)Math.round((double)n2 + iZyNodeRealizer.getCenterX()));
            cDefaultLabelEventHandler.handleMousePressedEvent(d5, d6, d2, d3, d4);
            zyLabelContent.setPaddingLeft(n2);
            return;
        }
        cDefaultLabelEventHandler.handleMousePressedEvent(d5, d6, d2, d3, d4);
    }
}

