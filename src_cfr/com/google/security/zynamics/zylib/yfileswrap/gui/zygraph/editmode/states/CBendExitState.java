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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.h.bu;
import y.h.cW;
import y.h.x;

public class CBendExitState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final x m_bend;

    public CBendExitState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, x x2) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_bend = (x)Preconditions.checkNotNull(x2, "Error: bend argument can not be null");
    }

    public x getEdge() {
        return this.m_bend;
    }

    public AbstractZyGraph getGraph() {
        return this.m_graph;
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
        if (cW2.t()) {
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            return CHitEdgesTransformer.enterEdge(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.r()) {
            return CHitEdgeLabelsTransformer.enterEdgeLabel(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.v()) {
            return CHitBendsTransformer.enterBend(this.m_factory, mouseEvent, cW2);
        }
        if (!cW2.q()) return new CStateChange(this.m_factory.createDefaultState(), true);
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
}

