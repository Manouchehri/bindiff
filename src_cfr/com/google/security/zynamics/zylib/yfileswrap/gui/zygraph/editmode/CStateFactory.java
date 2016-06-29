/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundClickedLeftState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundClickedRightState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundDraggedLeftState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundDraggedRightState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundPressedLeftState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundPressedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendPressedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CDefaultState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgePressedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgePressedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedMiddleState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeDraggedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEditEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEditExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEditState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodePressedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodePressedMiddleState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodePressedRightState;
import java.awt.event.MouseEvent;
import java.util.List;
import y.c.d;
import y.c.q;
import y.h.aA;
import y.h.x;

public final class CStateFactory {
    private final AbstractZyGraph m_graph;
    private final List m_listeners;
    private final IStateActionFactory m_factory;

    public CStateFactory(AbstractZyGraph abstractZyGraph, List list, IStateActionFactory iStateActionFactory) {
        this.m_graph = abstractZyGraph;
        this.m_listeners = list;
        this.m_factory = iStateActionFactory;
    }

    public IMouseState createBackgroundClickedLeftState(MouseEvent mouseEvent) {
        CBackgroundClickedLeftState cBackgroundClickedLeftState = new CBackgroundClickedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundClickedLeftAction().execute(cBackgroundClickedLeftState, mouseEvent);
        return cBackgroundClickedLeftState;
    }

    public IMouseState createBackgroundClickedRightState(MouseEvent mouseEvent) {
        CBackgroundClickedRightState cBackgroundClickedRightState = new CBackgroundClickedRightState(this, this.m_graph);
        this.m_factory.createBackgroundClickedRightAction().execute(cBackgroundClickedRightState, mouseEvent);
        return cBackgroundClickedRightState;
    }

    public IMouseState createBackgroundDraggedLeftState(MouseEvent mouseEvent) {
        CBackgroundDraggedLeftState cBackgroundDraggedLeftState = new CBackgroundDraggedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundDraggedLeftAction().execute(cBackgroundDraggedLeftState, mouseEvent);
        return cBackgroundDraggedLeftState;
    }

    public IMouseState createBackgroundDraggedRightState(MouseEvent mouseEvent) {
        CBackgroundDraggedRightState cBackgroundDraggedRightState = new CBackgroundDraggedRightState(this, this.m_graph);
        this.m_factory.createBackgroundDraggedRightAction().execute(cBackgroundDraggedRightState, mouseEvent);
        return cBackgroundDraggedRightState;
    }

    public IMouseState createBackgroundPressedLeftState(MouseEvent mouseEvent) {
        CBackgroundPressedLeftState cBackgroundPressedLeftState = new CBackgroundPressedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundPressedLeftAction().execute(cBackgroundPressedLeftState, mouseEvent);
        return cBackgroundPressedLeftState;
    }

    public IMouseState createBackgroundPressedRightState(MouseEvent mouseEvent) {
        CBackgroundPressedRightState cBackgroundPressedRightState = new CBackgroundPressedRightState(this, this.m_graph);
        this.m_factory.createBackgroundPressedRightAction().execute(cBackgroundPressedRightState, mouseEvent);
        return cBackgroundPressedRightState;
    }

    public IMouseState createBendClickedLeftState(x x2, MouseEvent mouseEvent) {
        CBendClickedLeftState cBendClickedLeftState = new CBendClickedLeftState(this, this.m_graph, x2);
        this.m_factory.createBendClickedLeftAction().execute(cBendClickedLeftState, mouseEvent);
        return cBendClickedLeftState;
    }

    public IMouseState createBendEnterState(x x2, MouseEvent mouseEvent) {
        CBendEnterState cBendEnterState = new CBendEnterState(this, this.m_graph, x2);
        this.m_factory.createBendEnterAction().execute(cBendEnterState, mouseEvent);
        return cBendEnterState;
    }

    public IMouseState createBendExitState(x x2, MouseEvent mouseEvent) {
        CBendExitState cBendExitState = new CBendExitState(this, this.m_graph, x2);
        this.m_factory.createBendExitAction().execute(cBendExitState, mouseEvent);
        return cBendExitState;
    }

    public IMouseState createBendHoverState(x x2, MouseEvent mouseEvent) {
        CBendHoverState cBendHoverState = new CBendHoverState(this, this.m_graph, x2);
        this.m_factory.createBendHoverAction().execute(cBendHoverState, mouseEvent);
        return cBendHoverState;
    }

    public IMouseState createBendPressedLeftState(x x2, MouseEvent mouseEvent) {
        CBendPressedLeftState cBendPressedLeftState = new CBendPressedLeftState(this, this.m_graph, x2);
        this.m_factory.createBendPressedLeftAction().execute(cBendPressedLeftState, mouseEvent);
        return cBendPressedLeftState;
    }

    public IMouseState createDefaultState() {
        return new CDefaultState(this);
    }

    public IMouseState createEdgeClickedLeftState(d d2, MouseEvent mouseEvent) {
        CEdgeClickedLeftState cEdgeClickedLeftState = new CEdgeClickedLeftState(this, this.m_graph, d2);
        this.m_factory.createEdgeClickedLeftAction().execute(cEdgeClickedLeftState, mouseEvent);
        return cEdgeClickedLeftState;
    }

    public IMouseState createEdgeClickedRightState(d d2, MouseEvent mouseEvent) {
        CEdgeClickedRightState cEdgeClickedRightState = new CEdgeClickedRightState(this, this.m_graph, d2);
        this.m_factory.createEdgeClickedRightAction().execute(cEdgeClickedRightState, mouseEvent);
        return cEdgeClickedRightState;
    }

    public IMouseState createEdgeEnterState(d d2, MouseEvent mouseEvent) {
        CEdgeEnterState cEdgeEnterState = new CEdgeEnterState(this, this.m_graph, d2);
        this.m_factory.createEdgeEnterAction().execute(cEdgeEnterState, mouseEvent);
        return cEdgeEnterState;
    }

    public IMouseState createEdgeExitState(d d2, MouseEvent mouseEvent) {
        CEdgeExitState cEdgeExitState = new CEdgeExitState(this, this.m_graph, d2);
        this.m_factory.createEdgeExitAction().execute(cEdgeExitState, mouseEvent);
        return cEdgeExitState;
    }

    public IMouseState createEdgeHoverState(d d2, MouseEvent mouseEvent) {
        CEdgeHoverState cEdgeHoverState = new CEdgeHoverState(this, this.m_graph, d2);
        this.m_factory.createEdgeHoverAction().execute(cEdgeHoverState, mouseEvent);
        return cEdgeHoverState;
    }

    public IMouseState createEdgeLabelEnterState(aA aA2, MouseEvent mouseEvent) {
        CEdgeLabelEnterState cEdgeLabelEnterState = new CEdgeLabelEnterState(this, this.m_graph, aA2);
        this.m_factory.createEdgeLabelEnterAction().execute(cEdgeLabelEnterState, mouseEvent);
        return cEdgeLabelEnterState;
    }

    public IMouseState createEdgeLabelExitState(aA aA2, MouseEvent mouseEvent) {
        CEdgeLabelExitState cEdgeLabelExitState = new CEdgeLabelExitState(this, this.m_graph, aA2);
        this.m_factory.createEdgeLabelExitAction().execute(cEdgeLabelExitState, mouseEvent);
        return cEdgeLabelExitState;
    }

    public IMouseState createEdgeLabelHoverState(aA aA2, MouseEvent mouseEvent) {
        CEdgeLabelHoverState cEdgeLabelHoverState = new CEdgeLabelHoverState(this, this.m_graph, aA2);
        this.m_factory.createEdgeLabelHoverAction().execute(cEdgeLabelHoverState, mouseEvent);
        return cEdgeLabelHoverState;
    }

    public IMouseState createEdgePressedLeftState(d d2, MouseEvent mouseEvent) {
        CEdgePressedLeftState cEdgePressedLeftState = new CEdgePressedLeftState(this, this.m_graph, d2);
        this.m_factory.createEdgePressedLeftAction().execute(cEdgePressedLeftState, mouseEvent);
        return cEdgePressedLeftState;
    }

    public IMouseState createEdgePressedRightState(d d2, MouseEvent mouseEvent) {
        CEdgePressedRightState cEdgePressedRightState = new CEdgePressedRightState(this, this.m_graph, d2, mouseEvent);
        this.m_factory.createEdgePressedRightAction().execute(cEdgePressedRightState, mouseEvent);
        return cEdgePressedRightState;
    }

    public IMouseState createNodeClickedLeftState(q q2, MouseEvent mouseEvent) {
        CNodeClickedLeftState cNodeClickedLeftState = new CNodeClickedLeftState(this, this.m_graph, q2);
        this.m_factory.createNodeClickedLeftAction().execute(cNodeClickedLeftState, mouseEvent);
        return cNodeClickedLeftState;
    }

    public IMouseState createNodeClickedMiddleState(q q2, MouseEvent mouseEvent) {
        CNodeClickedMiddleState cNodeClickedMiddleState = new CNodeClickedMiddleState(this, this.m_graph, q2);
        this.m_factory.createNodeClickedMiddleAction().execute(cNodeClickedMiddleState, mouseEvent);
        return cNodeClickedMiddleState;
    }

    public IMouseState createNodeClickedRightState(q q2, MouseEvent mouseEvent) {
        CNodeClickedRightState cNodeClickedRightState = new CNodeClickedRightState(this, this.m_graph, q2);
        this.m_factory.createNodeClickedRightAction().execute(cNodeClickedRightState, mouseEvent);
        return cNodeClickedRightState;
    }

    public IMouseState createNodeDraggedLeftState(q q2, MouseEvent mouseEvent, double d2, double d3) {
        CNodeDraggedLeftState cNodeDraggedLeftState = new CNodeDraggedLeftState(this, this.m_graph, q2, mouseEvent, d2, d3);
        this.m_factory.createNodeDraggedLeftAction().execute(cNodeDraggedLeftState, mouseEvent);
        return cNodeDraggedLeftState;
    }

    public IMouseState createNodeEditEnterState(q q2, MouseEvent mouseEvent) {
        CNodeEditEnterState cNodeEditEnterState = new CNodeEditEnterState(this, this.m_graph, q2);
        this.m_factory.createNodeEditEnterAction().execute(cNodeEditEnterState, mouseEvent);
        return cNodeEditEnterState;
    }

    public IMouseState createNodeEditExitState(q q2, MouseEvent mouseEvent) {
        CNodeEditExitState cNodeEditExitState = new CNodeEditExitState(this, this.m_graph, q2);
        this.m_factory.createNodeEditExitAction().execute(cNodeEditExitState, mouseEvent);
        return cNodeEditExitState;
    }

    public IMouseState createNodeEditState(q q2, MouseEvent mouseEvent) {
        CNodeEditState cNodeEditState = new CNodeEditState(this, this.m_graph, q2);
        this.m_factory.createNodeEditAction().execute(cNodeEditState, mouseEvent);
        return cNodeEditState;
    }

    public IMouseState createNodeEnterState(q q2, MouseEvent mouseEvent) {
        CNodeEnterState cNodeEnterState = new CNodeEnterState(this, this.m_graph, q2);
        this.m_factory.createNodeEnterAction().execute(cNodeEnterState, mouseEvent);
        return cNodeEnterState;
    }

    public IMouseState createNodeExitState(q q2, MouseEvent mouseEvent) {
        CNodeExitState cNodeExitState = new CNodeExitState(this, this.m_graph, q2);
        this.m_factory.createNodeExitAction().execute(cNodeExitState, mouseEvent);
        return cNodeExitState;
    }

    public IMouseState createNodeHoverState(q q2, MouseEvent mouseEvent) {
        CNodeHoverState cNodeHoverState = new CNodeHoverState(this, this.m_graph, q2);
        this.m_factory.createNodeHoverAction().execute(cNodeHoverState, mouseEvent);
        return cNodeHoverState;
    }

    public IMouseState createNodePressedLeftState(q q2, MouseEvent mouseEvent) {
        CNodePressedLeftState cNodePressedLeftState = new CNodePressedLeftState(this, this.m_graph, q2, mouseEvent);
        this.m_factory.createNodePressedLeftAction().execute(cNodePressedLeftState, mouseEvent);
        return cNodePressedLeftState;
    }

    public IMouseState createNodePressedMiddleState(q q2, MouseEvent mouseEvent) {
        CNodePressedMiddleState cNodePressedMiddleState = new CNodePressedMiddleState(this, this.m_graph, q2);
        this.m_factory.createNodePressedMiddleAction().execute(cNodePressedMiddleState, mouseEvent);
        return cNodePressedMiddleState;
    }

    public IMouseState createNodePressedRightState(q q2, MouseEvent mouseEvent) {
        CNodePressedRightState cNodePressedRightState = new CNodePressedRightState(this, this.m_graph, q2, mouseEvent);
        this.m_factory.createNodePressedRightAction().execute(cNodePressedRightState, mouseEvent);
        return cNodePressedRightState;
    }

    public List getListeners() {
        return this.m_listeners;
    }
}

