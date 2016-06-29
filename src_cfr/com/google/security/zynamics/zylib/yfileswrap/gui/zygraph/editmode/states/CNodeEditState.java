/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import y.c.d;
import y.c.q;
import y.h.aA;
import y.h.bu;
import y.h.cW;
import y.h.x;

public final class CNodeEditState
implements IMouseState {
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final q m_node;
    private boolean m_isDragging = false;

    public CNodeEditState(CStateFactory cStateFactory, AbstractZyGraph abstractZyGraph, q q2) {
        this.m_factory = cStateFactory;
        this.m_graph = abstractZyGraph;
        this.m_node = q2;
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
    public IMouseStateChange mouseDragged(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        this.m_isDragging = true;
        CEditNodeHelper.select(abstractZyGraph, this.m_node, mouseEvent);
        return new CStateChange(this, false);
    }

    @Override
    public IMouseStateChange mouseMoved(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }

    @Override
    public IMouseStateChange mousePressed(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = abstractZyGraph.getGraph().b(d2, d3);
        if (cW2.t()) {
            q q2 = cW2.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                if (q2 != this.m_node) {
                    this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                    return new CStateChange(this.m_factory.createNodePressedLeftState(q2, mouseEvent), true);
                }
                if (!this.m_isDragging) {
                    CEditNodeHelper.setCaretStart(abstractZyGraph, q2, mouseEvent);
                    return new CStateChange(this, false);
                }
                this.m_isDragging = false;
                return new CStateChange(this, false);
            }
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                if (q2 == this.m_node) {
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedRightState(q2, mouseEvent), true);
            }
            if (!SwingUtilities.isMiddleMouseButton(mouseEvent)) {
                if (!mouseEvent.isAltDown()) return new CStateChange(this, false);
                if (!SwingUtilities.isLeftMouseButton(mouseEvent)) return new CStateChange(this, false);
            }
            if (q2 != this.m_node) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedMiddleState(q2, mouseEvent), true);
            }
            if (!this.m_isDragging) {
                CEditNodeHelper.setCaretStart(abstractZyGraph, q2, mouseEvent);
                return new CStateChange(this, false);
            }
            this.m_isDragging = false;
            return new CStateChange(this, false);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(cW2.k(), mouseEvent), true);
        }
        if (cW2.r()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(cW2.m().getEdge(), mouseEvent), true);
        }
        if (cW2.v()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createBendPressedLeftState(cW2.j(), mouseEvent), true);
        }
        if (cW2.q()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createDefaultState(), true);
        }
        this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
        return new CStateChange(this.m_factory.createBackgroundPressedLeftState(mouseEvent), true);
    }

    @Override
    public IMouseStateChange mouseReleased(MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = abstractZyGraph.getGraph().b(d2, d3);
        if (cW2.t()) {
            q q2 = cW2.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                if (q2 != this.m_node) {
                    this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                    return new CStateChange(this.m_factory.createNodePressedLeftState(q2, mouseEvent), true);
                }
                if (!this.m_isDragging) {
                    CEditNodeHelper.setCaretEnd(abstractZyGraph, q2, mouseEvent);
                    return new CStateChange(this, false);
                }
                this.m_isDragging = false;
                return new CStateChange(this, false);
            }
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                if (q2 == this.m_node) {
                    return new CStateChange(this, false);
                }
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedRightState(q2, mouseEvent), true);
            }
            if (!SwingUtilities.isMiddleMouseButton(mouseEvent)) {
                if (!mouseEvent.isAltDown()) return new CStateChange(this, false);
                if (!SwingUtilities.isLeftMouseButton(mouseEvent)) return new CStateChange(this, false);
            }
            if (q2 != this.m_node) {
                this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
                return new CStateChange(this.m_factory.createNodePressedMiddleState(q2, mouseEvent), true);
            }
            if (!this.m_isDragging) {
                CEditNodeHelper.setCaretEnd(abstractZyGraph, q2, mouseEvent);
                return new CStateChange(this, false);
            }
            this.m_isDragging = false;
            return new CStateChange(this, false);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(cW2.k(), mouseEvent), true);
        }
        if (cW2.r()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(cW2.m().getEdge(), mouseEvent), true);
        }
        if (cW2.v()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createBendPressedLeftState(cW2.j(), mouseEvent), true);
        }
        if (cW2.q()) {
            this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
            return new CStateChange(this.m_factory.createDefaultState(), true);
        }
        this.m_factory.createNodeEditExitState(this.m_node, mouseEvent);
        return new CStateChange(this.m_factory.createBackgroundPressedLeftState(mouseEvent), true);
    }
}

