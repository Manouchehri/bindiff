package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import y.h.a.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import java.util.*;

public class CDefaultNodeClickedLeftAction implements IStateAction
{
    private void toggleGroup(final ZyGraphNode zyGraphNode) {
        final IGroupNode groupNode = (IGroupNode)zyGraphNode.getRawNode();
        groupNode.setCollapsed(!groupNode.isCollapsed());
    }
    
    public void execute(final CNodeClickedLeftState cNodeClickedLeftState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cNodeClickedLeftState.getGraph());
        final AbstractZyGraph graph = cNodeClickedLeftState.getGraph();
        final q node = cNodeClickedLeftState.getNode();
        final ZyGraphNode node2 = graph.getNode(node);
        final double translateX = graph.getEditMode().translateX(mouseEvent.getX());
        final double translateY = graph.getEditMode().translateY(mouseEvent.getY());
        final CStateFactory stateFactory = cNodeClickedLeftState.getStateFactory();
        if (ProximityHelper.isProximityNode(cNodeClickedLeftState.getGraph().getGraph(), node)) {
            CEditNodeHelper.removeCaret(graph);
            final ZyProximityNode proximityNode = ProximityHelper.getProximityNode(graph.getGraph(), node);
            for (final IZyEditModeListener zyEditModeListener : stateFactory.getListeners()) {
                try {
                    zyEditModeListener.proximityBrowserNodeClicked(proximityNode, mouseEvent, translateX, translateY);
                }
                catch (Exception ex) {}
            }
        }
        else if (node2 != null && node2.getRawNode() instanceof IGroupNode) {
            CEditNodeHelper.removeCaret(graph);
            if (((p)graph.getGraph().t(node2.getNode())).getStateLabel().getBox().a(translateX, translateY)) {
                this.toggleGroup(node2);
            }
            else if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                if (mouseEvent.getClickCount() == 2 && mouseEvent.isControlDown()) {
                    this.toggleGroup(node2);
                }
                else if (mouseEvent.getClickCount() == 1) {
                    CGraphSelector.selectNode(graph, node2, mouseEvent.isShiftDown());
                }
            }
        }
        else if (node2 != null) {
            if (graph.getEditMode().getLabelEventHandler().isActiveLabel(node2.getRealizer().getNodeContent())) {
                CEditNodeHelper.setCaretEnd(graph, cNodeClickedLeftState.getNode(), mouseEvent);
            }
            else {
                if (graph.getEditMode().getLabelEventHandler().isActive()) {
                    CEditNodeHelper.removeCaret(graph);
                }
                final Set selectedNodes = graph.getSelectedNodes();
                if (mouseEvent.isShiftDown() && selectedNodes.size() >= 1) {
                    CGraphSelector.selectPath(graph, new ArrayList(selectedNodes), node2);
                }
                else if (mouseEvent.isControlDown()) {
                    graph.selectNode(node2, !node2.isSelected());
                }
                else {
                    final ArrayList list = new ArrayList(graph.getNodes());
                    list.remove(node2);
                    final ArrayList<ZyGraphNode> list2 = new ArrayList<ZyGraphNode>();
                    list2.add(node2);
                    graph.selectNodes(list2, list);
                }
            }
            for (final IZyEditModeListener zyEditModeListener2 : stateFactory.getListeners()) {
                try {
                    zyEditModeListener2.nodeClicked(node2, mouseEvent, translateX, translateY);
                }
                catch (Exception ex2) {}
            }
        }
    }
}
