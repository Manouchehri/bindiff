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
import y.h.aA;
import y.h.bu;
import y.h.cW;

public class CEdgeLabelHoverState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final aA m_label;

    public CEdgeLabelHoverState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, aA aA2) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_label = (aA)Preconditions.checkNotNull(aA2, "Error: label argument can not be null");
    }

    @Override
    public CStateFactory getStateFactory() {
        return this.m_factory;
    }

    @Override
    public IMouseStateChange mouseDragged(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = this.m_graph.getGraph().b(d2, d3);
        if (cW2.t()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitEdgesTransformer.enterEdge(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.r()) {
            return CHitEdgeLabelsTransformer.changeEdgeLabel(this.m_factory, mouseEvent, cW2, this.m_label);
        }
        if (cW2.v()) {
            this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
            return CHitBendsTransformer.enterBend(this.m_factory, mouseEvent, cW2);
        }
        if (cW2.q()) {
            return new CStateChange(this, true);
        }
        this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = this.m_graph.getEditMode().translateX(mouseEvent.getX());
        double d3 = this.m_graph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = this.m_graph.getGraph().b(d2, d3);
        if (cW2.t()) {
            throw new IllegalStateException();
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            throw new IllegalStateException();
        }
        if (cW2.r()) {
            aA aA2 = cW2.m();
            if (aA2 != this.m_label) throw new IllegalStateException();
            return new CStateChange(this, true);
        }
        if (cW2.v()) {
            throw new IllegalStateException();
        }
        if (cW2.q()) {
            return new CStateChange(this, true);
        }
        this.m_factory.createEdgeLabelExitState(this.m_label, mouseEvent);
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
}

