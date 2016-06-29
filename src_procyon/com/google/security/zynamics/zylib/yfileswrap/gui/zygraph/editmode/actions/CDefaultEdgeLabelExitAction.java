package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;

public class CDefaultEdgeLabelExitAction implements IStateAction
{
    protected void unhighlightEdges(final aB ab) {
        CEdgeHighlighter.highlightEdge(ab, false);
    }
    
    public void execute(final CEdgeLabelExitState cEdgeLabelExitState, final MouseEvent mouseEvent) {
        this.unhighlightEdges(cEdgeLabelExitState.getLabel().getOwner());
        if (cEdgeLabelExitState.getLabel() != null) {
            this.unhighlightEdges(cEdgeLabelExitState.getLabel().getOwner());
            for (final IZyEditModeListener zyEditModeListener : cEdgeLabelExitState.getStateFactory().getListeners()) {
                try {
                    zyEditModeListener.edgeLabelLeft(cEdgeLabelExitState.getLabel());
                }
                catch (Exception ex) {}
            }
        }
        cEdgeLabelExitState.getGraph().updateViews();
    }
}
