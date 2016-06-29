/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CGraphSelector;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.SwingUtilities;
import y.c.q;
import y.d.y;
import y.h.a.p;
import y.h.bu;
import y.h.eR;
import y.h.fj;

public class CDefaultNodeClickedLeftAction
implements IStateAction {
    private void toggleGroup(ZyGraphNode zyGraphNode) {
        IGroupNode iGroupNode;
        iGroupNode.setCollapsed(!(iGroupNode = (IGroupNode)zyGraphNode.getRawNode()).isCollapsed());
    }

    public void execute(CNodeClickedLeftState cNodeClickedLeftState, MouseEvent mouseEvent) {
        Object object;
        Object object2;
        CMouseCursorHelper.setDefaultCursor(cNodeClickedLeftState.getGraph());
        AbstractZyGraph abstractZyGraph = cNodeClickedLeftState.getGraph();
        q q2 = cNodeClickedLeftState.getNode();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(q2);
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        CStateFactory cStateFactory = cNodeClickedLeftState.getStateFactory();
        if (!ProximityHelper.isProximityNode(cNodeClickedLeftState.getGraph().getGraph(), q2)) {
            if (zyGraphNode != null && zyGraphNode.getRawNode() instanceof IGroupNode) {
                CEditNodeHelper.removeCaret(abstractZyGraph);
                p p2 = (p)abstractZyGraph.getGraph().t(zyGraphNode.getNode());
                eR eR2 = p2.getStateLabel();
                if (eR2.getBox().a(d2, d3)) {
                    this.toggleGroup(zyGraphNode);
                    return;
                }
                if (!SwingUtilities.isLeftMouseButton(mouseEvent)) return;
                if (mouseEvent.getClickCount() == 2 && mouseEvent.isControlDown()) {
                    this.toggleGroup(zyGraphNode);
                    return;
                }
                if (mouseEvent.getClickCount() != 1) return;
                CGraphSelector.selectNode(abstractZyGraph, zyGraphNode, mouseEvent.isShiftDown());
                return;
            }
            if (zyGraphNode == null) return;
            if (abstractZyGraph.getEditMode().getLabelEventHandler().isActiveLabel(zyGraphNode.getRealizer().getNodeContent())) {
                CEditNodeHelper.setCaretEnd(abstractZyGraph, cNodeClickedLeftState.getNode(), mouseEvent);
            } else {
                if (abstractZyGraph.getEditMode().getLabelEventHandler().isActive()) {
                    CEditNodeHelper.removeCaret(abstractZyGraph);
                }
                object2 = abstractZyGraph.getSelectedNodes();
                if (mouseEvent.isShiftDown() && object2.size() >= 1) {
                    CGraphSelector.selectPath(abstractZyGraph, new ArrayList(object2), zyGraphNode);
                } else if (mouseEvent.isControlDown()) {
                    abstractZyGraph.selectNode(zyGraphNode, !zyGraphNode.isSelected());
                } else {
                    object = new ArrayList(abstractZyGraph.getNodes());
                    object.remove(zyGraphNode);
                    ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
                    arrayList.add(zyGraphNode);
                    abstractZyGraph.selectNodes(arrayList, (Collection)object);
                }
            }
        } else {
            CEditNodeHelper.removeCaret(abstractZyGraph);
            ZyProximityNode zyProximityNode = ProximityHelper.getProximityNode(abstractZyGraph.getGraph(), q2);
            Iterator iterator = cStateFactory.getListeners().iterator();
            while (iterator.hasNext()) {
                IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
                try {
                    iZyEditModeListener.proximityBrowserNodeClicked(zyProximityNode, mouseEvent, d2, d3);
                }
                catch (Exception var14_18) {}
            }
            return;
        }
        object2 = cStateFactory.getListeners().iterator();
        while (object2.hasNext()) {
            object = (IZyEditModeListener)object2.next();
            try {
                object.nodeClicked(zyGraphNode, mouseEvent, d2, d3);
            }
            catch (Exception var13_17) {}
        }
    }
}

