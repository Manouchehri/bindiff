package com.google.security.zynamics.zylib.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBackgroundTransformer;
import java.awt.event.MouseEvent;

public class CBackgroundClickedLeftState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;

   public CBackgroundClickedLeftState(CStateFactory var1, AbstractZyGraph var2) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
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
      return CHitBackgroundTransformer.exitBackground(this.m_factory, var1, var2, this);
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }
}
