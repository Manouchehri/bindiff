package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;

public class CDefaultNodeDraggedLeftAction implements IStateAction
{
    protected void moveToFront(final ZyGraphLayeredRenderer zyGraphLayeredRenderer, final q q) {
        zyGraphLayeredRenderer.bringNodeToFront(q);
    }
    
    public void execute(final CNodeDraggedLeftState cNodeDraggedLeftState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setHandCursor(cNodeDraggedLeftState.getGraph());
        this.moveToFront((ZyGraphLayeredRenderer)cNodeDraggedLeftState.getGraph().getView().getGraph2DRenderer(), cNodeDraggedLeftState.getNode());
        final AbstractZyGraph graph = cNodeDraggedLeftState.getGraph();
        final HashSet set = new HashSet();
        final ZyGraphNode node = graph.getNode(cNodeDraggedLeftState.getNode());
        if (graph.getEditMode().getLabelEventHandler().isActiveLabel(node.getRealizer().getNodeContent())) {
            CEditNodeHelper.setCaretEnd(graph, cNodeDraggedLeftState.getNode(), mouseEvent);
            CEditNodeHelper.select(graph, cNodeDraggedLeftState.getNode(), mouseEvent);
        }
        else if (node.isSelected()) {
            final Iterator iterator = graph.getSelectedNodes().iterator();
            while (iterator.hasNext()) {
                CNodeMover.moveNode(graph, iterator.next(), cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY(), set);
            }
        }
        else {
            CNodeMover.moveNode(graph, node, cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY(), set);
        }
        graph.updateViews();
    }
}
