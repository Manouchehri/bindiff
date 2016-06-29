package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public final class CNodeEditExitState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final q m_node;
    
    public CNodeEditExitState(final CStateFactory factory, final AbstractZyGraph graph, final q node) {
        this.m_factory = factory;
        this.m_graph = graph;
        this.m_node = node;
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
        throw new IllegalStateException("Not yet implemented");
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        throw new IllegalStateException("Not yet implemented");
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        throw new IllegalStateException("Not yet implemented");
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        throw new IllegalStateException("Not yet implemented");
    }
}
