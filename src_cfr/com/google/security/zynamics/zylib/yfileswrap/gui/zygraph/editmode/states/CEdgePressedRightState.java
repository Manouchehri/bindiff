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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeMover;
import java.awt.event.MouseEvent;
import y.c.d;

public class CEdgePressedRightState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final d m_edge;

    public CEdgePressedRightState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, d d2, MouseEvent mouseEvent) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_edge = (d)Preconditions.checkNotNull(d2, "Error: edge argument can not be null");
        this.m_event = (MouseEvent)Preconditions.checkNotNull(mouseEvent, "Error: event argument can not be null");
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
        int n2;
        int n3;
        int n4;
        int n5 = this.m_event.getX();
        if (!CNodeMover.isDraggedFar(n5, n3 = this.m_event.getY(), n4 = mouseEvent.getX(), n2 = mouseEvent.getY())) return new CStateChange(this, true);
        return new CStateChange(this.m_factory.createBackgroundDraggedRightState(mouseEvent), true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createEdgeClickedRightState(this.m_edge, mouseEvent), true);
    }
}

