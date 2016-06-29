package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;

public class CBendClickedLeftState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final x m_bend;
    
    public CBendClickedLeftState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final x x) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_bend = (x)Preconditions.checkNotNull(x, (Object)"Error: bend argument can not be null");
    }
    
    public AbstractZyGraph getGraph() {
        return this.m_graph;
    }
    
    @Override
    public CStateFactory getStateFactory() {
        return this.m_factory;
    }
    
    @Override
    public IMouseStateChange mouseDragged(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = abstractZyGraph.getGraph().b(abstractZyGraph.getEditMode().translateX(mouseEvent.getX()), abstractZyGraph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            this.m_factory.createBendExitState(this.m_bend, mouseEvent);
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, b);
        }
        if (b.s()) {
            throw new IllegalStateException();
        }
        if (b.u()) {
            this.m_factory.createBendExitState(this.m_bend, mouseEvent);
            return new CStateChange(this.m_factory.createEdgeEnterState(b.k(), mouseEvent), true);
        }
        if (b.r()) {
            this.m_factory.createBendExitState(this.m_bend, mouseEvent);
            return new CStateChange(this.m_factory.createEdgeLabelEnterState(b.m(), mouseEvent), true);
        }
        if (b.v()) {
            return CHitBendsTransformer.changeBend(this.m_factory, mouseEvent, b, this.m_bend);
        }
        if (b.q()) {
            return new CStateChange(this, true);
        }
        this.m_factory.createBendExitState(this.m_bend, mouseEvent);
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
}
