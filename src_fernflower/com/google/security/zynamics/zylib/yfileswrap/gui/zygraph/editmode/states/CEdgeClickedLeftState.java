package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.cW;

public class CEdgeClickedLeftState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final d m_edge;

   public CEdgeClickedLeftState(CStateFactory var1, AbstractZyGraph var2, d var3) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_edge = (d)Preconditions.checkNotNull(var3, "Error: edge argument can not be null");
   }

   public ZyGraphEdge getEdge() {
      return this.m_graph.getEdge(this.m_edge);
   }

   public AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   public CStateFactory getStateFactory() {
      return this.m_factory;
   }

   public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = var2.getEditMode().translateX(var1.getX());
      double var5 = var2.getEditMode().translateY(var1.getY());
      cW var7 = var2.getGraph().b(var3, var5);
      if(var7.u()) {
         return CHitEdgesTransformer.changeEdge(this.m_factory, var1, var7, this.m_edge);
      } else {
         this.m_factory.createEdgeExitState(this.m_edge, var1);
         return CHitEdgesTransformer.exitEdge(this.m_factory, var1, var7, this);
      }
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }
}
