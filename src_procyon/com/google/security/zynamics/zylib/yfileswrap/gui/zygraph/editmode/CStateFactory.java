package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.*;
import y.h.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;

public final class CStateFactory
{
    private final AbstractZyGraph m_graph;
    private final List m_listeners;
    private final IStateActionFactory m_factory;
    
    public CStateFactory(final AbstractZyGraph graph, final List listeners, final IStateActionFactory factory) {
        this.m_graph = graph;
        this.m_listeners = listeners;
        this.m_factory = factory;
    }
    
    public IMouseState createBackgroundClickedLeftState(final MouseEvent mouseEvent) {
        final CBackgroundClickedLeftState cBackgroundClickedLeftState = new CBackgroundClickedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundClickedLeftAction().execute(cBackgroundClickedLeftState, mouseEvent);
        return cBackgroundClickedLeftState;
    }
    
    public IMouseState createBackgroundClickedRightState(final MouseEvent mouseEvent) {
        final CBackgroundClickedRightState cBackgroundClickedRightState = new CBackgroundClickedRightState(this, this.m_graph);
        this.m_factory.createBackgroundClickedRightAction().execute(cBackgroundClickedRightState, mouseEvent);
        return cBackgroundClickedRightState;
    }
    
    public IMouseState createBackgroundDraggedLeftState(final MouseEvent mouseEvent) {
        final CBackgroundDraggedLeftState cBackgroundDraggedLeftState = new CBackgroundDraggedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundDraggedLeftAction().execute(cBackgroundDraggedLeftState, mouseEvent);
        return cBackgroundDraggedLeftState;
    }
    
    public IMouseState createBackgroundDraggedRightState(final MouseEvent mouseEvent) {
        final CBackgroundDraggedRightState cBackgroundDraggedRightState = new CBackgroundDraggedRightState(this, this.m_graph);
        this.m_factory.createBackgroundDraggedRightAction().execute(cBackgroundDraggedRightState, mouseEvent);
        return cBackgroundDraggedRightState;
    }
    
    public IMouseState createBackgroundPressedLeftState(final MouseEvent mouseEvent) {
        final CBackgroundPressedLeftState cBackgroundPressedLeftState = new CBackgroundPressedLeftState(this, this.m_graph);
        this.m_factory.createBackgroundPressedLeftAction().execute(cBackgroundPressedLeftState, mouseEvent);
        return cBackgroundPressedLeftState;
    }
    
    public IMouseState createBackgroundPressedRightState(final MouseEvent mouseEvent) {
        final CBackgroundPressedRightState cBackgroundPressedRightState = new CBackgroundPressedRightState(this, this.m_graph);
        this.m_factory.createBackgroundPressedRightAction().execute(cBackgroundPressedRightState, mouseEvent);
        return cBackgroundPressedRightState;
    }
    
    public IMouseState createBendClickedLeftState(final x x, final MouseEvent mouseEvent) {
        final CBendClickedLeftState cBendClickedLeftState = new CBendClickedLeftState(this, this.m_graph, x);
        this.m_factory.createBendClickedLeftAction().execute(cBendClickedLeftState, mouseEvent);
        return cBendClickedLeftState;
    }
    
    public IMouseState createBendEnterState(final x x, final MouseEvent mouseEvent) {
        final CBendEnterState cBendEnterState = new CBendEnterState(this, this.m_graph, x);
        this.m_factory.createBendEnterAction().execute(cBendEnterState, mouseEvent);
        return cBendEnterState;
    }
    
    public IMouseState createBendExitState(final x x, final MouseEvent mouseEvent) {
        final CBendExitState cBendExitState = new CBendExitState(this, this.m_graph, x);
        this.m_factory.createBendExitAction().execute(cBendExitState, mouseEvent);
        return cBendExitState;
    }
    
    public IMouseState createBendHoverState(final x x, final MouseEvent mouseEvent) {
        final CBendHoverState cBendHoverState = new CBendHoverState(this, this.m_graph, x);
        this.m_factory.createBendHoverAction().execute(cBendHoverState, mouseEvent);
        return cBendHoverState;
    }
    
    public IMouseState createBendPressedLeftState(final x x, final MouseEvent mouseEvent) {
        final CBendPressedLeftState cBendPressedLeftState = new CBendPressedLeftState(this, this.m_graph, x);
        this.m_factory.createBendPressedLeftAction().execute(cBendPressedLeftState, mouseEvent);
        return cBendPressedLeftState;
    }
    
    public IMouseState createDefaultState() {
        return new CDefaultState(this);
    }
    
    public IMouseState createEdgeClickedLeftState(final d d, final MouseEvent mouseEvent) {
        final CEdgeClickedLeftState cEdgeClickedLeftState = new CEdgeClickedLeftState(this, this.m_graph, d);
        this.m_factory.createEdgeClickedLeftAction().execute(cEdgeClickedLeftState, mouseEvent);
        return cEdgeClickedLeftState;
    }
    
    public IMouseState createEdgeClickedRightState(final d d, final MouseEvent mouseEvent) {
        final CEdgeClickedRightState cEdgeClickedRightState = new CEdgeClickedRightState(this, this.m_graph, d);
        this.m_factory.createEdgeClickedRightAction().execute(cEdgeClickedRightState, mouseEvent);
        return cEdgeClickedRightState;
    }
    
    public IMouseState createEdgeEnterState(final d d, final MouseEvent mouseEvent) {
        final CEdgeEnterState cEdgeEnterState = new CEdgeEnterState(this, this.m_graph, d);
        this.m_factory.createEdgeEnterAction().execute(cEdgeEnterState, mouseEvent);
        return cEdgeEnterState;
    }
    
    public IMouseState createEdgeExitState(final d d, final MouseEvent mouseEvent) {
        final CEdgeExitState cEdgeExitState = new CEdgeExitState(this, this.m_graph, d);
        this.m_factory.createEdgeExitAction().execute(cEdgeExitState, mouseEvent);
        return cEdgeExitState;
    }
    
    public IMouseState createEdgeHoverState(final d d, final MouseEvent mouseEvent) {
        final CEdgeHoverState cEdgeHoverState = new CEdgeHoverState(this, this.m_graph, d);
        this.m_factory.createEdgeHoverAction().execute(cEdgeHoverState, mouseEvent);
        return cEdgeHoverState;
    }
    
    public IMouseState createEdgeLabelEnterState(final aA aa, final MouseEvent mouseEvent) {
        final CEdgeLabelEnterState cEdgeLabelEnterState = new CEdgeLabelEnterState(this, this.m_graph, aa);
        this.m_factory.createEdgeLabelEnterAction().execute(cEdgeLabelEnterState, mouseEvent);
        return cEdgeLabelEnterState;
    }
    
    public IMouseState createEdgeLabelExitState(final aA aa, final MouseEvent mouseEvent) {
        final CEdgeLabelExitState cEdgeLabelExitState = new CEdgeLabelExitState(this, this.m_graph, aa);
        this.m_factory.createEdgeLabelExitAction().execute(cEdgeLabelExitState, mouseEvent);
        return cEdgeLabelExitState;
    }
    
    public IMouseState createEdgeLabelHoverState(final aA aa, final MouseEvent mouseEvent) {
        final CEdgeLabelHoverState cEdgeLabelHoverState = new CEdgeLabelHoverState(this, this.m_graph, aa);
        this.m_factory.createEdgeLabelHoverAction().execute(cEdgeLabelHoverState, mouseEvent);
        return cEdgeLabelHoverState;
    }
    
    public IMouseState createEdgePressedLeftState(final d d, final MouseEvent mouseEvent) {
        final CEdgePressedLeftState cEdgePressedLeftState = new CEdgePressedLeftState(this, this.m_graph, d);
        this.m_factory.createEdgePressedLeftAction().execute(cEdgePressedLeftState, mouseEvent);
        return cEdgePressedLeftState;
    }
    
    public IMouseState createEdgePressedRightState(final d d, final MouseEvent mouseEvent) {
        final CEdgePressedRightState cEdgePressedRightState = new CEdgePressedRightState(this, this.m_graph, d, mouseEvent);
        this.m_factory.createEdgePressedRightAction().execute(cEdgePressedRightState, mouseEvent);
        return cEdgePressedRightState;
    }
    
    public IMouseState createNodeClickedLeftState(final q q, final MouseEvent mouseEvent) {
        final CNodeClickedLeftState cNodeClickedLeftState = new CNodeClickedLeftState(this, this.m_graph, q);
        this.m_factory.createNodeClickedLeftAction().execute(cNodeClickedLeftState, mouseEvent);
        return cNodeClickedLeftState;
    }
    
    public IMouseState createNodeClickedMiddleState(final q q, final MouseEvent mouseEvent) {
        final CNodeClickedMiddleState cNodeClickedMiddleState = new CNodeClickedMiddleState(this, this.m_graph, q);
        this.m_factory.createNodeClickedMiddleAction().execute(cNodeClickedMiddleState, mouseEvent);
        return cNodeClickedMiddleState;
    }
    
    public IMouseState createNodeClickedRightState(final q q, final MouseEvent mouseEvent) {
        final CNodeClickedRightState cNodeClickedRightState = new CNodeClickedRightState(this, this.m_graph, q);
        this.m_factory.createNodeClickedRightAction().execute(cNodeClickedRightState, mouseEvent);
        return cNodeClickedRightState;
    }
    
    public IMouseState createNodeDraggedLeftState(final q q, final MouseEvent mouseEvent, final double n, final double n2) {
        final CNodeDraggedLeftState cNodeDraggedLeftState = new CNodeDraggedLeftState(this, this.m_graph, q, mouseEvent, n, n2);
        this.m_factory.createNodeDraggedLeftAction().execute(cNodeDraggedLeftState, mouseEvent);
        return cNodeDraggedLeftState;
    }
    
    public IMouseState createNodeEditEnterState(final q q, final MouseEvent mouseEvent) {
        final CNodeEditEnterState cNodeEditEnterState = new CNodeEditEnterState(this, this.m_graph, q);
        this.m_factory.createNodeEditEnterAction().execute(cNodeEditEnterState, mouseEvent);
        return cNodeEditEnterState;
    }
    
    public IMouseState createNodeEditExitState(final q q, final MouseEvent mouseEvent) {
        final CNodeEditExitState cNodeEditExitState = new CNodeEditExitState(this, this.m_graph, q);
        this.m_factory.createNodeEditExitAction().execute(cNodeEditExitState, mouseEvent);
        return cNodeEditExitState;
    }
    
    public IMouseState createNodeEditState(final q q, final MouseEvent mouseEvent) {
        final CNodeEditState cNodeEditState = new CNodeEditState(this, this.m_graph, q);
        this.m_factory.createNodeEditAction().execute(cNodeEditState, mouseEvent);
        return cNodeEditState;
    }
    
    public IMouseState createNodeEnterState(final q q, final MouseEvent mouseEvent) {
        final CNodeEnterState cNodeEnterState = new CNodeEnterState(this, this.m_graph, q);
        this.m_factory.createNodeEnterAction().execute(cNodeEnterState, mouseEvent);
        return cNodeEnterState;
    }
    
    public IMouseState createNodeExitState(final q q, final MouseEvent mouseEvent) {
        final CNodeExitState cNodeExitState = new CNodeExitState(this, this.m_graph, q);
        this.m_factory.createNodeExitAction().execute(cNodeExitState, mouseEvent);
        return cNodeExitState;
    }
    
    public IMouseState createNodeHoverState(final q q, final MouseEvent mouseEvent) {
        final CNodeHoverState cNodeHoverState = new CNodeHoverState(this, this.m_graph, q);
        this.m_factory.createNodeHoverAction().execute(cNodeHoverState, mouseEvent);
        return cNodeHoverState;
    }
    
    public IMouseState createNodePressedLeftState(final q q, final MouseEvent mouseEvent) {
        final CNodePressedLeftState cNodePressedLeftState = new CNodePressedLeftState(this, this.m_graph, q, mouseEvent);
        this.m_factory.createNodePressedLeftAction().execute(cNodePressedLeftState, mouseEvent);
        return cNodePressedLeftState;
    }
    
    public IMouseState createNodePressedMiddleState(final q q, final MouseEvent mouseEvent) {
        final CNodePressedMiddleState cNodePressedMiddleState = new CNodePressedMiddleState(this, this.m_graph, q);
        this.m_factory.createNodePressedMiddleAction().execute(cNodePressedMiddleState, mouseEvent);
        return cNodePressedMiddleState;
    }
    
    public IMouseState createNodePressedRightState(final q q, final MouseEvent mouseEvent) {
        final CNodePressedRightState cNodePressedRightState = new CNodePressedRightState(this, this.m_graph, q, mouseEvent);
        this.m_factory.createNodePressedRightAction().execute(cNodePressedRightState, mouseEvent);
        return cNodePressedRightState;
    }
    
    public List getListeners() {
        return this.m_listeners;
    }
}
