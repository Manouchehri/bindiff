package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public final class CDefaultState implements IMouseState
{
    private final CStateFactory m_factory;
    
    public CDefaultState(final CStateFactory factory) {
        this.m_factory = factory;
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
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, b);
        }
        if (b.u()) {
            return CHitEdgesTransformer.enterEdge(this.m_factory, mouseEvent, b);
        }
        if (b.r()) {
            return CHitEdgeLabelsTransformer.enterEdgeLabel(this.m_factory, mouseEvent, b);
        }
        if (b.v()) {
            return CHitBendsTransformer.enterBend(this.m_factory, mouseEvent, b);
        }
        if (b.q()) {
            return new CStateChange(this, true);
        }
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return CMousePressedHandler.handleMousePressed(this.m_factory, this, abstractZyGraph, mouseEvent);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
}
