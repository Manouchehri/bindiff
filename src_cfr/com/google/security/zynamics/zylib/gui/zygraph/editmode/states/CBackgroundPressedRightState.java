/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CMousePressedHandler;
import java.awt.event.MouseEvent;

public class CBackgroundPressedRightState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;

    public CBackgroundPressedRightState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
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
        return new CStateChange(this.m_factory.createBackgroundDraggedRightState(mouseEvent), true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return CMousePressedHandler.handleMousePressed(this.m_factory, this, abstractZyGraph, mouseEvent);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createBackgroundClickedRightState(mouseEvent), true);
    }
}

