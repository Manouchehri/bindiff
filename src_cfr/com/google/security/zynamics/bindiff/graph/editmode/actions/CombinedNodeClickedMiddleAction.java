/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.EditCombinedNodeHelper;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedMiddleState;
import java.awt.event.MouseEvent;
import y.c.q;

public class CombinedNodeClickedMiddleAction
implements IStateAction {
    public void execute(CNodeClickedMiddleState cNodeClickedMiddleState, MouseEvent mouseEvent) {
        EditCombinedNodeHelper.setActiveLabelContent((CombinedGraph)cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        EditCombinedNodeHelper.setCaretStart(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        EditCombinedNodeHelper.setCaretEnd(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
    }
}

