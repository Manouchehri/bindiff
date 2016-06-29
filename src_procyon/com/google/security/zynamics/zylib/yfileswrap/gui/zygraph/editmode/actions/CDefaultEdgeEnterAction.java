package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;

public class CDefaultEdgeEnterAction implements IStateAction
{
    protected void highlightEdge(final d d) {
        CEdgeHighlighter.highlightEdge(((bu)d.a()).i(d), true);
    }
    
    protected void updateTooltip(final AbstractZyGraph abstractZyGraph, final d d) {
        CTooltipUpdater.updateEdgeTooltip(abstractZyGraph, d);
    }
    
    public void execute(final CEdgeEnterState cEdgeEnterState, final MouseEvent mouseEvent) {
        this.highlightEdge(cEdgeEnterState.getEdge());
        this.updateTooltip(cEdgeEnterState.getGraph(), cEdgeEnterState.getEdge());
        cEdgeEnterState.getGraph().updateViews();
    }
}
