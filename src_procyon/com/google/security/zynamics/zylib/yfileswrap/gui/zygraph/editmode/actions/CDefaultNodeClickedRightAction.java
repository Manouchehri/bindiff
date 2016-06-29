package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import java.util.*;

public class CDefaultNodeClickedRightAction implements IStateAction
{
    public void execute(final CNodeClickedRightState cNodeClickedRightState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cNodeClickedRightState.getGraph());
        final AbstractZyGraph graph = cNodeClickedRightState.getGraph();
        final q node = cNodeClickedRightState.getNode();
        final ZyGraphNode node2 = graph.getNode(node);
        final double translateX = graph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = graph.getEditMode().translateY(mouseEvent.getY());
        if (graph.getEditMode().getLabelEventHandler().isActive() && graph.getEditMode().getLabelEventHandler().hasEmptySelection()) {
            CEditNodeHelper.removeCaret(graph);
        }
        if (node2 == null) {
            final ZyProximityNode proximityNode = ProximityHelper.getProximityNode(graph.getGraph(), node);
            for (final IZyEditModeListener zyEditModeListener : cNodeClickedRightState.getStateFactory().getListeners()) {
                try {
                    zyEditModeListener.proximityBrowserNodeClicked(proximityNode, mouseEvent, translateX, translateY);
                }
                catch (Exception ex) {}
            }
        }
        else {
            for (final IZyEditModeListener zyEditModeListener2 : cNodeClickedRightState.getStateFactory().getListeners()) {
                try {
                    zyEditModeListener2.nodeClicked(node2, mouseEvent, translateX, translateY);
                }
                catch (Exception ex2) {}
            }
        }
    }
}
