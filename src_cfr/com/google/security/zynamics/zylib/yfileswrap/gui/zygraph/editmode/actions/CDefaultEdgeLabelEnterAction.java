/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelEnterState;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import y.h.aA;
import y.h.aB;

public class CDefaultEdgeLabelEnterAction
implements IStateAction {
    protected void highlightEdge(aA aA2) {
        CEdgeHighlighter.highlightEdge(aA2.getOwner(), true);
    }

    public void execute(CEdgeLabelEnterState cEdgeLabelEnterState, MouseEvent mouseEvent) {
        this.highlightEdge(cEdgeLabelEnterState.getLabel());
        AbstractZyGraph abstractZyGraph = cEdgeLabelEnterState.getGraph();
        aA aA2 = cEdgeLabelEnterState.getLabel();
        Iterator iterator = cEdgeLabelEnterState.getStateFactory().getListeners().iterator();
        do {
            if (!iterator.hasNext()) {
                abstractZyGraph.updateViews();
                return;
            }
            IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
            try {
                iZyEditModeListener.edgeLabelEntered(aA2, mouseEvent);
            }
            catch (Exception var7_7) {
            }
        } while (true);
    }
}

