package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.h.aA;
import y.h.cW;

public class CEdgeLabelHoverState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final aA m_label;

   public CEdgeLabelHoverState(CStateFactory var1, AbstractZyGraph var2, aA var3) {
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_label = (aA)Preconditions.checkNotNull(var3, "Error: label argument can not be null");
   }

   public CStateFactory getStateFactory() {
      return this.m_factory;
   }

   public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY());
      cW var7 = this.m_graph.getGraph().b(var3, var5);
      if(var7.t()) {
         this.m_factory.createEdgeLabelExitState(this.m_label, var1);
         return CHitNodesTransformer.enterNode(this.m_factory, var1, var7);
      } else if(var7.s()) {
         throw new IllegalStateException();
      } else if(var7.u()) {
         this.m_factory.createEdgeLabelExitState(this.m_label, var1);
         return CHitEdgesTransformer.enterEdge(this.m_factory, var1, var7);
      } else if(var7.r()) {
         return CHitEdgeLabelsTransformer.changeEdgeLabel(this.m_factory, var1, var7, this.m_label);
      } else if(var7.v()) {
         this.m_factory.createEdgeLabelExitState(this.m_label, var1);
         return CHitBendsTransformer.enterBend(this.m_factory, var1, var7);
      } else if(var7.q()) {
         return new CStateChange(this, true);
      } else {
         this.m_factory.createEdgeLabelExitState(this.m_label, var1);
         return new CStateChange(this.m_factory.createDefaultState(), true);
      }
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY());
      cW var7 = this.m_graph.getGraph().b(var3, var5);
      if(var7.t()) {
         throw new IllegalStateException();
      } else if(var7.s()) {
         throw new IllegalStateException();
      } else if(var7.u()) {
         throw new IllegalStateException();
      } else if(var7.r()) {
         aA var8 = var7.m();
         if(var8 == this.m_label) {
            return new CStateChange(this, true);
         } else {
            throw new IllegalStateException();
         }
      } else if(var7.v()) {
         throw new IllegalStateException();
      } else if(var7.q()) {
         return new CStateChange(this, true);
      } else {
         this.m_factory.createEdgeLabelExitState(this.m_label, var1);
         return new CStateChange(this, true);
      }
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }
}
