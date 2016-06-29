package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CMousePressedHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.h.cW;

public final class CDefaultState implements IMouseState {
   private final CStateFactory m_factory;

   public CDefaultState(CStateFactory var1) {
      this.m_factory = var1;
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
      return (IMouseStateChange)(var7.t()?CHitNodesTransformer.enterNode(this.m_factory, var1, var7):(var7.u()?CHitEdgesTransformer.enterEdge(this.m_factory, var1, var7):(var7.r()?CHitEdgeLabelsTransformer.enterEdgeLabel(this.m_factory, var1, var7):(var7.v()?CHitBendsTransformer.enterBend(this.m_factory, var1, var7):(var7.q()?new CStateChange(this, true):new CStateChange(this, true))))));
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return CMousePressedHandler.handleMousePressed(this.m_factory, this, var2, var1);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }
}
