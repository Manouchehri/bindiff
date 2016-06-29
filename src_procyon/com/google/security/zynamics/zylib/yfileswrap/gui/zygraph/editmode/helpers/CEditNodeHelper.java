package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import y.c.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public final class CEditNodeHelper
{
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
            labelEventHandler.handleMouseDraggedEvent(zyNodeRealizer.getRealizer().getX(), zyNodeRealizer.getRealizer().getY(), translateX, translateY, abstractZyGraph.getView().getZoom());
        }
    }
    
    public static void setCaretEnd(final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        final double translateX = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        final IZyNodeRealizer zyNodeRealizer = (IZyNodeRealizer)abstractZyGraph.getGraph().t(q);
        final ZyLabelContent nodeContent = zyNodeRealizer.getNodeContent();
        final CDefaultLabelEventHandler labelEventHandler = abstractZyGraph.getEditMode().getLabelEventHandler();
        if (nodeContent.isSelectable()) {
            labelEventHandler.handleMouseReleasedEvent(zyNodeRealizer.getRealizer().getX(), zyNodeRealizer.getRealizer().getY(), translateX, translateY, abstractZyGraph.getView().getZoom(), mouseEvent.getClickCount());
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
            labelEventHandler.handleMousePressedEvent(zyNodeRealizer.getRealizer().getX(), zyNodeRealizer.getRealizer().getY(), translateX, translateY, abstractZyGraph.getView().getZoom());
        }
    }
}
