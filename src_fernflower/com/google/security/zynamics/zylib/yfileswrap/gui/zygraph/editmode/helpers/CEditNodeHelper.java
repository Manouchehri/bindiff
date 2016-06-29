package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyRegenerateableNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;

public final class CEditNodeHelper {
   public static void removeCaret(AbstractZyGraph var0) {
      CDefaultLabelEventHandler var1 = var0.getEditMode().getLabelEventHandler();
      if(var1.isActive()) {
         var1.deactivateLabelContent();
      }

   }

   public static void select(AbstractZyGraph var0, q var1, MouseEvent var2) {
      double var3 = var0.getEditMode().translateX(var2.getX());
      double var5 = var0.getEditMode().translateY(var2.getY());
      IZyNodeRealizer var7 = (IZyNodeRealizer)var0.getGraph().t(var1);
      ZyLabelContent var8 = var7.getNodeContent();
      CDefaultLabelEventHandler var9 = var0.getEditMode().getLabelEventHandler();
      if(var8.isSelectable()) {
         double var10 = var0.getView().getZoom();
         double var12 = var7.getRealizer().getX();
         double var14 = var7.getRealizer().getY();
         var9.handleMouseDraggedEvent(var12, var14, var3, var5, var10);
      }

   }

   public static void setCaretEnd(AbstractZyGraph var0, q var1, MouseEvent var2) {
      double var3 = var0.getEditMode().translateX(var2.getX());
      double var5 = var0.getEditMode().translateY(var2.getY());
      IZyNodeRealizer var7 = (IZyNodeRealizer)var0.getGraph().t(var1);
      ZyLabelContent var8 = var7.getNodeContent();
      CDefaultLabelEventHandler var9 = var0.getEditMode().getLabelEventHandler();
      if(var8.isSelectable()) {
         double var10 = var0.getView().getZoom();
         double var12 = var7.getRealizer().getX();
         double var14 = var7.getRealizer().getY();
         var9.handleMouseReleasedEvent(var12, var14, var3, var5, var10, var2.getClickCount());
      }

   }

   public static void setCaretStart(AbstractZyGraph var0, q var1, MouseEvent var2) {
      double var3 = var0.getEditMode().translateX(var2.getX());
      double var5 = var0.getEditMode().translateY(var2.getY());
      IZyNodeRealizer var7 = (IZyNodeRealizer)var0.getGraph().t(var1);
      ZyLabelContent var8 = var7.getNodeContent();
      CDefaultLabelEventHandler var9 = var0.getEditMode().getLabelEventHandler();
      var0.getEditMode().getLabelEventHandler().activateLabelContent(var8, new ZyRegenerateableNodeRealizer(var7));
      if(var8.isSelectable()) {
         double var10 = var0.getView().getZoom();
         double var12 = var7.getRealizer().getX();
         double var14 = var7.getRealizer().getY();
         var9.handleMousePressedEvent(var12, var14, var3, var5, var10);
      }

   }
}
