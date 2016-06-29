/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeEnterState;
import java.awt.event.MouseEvent;
import y.c.d;
import y.c.i;
import y.h.aB;
import y.h.bu;

public class CDefaultEdgeEnterAction
implements IStateAction {
    protected void highlightEdge(d d2) {
        CEdgeHighlighter.highlightEdge(((bu)d2.a()).i(d2), true);
    }

    protected void updateTooltip(AbstractZyGraph abstractZyGraph, d d2) {
        CTooltipUpdater.updateEdgeTooltip(abstractZyGraph, d2);
    }

    public void execute(CEdgeEnterState cEdgeEnterState, MouseEvent mouseEvent) {
        this.highlightEdge(cEdgeEnterState.getEdge());
        this.updateTooltip(cEdgeEnterState.getGraph(), cEdgeEnterState.getEdge());
        cEdgeEnterState.getGraph().updateViews();
    }
}

