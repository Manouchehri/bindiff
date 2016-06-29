/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.bu;
import y.h.cW;

public class CNodeDraggedLeftState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final q m_node;
    private final double m_distX;
    private final double m_distY;

    public CNodeDraggedLeftState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent) {
        this(cStateFactory, abstractZyGraph, q2, mouseEvent, 0.0, 0.0);
    }

    public CNodeDraggedLeftState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, q q2, MouseEvent mouseEvent, double d2, double d3) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_node = (q)Preconditions.checkNotNull(q2, "Error: node argument can not be null");
        this.m_event = (MouseEvent)Preconditions.checkNotNull(mouseEvent, "Error: event argument can not be null");
        this.m_distX = d2;
        this.m_distY = d3;
    }

    public double getDistanceX() {
        return this.m_distX;
    }

    public double getDistanceY() {
        return this.m_distY;
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
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, d2, d3), false);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, d2, d3), false);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, d2, d3), false);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = this.m_graph.getGraph().b(d2, d3);
        if (cW2.t()) {
            return CHitNodesTransformer.changeNode(this.m_factory, mouseEvent, cW2, this.m_node);
        }
        this.m_factory.createNodeExitState(this.m_node, mouseEvent);
        return CHitNodesTransformer.exitNode(this.m_factory, mouseEvent, cW2, this);
    }
}

