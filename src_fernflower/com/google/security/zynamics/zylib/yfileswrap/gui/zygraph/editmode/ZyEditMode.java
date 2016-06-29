package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CDefaultActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CSelectionMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.c.q;
import y.h.aC;
import y.h.ds;

public class ZyEditMode extends aC {
   private final IStateActionFactory m_actionFactory;
   private final CStateFactory m_stateFactory;
   private IMouseState m_state;
   private final AbstractZyGraph m_graph;
   private final ds m_magifierViewMode = new ds();
   private final List m_listeners = new ArrayList();
   private final CDefaultLabelEventHandler m_labelKeyHandler;
   private boolean m_inMouseMoved;
   private boolean m_inMouseDragged;
   private boolean m_inMousePressed;
   private boolean m_inMouseDraggedRight;

   public ZyEditMode(AbstractZyGraph var1) {
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var1, "Graph argument cannot be null");
      this.m_labelKeyHandler = this.createNodeKeyHandler(var1);
      this.m_actionFactory = this.createStateActionFactory();
      this.m_stateFactory = new CStateFactory(var1, this.m_listeners, this.m_actionFactory);
      this.m_state = this.m_stateFactory.createDefaultState();
      this.setDefaultBehaviour();
   }

   private boolean getMagnifyingMode() {
      Iterator var1 = this.m_graph.getView().getViewModes();

      do {
         if(!var1.hasNext()) {
            return false;
         }
      } while(var1.next() != this.m_magifierViewMode);

      return true;
   }

   private void setDefaultBehaviour() {
      this.allowBendCreation(false);
      this.allowEdgeCreation(false);
      this.allowNodeCreation(false);
      this.allowMoveLabels(true);
      this.allowMovePorts(true);
      this.allowNodeEditing(true);
      this.allowMoving(true);
      this.allowMoveSelection(true);
      this.showEdgeTips(true);
      this.showNodeTips(true);
      this.setSelectionBoxMode(new CSelectionMode(this.m_graph));
      this.m_graph.getView().getCanvasComponent().addMouseWheelListener(new ZyEditModeMouseWheelListener(this.m_graph));
   }

   protected CDefaultLabelEventHandler createNodeKeyHandler(AbstractZyGraph var1) {
      return new CDefaultLabelEventHandler(var1);
   }

   protected IStateActionFactory createStateActionFactory() {
      return new CDefaultActionFactory();
   }

   protected String getEdgeTip(d var1) {
      return CTooltipUpdater.updateEdgeTooltip(this.m_graph, var1);
   }

   protected AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   protected String getNodeTip(q var1) {
      return CTooltipUpdater.updateNodeTooltip(this.m_graph, var1);
   }

   public void addListener(IZyEditModeListener var1) {
      this.m_listeners.add(var1);
   }

   public CDefaultLabelEventHandler getLabelEventHandler() {
      return this.m_labelKeyHandler;
   }

   public boolean isInMouseDragged() {
      return this.m_inMouseDragged;
   }

   public boolean isInMouseDraggedRight() {
      return this.m_inMouseDraggedRight;
   }

   public boolean isInMouseMoved() {
      return this.m_inMouseMoved;
   }

   public boolean isInMousePressed() {
      return this.m_inMousePressed;
   }

   public void mouseDragged(MouseEvent var1) {
      Preconditions.checkNotNull(var1, "Error: mouse event can not be null");
      IMouseStateChange var2 = this.m_state.mouseDragged(var1, this.m_graph);
      this.m_state = var2.getNextState();
      if(var2.notifyYFiles()) {
         this.m_inMouseDragged = true;

         try {
            super.mouseDragged(var1);
         } finally {
            this.m_inMouseDragged = false;
         }
      }

   }

   public void mouseDraggedRight(double var1, double var3) {
      this.m_inMouseDraggedRight = true;

      try {
         super.mouseDraggedLeft(var1, var3);
      } finally {
         this.m_inMouseDraggedRight = false;
      }

   }

   public void mouseMoved(double var1, double var3) {
      this.m_inMouseMoved = true;

      try {
         super.mouseMoved(var1, var3);
      } finally {
         this.m_inMouseMoved = false;
      }

   }

   public void mouseMoved(MouseEvent var1) {
      Preconditions.checkNotNull(var1, "Error: mouse event can not be null");
      IMouseStateChange var2 = this.m_state.mouseMoved(var1, this.m_graph);
      this.m_state = var2.getNextState();
      if(var2.notifyYFiles()) {
         this.m_inMouseMoved = true;

         try {
            super.mouseMoved(var1);
         } finally {
            this.m_inMouseMoved = false;
         }
      }

   }

   public void mousePressed(MouseEvent var1) {
      IMouseStateChange var2 = this.m_state.mousePressed(var1, this.m_graph);
      this.m_state = var2.getNextState();
      if(var2.notifyYFiles()) {
         this.m_inMousePressed = true;

         try {
            super.mousePressed(var1);
         } finally {
            this.m_inMousePressed = false;
         }
      }

   }

   public void mouseReleased(double var1, double var3) {
      super.mouseReleased(var1, var3);
   }

   public void mouseReleased(MouseEvent var1) {
      IMouseStateChange var2 = this.m_state.mouseReleased(var1, this.m_graph);
      this.m_state = var2.getNextState();
      if(var2.notifyYFiles()) {
         super.mouseReleased(var1);
      }

   }

   public void setMagnifyingMode(boolean var1) {
      if(this.getMagnifyingMode() != var1) {
         if(var1) {
            this.m_graph.getView().addViewMode(this.m_magifierViewMode);
         } else {
            this.m_graph.getView().removeViewMode(this.m_magifierViewMode);
         }

      }
   }

   public double translateX(int var1) {
      return super.translateX(var1);
   }

   public double translateY(int var1) {
      return super.translateY(var1);
   }
}
