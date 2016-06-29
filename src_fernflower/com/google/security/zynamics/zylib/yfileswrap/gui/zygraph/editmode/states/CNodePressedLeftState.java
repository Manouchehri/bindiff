package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.c.q;

public class CNodePressedLeftState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final MouseEvent m_event;
   private final q m_node;

   public CNodePressedLeftState(CStateFactory var1, AbstractZyGraph var2, q var3, MouseEvent var4) {
      this.m_factory = var1;
      this.m_graph = var2;
      this.m_node = var3;
      this.m_event = var4;
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
      return this.m_graph.getNode(this.m_node) == null?new CStateChange(this.m_factory.createNodeExitState(this.m_node, var1), true):new CStateChange(this.m_factory.createNodeDraggedLeftState(this.m_node, var1, var3, var5), false);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createNodeClickedLeftState(this.m_node, var1), false);
   }
}
