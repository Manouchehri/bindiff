package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;

public class CDefaultEdgeExitAction implements IStateAction
{
    protected void clearTooltip(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().setToolTipText(null);
    }
    
    protected void unhighlightEdge(final d d) {
        CEdgeHighlighter.highlightEdge(((bu)d.a()).i(d), false);
    }
    
    public void execute(final CEdgeExitState cEdgeExitState, final MouseEvent mouseEvent) {
        this.clearTooltip(cEdgeExitState.getGraph());
        if (cEdgeExitState.getEdge().a() != null) {
            this.unhighlightEdge(cEdgeExitState.getEdge());
        }
        cEdgeExitState.getGraph().updateViews();
    }
}
