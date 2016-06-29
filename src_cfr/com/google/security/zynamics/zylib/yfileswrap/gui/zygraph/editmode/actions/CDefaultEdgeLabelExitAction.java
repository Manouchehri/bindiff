/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelExitState;
import java.awt.event.MouseEvent;
import java.util.List;
import y.h.aA;
import y.h.aB;

public class CDefaultEdgeLabelExitAction
implements IStateAction {
    protected void unhighlightEdges(aB aB2) {
        CEdgeHighlighter.highlightEdge(aB2, false);
    }

    public void execute(CEdgeLabelExitState cEdgeLabelExitState, MouseEvent mouseEvent) {
        this.unhighlightEdges(cEdgeLabelExitState.getLabel().getOwner());
        if (cEdgeLabelExitState.getLabel() != null) {
            this.unhighlightEdges(cEdgeLabelExitState.getLabel().getOwner());
            for (IZyEditModeListener iZyEditModeListener : cEdgeLabelExitState.getStateFactory().getListeners()) {
                try {
                    iZyEditModeListener.edgeLabelLeft(cEdgeLabelExitState.getLabel());
                }
                catch (Exception var5_5) {}
            }
        }
        cEdgeLabelExitState.getGraph().updateViews();
    }
}

