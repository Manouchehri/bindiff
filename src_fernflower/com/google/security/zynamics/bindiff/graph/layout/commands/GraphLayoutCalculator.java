package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCreator;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator$InternalLayoutThread;
import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.ZyGraphLayouter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.ae;
import y.f.am;
import y.f.c;
import y.f.v;
import y.f.a.a;
import y.f.c.E;
import y.f.c.M;
import y.f.c.a.br;
import y.h.bu;

public class GraphLayoutCalculator implements ICancelableCommand {
   private final BinDiffGraph referenceGraph;
   private O primaryLayout = new v();
   private O secondaryLayout = new v();
   private O combinedLayout = null;
   private GraphLayoutCalculator$InternalLayoutThread superLayoutThread = null;
   private GraphLayoutCalculator$InternalLayoutThread combinedLayoutThread = null;
   private CountDownLatch doneLatch;
   private volatile boolean canceled;

   public GraphLayoutCalculator(BinDiffGraph var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(!(var1 instanceof SuperGraph), "Reference graph cannot be a super graph");
      this.referenceGraph = var1;
   }

   private static void addSuperProxiEdgesToMaps(SuperGraph var0, Map var1, Map var2) {
      bu var3 = var0.getGraph();
      d[] var4 = var3.n();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         d var7 = var4[var6];
         if(ProximityHelper.isProximityEdge(var0.getGraph(), var7)) {
            q var8 = var7.c();
            q var9 = var7.d();
            SuperDiffNode var10 = (SuperDiffNode)var0.getNode(var8);
            boolean var11 = var10 == null;
            if(var11) {
               var10 = (SuperDiffNode)var0.getNode(var7.d());
            }

            if(ProximityHelper.isProximityNode(var0.getGraph(), var11?var8:var9)) {
               SingleDiffNode var12 = var10.getPrimaryDiffNode();
               if(var12 != null) {
                  q var13 = var12.getNode();
                  e var14 = var11?var13.k():var13.l();

                  while(var14.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getPrimaryGraph().getGraph(), var14.a())) {
                        var1.put(var7, var14.a());
                        break;
                     }

                     var14.g();
                  }
               }

               SingleDiffNode var16 = var10.getSecondaryDiffNode();
               if(var16 != null) {
                  q var17 = var16.getNode();
                  e var15 = var11?var17.k():var17.l();

                  while(var15.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getSecondaryGraph().getGraph(), var15.a())) {
                        var2.put(var7, var15.a());
                        break;
                     }

                     var15.g();
                  }
               }
            }
         }
      }

   }

   private static void addSuperProxiNodesToMaps(SuperGraph var0, Map var1, Map var2) {
      bu var3 = var0.getGraph();
      q[] var4 = var3.m();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         q var7 = var4[var6];
         if(var0.getNode(var7) == null && var7.a() == 1) {
            q var8 = var7.m().e();
            SuperDiffNode var9 = (SuperDiffNode)var0.getNode(var8);
            SingleDiffNode var10 = var9.getPrimaryDiffNode();
            SingleDiffNode var11 = var9.getSecondaryDiffNode();
            q var12;
            e var13;
            q var14;
            if(var7.c() == 1) {
               if(var10 != null) {
                  var12 = var10.getNode();
                  var13 = var12.k();

                  while(var13.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getPrimaryGraph().getGraph(), var13.a())) {
                        var14 = var13.a().c();
                        var1.put(var7, var14);
                        break;
                     }

                     var13.g();
                  }
               }

               if(var11 != null) {
                  var12 = var11.getNode();
                  var13 = var12.k();

                  while(var13.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getSecondaryGraph().getGraph(), var13.a())) {
                        var14 = var13.a().c();
                        var2.put(var7, var14);
                        break;
                     }

                     var13.g();
                  }
               }
            } else if(var7.b() == 1) {
               if(var10 != null) {
                  var12 = var10.getNode();
                  var13 = var12.l();

                  while(var13.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getPrimaryGraph().getGraph(), var13.a())) {
                        var14 = var13.a().d();
                        var1.put(var7, var14);
                        break;
                     }

                     var13.g();
                  }
               }

               if(var11 != null) {
                  var12 = var11.getNode();
                  var13 = var12.l();

                  while(var13.f()) {
                     if(ProximityHelper.isProximityEdge(var0.getSecondaryGraph().getGraph(), var13.a())) {
                        var14 = var13.a().d();
                        var2.put(var7, var14);
                        break;
                     }

                     var13.g();
                  }
               }
            }
         }
      }

   }

   private static void createSuperEdgeMaps(SuperGraph var0, Map var1, Map var2) {
      Iterator var3 = var0.getEdges().iterator();

      while(var3.hasNext()) {
         SuperDiffEdge var4 = (SuperDiffEdge)var3.next();
         SingleDiffEdge var5 = var4.getPrimaryDiffEdge();
         SingleDiffEdge var6 = var4.getSecondaryDiffEdge();
         d var7;
         if(var5 != null && var4.isVisible()) {
            var7 = var5.getEdge();
            var1.put(var4.getEdge(), var7);
         }

         if(var6 != null && var4.isVisible()) {
            var7 = var6.getEdge();
            var2.put(var4.getEdge(), var7);
         }
      }

      addSuperProxiEdgesToMaps(var0, var1, var2);
   }

   private static void createSuperNodeMaps(SuperGraph var0, Map var1, Map var2) {
      Iterator var3 = var0.getNodes().iterator();

      while(var3.hasNext()) {
         SuperDiffNode var4 = (SuperDiffNode)var3.next();
         SingleDiffNode var5 = var4.getPrimaryDiffNode();
         SingleDiffNode var6 = var4.getSecondaryDiffNode();
         q var7;
         if(var5 != null && var4.isVisible()) {
            var7 = var5.getNode();
            var1.put(var4.getNode(), var7);
         }

         if(var6 != null && var4.isVisible()) {
            var7 = var6.getNode();
            var2.put(var4.getNode(), var7);
         }
      }

      addSuperProxiNodesToMaps(var0, var1, var2);
   }

   private void adoptSuperGraphLayout(O var1) {
      SuperGraph var2 = this.referenceGraph.getSuperGraph();
      HashMap var3 = new HashMap();
      HashMap var4 = new HashMap();
      createSuperNodeMaps(var2, var3, var4);
      q[] var5 = this.referenceGraph.getSuperGraph().getGraph().m();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         q var8 = var5[var7];
         am var9 = var1.a(var8);
         q var10 = (q)var3.get(var8);
         q var11 = (q)var4.get(var8);
         if(var10 != null) {
            ((v)this.primaryLayout).a(var10, (am)var9);
         }

         if(var11 != null) {
            ((v)this.secondaryLayout).a(var11, (am)var9);
         }
      }

      var3.clear();
      var4.clear();
      HashMap var14 = new HashMap();
      HashMap var15 = new HashMap();
      createSuperEdgeMaps(var2, var14, var15);
      d[] var16 = var2.getGraph().n();
      int var17 = var16.length;

      for(int var18 = 0; var18 < var17; ++var18) {
         d var19 = var16[var18];
         I var20 = var1.b(var19);
         d var12 = (d)var14.get(var19);
         d var13 = (d)var15.get(var19);
         if(var12 != null) {
            ((v)this.primaryLayout).a(var12, (I)var20);
         }

         if(var13 != null) {
            ((v)this.secondaryLayout).a(var13, (I)var20);
         }
      }

   }

   private void cancelLayoutCalculation() {
      if(this.superLayoutThread != null && this.superLayoutThread.isAlive()) {
         this.superLayoutThread.stop();
         this.superLayoutThread = null;
         this.doneLatch.countDown();
      }

      if(this.combinedLayoutThread != null && this.combinedLayoutThread.isAlive()) {
         this.combinedLayoutThread.stop();
         this.combinedLayoutThread = null;
         this.doneLatch.countDown();
      }

      this.setCanceled();
   }

   private c createSecondThreadLayouter(c var1, GraphLayoutSettings var2) {
      if(var1 instanceof a) {
         return LayoutCreator.getCircularLayout(var2);
      } else if(!(var1 instanceof M) && !(var1 instanceof E)) {
         if(var1 instanceof y.f.f.c) {
            return LayoutCreator.getOrthogonalLayout(var2);
         } else {
            throw new IllegalStateException("Unsupported graph layout style.");
         }
      } else {
         return LayoutCreator.getHierarchicalLayout(var2);
      }
   }

   private synchronized void setCanceled() {
      this.canceled = true;
   }

   public void cancel() {
      this.cancelLayoutCalculation();
   }

   public void execute() {
      try {
         GraphSettings var1 = this.referenceGraph.getSettings();
         if(var1.isSync()) {
            SuperGraph var2 = this.referenceGraph.getSuperGraph();
            CombinedGraph var3 = this.referenceGraph.getCombinedGraph();
            c var4 = var1.getLayoutSettings().getCurrentLayouter();
            c var5 = this.createSecondThreadLayouter(var4, var1.getLayoutSettings());
            if(var5 instanceof M) {
               M var6 = (M)var5;
               var6.h(false);
               var6.b(false);
               CustomizedPCListOptimizer var7 = new CustomizedPCListOptimizer();
               var7.setBackloopRouting(true);
               var6.u().a((br)var7);
            }

            ZyGraphLayouter.alignNodesToTopLayer(var2.getGraph(), var4);
            ZyGraphLayouter.alignNodesToTopLayer(var3.getGraph(), var5);
            this.doneLatch = new CountDownLatch(2);
            this.superLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, var2, var4);
            this.combinedLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, var3, var5);
            this.superLayoutThread.start();
            this.combinedLayoutThread.start();
            this.doneLatch.await();
            if(this.superLayoutThread != null && this.combinedLayoutThread != null) {
               if(this.superLayoutThread.getException() != null) {
                  throw this.superLayoutThread.getException();
               }

               if(this.combinedLayoutThread.getException() != null) {
                  throw this.combinedLayoutThread.getException();
               }

               this.combinedLayout = this.combinedLayoutThread.getGraphLayout();
               O var10 = this.superLayoutThread.getGraphLayout();
               ae.a((X)var2.getGraph(), (O)var10);
               GraphViewFitter.adoptSuperViewCanvasProperties(var2);
               this.adoptSuperGraphLayout(var10);
            }
         } else if(this.referenceGraph instanceof SingleGraph) {
            if(((SingleGraph)this.referenceGraph).getSide() == ESide.PRIMARY) {
               this.primaryLayout = this.referenceGraph.calculateLayout();
            } else {
               this.secondaryLayout = this.referenceGraph.calculateLayout();
            }
         } else if(this.referenceGraph instanceof CombinedGraph) {
            this.combinedLayout = this.referenceGraph.calculateLayout();
         }

      } catch (GraphLayoutException var8) {
         throw var8;
      } catch (Exception var9) {
         Logger.logException(var9, var9.getMessage());
         throw new GraphLayoutException(var9, "Could not calculate graph layouts.");
      }
   }

   public O getCombinedGraphLayout() {
      return this.combinedLayout;
   }

   public O getPrimaryGraphLayout() {
      return this.primaryLayout;
   }

   public BinDiffGraph getReferenceGraph() {
      return this.referenceGraph;
   }

   public O getSecondaryGraphLayout() {
      return this.secondaryLayout;
   }

   public synchronized boolean wasCanceled() {
      return this.canceled;
   }

   // $FF: synthetic method
   static CountDownLatch access$000(GraphLayoutCalculator var0) {
      return var0.doneLatch;
   }
}
