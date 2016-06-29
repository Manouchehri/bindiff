/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import y.c.q;

public class CDefaultNodeHoverAction
implements IStateAction {
    public void execute(CNodeHoverState cNodeHoverState, MouseEvent mouseEvent) {
        AbstractZyGraph abstractZyGraph = cNodeHoverState.getGraph();
        CMouseCursorHelper.setDefaultCursor(abstractZyGraph);
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(cNodeHoverState.getNode());
        if (zyGraphNode == null) return;
        Iterator iterator = cNodeHoverState.getStateFactory().getListeners().iterator();
        while (iterator.hasNext()) {
            IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
            try {
                iZyEditModeListener.nodeHovered(zyGraphNode, d2, d3);
            }
            catch (Exception var11_9) {}
        }
    }
}

