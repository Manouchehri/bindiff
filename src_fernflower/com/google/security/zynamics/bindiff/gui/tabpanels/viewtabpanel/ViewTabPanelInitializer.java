package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CNormalViewPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.awt.Dimension;
import y.h.ch;

public class ViewTabPanelInitializer {
   private static void configureScrollPanes(GraphsContainer var0) {
      boolean var1 = var0.getSettings().getShowScrollbars();
      byte var2 = 31;
      byte var3 = 21;
      if(var1) {
         var2 = 32;
         var3 = 22;
      }

      var0.getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(var1);
      var0.getSecondaryGraph().getEditMode().setAdjustScrollBarPolicy(var1);
      var0.getCombinedGraph().getEditMode().setAdjustScrollBarPolicy(var1);
      var0.getPrimaryGraph().getView().setHorizontalScrollBarPolicy(var2);
      var0.getSecondaryGraph().getView().setHorizontalScrollBarPolicy(var2);
      var0.getCombinedGraph().getView().setHorizontalScrollBarPolicy(var2);
      var0.getPrimaryGraph().getView().setVerticalScrollBarPolicy(var3);
      var0.getSecondaryGraph().getView().setVerticalScrollBarPolicy(var3);
      var0.getCombinedGraph().getView().setVerticalScrollBarPolicy(var3);
   }

   private static void setDoubleBufferedGraphViews(GraphsContainer var0) {
      var0.getPrimaryGraph().getView().setDoubleBuffered(true);
      var0.getSecondaryGraph().getView().setDoubleBuffered(true);
      var0.getCombinedGraph().getView().setDoubleBuffered(true);
   }

   public static void centerCombinedGraph(GraphsContainer var0, ViewTabPanel var1) {
      ch var2 = var0.getCombinedGraph().getView();
      CNormalViewPanel var3 = var1.getNormalViewPanel();
      int var4 = var3.getSize().width;
      int var5 = var3.getSize().height;
      long var6 = Math.round((double)var4 * (1.0D - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH));
      long var8 = (long)Math.round((float)var5);
      var2.setSize((int)var6, (int)var8);
      var2.setPreferredSize(new Dimension((int)var6, (int)var8));
      var2.fitWorldRect();
      var2.fitContent();
      var2.setZoom(var0.getCombinedGraph().getView().getZoom() * 0.95D);
   }

   public static void centerSingleGraphs(SuperGraph var0) {
      GraphViewFitter.adoptSuperViewCanvasProperties(var0);
      GraphViewFitter.fitSingleViewToSuperViewContent(var0);
   }

   public static void initialize(GraphsContainer var0, CEndlessHelperThread var1) {
      var1.setDescription("Configure View...");
      configureScrollPanes(var0);
      setDoubleBufferedGraphViews(var0);
      var1.setDescription("Layouting graphs...");
      GraphLayoutEventHandler.handleInitialLayoutEvent(var0.getCombinedGraph());
   }
}
