package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import java.awt.event.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;

public class EdgeClickEventHandler
{
    public static void handleEdgeClicks(final AbstractZyGraph abstractZyGraph, final ZyGraphEdge zyGraphEdge, final MouseEvent mouseEvent) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphEdge, (Object)"Edge argument can not be null");
        Preconditions.checkNotNull(mouseEvent, (Object)"Event argument can not be null");
        if (mouseEvent.getButton() == 1 && mouseEvent.isShiftDown()) {
            abstractZyGraph.getGraph().a(zyGraphEdge.getEdge(), !zyGraphEdge.isSelected());
        }
        else if (mouseEvent.getButton() == 1 && !mouseEvent.isShiftDown() && zyGraphEdge.getSource() != zyGraphEdge.getTarget()) {
            GraphMover.moveToEdgeNode((BinDiffGraph)abstractZyGraph, zyGraphEdge.getEdge(), abstractZyGraph.getView().toWorldCoordX(mouseEvent.getX()), abstractZyGraph.getView().toWorldCoordY(mouseEvent.getY()));
        }
    }
}
