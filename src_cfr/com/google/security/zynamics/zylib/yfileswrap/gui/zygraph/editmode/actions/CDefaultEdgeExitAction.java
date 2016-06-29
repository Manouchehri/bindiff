/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeExitState;
import java.awt.event.MouseEvent;
import y.c.d;
import y.c.i;
import y.h.aB;
import y.h.bu;
import y.h.ch;

public class CDefaultEdgeExitAction
implements IStateAction {
    protected void clearTooltip(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().setToolTipText(null);
    }

    protected void unhighlightEdge(d d2) {
        CEdgeHighlighter.highlightEdge(((bu)d2.a()).i(d2), false);
    }

    public void execute(CEdgeExitState cEdgeExitState, MouseEvent mouseEvent) {
        this.clearTooltip(cEdgeExitState.getGraph());
        if (cEdgeExitState.getEdge().a() != null) {
            this.unhighlightEdge(cEdgeExitState.getEdge());
        }
        cEdgeExitState.getGraph().updateViews();
    }
}

