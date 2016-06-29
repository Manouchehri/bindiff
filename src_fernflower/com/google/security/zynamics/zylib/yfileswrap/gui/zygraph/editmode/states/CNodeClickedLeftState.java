package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CMousePressedHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.cW;

public class CNodeClickedLeftState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final q m_node;

   public CNodeClickedLeftState(CStateFactory var1, AbstractZyGraph var2, q var3) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_node = (q)Preconditions.checkNotNull(var3, "Error: node argument can not be null");
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
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = var2.getEditMode().translateX(var1.getX());
      double var5 = var2.getEditMode().translateY(var1.getY());
      cW var7 = var2.getGraph().b(var3, var5);
      if(var7.t()) {
         return CHitNodesTransformer.changeNode(this.m_factory, var1, var7, this.m_node);
      } else {
         this.m_factory.createNodeExitState(this.m_node, var1);
         return CHitNodesTransformer.exitNode(this.m_factory, var1, var7, this);
      }
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return CMousePressedHandler.handleMousePressed(this.m_factory, this, var2, var1);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }
}
