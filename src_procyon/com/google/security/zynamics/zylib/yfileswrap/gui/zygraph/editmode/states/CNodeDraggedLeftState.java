package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.awt.event.*;
import y.c.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;

public class CNodeDraggedLeftState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final q m_node;
    private final double m_distX;
    private final double m_distY;
    
    public CNodeDraggedLeftState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        this(cStateFactory, abstractZyGraph, q, mouseEvent, 0.0, 0.0);
    }
    
    public CNodeDraggedLeftState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent, final double distX, final double distY) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_node = (q)Preconditions.checkNotNull(q, (Object)"Error: node argument can not be null");
        this.m_event = (MouseEvent)Preconditions.checkNotNull(mouseEvent, (Object)"Error: event argument can not be null");
        this.m_distX = distX;
        this.m_distY = distY;
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
    public IMouseStateChange mouseDragged(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY())), false);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY())), false);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY())), false);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = this.m_graph.getGraph().b(this.m_graph.getEditMode().translateX(mouseEvent.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            return CHitNodesTransformer.changeNode(this.m_factory, mouseEvent, b, this.m_node);
        }
        this.m_factory.createNodeExitState(this.m_node, mouseEvent);
        return CHitNodesTransformer.exitNode(this.m_factory, mouseEvent, b, this);
    }
}
