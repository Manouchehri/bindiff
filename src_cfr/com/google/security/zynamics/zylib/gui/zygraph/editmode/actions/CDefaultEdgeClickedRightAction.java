/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedRightState;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

public class CDefaultEdgeClickedRightAction
implements IStateAction {
    public void execute(CEdgeClickedRightState cEdgeClickedRightState, MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cEdgeClickedRightState.getGraph());
        AbstractZyGraph abstractZyGraph = cEdgeClickedRightState.getGraph();
        ZyGraphEdge zyGraphEdge = cEdgeClickedRightState.getEdge();
        if (zyGraphEdge instanceof ZyInfoEdge) {
            return;
        }
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        Iterator iterator = cEdgeClickedRightState.getStateFactory().getListeners().iterator();
        while (iterator.hasNext()) {
            IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
            try {
                iZyEditModeListener.edgeClicked(zyGraphEdge, mouseEvent, d2, d3);
            }
            catch (Exception var11_9) {}
        }
    }
}

