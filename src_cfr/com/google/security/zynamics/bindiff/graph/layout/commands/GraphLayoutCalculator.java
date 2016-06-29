/*
 * Decompiled with CFR 0_115.
 */
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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.a.a;
import y.f.ae;
import y.f.am;
import y.f.c.E;
import y.f.c.M;
import y.f.c.a.N;
import y.f.c.a.br;
import y.f.f.c;
import y.f.v;
import y.h.bu;

public class GraphLayoutCalculator
implements ICancelableCommand {
    private final BinDiffGraph referenceGraph;
    private O primaryLayout = new v();
    private O secondaryLayout = new v();
    private O combinedLayout = null;
    private GraphLayoutCalculator$InternalLayoutThread superLayoutThread = null;
    private GraphLayoutCalculator$InternalLayoutThread combinedLayoutThread = null;
    private CountDownLatch doneLatch;
    private volatile boolean canceled;

    public GraphLayoutCalculator(BinDiffGraph binDiffGraph) {
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkArgument(!(binDiffGraph instanceof SuperGraph), "Reference graph cannot be a super graph");
        this.referenceGraph = binDiffGraph;
    }

    private static void addSuperProxiEdgesToMaps(SuperGraph superGraph, Map map, Map map2) {
        bu bu2 = superGraph.getGraph();
        d[] arrd = bu2.n();
        int n2 = arrd.length;
        int n3 = 0;
        while (n3 < n2) {
            d d2 = arrd[n3];
            if (ProximityHelper.isProximityEdge(superGraph.getGraph(), d2)) {
                boolean bl2;
                q q2 = d2.c();
                q q3 = d2.d();
                SuperDiffNode superDiffNode = (SuperDiffNode)superGraph.getNode(q2);
                boolean bl3 = bl2 = superDiffNode == null;
                if (bl2) {
                    superDiffNode = (SuperDiffNode)superGraph.getNode(d2.d());
                }
                if (ProximityHelper.isProximityNode(superGraph.getGraph(), bl2 ? q2 : q3)) {
                    Object object;
                    Object object2;
                    SingleDiffNode singleDiffNode = superDiffNode.getPrimaryDiffNode();
                    if (singleDiffNode != null) {
                        object = singleDiffNode.getNode();
                        Object object3 = object2 = bl2 ? object.k() : object.l();
                        while (object2.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getPrimaryGraph().getGraph(), object2.a())) {
                                map.put(d2, object2.a());
                                break;
                            }
                            object2.g();
                        }
                    }
                    if ((object = superDiffNode.getSecondaryDiffNode()) != null) {
                        e e2;
                        object2 = object.getNode();
                        e e3 = e2 = bl2 ? object2.k() : object2.l();
                        while (e2.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getSecondaryGraph().getGraph(), e2.a())) {
                                map2.put(d2, e2.a());
                                break;
                            }
                            e2.g();
                        }
                    }
                }
            }
            ++n3;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void addSuperProxiNodesToMaps(SuperGraph var0, Map var1_1, Map var2_2) {
        var3_3 = var0.getGraph();
        var4_4 = var3_3.m();
        var5_5 = var4_4.length;
        var6_6 = 0;
        while (var6_6 < var5_5) {
            block11 : {
                var7_7 = var4_4[var6_6];
                if (var0.getNode(var7_7) != null || var7_7.a() != 1) ** GOTO lbl58
                var8_8 = var7_7.m().e();
                var9_9 = (SuperDiffNode)var0.getNode(var8_8);
                var10_10 = var9_9.getPrimaryDiffNode();
                var11_11 = var9_9.getSecondaryDiffNode();
                if (var7_7.c() != 1) ** GOTO lbl17
                if (var10_10 == null) ** GOTO lbl29
                var12_12 = var10_10.getNode();
                var13_13 = var12_12.k();
                ** GOTO lbl22
lbl17: // 1 sources:
                if (var7_7.b() != 1) ** GOTO lbl58
                if (var10_10 == null) ** GOTO lbl48
                var12_12 = var10_10.getNode();
                var13_13 = var12_12.l();
                ** GOTO lbl41
lbl22: // 2 sources:
                while (var13_13.f()) {
                    if (ProximityHelper.isProximityEdge(var0.getPrimaryGraph().getGraph(), var13_13.a())) {
                        var14_14 = var13_13.a().c();
                        var1_1.put(var7_7, var14_14);
                        break;
                    }
                    var13_13.g();
                }
lbl29: // 3 sources:
                if (var11_11 != null) {
                    var12_12 = var11_11.getNode();
                    var13_13 = var12_12.k();
                    while (var13_13.f()) {
                        if (ProximityHelper.isProximityEdge(var0.getSecondaryGraph().getGraph(), var13_13.a())) {
                            var14_14 = var13_13.a().c();
                            var2_2.put(var7_7, var14_14);
                            break block11;
                        }
                        var13_13.g();
                    }
                }
                ** GOTO lbl58
lbl41: // 2 sources:
                while (var13_13.f()) {
                    if (ProximityHelper.isProximityEdge(var0.getPrimaryGraph().getGraph(), var13_13.a())) {
                        var14_14 = var13_13.a().d();
                        var1_1.put(var7_7, var14_14);
                        break;
                    }
                    var13_13.g();
                }
lbl48: // 3 sources:
                if (var11_11 != null) {
                    var12_12 = var11_11.getNode();
                    var13_13 = var12_12.l();
                    while (var13_13.f()) {
                        if (ProximityHelper.isProximityEdge(var0.getSecondaryGraph().getGraph(), var13_13.a())) {
                            var14_14 = var13_13.a().d();
                            var2_2.put(var7_7, var14_14);
                            break;
                        }
                        var13_13.g();
                    }
                }
            }
            ++var6_6;
        }
    }

    private static void createSuperEdgeMaps(SuperGraph superGraph, Map map, Map map2) {
        Iterator iterator = superGraph.getEdges().iterator();
        do {
            d d2;
            if (!iterator.hasNext()) {
                GraphLayoutCalculator.addSuperProxiEdgesToMaps(superGraph, map, map2);
                return;
            }
            SuperDiffEdge superDiffEdge = (SuperDiffEdge)iterator.next();
            SingleDiffEdge singleDiffEdge = superDiffEdge.getPrimaryDiffEdge();
            SingleDiffEdge singleDiffEdge2 = superDiffEdge.getSecondaryDiffEdge();
            if (singleDiffEdge != null && superDiffEdge.isVisible()) {
                d2 = singleDiffEdge.getEdge();
                map.put(superDiffEdge.getEdge(), d2);
            }
            if (singleDiffEdge2 == null || !superDiffEdge.isVisible()) continue;
            d2 = singleDiffEdge2.getEdge();
            map2.put(superDiffEdge.getEdge(), d2);
        } while (true);
    }

    private static void createSuperNodeMaps(SuperGraph superGraph, Map map, Map map2) {
        Iterator iterator = superGraph.getNodes().iterator();
        do {
            q q2;
            if (!iterator.hasNext()) {
                GraphLayoutCalculator.addSuperProxiNodesToMaps(superGraph, map, map2);
                return;
            }
            SuperDiffNode superDiffNode = (SuperDiffNode)iterator.next();
            SingleDiffNode singleDiffNode = superDiffNode.getPrimaryDiffNode();
            SingleDiffNode singleDiffNode2 = superDiffNode.getSecondaryDiffNode();
            if (singleDiffNode != null && superDiffNode.isVisible()) {
                q2 = singleDiffNode.getNode();
                map.put(superDiffNode.getNode(), q2);
            }
            if (singleDiffNode2 == null || !superDiffNode.isVisible()) continue;
            q2 = singleDiffNode2.getNode();
            map2.put(superDiffNode.getNode(), q2);
        } while (true);
    }

    private void adoptSuperGraphLayout(O o2) {
        Object object;
        SuperGraph superGraph = this.referenceGraph.getSuperGraph();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        GraphLayoutCalculator.createSuperNodeMaps(superGraph, hashMap, hashMap2);
        for (q q3 : this.referenceGraph.getSuperGraph().getGraph().m()) {
            am am2 = o2.a(q3);
            q q2 = (q)hashMap.get(q3);
            object = (q)hashMap2.get(q3);
            if (q2 != null) {
                ((v)this.primaryLayout).a((Object)q2, am2);
            }
            if (object == null) continue;
            ((v)this.secondaryLayout).a(object, am2);
        }
        hashMap.clear();
        hashMap2.clear();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        GraphLayoutCalculator.createSuperEdgeMaps(superGraph, hashMap3, hashMap4);
        d[] arrd = superGraph.getGraph().n();
        int n2 = arrd.length;
        int n3 = 0;
        while (n3 < n2) {
            d d2 = arrd[n3];
            object = o2.b(d2);
            d d3 = (d)hashMap3.get(d2);
            d d4 = (d)hashMap4.get(d2);
            if (d3 != null) {
                ((v)this.primaryLayout).a((Object)d3, (I)object);
            }
            if (d4 != null) {
                ((v)this.secondaryLayout).a((Object)d4, (I)object);
            }
            ++n3;
        }
    }

    private void cancelLayoutCalculation() {
        if (this.superLayoutThread != null && this.superLayoutThread.isAlive()) {
            this.superLayoutThread.stop();
            this.superLayoutThread = null;
            this.doneLatch.countDown();
        }
        if (this.combinedLayoutThread != null && this.combinedLayoutThread.isAlive()) {
            this.combinedLayoutThread.stop();
            this.combinedLayoutThread = null;
            this.doneLatch.countDown();
        }
        this.setCanceled();
    }

    private y.f.c createSecondThreadLayouter(y.f.c c2, GraphLayoutSettings graphLayoutSettings) {
        if (c2 instanceof a) {
            return LayoutCreator.getCircularLayout(graphLayoutSettings);
        }
        if (c2 instanceof M) return LayoutCreator.getHierarchicalLayout(graphLayoutSettings);
        if (c2 instanceof E) {
            return LayoutCreator.getHierarchicalLayout(graphLayoutSettings);
        }
        if (!(c2 instanceof c)) throw new IllegalStateException("Unsupported graph layout style.");
        return LayoutCreator.getOrthogonalLayout(graphLayoutSettings);
    }

    private synchronized void setCanceled() {
        this.canceled = true;
    }

    @Override
    public void cancel() {
        this.cancelLayoutCalculation();
    }

    @Override
    public void execute() {
        try {
            GraphSettings graphSettings = this.referenceGraph.getSettings();
            if (graphSettings.isSync()) {
                Object object;
                SuperGraph superGraph = this.referenceGraph.getSuperGraph();
                CombinedGraph combinedGraph = this.referenceGraph.getCombinedGraph();
                y.f.c c2 = graphSettings.getLayoutSettings().getCurrentLayouter();
                y.f.c c3 = this.createSecondThreadLayouter(c2, graphSettings.getLayoutSettings());
                if (c3 instanceof M) {
                    object = (M)c3;
                    object.h(false);
                    object.b(false);
                    CustomizedPCListOptimizer customizedPCListOptimizer = new CustomizedPCListOptimizer();
                    customizedPCListOptimizer.setBackloopRouting(true);
                    object.u().a(customizedPCListOptimizer);
                }
                ZyGraphLayouter.alignNodesToTopLayer(superGraph.getGraph(), c2);
                ZyGraphLayouter.alignNodesToTopLayer(combinedGraph.getGraph(), c3);
                this.doneLatch = new CountDownLatch(2);
                this.superLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, superGraph, c2);
                this.combinedLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, combinedGraph, c3);
                this.superLayoutThread.start();
                this.combinedLayoutThread.start();
                this.doneLatch.await();
                if (this.superLayoutThread == null) return;
                if (this.combinedLayoutThread == null) return;
                if (this.superLayoutThread.getException() != null) {
                    throw this.superLayoutThread.getException();
                }
                if (this.combinedLayoutThread.getException() != null) {
                    throw this.combinedLayoutThread.getException();
                }
                this.combinedLayout = this.combinedLayoutThread.getGraphLayout();
                object = this.superLayoutThread.getGraphLayout();
                ae.a((X)superGraph.getGraph(), (O)object);
                GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
                this.adoptSuperGraphLayout((O)object);
                return;
            }
            if (!(this.referenceGraph instanceof SingleGraph)) {
                if (!(this.referenceGraph instanceof CombinedGraph)) return;
                this.combinedLayout = this.referenceGraph.calculateLayout();
                return;
            }
            if (((SingleGraph)this.referenceGraph).getSide() == ESide.PRIMARY) {
                this.primaryLayout = this.referenceGraph.calculateLayout();
                return;
            }
            this.secondaryLayout = this.referenceGraph.calculateLayout();
            return;
        }
        catch (GraphLayoutException var1_2) {
            throw var1_2;
        }
        catch (Exception var1_3) {
            Logger.logException(var1_3, var1_3.getMessage());
            throw new GraphLayoutException(var1_3, "Could not calculate graph layouts.");
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

    @Override
    public synchronized boolean wasCanceled() {
        return this.canceled;
    }

    static /* synthetic */ CountDownLatch access$000(GraphLayoutCalculator graphLayoutCalculator) {
        return graphLayoutCalculator.doneLatch;
    }
}

