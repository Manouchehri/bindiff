package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;

public class CDefaultNodeHoverAction implements IStateAction
{
    public void execute(final CNodeHoverState cNodeHoverState, final MouseEvent mouseEvent) {
        final AbstractZyGraph graph = cNodeHoverState.getGraph();
        CMouseCursorHelper.setDefaultCursor(graph);
        final double translateX = graph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = graph.getEditMode().translateY(mouseEvent.getY());
        final ZyGraphNode node = graph.getNode(cNodeHoverState.getNode());
        if (node != null) {
            for (final IZyEditModeListener zyEditModeListener : cNodeHoverState.getStateFactory().getListeners()) {
                try {
                    zyEditModeListener.nodeHovered(node, translateX, translateY);
                }
                catch (Exception ex) {}
            }
        }
    }
}
