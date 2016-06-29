package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;

public class SingleGraphNodeDraggedLeftAction implements IStateAction
{
    protected void moveToFront(final ZyGraphLayeredRenderer zyGraphLayeredRenderer, final q q) {
        zyGraphLayeredRenderer.bringNodeToFront(q);
    }
    
    public void execute(final CNodeDraggedLeftState cNodeDraggedLeftState, final MouseEvent mouseEvent) {
        new CDefaultNodeDraggedLeftAction().execute(cNodeDraggedLeftState, mouseEvent);
        final AbstractZyGraph graph = cNodeDraggedLeftState.getGraph();
        if (!graph.getEditMode().getLabelEventHandler().isActiveLabel(graph.getNode(cNodeDraggedLeftState.getNode()).getRealizer().getNodeContent())) {
            final q node = cNodeDraggedLeftState.getNode();
            this.moveToFront((ZyGraphLayeredRenderer)graph.getView().getGraph2DRenderer(), node);
            GraphElementMover.moveNodes(graph, node, cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY());
        }
    }
}
