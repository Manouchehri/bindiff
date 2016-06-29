package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SingleViewFocusListener extends MouseAdapter {
   private final SingleGraph graph;
   private final ViewTabPanelFunctions controller;

   protected SingleViewFocusListener(ViewTabPanelFunctions var1, SingleGraph var2) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = (SingleGraph)Preconditions.checkNotNull(var2);
      this.addListener();
   }

   public void addListener() {
      this.graph.getView().getCanvasComponent().addMouseListener(this);
   }

   public void mouseReleased(MouseEvent var1) {
      this.controller.setViewFocus(this.graph.getSide());
   }

   public void removeListener() {
      this.graph.getView().getCanvasComponent().removeMouseListener(this);
   }
}
