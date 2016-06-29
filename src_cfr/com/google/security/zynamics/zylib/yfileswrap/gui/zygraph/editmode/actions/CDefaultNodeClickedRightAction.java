/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import y.c.q;
import y.h.bu;

public class CDefaultNodeClickedRightAction
implements IStateAction {
    public void execute(CNodeClickedRightState cNodeClickedRightState, MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cNodeClickedRightState.getGraph());
        AbstractZyGraph abstractZyGraph = cNodeClickedRightState.getGraph();
        q q2 = cNodeClickedRightState.getNode();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(q2);
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        if (abstractZyGraph.getEditMode().getLabelEventHandler().isActive() && abstractZyGraph.getEditMode().getLabelEventHandler().hasEmptySelection()) {
            CEditNodeHelper.removeCaret(abstractZyGraph);
        }
        if (zyGraphNode == null) {
            ZyProximityNode zyProximityNode = ProximityHelper.getProximityNode(abstractZyGraph.getGraph(), q2);
            Iterator iterator = cNodeClickedRightState.getStateFactory().getListeners().iterator();
            while (iterator.hasNext()) {
                IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
                try {
                    iZyEditModeListener.proximityBrowserNodeClicked(zyProximityNode, mouseEvent, d2, d3);
                }
                catch (Exception var13_14) {}
            }
            return;
        }
        Iterator iterator = cNodeClickedRightState.getStateFactory().getListeners().iterator();
        while (iterator.hasNext()) {
            IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
            try {
                iZyEditModeListener.nodeClicked(zyGraphNode, mouseEvent, d2, d3);
            }
            catch (Exception var12_13) {}
        }
    }
}

