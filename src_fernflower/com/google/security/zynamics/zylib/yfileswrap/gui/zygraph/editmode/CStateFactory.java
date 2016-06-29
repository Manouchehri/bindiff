package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
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

   public CStateFactory(AbstractZyGraph var1, List var2, IStateActionFactory var3) {
      this.m_graph = var1;
      this.m_listeners = var2;
      this.m_factory = var3;
   }

   public IMouseState createBackgroundClickedLeftState(MouseEvent var1) {
      CBackgroundClickedLeftState var2 = new CBackgroundClickedLeftState(this, this.m_graph);
      this.m_factory.createBackgroundClickedLeftAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBackgroundClickedRightState(MouseEvent var1) {
      CBackgroundClickedRightState var2 = new CBackgroundClickedRightState(this, this.m_graph);
      this.m_factory.createBackgroundClickedRightAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBackgroundDraggedLeftState(MouseEvent var1) {
      CBackgroundDraggedLeftState var2 = new CBackgroundDraggedLeftState(this, this.m_graph);
      this.m_factory.createBackgroundDraggedLeftAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBackgroundDraggedRightState(MouseEvent var1) {
      CBackgroundDraggedRightState var2 = new CBackgroundDraggedRightState(this, this.m_graph);
      this.m_factory.createBackgroundDraggedRightAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBackgroundPressedLeftState(MouseEvent var1) {
      CBackgroundPressedLeftState var2 = new CBackgroundPressedLeftState(this, this.m_graph);
      this.m_factory.createBackgroundPressedLeftAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBackgroundPressedRightState(MouseEvent var1) {
      CBackgroundPressedRightState var2 = new CBackgroundPressedRightState(this, this.m_graph);
      this.m_factory.createBackgroundPressedRightAction().execute(var2, var1);
      return var2;
   }

   public IMouseState createBendClickedLeftState(x var1, MouseEvent var2) {
      CBendClickedLeftState var3 = new CBendClickedLeftState(this, this.m_graph, var1);
      this.m_factory.createBendClickedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createBendEnterState(x var1, MouseEvent var2) {
      CBendEnterState var3 = new CBendEnterState(this, this.m_graph, var1);
      this.m_factory.createBendEnterAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createBendExitState(x var1, MouseEvent var2) {
      CBendExitState var3 = new CBendExitState(this, this.m_graph, var1);
      this.m_factory.createBendExitAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createBendHoverState(x var1, MouseEvent var2) {
      CBendHoverState var3 = new CBendHoverState(this, this.m_graph, var1);
      this.m_factory.createBendHoverAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createBendPressedLeftState(x var1, MouseEvent var2) {
      CBendPressedLeftState var3 = new CBendPressedLeftState(this, this.m_graph, var1);
      this.m_factory.createBendPressedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createDefaultState() {
      return new CDefaultState(this);
   }

   public IMouseState createEdgeClickedLeftState(d var1, MouseEvent var2) {
      CEdgeClickedLeftState var3 = new CEdgeClickedLeftState(this, this.m_graph, var1);
      this.m_factory.createEdgeClickedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeClickedRightState(d var1, MouseEvent var2) {
      CEdgeClickedRightState var3 = new CEdgeClickedRightState(this, this.m_graph, var1);
      this.m_factory.createEdgeClickedRightAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeEnterState(d var1, MouseEvent var2) {
      CEdgeEnterState var3 = new CEdgeEnterState(this, this.m_graph, var1);
      this.m_factory.createEdgeEnterAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeExitState(d var1, MouseEvent var2) {
      CEdgeExitState var3 = new CEdgeExitState(this, this.m_graph, var1);
      this.m_factory.createEdgeExitAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeHoverState(d var1, MouseEvent var2) {
      CEdgeHoverState var3 = new CEdgeHoverState(this, this.m_graph, var1);
      this.m_factory.createEdgeHoverAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeLabelEnterState(aA var1, MouseEvent var2) {
      CEdgeLabelEnterState var3 = new CEdgeLabelEnterState(this, this.m_graph, var1);
      this.m_factory.createEdgeLabelEnterAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeLabelExitState(aA var1, MouseEvent var2) {
      CEdgeLabelExitState var3 = new CEdgeLabelExitState(this, this.m_graph, var1);
      this.m_factory.createEdgeLabelExitAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgeLabelHoverState(aA var1, MouseEvent var2) {
      CEdgeLabelHoverState var3 = new CEdgeLabelHoverState(this, this.m_graph, var1);
      this.m_factory.createEdgeLabelHoverAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgePressedLeftState(d var1, MouseEvent var2) {
      CEdgePressedLeftState var3 = new CEdgePressedLeftState(this, this.m_graph, var1);
      this.m_factory.createEdgePressedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createEdgePressedRightState(d var1, MouseEvent var2) {
      CEdgePressedRightState var3 = new CEdgePressedRightState(this, this.m_graph, var1, var2);
      this.m_factory.createEdgePressedRightAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeClickedLeftState(q var1, MouseEvent var2) {
      CNodeClickedLeftState var3 = new CNodeClickedLeftState(this, this.m_graph, var1);
      this.m_factory.createNodeClickedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeClickedMiddleState(q var1, MouseEvent var2) {
      CNodeClickedMiddleState var3 = new CNodeClickedMiddleState(this, this.m_graph, var1);
      this.m_factory.createNodeClickedMiddleAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeClickedRightState(q var1, MouseEvent var2) {
      CNodeClickedRightState var3 = new CNodeClickedRightState(this, this.m_graph, var1);
      this.m_factory.createNodeClickedRightAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeDraggedLeftState(q var1, MouseEvent var2, double var3, double var5) {
      CNodeDraggedLeftState var7 = new CNodeDraggedLeftState(this, this.m_graph, var1, var2, var3, var5);
      this.m_factory.createNodeDraggedLeftAction().execute(var7, var2);
      return var7;
   }

   public IMouseState createNodeEditEnterState(q var1, MouseEvent var2) {
      CNodeEditEnterState var3 = new CNodeEditEnterState(this, this.m_graph, var1);
      this.m_factory.createNodeEditEnterAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeEditExitState(q var1, MouseEvent var2) {
      CNodeEditExitState var3 = new CNodeEditExitState(this, this.m_graph, var1);
      this.m_factory.createNodeEditExitAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeEditState(q var1, MouseEvent var2) {
      CNodeEditState var3 = new CNodeEditState(this, this.m_graph, var1);
      this.m_factory.createNodeEditAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeEnterState(q var1, MouseEvent var2) {
      CNodeEnterState var3 = new CNodeEnterState(this, this.m_graph, var1);
      this.m_factory.createNodeEnterAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeExitState(q var1, MouseEvent var2) {
      CNodeExitState var3 = new CNodeExitState(this, this.m_graph, var1);
      this.m_factory.createNodeExitAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodeHoverState(q var1, MouseEvent var2) {
      CNodeHoverState var3 = new CNodeHoverState(this, this.m_graph, var1);
      this.m_factory.createNodeHoverAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodePressedLeftState(q var1, MouseEvent var2) {
      CNodePressedLeftState var3 = new CNodePressedLeftState(this, this.m_graph, var1, var2);
      this.m_factory.createNodePressedLeftAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodePressedMiddleState(q var1, MouseEvent var2) {
      CNodePressedMiddleState var3 = new CNodePressedMiddleState(this, this.m_graph, var1);
      this.m_factory.createNodePressedMiddleAction().execute(var3, var2);
      return var3;
   }

   public IMouseState createNodePressedRightState(q var1, MouseEvent var2) {
      CNodePressedRightState var3 = new CNodePressedRightState(this, this.m_graph, var1, var2);
      this.m_factory.createNodePressedRightAction().execute(var3, var2);
      return var3;
   }

   public List getListeners() {
      return this.m_listeners;
   }
}
