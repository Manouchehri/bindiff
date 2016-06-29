package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import y.c.q;
import y.h.cW;

public final class CNodeEditState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final q m_node;
   private boolean m_isDragging = false;

   public CNodeEditState(CStateFactory var1, AbstractZyGraph var2, q var3) {
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
      this.m_isDragging = true;
      CEditNodeHelper.select(var2, this.m_node, var1);
      return new CStateChange(this, false);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this, true);
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = var2.getEditMode().translateX(var1.getX());
      double var5 = var2.getEditMode().translateY(var1.getY());
      cW var7 = var2.getGraph().b(var3, var5);
      if(!var7.t()) {
         if(var7.s()) {
            throw new IllegalStateException();
         } else if(var7.u()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(var7.k(), var1), true);
         } else if(var7.r()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(var7.m().getEdge(), var1), true);
         } else if(var7.v()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createBendPressedLeftState(var7.j(), var1), true);
         } else if(var7.q()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createDefaultState(), true);
         } else {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createBackgroundPressedLeftState(var1), true);
         }
      } else {
         q var8 = var7.i();
         if(SwingUtilities.isLeftMouseButton(var1) && !var1.isAltDown()) {
            if(var8 == this.m_node) {
               if(!this.m_isDragging) {
                  CEditNodeHelper.setCaretStart(var2, var8, var1);
               } else {
                  this.m_isDragging = false;
               }

               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedLeftState(var8, var1), true);
            }
         } else if(SwingUtilities.isRightMouseButton(var1)) {
            if(var8 == this.m_node) {
               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedRightState(var8, var1), true);
            }
         } else if(SwingUtilities.isMiddleMouseButton(var1) || var1.isAltDown() && SwingUtilities.isLeftMouseButton(var1)) {
            if(var8 == this.m_node) {
               if(!this.m_isDragging) {
                  CEditNodeHelper.setCaretStart(var2, var8, var1);
               } else {
                  this.m_isDragging = false;
               }

               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedMiddleState(var8, var1), true);
            }
         } else {
            return new CStateChange(this, false);
         }
      }
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = var2.getEditMode().translateX(var1.getX());
      double var5 = var2.getEditMode().translateY(var1.getY());
      cW var7 = var2.getGraph().b(var3, var5);
      if(!var7.t()) {
         if(var7.s()) {
            throw new IllegalStateException();
         } else if(var7.u()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(var7.k(), var1), true);
         } else if(var7.r()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createEdgePressedLeftState(var7.m().getEdge(), var1), true);
         } else if(var7.v()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createBendPressedLeftState(var7.j(), var1), true);
         } else if(var7.q()) {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createDefaultState(), true);
         } else {
            this.m_factory.createNodeEditExitState(this.m_node, var1);
            return new CStateChange(this.m_factory.createBackgroundPressedLeftState(var1), true);
         }
      } else {
         q var8 = var7.i();
         if(SwingUtilities.isLeftMouseButton(var1) && !var1.isAltDown()) {
            if(var8 == this.m_node) {
               if(!this.m_isDragging) {
                  CEditNodeHelper.setCaretEnd(var2, var8, var1);
               } else {
                  this.m_isDragging = false;
               }

               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedLeftState(var8, var1), true);
            }
         } else if(SwingUtilities.isRightMouseButton(var1)) {
            if(var8 == this.m_node) {
               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedRightState(var8, var1), true);
            }
         } else if(SwingUtilities.isMiddleMouseButton(var1) || var1.isAltDown() && SwingUtilities.isLeftMouseButton(var1)) {
            if(var8 == this.m_node) {
               if(!this.m_isDragging) {
                  CEditNodeHelper.setCaretEnd(var2, var8, var1);
               } else {
                  this.m_isDragging = false;
               }

               return new CStateChange(this, false);
            } else {
               this.m_factory.createNodeEditExitState(this.m_node, var1);
               return new CStateChange(this.m_factory.createNodePressedMiddleState(var8, var1), true);
            }
         } else {
            return new CStateChange(this, false);
         }
      }
   }
}
