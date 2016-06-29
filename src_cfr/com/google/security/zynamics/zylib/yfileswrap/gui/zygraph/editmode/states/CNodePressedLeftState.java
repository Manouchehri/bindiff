/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import y.c.q;

public class CNodePressedLeftState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final q m_node;

    public CNodePressedLeftState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent) {
        this.m_factory = cStateFactory;
        this.m_graph = abstractZyGraph;
        this.m_node = q2;
        this.m_event = mouseEvent;
    }

    public AbstractZyGraph getGraph() {
        return this.m_graph;
    }

    public q getNode() {
        return this.m_node;
    }

    @Override
    public CStateFactory getStateFactory() {
        return this.m_factory;
    }

    @Override
    public IMouseStateChange mouseDragged(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
        if (this.m_graph.getNode(this.m_node) != null) return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, d2, d3), false);
        return new CStateChange(this.m_factory.createNodeExitState(this.m_node, mouseEvent), true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeClickedLeftState(this.m_node, mouseEvent), false);
    }
}

