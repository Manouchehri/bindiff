package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.awt.event.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CNodePressedLeftState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final q m_node;
    
    public CNodePressedLeftState(final CStateFactory factory, final AbstractZyGraph graph, final q node, final MouseEvent event) {
        this.m_factory = factory;
        this.m_graph = graph;
        this.m_node = node;
        this.m_event = event;
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
        final double n = this.m_graph.getEditMode().translateX(mouseEvent.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
        final double n2 = this.m_graph.getEditMode().translateY(mouseEvent.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
        if (this.m_graph.getNode(this.m_node) == null) {
            return new CStateChange(this.m_factory.createNodeExitState(this.m_node, mouseEvent), true);
        }
        return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, mouseEvent, n, n2), false);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeClickedLeftState(this.m_node, mouseEvent), false);
    }
}
