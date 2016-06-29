package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;

public class CEdgeLabelHoverState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final aA m_label;
    
    public CEdgeLabelHoverState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final aA aa) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_label = (aA)Preconditions.checkNotNull(aa, (Object)"Error: label argument can not be null");
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
        final cW b = this.m_graph.getGraph().b(this.m_graph.getEditMode().translateX(mouseEvent.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, b);
        }
        if (b.s()) {
            throw new IllegalStateException();
        }
        if (b.u()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitEdgesTransformer.enterEdge(this.m_factory, mouseEvent, b);
        }
        if (b.r()) {
            return CHitEdgeLabelsTransformer.changeEdgeLabel(this.m_factory, mouseEvent, b, this.m_label);
        }
        if (b.v()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitBendsTransformer.enterBend(this.m_factory, mouseEvent, b);
        }
        if (b.q()) {
            return new CStateChange(this, true);
        }
        this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = this.m_graph.getGraph().b(this.m_graph.getEditMode().translateX(mouseEvent.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            throw new IllegalStateException();
        }
        if (b.s()) {
            throw new IllegalStateException();
        }
        if (b.u()) {
            throw new IllegalStateException();
        }
        if (b.r()) {
            if (b.m() == this.m_label) {
                return new CStateChange(this, true);
            }
            throw new IllegalStateException();
        }
        else {
            if (b.v()) {
                throw new IllegalStateException();
            }
            if (b.q()) {
                return new CStateChange(this, true);
            }
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return new CStateChange(this, true);
        }
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
}
