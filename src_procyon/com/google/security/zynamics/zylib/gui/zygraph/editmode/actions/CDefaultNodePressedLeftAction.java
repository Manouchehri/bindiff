package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

public class CDefaultNodePressedLeftAction implements IStateAction
{
    public void execute(final CNodePressedLeftState cNodePressedLeftState, final MouseEvent mouseEvent) {
        final AbstractZyGraph graph = cNodePressedLeftState.getGraph();
        final ZyGraphNode node = graph.getNode(cNodePressedLeftState.getNode());
        if (node != null) {
            if (graph.getEditMode().getLabelEventHandler().isActiveLabel(node.getRealizer().getNodeContent())) {
                CEditNodeHelper.setCaretStart(graph, cNodePressedLeftState.getNode(), mouseEvent);
                CEditNodeHelper.setCaretEnd(graph, cNodePressedLeftState.getNode(), mouseEvent);
            }
            else {
                CEditNodeHelper.removeCaret(graph);
            }
        }
        else {
            CEditNodeHelper.removeCaret(graph);
        }
    }
}
