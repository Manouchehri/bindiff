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
import java.awt.event.MouseEvent;
import y.h.x;

public class CBendPressedLeftState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final x m_bend;

    public CBendPressedLeftState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, x x2) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, "Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: graph argument can not be null");
        this.m_bend = (x)Preconditions.checkNotNull(x2, "Error: bend argument can not be null");
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
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createBendClickedLeftState(this.m_bend, mouseEvent), false);
    }
}

