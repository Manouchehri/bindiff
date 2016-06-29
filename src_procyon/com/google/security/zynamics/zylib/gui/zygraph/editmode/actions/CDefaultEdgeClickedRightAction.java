package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import java.util.*;

public class CDefaultEdgeClickedRightAction implements IStateAction
{
    public void execute(final CEdgeClickedRightState cEdgeClickedRightState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cEdgeClickedRightState.getGraph());
        final AbstractZyGraph graph = cEdgeClickedRightState.getGraph();
        final ZyGraphEdge edge = cEdgeClickedRightState.getEdge();
        if (edge instanceof ZyInfoEdge) {
            return;
        }
        final double translateX = graph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = graph.getEditMode().translateY(mouseEvent.getY());
        for (final IZyEditModeListener zyEditModeListener : cEdgeClickedRightState.getStateFactory().getListeners()) {
            try {
                zyEditModeListener.edgeClicked(edge, mouseEvent, translateX, translateY);
            }
            catch (Exception ex) {}
        }
    }
}
