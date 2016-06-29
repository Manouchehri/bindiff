package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;

public class CDefaultEdgeLabelEnterAction implements IStateAction
{
    protected void highlightEdge(final aA aa) {
        CEdgeHighlighter.highlightEdge(aa.getOwner(), true);
    }
    
    public void execute(final CEdgeLabelEnterState cEdgeLabelEnterState, final MouseEvent mouseEvent) {
        this.highlightEdge(cEdgeLabelEnterState.getLabel());
        final AbstractZyGraph graph = cEdgeLabelEnterState.getGraph();
        final aA label = cEdgeLabelEnterState.getLabel();
        for (final IZyEditModeListener zyEditModeListener : cEdgeLabelEnterState.getStateFactory().getListeners()) {
            try {
                zyEditModeListener.edgeLabelEntered(label, mouseEvent);
            }
            catch (Exception ex) {}
        }
        graph.updateViews();
    }
}
