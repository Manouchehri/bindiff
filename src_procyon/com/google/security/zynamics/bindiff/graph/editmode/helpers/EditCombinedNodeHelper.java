package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.security.zynamics.bindiff.graph.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import java.awt.event.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public final class EditCombinedNodeHelper
{
    private static boolean isRightSideLabel(final CombinedGraph combinedGraph, final q q, final double n) {
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q);
        return combinedDiffNode.getPrimaryDiffNode() != null && combinedDiffNode.getSecondaryDiffNode() != null && n >= ((IZyNodeRealizer)combinedGraph.getGraph().t(q)).getCenterX();
    }
    
    public static ZyLabelContent getLabelContent(final CombinedGraph combinedGraph, final q q, final MouseEvent mouseEvent) {
        final int x = mouseEvent.getX();
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q);
        if (combinedDiffNode.getPrimaryDiffNode() == null || combinedDiffNode.getSecondaryDiffNode() == null) {
            return combinedDiffNode.getRealizer().getNodeContent();
        }
        final bu graph = combinedGraph.getGraph();
        final double worldCoordX = combinedGraph.getView().toWorldCoordX(x);
        final fj t = graph.t(q);
        final double x2 = t.getX();
        final double width = t.getWidth();
        if (worldCoordX > x2 && worldCoordX < x2 + width / 2.0) {
            return combinedDiffNode.getPrimaryDiffNode().getRealizer().getNodeContent();
        }
        return combinedDiffNode.getSecondaryDiffNode().getRealizer().getNodeContent();
    }
    
    public static void removeCaret(final AbstractZyGraph abstractZyGraph) {
        final CDefaultLabelEventHandler labelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (labelEventHandler.isActive()) {
            labelEventHandler.deactivateLabelContent();
        }
    }
    
    public static void select(final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        final double translateX = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        final IZyNodeRealizer zyNodeRealizer = (IZyNodeRealizer)abstractZyGraph.getGraph().t(q);
        final ZyLabelContent nodeContent = zyNodeRealizer.getNodeContent();
        final CDefaultLabelEventHandler labelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (nodeContent.isSelectable()) {
            final double zoom = abstractZyGraph.getView().getZoom();
            final double x = zyNodeRealizer.getRealizer().getX();
            final double y = zyNodeRealizer.getRealizer().getY();
            if (isRightSideLabel((CombinedGraph)abstractZyGraph, q, translateX)) {
                final int paddingLeft = nodeContent.getPaddingLeft();
                nodeContent.setPaddingLeft((int)Math.round(paddingLeft + zyNodeRealizer.getCenterX()));
                labelEventHandler.handleMouseDraggedEvent(x, y, translateX, translateY, zoom);
                nodeContent.setPaddingLeft(paddingLeft);
            }
            else {
                labelEventHandler.handleMouseDraggedEvent(x, y, translateX, translateY, zoom);
            }
        }
    }
    
    public static void setActiveLabelContent(final CombinedGraph combinedGraph, final q q, final MouseEvent mouseEvent) {
        final int x = mouseEvent.getX();
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(q);
        if (combinedDiffNode.getPrimaryDiffNode() != null && combinedDiffNode.getSecondaryDiffNode() != null) {
            final bu graph = combinedGraph.getGraph();
            final double worldCoordX = combinedGraph.getView().toWorldCoordX(x);
            final fj t = graph.t(q);
            final double x2 = t.getX();
            final double width = t.getWidth();
            if (worldCoordX > x2 && worldCoordX < x2 + width / 2.0) {
                ((CombinedNodeRealizer)combinedDiffNode.getRealizer()).setActiveContent(ESide.PRIMARY);
            }
            else {
                ((CombinedNodeRealizer)combinedDiffNode.getRealizer()).setActiveContent(ESide.SECONDARY);
            }
        }
    }
    
    public static void setCaretEnd(final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        final double translateX = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        final IZyNodeRealizer zyNodeRealizer = (IZyNodeRealizer)abstractZyGraph.getGraph().t(q);
        final ZyLabelContent nodeContent = zyNodeRealizer.getNodeContent();
        final CDefaultLabelEventHandler labelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (nodeContent.isSelectable()) {
            final double zoom = abstractZyGraph.getView().getZoom();
            final double x = zyNodeRealizer.getRealizer().getX();
            final double y = zyNodeRealizer.getRealizer().getY();
            if (isRightSideLabel((CombinedGraph)abstractZyGraph, q, translateX)) {
                final int paddingLeft = nodeContent.getPaddingLeft();
                nodeContent.setPaddingLeft((int)Math.round(paddingLeft + zyNodeRealizer.getCenterX()));
                labelEventHandler.handleMouseReleasedEvent(x, y, translateX, translateY, zoom, mouseEvent.getClickCount());
                nodeContent.setPaddingLeft(paddingLeft);
            }
            else {
                labelEventHandler.handleMouseReleasedEvent(x, y, translateX, translateY, zoom, mouseEvent.getClickCount());
            }
        }
    }
    
    public static void setCaretStart(final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        final double translateX = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        final IZyNodeRealizer zyNodeRealizer = (IZyNodeRealizer)abstractZyGraph.getGraph().t(q);
        final ZyLabelContent nodeContent = zyNodeRealizer.getNodeContent();
        final CDefaultLabelEventHandler labelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        abstractZyGraph.getEditMode().getLabelEventHandler().activateLabelContent(nodeContent, new ZyRegenerateableNodeRealizer(zyNodeRealizer));
        if (nodeContent.isSelectable()) {
            final double zoom = abstractZyGraph.getView().getZoom();
            final double x = zyNodeRealizer.getRealizer().getX();
            final double y = zyNodeRealizer.getRealizer().getY();
            if (isRightSideLabel((CombinedGraph)abstractZyGraph, q, translateX)) {
                final int paddingLeft = nodeContent.getPaddingLeft();
                nodeContent.setPaddingLeft((int)Math.round(paddingLeft + zyNodeRealizer.getCenterX()));
                labelEventHandler.handleMousePressedEvent(x, y, translateX, translateY, zoom);
                nodeContent.setPaddingLeft(paddingLeft);
            }
            else {
                labelEventHandler.handleMousePressedEvent(x, y, translateX, translateY, zoom);
            }
        }
    }
}
