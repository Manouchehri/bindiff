package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyRegenerateableNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public final class EditCombinedNodeHelper {
   private static boolean isRightSideLabel(CombinedGraph var0, q var1, double var2) {
      CombinedDiffNode var4 = (CombinedDiffNode)var0.getNode(var1);
      if(var4.getPrimaryDiffNode() != null && var4.getSecondaryDiffNode() != null) {
         IZyNodeRealizer var5 = (IZyNodeRealizer)var0.getGraph().t(var1);
         double var6 = var5.getCenterX();
         return var2 >= var6;
      } else {
         return false;
      }
   }

   public static ZyLabelContent getLabelContent(CombinedGraph var0, q var1, MouseEvent var2) {
      int var3 = var2.getX();
      CombinedDiffNode var4 = (CombinedDiffNode)var0.getNode(var1);
      if(var4.getPrimaryDiffNode() != null && var4.getSecondaryDiffNode() != null) {
         bu var5 = var0.getGraph();
         ch var6 = var0.getView();
         double var7 = var6.toWorldCoordX(var3);
         fj var9 = var5.t(var1);
         double var10 = var9.getX();
         double var12 = var9.getWidth();
         return var7 > var10 && var7 < var10 + var12 / 2.0D?var4.getPrimaryDiffNode().getRealizer().getNodeContent():var4.getSecondaryDiffNode().getRealizer().getNodeContent();
      } else {
         return var4.getRealizer().getNodeContent();
      }
   }

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
         if(isRightSideLabel((CombinedGraph)var0, var1, var3)) {
            int var16 = var8.getPaddingLeft();
            var8.setPaddingLeft((int)Math.round((double)var16 + var7.getCenterX()));
            var9.handleMouseDraggedEvent(var12, var14, var3, var5, var10);
            var8.setPaddingLeft(var16);
         } else {
            var9.handleMouseDraggedEvent(var12, var14, var3, var5, var10);
         }
      }

   }

   public static void setActiveLabelContent(CombinedGraph var0, q var1, MouseEvent var2) {
      int var3 = var2.getX();
      CombinedDiffNode var4 = (CombinedDiffNode)var0.getNode(var1);
      if(var4.getPrimaryDiffNode() != null && var4.getSecondaryDiffNode() != null) {
         bu var5 = var0.getGraph();
         ch var6 = var0.getView();
         double var7 = var6.toWorldCoordX(var3);
         fj var9 = var5.t(var1);
         double var10 = var9.getX();
         double var12 = var9.getWidth();
         if(var7 > var10 && var7 < var10 + var12 / 2.0D) {
            ((CombinedNodeRealizer)var4.getRealizer()).setActiveContent(ESide.PRIMARY);
         } else {
            ((CombinedNodeRealizer)var4.getRealizer()).setActiveContent(ESide.SECONDARY);
         }
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
         if(isRightSideLabel((CombinedGraph)var0, var1, var3)) {
            int var16 = var8.getPaddingLeft();
            var8.setPaddingLeft((int)Math.round((double)var16 + var7.getCenterX()));
            var9.handleMouseReleasedEvent(var12, var14, var3, var5, var10, var2.getClickCount());
            var8.setPaddingLeft(var16);
         } else {
            var9.handleMouseReleasedEvent(var12, var14, var3, var5, var10, var2.getClickCount());
         }
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
         if(isRightSideLabel((CombinedGraph)var0, var1, var3)) {
            int var16 = var8.getPaddingLeft();
            var8.setPaddingLeft((int)Math.round((double)var16 + var7.getCenterX()));
            var9.handleMousePressedEvent(var12, var14, var3, var5, var10);
            var8.setPaddingLeft(var16);
         } else {
            var9.handleMousePressedEvent(var12, var14, var3, var5, var10);
         }
      }

   }
}
