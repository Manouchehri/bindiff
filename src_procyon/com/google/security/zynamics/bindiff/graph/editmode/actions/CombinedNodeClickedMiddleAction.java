package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.*;

public class CombinedNodeClickedMiddleAction implements IStateAction
{
    public void execute(final CNodeClickedMiddleState cNodeClickedMiddleState, final MouseEvent mouseEvent) {
        EditCombinedNodeHelper.setActiveLabelContent((CombinedGraph)cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        EditCombinedNodeHelper.setCaretStart(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        EditCombinedNodeHelper.setCaretEnd(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
    }
}
