package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import javax.swing.*;
import y.h.*;

public final class CNodeEditState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final q m_node;
    private boolean m_isDragging;
    
    public CNodeEditState(final CStateFactory factory, final AbstractZyGraph graph, final q node) {
        this.m_isDragging = false;
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
        this.m_isDragging = true;
        CEditNodeHelper.select(abstractZyGraph, this.m_node, mouseEvent);
        return new CStateChange(this, false);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = abstractZyGraph.getGraph().b(abstractZyGraph.getEditMode().translateX(mouseEvent.getX()), abstractZyGraph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            final q i = b.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                if (i == this.m_node) {
                    if (!this.m_isDragging) {
                        CEditNodeHelper.setCaretStart(abstractZyGraph, i, mouseEvent);
                    }
                    else {
                        this.m_isDragging = false;
                    }
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedLeftState(i, mouseEvent), true);
            }
            else if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                if (i == this.m_node) {
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedRightState(i, mouseEvent), true);
            }
            else {
                if (!SwingUtilities.isMiddleMouseButton(mouseEvent) && (!mouseEvent.isAltDown() || !SwingUtilities.isLeftMouseButton(mouseEvent))) {
                    return new CStateChange(this, false);
                }
                if (i == this.m_node) {
                    if (!this.m_isDragging) {
                        CEditNodeHelper.setCaretStart(abstractZyGraph, i, mouseEvent);
                    }
                    else {
                        this.m_isDragging = false;
                    }
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedMiddleState(i, mouseEvent), true);
            }
        }
        else {
            if (b.s()) {
                throw new IllegalStateException();
            }
            if (b.u()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createEdgePressedLeftState(b.k(), mouseEvent), true);
            }
            if (b.r()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createEdgePressedLeftState(b.m().getEdge(), mouseEvent), true);
            }
            if (b.v()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createBendPressedLeftState(b.j(), mouseEvent), true);
            }
            if (b.q()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createDefaultState(), true);
            }
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createBackgroundPressedLeftState(mouseEvent), true);
        }
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = abstractZyGraph.getGraph().b(abstractZyGraph.getEditMode().translateX(mouseEvent.getX()), abstractZyGraph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            final q i = b.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                if (i == this.m_node) {
                    if (!this.m_isDragging) {
                        CEditNodeHelper.setCaretEnd(abstractZyGraph, i, mouseEvent);
                    }
                    else {
                        this.m_isDragging = false;
                    }
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedLeftState(i, mouseEvent), true);
            }
            else if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                if (i == this.m_node) {
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedRightState(i, mouseEvent), true);
            }
            else {
                if (!SwingUtilities.isMiddleMouseButton(mouseEvent) && (!mouseEvent.isAltDown() || !SwingUtilities.isLeftMouseButton(mouseEvent))) {
                    return new CStateChange(this, false);
                }
                if (i == this.m_node) {
                    if (!this.m_isDragging) {
                        CEditNodeHelper.setCaretEnd(abstractZyGraph, i, mouseEvent);
                    }
                    else {
                        this.m_isDragging = false;
                    }
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedMiddleState(i, mouseEvent), true);
            }
        }
        else {
            if (b.s()) {
                throw new IllegalStateException();
            }
            if (b.u()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createEdgePressedLeftState(b.k(), mouseEvent), true);
            }
            if (b.r()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createEdgePressedLeftState(b.m().getEdge(), mouseEvent), true);
            }
            if (b.v()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createBendPressedLeftState(b.j(), mouseEvent), true);
            }
            if (b.q()) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createDefaultState(), true);
            }
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createBackgroundPressedLeftState(mouseEvent), true);
        }
    }
}
