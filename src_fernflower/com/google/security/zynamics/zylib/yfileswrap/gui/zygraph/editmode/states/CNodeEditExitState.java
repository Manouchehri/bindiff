package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.c.q;

public final class CNodeEditExitState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final q m_node;

   public CNodeEditExitState(CStateFactory var1, AbstractZyGraph var2, q var3) {
      this.m_factory = var1;
      this.m_graph = var2;
      this.m_node = var3;
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
      throw new IllegalStateException("Not yet implemented");
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      throw new IllegalStateException("Not yet implemented");
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      throw new IllegalStateException("Not yet implemented");
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      throw new IllegalStateException("Not yet implemented");
   }
}
