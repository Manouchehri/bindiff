package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import java.util.*;
import y.f.a.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import y.f.c.*;
import com.google.security.zynamics.bindiff.graph.layout.util.*;
import y.f.c.a.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.*;
import y.f.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

public class GraphLayoutCalculator implements ICancelableCommand
{
    private final BinDiffGraph referenceGraph;
    private O primaryLayout;
    private O secondaryLayout;
    private O combinedLayout;
    private GraphLayoutCalculator$InternalLayoutThread superLayoutThread;
    private GraphLayoutCalculator$InternalLayoutThread combinedLayoutThread;
    private CountDownLatch doneLatch;
    private volatile boolean canceled;
    
    public GraphLayoutCalculator(final BinDiffGraph referenceGraph) {
        this.primaryLayout = new v();
        this.secondaryLayout = new v();
        this.combinedLayout = null;
        this.superLayoutThread = null;
        this.combinedLayoutThread = null;
        Preconditions.checkNotNull(referenceGraph);
        Preconditions.checkArgument(!(referenceGraph instanceof SuperGraph), (Object)"Reference graph cannot be a super graph");
        this.referenceGraph = referenceGraph;
    }
    
    private static void addSuperProxiEdgesToMaps(final SuperGraph superGraph, final Map map, final Map map2) {
        for (final d d : superGraph.getGraph().n()) {
            if (ProximityHelper.isProximityEdge(superGraph.getGraph(), d)) {
                final q c = d.c();
                final q d2 = d.d();
                SuperDiffNode superDiffNode = (SuperDiffNode)superGraph.getNode(c);
                final boolean b = superDiffNode == null;
                if (b) {
                    superDiffNode = (SuperDiffNode)superGraph.getNode(d.d());
                }
                if (ProximityHelper.isProximityNode(superGraph.getGraph(), b ? c : d2)) {
                    final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
                    if (primaryDiffNode != null) {
                        final q node = primaryDiffNode.getNode();
                        final e e = b ? node.k() : node.l();
                        while (e.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getPrimaryGraph().getGraph(), e.a())) {
                                map.put(d, e.a());
                                break;
                            }
                            e.g();
                        }
                    }
                    final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
                    if (secondaryDiffNode != null) {
                        final q node2 = secondaryDiffNode.getNode();
                        final e e2 = b ? node2.k() : node2.l();
                        while (e2.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getSecondaryGraph().getGraph(), e2.a())) {
                                map2.put(d, e2.a());
                                break;
                            }
                            e2.g();
                        }
                    }
                }
            }
        }
    }
    
    private static void addSuperProxiNodesToMaps(final SuperGraph superGraph, final Map map, final Map map2) {
        for (final q q : superGraph.getGraph().m()) {
            if (superGraph.getNode(q) == null && q.a() == 1) {
                final SuperDiffNode superDiffNode = (SuperDiffNode)superGraph.getNode(q.m().e());
                final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
                final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
                if (q.c() == 1) {
                    if (primaryDiffNode != null) {
                        final e k = primaryDiffNode.getNode().k();
                        while (k.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getPrimaryGraph().getGraph(), k.a())) {
                                map.put(q, k.a().c());
                                break;
                            }
                            k.g();
                        }
                    }
                    if (secondaryDiffNode != null) {
                        final e j = secondaryDiffNode.getNode().k();
                        while (j.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getSecondaryGraph().getGraph(), j.a())) {
                                map2.put(q, j.a().c());
                                break;
                            }
                            j.g();
                        }
                    }
                }
                else if (q.b() == 1) {
                    if (primaryDiffNode != null) {
                        final e l = primaryDiffNode.getNode().l();
                        while (l.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getPrimaryGraph().getGraph(), l.a())) {
                                map.put(q, l.a().d());
                                break;
                            }
                            l.g();
                        }
                    }
                    if (secondaryDiffNode != null) {
                        final e l2 = secondaryDiffNode.getNode().l();
                        while (l2.f()) {
                            if (ProximityHelper.isProximityEdge(superGraph.getSecondaryGraph().getGraph(), l2.a())) {
                                map2.put(q, l2.a().d());
                                break;
                            }
                            l2.g();
                        }
                    }
                }
            }
        }
    }
    
    private static void createSuperEdgeMaps(final SuperGraph superGraph, final Map map, final Map map2) {
        for (final SuperDiffEdge superDiffEdge : superGraph.getEdges()) {
            final SingleDiffEdge primaryDiffEdge = superDiffEdge.getPrimaryDiffEdge();
            final SingleDiffEdge secondaryDiffEdge = superDiffEdge.getSecondaryDiffEdge();
            if (primaryDiffEdge != null && superDiffEdge.isVisible()) {
                map.put(superDiffEdge.getEdge(), primaryDiffEdge.getEdge());
            }
            if (secondaryDiffEdge != null && superDiffEdge.isVisible()) {
                map2.put(superDiffEdge.getEdge(), secondaryDiffEdge.getEdge());
            }
        }
        addSuperProxiEdgesToMaps(superGraph, map, map2);
    }
    
    private static void createSuperNodeMaps(final SuperGraph superGraph, final Map map, final Map map2) {
        for (final SuperDiffNode superDiffNode : superGraph.getNodes()) {
            final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
            final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
            if (primaryDiffNode != null && superDiffNode.isVisible()) {
                map.put(superDiffNode.getNode(), primaryDiffNode.getNode());
            }
            if (secondaryDiffNode != null && superDiffNode.isVisible()) {
                map2.put(superDiffNode.getNode(), secondaryDiffNode.getNode());
            }
        }
        addSuperProxiNodesToMaps(superGraph, map, map2);
    }
    
    private void adoptSuperGraphLayout(final O o) {
        final SuperGraph superGraph = this.referenceGraph.getSuperGraph();
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        createSuperNodeMaps(superGraph, hashMap, hashMap2);
        for (final q q : this.referenceGraph.getSuperGraph().getGraph().m()) {
            final am a = o.a(q);
            final q q2 = hashMap.get(q);
            final q q3 = hashMap2.get(q);
            if (q2 != null) {
                ((v)this.primaryLayout).a(q2, a);
            }
            if (q3 != null) {
                ((v)this.secondaryLayout).a(q3, a);
            }
        }
        hashMap.clear();
        hashMap2.clear();
        final HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
        final HashMap<Object, Object> hashMap4 = new HashMap<Object, Object>();
        createSuperEdgeMaps(superGraph, hashMap3, hashMap4);
        for (final d d : superGraph.getGraph().n()) {
            final I b = o.b(d);
            final d d2 = hashMap3.get(d);
            final d d3 = hashMap4.get(d);
            if (d2 != null) {
                ((v)this.primaryLayout).a(d2, b);
            }
            if (d3 != null) {
                ((v)this.secondaryLayout).a(d3, b);
            }
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
    
    private c createSecondThreadLayouter(final c c, final GraphLayoutSettings graphLayoutSettings) {
        if (c instanceof a) {
            return LayoutCreator.getCircularLayout(graphLayoutSettings);
        }
        if (c instanceof M || c instanceof E) {
            return LayoutCreator.getHierarchicalLayout(graphLayoutSettings);
        }
        if (c instanceof y.f.f.c) {
            return LayoutCreator.getOrthogonalLayout(graphLayoutSettings);
        }
        throw new IllegalStateException("Unsupported graph layout style.");
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
            final GraphSettings settings = this.referenceGraph.getSettings();
            if (settings.isSync()) {
                final SuperGraph superGraph = this.referenceGraph.getSuperGraph();
                final CombinedGraph combinedGraph = this.referenceGraph.getCombinedGraph();
                final c currentLayouter = settings.getLayoutSettings().getCurrentLayouter();
                final c secondThreadLayouter = this.createSecondThreadLayouter(currentLayouter, settings.getLayoutSettings());
                if (secondThreadLayouter instanceof M) {
                    final M m = (M)secondThreadLayouter;
                    m.h(false);
                    m.b(false);
                    final CustomizedPCListOptimizer customizedPCListOptimizer = new CustomizedPCListOptimizer();
                    customizedPCListOptimizer.setBackloopRouting(true);
                    m.u().a(customizedPCListOptimizer);
                }
                ZyGraphLayouter.alignNodesToTopLayer(superGraph.getGraph(), currentLayouter);
                ZyGraphLayouter.alignNodesToTopLayer(combinedGraph.getGraph(), secondThreadLayouter);
                this.doneLatch = new CountDownLatch(2);
                this.superLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, superGraph, currentLayouter);
                this.combinedLayoutThread = new GraphLayoutCalculator$InternalLayoutThread(this, combinedGraph, secondThreadLayouter);
                this.superLayoutThread.start();
                this.combinedLayoutThread.start();
                this.doneLatch.await();
                if (this.superLayoutThread != null && this.combinedLayoutThread != null) {
                    if (this.superLayoutThread.getException() != null) {
                        throw this.superLayoutThread.getException();
                    }
                    if (this.combinedLayoutThread.getException() != null) {
                        throw this.combinedLayoutThread.getException();
                    }
                    this.combinedLayout = this.combinedLayoutThread.getGraphLayout();
                    final O graphLayout = this.superLayoutThread.getGraphLayout();
                    ae.a(superGraph.getGraph(), graphLayout);
                    GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
                    this.adoptSuperGraphLayout(graphLayout);
                }
            }
            else if (this.referenceGraph instanceof SingleGraph) {
                if (((SingleGraph)this.referenceGraph).getSide() == ESide.PRIMARY) {
                    this.primaryLayout = this.referenceGraph.calculateLayout();
                }
                else {
                    this.secondaryLayout = this.referenceGraph.calculateLayout();
                }
            }
            else if (this.referenceGraph instanceof CombinedGraph) {
                this.combinedLayout = this.referenceGraph.calculateLayout();
            }
        }
        catch (GraphLayoutException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            Logger.logException(ex2, ex2.getMessage());
            throw new GraphLayoutException(ex2, "Could not calculate graph layouts.");
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
}
