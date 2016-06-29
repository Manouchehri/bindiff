package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.cW;

public class CNodeDraggedLeftState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final MouseEvent m_event;
   private final q m_node;
   private final double m_distX;
   private final double m_distY;

   public CNodeDraggedLeftState(CStateFactory var1, AbstractZyGraph var2, q var3, MouseEvent var4) {
      this(var1, var2, var3, var4, 0.0D, 0.0D);
   }

   public CNodeDraggedLeftState(CStateFactory var1, AbstractZyGraph var2, q var3, MouseEvent var4, double var5, double var7) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_node = (q)Preconditions.checkNotNull(var3, "Error: node argument can not be null");
      this.m_event = (MouseEvent)Preconditions.checkNotNull(var4, "Error: event argument can not be null");
      this.m_distX = var5;
      this.m_distY = var7;
   }

   public double getDistanceX() {
      return this.m_distX;
   }

   public double getDistanceY() {
      return this.m_distY;
   }

   public AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   public q getNode() {
      return this.m_node;
   }

   public CStateFactory getStateFactory() {
      return this.m_factory;
   }

   public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
      return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, var1, var3, var5), false);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
      return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, var1, var3, var5), false);
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX()) - this.m_graph.getEditMode().translateX(this.m_event.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY()) - this.m_graph.getEditMode().translateY(this.m_event.getY());
      return new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, var1, var3, var5), false);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY());
      cW var7 = this.m_graph.getGraph().b(var3, var5);
      if(var7.t()) {
         return CHitNodesTransformer.changeNode(this.m_factory, var1, var7, this.m_node);
      } else {
         this.m_factory.createNodeExitState(this.m_node, var1);
         return CHitNodesTransformer.exitNode(this.m_factory, var1, var7, this);
      }
   }
}
