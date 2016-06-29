package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

public class CombinedNodePressedLeftAction implements IStateAction
{
    public void execute(final CNodePressedLeftState cNodePressedLeftState, final MouseEvent mouseEvent) {
        final AbstractZyGraph graph = cNodePressedLeftState.getGraph();
        final ZyGraphNode node = graph.getNode(cNodePressedLeftState.getNode());
        if (node != null && graph.getEditMode().getLabelEventHandler().isActiveLabel(node.getRealizer().getNodeContent())) {
            EditCombinedNodeHelper.setCaretStart(graph, cNodePressedLeftState.getNode(), mouseEvent);
            EditCombinedNodeHelper.setCaretEnd(graph, cNodePressedLeftState.getNode(), mouseEvent);
            return;
        }
        EditCombinedNodeHelper.removeCaret(graph);
    }
}
