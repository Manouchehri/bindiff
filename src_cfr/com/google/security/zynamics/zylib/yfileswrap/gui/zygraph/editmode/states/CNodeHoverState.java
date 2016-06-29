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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CMousePressedHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.bu;
import y.h.cW;

public final class CNodeHoverState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final q m_node;

    public CNodeHoverState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, q q2) {
        this.m_graph = abstractZyGraph;
        this.m_factory = cStateFactory;
        this.m_node = q2;
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
        return new CStateChange(this, false);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = this.m_graph.getGraph().b(d2, d3);
        if (cW2.t()) {
            return CHitNodesTransformer.changeNode(this.m_factory, mouseEvent, cW2, this.m_node);
        }
        this.m_factory.createNodeExitState(this.m_node, mouseEvent);
        return CHitNodesTransformer.exitNode(this.m_factory, mouseEvent, cW2, this);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return CMousePressedHandler.handleMousePressed(this.m_factory, this, abstractZyGraph, mouseEvent);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
}

