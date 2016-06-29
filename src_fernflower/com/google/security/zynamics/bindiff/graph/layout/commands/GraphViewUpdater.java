package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.layout.LayoutMorpher;
import com.google.security.zynamics.bindiff.graph.layout.SuperLayoutMorpher;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.types.common.ICommand;
import y.b.b;
import y.b.d;
import y.b.e;
import y.b.l;
import y.f.O;
import y.f.V;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.c;
import y.h.bu;
import y.h.ch;

public class GraphViewUpdater implements ICommand {
   private final BinDiffGraph referenceGraph;
   private final GraphLayoutCalculator layoutCalculator;

   public GraphViewUpdater(GraphLayoutCalculator var1) {
      Preconditions.checkNotNull(var1);
      this.layoutCalculator = var1;
      this.referenceGraph = var1.getReferenceGraph();
   }

   public static void updateViews(BinDiffGraph var0) {
      var0.getPrimaryGraph().getGraph().T();
      var0.getSecondaryGraph().getGraph().T();
      var0.getCombinedGraph().getGraph().T();
      var0.getSuperGraph().getGraph().T();
   }

   private void applyGraphLayout() {
      GraphSettings var1 = this.referenceGraph.getSettings();
      if(var1.isSync()) {
         ae.a((X)this.referenceGraph.getPrimaryGraph().getGraph(), (O)this.layoutCalculator.getPrimaryGraphLayout());
         ae.a((X)this.referenceGraph.getSecondaryGraph().getGraph(), (O)this.layoutCalculator.getSecondaryGraphLayout());
         ae.a((X)this.referenceGraph.getCombinedGraph().getGraph(), (O)this.layoutCalculator.getCombinedGraphLayout());
         this.referenceGraph.getCombinedGraph().getView().fitContent();
      } else {
         ae.a((X)this.referenceGraph.getGraph(), (O)this.getReferenceGraphLayout());
         this.referenceGraph.getView().fitContent();
         this.referenceGraph.getView().setZoom(this.referenceGraph.getView().getZoom() * 0.95D);
      }

   }

   private O getReferenceGraphLayout() {
      if(this.referenceGraph instanceof SingleGraph) {
         ESide var1 = ((SingleGraph)this.referenceGraph).getSide();
         return var1 == ESide.PRIMARY?this.layoutCalculator.getPrimaryGraphLayout():this.layoutCalculator.getSecondaryGraphLayout();
      } else {
         return this.layoutCalculator.getCombinedGraphLayout();
      }
   }

   private void morphGraphLayout() {
      try {
         GraphSettings var1 = this.referenceGraph.getSettings();
         if(var1.isSync()) {
            if(var1.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
               ae.a((X)this.referenceGraph.getCombinedGraph().getGraph(), (O)this.layoutCalculator.getCombinedGraphLayout());
               this.referenceGraph.getCombinedGraph().getView().fitContent();
               double var2 = this.referenceGraph.getCombinedGraph().getView().getZoom() * 0.95D;
               this.referenceGraph.getCombinedGraph().getView().setZoom(var2);
               this.morphTwoGraphLayouts();
            } else {
               ae.a((X)this.referenceGraph.getPrimaryGraph().getGraph(), (O)this.layoutCalculator.getPrimaryGraphLayout());
               ae.a((X)this.referenceGraph.getSecondaryGraph().getGraph(), (O)this.layoutCalculator.getSecondaryGraphLayout());
               this.morphOneGraphLayout(this.referenceGraph, this.layoutCalculator.getCombinedGraphLayout());
            }
         } else {
            this.morphOneGraphLayout(this.referenceGraph, this.getReferenceGraphLayout());
         }

      } catch (Exception var4) {
         throw new GraphLayoutException(var4, "Graph layout failed. Could not morph graph layout.");
      }
   }

   private void morphOneGraphLayout(BinDiffGraph var1, O var2) {
      GraphSettings var3 = var1.getSettings();
      c var4 = var3.getLayoutSettings().getCurrentLayouter();
      ch var5 = var1.getView();
      var4.c((ad)(new V()));
      var4.c(true);
      boolean var6 = true;
      int var7 = var1.getSettings().getDisplaySettings().getAnimationSpeed();
      e var8 = new e();
      var8.a(true);
      var8.a((y.b.c)var5);
      LayoutMorpher var9 = new LayoutMorpher(var5, var2);
      var9.setKeepZoomFactor(false);
      var9.setEasedExecution(true);
      var9.setPreferredDuration((long)(100 * var7));
      var9.setSmoothViewTransform(true);
      l var10 = b.a();
      var10.a(var9);
      var8.a((d)var10);
   }

   private void morphTwoGraphLayouts() {
      bu var1 = this.referenceGraph.getSuperGraph().getGraph();
      O var2 = this.layoutCalculator.getPrimaryGraphLayout();
      O var3 = this.layoutCalculator.getSecondaryGraphLayout();
      ch var4 = this.referenceGraph.getPrimaryGraph().getView();
      ch var5 = this.referenceGraph.getSecondaryGraph().getView();
      e var6 = new e();
      var6.a(true);
      var6.a((y.b.c)var4);
      var6.a((y.b.c)var5);
      SuperLayoutMorpher var7 = new SuperLayoutMorpher(var4, var2, var1);
      SuperLayoutMorpher var8 = new SuperLayoutMorpher(var5, var3, var1);
      int var9 = this.referenceGraph.getSettings().getDisplaySettings().getAnimationSpeed();
      boolean var10 = true;
      var7.setSmoothViewTransform(true);
      var7.setPreferredDuration((long)(100 * var9));
      var7.setEasedExecution(true);
      var8.setSmoothViewTransform(true);
      var8.setPreferredDuration((long)(100 * var9));
      var8.setEasedExecution(true);
      l var11 = b.a();
      var11.a(var7);
      var11.a(var8);
      var6.a((d)var11);
   }

   public void execute() {
      try {
         GraphSettings var1 = this.referenceGraph.getSettings();
         GraphViewFitter.adoptSuperViewCanvasProperties(this.referenceGraph.getSuperGraph());
         GraphViewFitter.fitSingleViewToSuperViewContent(this.referenceGraph.getSuperGraph());
         if(var1.getLayoutSettings().getAnimateLayout()) {
            this.morphGraphLayout();
         } else {
            this.applyGraphLayout();
         }

         updateViews(this.referenceGraph);
      } catch (GraphLayoutException var2) {
         throw var2;
      } catch (Exception var3) {
         Logger.logException(var3, var3.getMessage());
         throw new GraphLayoutException(var3, "Could update graph view.");
      }
   }
}
