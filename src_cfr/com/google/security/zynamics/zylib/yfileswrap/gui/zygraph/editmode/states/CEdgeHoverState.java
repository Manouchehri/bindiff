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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CMousePressedHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.bu;
import y.h.cW;

public class CEdgeHoverState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final d m_edge;

    public CEdgeHoverState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, d d2) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_edge = (d)Preconditions.checkNotNull(d2, "Error: edge argument can not be null");
    }

    @Override
    public CStateFactory getStateFactory() {
        return this.m_factory;
    }

    @Override
    public IMouseStateChange mouseDragged(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = this.m_graph.getGraph().b(d2, d3);
        if (cW2.u()) {
            return CHitEdgesTransformer.changeEdge(this.m_factory, mouseEvent, cW2, this.m_edge);
        }
        this.m_factory.createEdgeExitState(this.m_edge, mouseEvent);
        return CHitEdgesTransformer.exitEdge(this.m_factory, mouseEvent, cW2, this);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return CMousePressedHandler.handleMousePressed(this.m_factory, this, abstractZyGraph, mouseEvent);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
}

