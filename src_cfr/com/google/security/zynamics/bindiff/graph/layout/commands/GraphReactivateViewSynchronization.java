/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserDeactivator;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class GraphReactivateViewSynchronization {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void synchronizeNodeSelection(BinDiffGraph binDiffGraph) {
        Object object;
        Object object2;
        HashSet<SuperDiffNode> hashSet = new HashSet<SuperDiffNode>();
        HashSet<Object> hashSet2 = new HashSet<Object>();
        HashSet<Object> hashSet3 = new HashSet<Object>();
        HashSet<SingleDiffNode> hashSet4 = new HashSet<SingleDiffNode>();
        GraphSettings graphSettings = binDiffGraph.getSettings();
        for (Object object32 : binDiffGraph.getCombinedGraph().getNodes()) {
            object = object32.getPrimaryDiffNode();
            object2 = object32.getSecondaryDiffNode();
            boolean bl2 = object != null && object.isSelected();
            boolean bl3 = object2 != null && object2.isSelected();
            boolean bl4 = graphSettings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && (bl2 || bl3);
            boolean bl5 = bl4 || graphSettings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW && object32.isSelected();
            bl4 = bl5;
            if (!bl4) continue;
            if (object != null) {
                hashSet3.add(object);
            }
            if (object2 != null) {
                hashSet4.add((SingleDiffNode)object2);
            }
            hashSet.add(object32.getSuperDiffNode());
            hashSet2.add(object32);
        }
        boolean bl6 = graphSettings.getProximitySettings().getProximityBrowsingFrozen();
        try {
            Object object32;
            graphSettings.getProximitySettings().setProximityBrowsingFrozen(true);
            object32 = new HashSet();
            object32.addAll(binDiffGraph.getCombinedGraph().getNodes());
            object32.removeAll(hashSet2);
            binDiffGraph.getCombinedGraph().selectNodes(hashSet2, (Collection)object32);
            object = new HashSet();
            object.addAll(binDiffGraph.getSuperGraph().getNodes());
            object.removeAll(hashSet);
            binDiffGraph.getSuperGraph().selectNodes(hashSet, (Collection)object);
            object2 = new HashSet();
            object2.addAll(binDiffGraph.getPrimaryGraph().getNodes());
            object2.removeAll(hashSet3);
            binDiffGraph.getPrimaryGraph().selectNodes(hashSet3, (Collection)object2);
            HashSet hashSet5 = new HashSet();
            hashSet5.addAll(binDiffGraph.getSecondaryGraph().getNodes());
            hashSet5.removeAll(hashSet4);
            binDiffGraph.getSecondaryGraph().selectNodes(hashSet4, hashSet5);
            return;
        }
        finally {
            graphSettings.getProximitySettings().setProximityBrowsingFrozen(bl6);
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void synchronizeNodeVisibility(BinDiffGraph var0) {
        var1_1 = new HashSet<SuperDiffNode>();
        var2_2 = new HashSet<SuperDiffNode>();
        if (var0.getSettings().getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) ** GOTO lbl6
        var3_3 = var0.getCombinedGraph().getNodes().iterator();
        ** GOTO lbl11
lbl6: // 1 sources:
        if (var0.getSettings().getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) ** GOTO lbl42
        var3_4 = new HashSet<CombinedDiffNode>();
        var4_6 = new HashSet<CombinedDiffNode>();
        var5_7 = var0.getPrimaryGraph().getNodes().iterator();
        ** GOTO lbl19
lbl11: // 3 sources:
        while (var3_3.hasNext()) {
            var4_5 = (CombinedDiffNode)var3_3.next();
            if (var4_5.isVisible()) {
                var1_1.add(var4_5.getSuperDiffNode());
                continue;
            }
            var2_2.add(var4_5.getSuperDiffNode());
        }
        ** GOTO lbl42
lbl19: // 3 sources:
        while (var5_7.hasNext()) {
            var6_8 = (SingleDiffNode)var5_7.next();
            if (var6_8.isVisible()) {
                var1_1.add(var6_8.getSuperDiffNode());
                var3_4.add(var6_8.getCombinedDiffNode());
                continue;
            }
            var2_2.add(var6_8.getSuperDiffNode());
            var4_6.add(var6_8.getCombinedDiffNode());
        }
        for (SingleDiffNode var6_8 : var0.getSecondaryGraph().getNodes()) {
            if (var6_8.isVisible()) {
                var1_1.add(var6_8.getSuperDiffNode());
                var3_4.add(var6_8.getCombinedDiffNode());
                var7_9 = var6_8.getOtherSideDiffNode();
                if (var7_9 == null || var7_9.isVisible()) continue;
                var2_2.remove(var7_9.getSuperDiffNode());
                var4_6.remove(var6_8.getCombinedDiffNode());
                continue;
            }
            if (var1_1.contains(var6_8.getSuperDiffNode())) continue;
            var2_2.add(var6_8.getSuperDiffNode());
            var4_6.add(var6_8.getCombinedDiffNode());
        }
        var0.getCombinedGraph().showNodes(var3_4, var4_6, false);
lbl42: // 3 sources:
        var0.getSuperGraph().showNodes(var1_1, var2_2, false);
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        GraphProximityBrowsingSettings graphProximityBrowsingSettings = binDiffGraph.getSettings().getProximitySettings();
        if (graphProximityBrowsingSettings.getProximityBrowsing()) {
            if (binDiffGraph.getSettings().getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) {
                ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getCombinedGraph());
            }
            GraphReactivateViewSynchronization.synchronizeNodeSelection(binDiffGraph);
            GraphReactivateViewSynchronization.synchronizeNodeVisibility(binDiffGraph);
            ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
            ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
        } else {
            ProximityBrowserDeactivator.executeStatic(binDiffGraph);
        }
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (!LayoutCommandHelper.isAutolayout(binDiffGraph)) return;
        GraphLayoutUpdater.executeStatic(binDiffGraph, false);
    }
}

