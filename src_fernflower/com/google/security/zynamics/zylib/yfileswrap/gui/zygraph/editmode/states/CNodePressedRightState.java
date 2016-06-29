package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeMover;
import java.awt.event.MouseEvent;
import y.c.q;

public class CNodePressedRightState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final MouseEvent m_event;
   private final q m_node;

   public CNodePressedRightState(CStateFactory var1, AbstractZyGraph var2, q var3, MouseEvent var4) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_node = (q)Preconditions.checkNotNull(var3, "Error: node argument can not be null");
      this.m_event = (MouseEvent)Preconditions.checkNotNull(var4, "Error: event argument can not be null");
   }

   public AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   public CStateFactory getStateFactory() {
      return this.m_factory;
   }

   public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2) {
      int var3 = this.m_event.getX();
      int var4 = this.m_event.getY();
      int var5 = var1.getX();
      int var6 = var1.getY();
      return CNodeMover.isDraggedFar((double)var3, (double)var4, (double)var5, (double)var6)?new CStateChange(this.m_factory.createBackgroundDraggedRightState(var1), true):new CStateChange(this, true);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createNodeClickedRightState(this.m_node, var1), true);
   }
}
