/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GraphSelector {
    private static void deselectNodes(BinDiffGraph binDiffGraph, Collection collection) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.addAll(binDiffGraph.getSelectedNodes());
        boolean bl2 = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing() && binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                hashSet2.addAll(binDiffGraph.getNodes());
                hashSet2.removeAll(hashSet);
                binDiffGraph.selectNodes(hashSet, hashSet2);
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!zyGraphNode.isVisible() && bl2) continue;
            hashSet.remove(zyGraphNode);
        } while (true);
    }

    private static Set getSelectedLeafNodes(CombinedGraph combinedGraph) {
        HashSet<CombinedDiffNode> hashSet = new HashSet<CombinedDiffNode>();
        Iterator iterator = combinedGraph.getSelectedNodes().iterator();
        block0 : while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            boolean bl2 = false;
            Iterator iterator2 = GraphAlgorithms.getSuccessors(combinedDiffNode.getRawNode(), 1).iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                CombinedViewNode combinedViewNode = (CombinedViewNode)iterator2.next();
                if (!combinedViewNode.isSelected()) continue;
                bl2 = true;
            } while (true);
            break;
        }
        return hashSet;
    }

    private static Collection getSelectedLeafNodes(SingleGraph singleGraph) {
        HashSet<SingleDiffNode> hashSet = new HashSet<SingleDiffNode>();
        Iterator iterator = singleGraph.getSelectedNodes().iterator();
        block0 : while (iterator.hasNext()) {
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            boolean bl2 = false;
            Iterator iterator2 = GraphAlgorithms.getSuccessors(singleDiffNode.getRawNode(), 1).iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                SingleViewNode singleViewNode = (SingleViewNode)iterator2.next();
                if (!singleViewNode.isSelected()) continue;
                bl2 = true;
            } while (true);
            break;
        }
        return hashSet;
    }

    private static Set getSelectedRootNodes(CombinedGraph combinedGraph) {
        HashSet<CombinedDiffNode> hashSet = new HashSet<CombinedDiffNode>();
        Iterator iterator = combinedGraph.getSelectedNodes().iterator();
        block0 : while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            boolean bl2 = false;
            Iterator iterator2 = GraphAlgorithms.getPredecessors(combinedDiffNode.getRawNode(), 1).iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                CombinedViewNode combinedViewNode = (CombinedViewNode)iterator2.next();
                if (!combinedViewNode.isSelected()) continue;
                bl2 = true;
            } while (true);
            break;
        }
        return hashSet;
    }

    private static Set getSelectedRootNodes(SingleGraph singleGraph) {
        HashSet<SingleDiffNode> hashSet = new HashSet<SingleDiffNode>();
        Iterator iterator = singleGraph.getSelectedNodes().iterator();
        block0 : while (iterator.hasNext()) {
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            boolean bl2 = false;
            Iterator iterator2 = GraphAlgorithms.getPredecessors(singleDiffNode.getRawNode(), 1).iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                SingleViewNode singleViewNode = (SingleViewNode)iterator2.next();
                if (!singleViewNode.isSelected()) continue;
                bl2 = true;
            } while (true);
            break;
        }
        return hashSet;
    }

    private static void selectNodes(BinDiffGraph binDiffGraph, Collection collection) {
        HashSet<ZyGraphNode> hashSet = new HashSet<ZyGraphNode>();
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(binDiffGraph.getNodes());
        hashSet.addAll(binDiffGraph.getSelectedNodes());
        boolean bl2 = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing() && binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                hashSet2.removeAll(hashSet);
                binDiffGraph.selectNodes(hashSet, hashSet2);
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!zyGraphNode.isVisible() && bl2) continue;
            hashSet.add(zyGraphNode);
        } while (true);
    }

    public static void deselectLeafs(CombinedGraph combinedGraph) {
        GraphSelector.deselectNodes(combinedGraph, GraphSelector.getSelectedLeafNodes(combinedGraph));
    }

    public static void deselectLeafs(SingleGraph singleGraph) {
        GraphSelector.deselectNodes(singleGraph, GraphSelector.getSelectedLeafNodes(singleGraph));
    }

    public static void deselectPeriphery(CombinedGraph combinedGraph) {
        Set set = GraphSelector.getSelectedRootNodes(combinedGraph);
        set.addAll(GraphSelector.getSelectedLeafNodes(combinedGraph));
        GraphSelector.deselectNodes(combinedGraph, set);
    }

    public static void deselectPeriphery(SingleGraph singleGraph) {
        Set set = GraphSelector.getSelectedRootNodes(singleGraph);
        set.addAll(GraphSelector.getSelectedLeafNodes(singleGraph));
        GraphSelector.deselectNodes(singleGraph, set);
    }

    public static void deselectRoots(CombinedGraph combinedGraph) {
        GraphSelector.deselectNodes(combinedGraph, GraphSelector.getSelectedRootNodes(combinedGraph));
    }

    public static void deselectRoots(SingleGraph singleGraph) {
        GraphSelector.deselectNodes(singleGraph, GraphSelector.getSelectedRootNodes(singleGraph));
    }

    public static void invertSelection(CombinedGraph combinedGraph) {
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        boolean bl2 = combinedGraph.getSettings().getProximitySettings().getProximityBrowsing() && combinedGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        Iterator iterator = combinedGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                combinedGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            if (bl2 && !combinedDiffNode.isVisible()) continue;
            if (combinedDiffNode.isSelected()) {
                arrayList2.add(combinedDiffNode);
                continue;
            }
            arrayList.add(combinedDiffNode);
        } while (true);
    }

    public static void invertSelection(SingleGraph singleGraph) {
        ArrayList<SingleDiffNode> arrayList = new ArrayList<SingleDiffNode>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        boolean bl2 = singleGraph.getSettings().getProximitySettings().getProximityBrowsing() && singleGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        Iterator iterator = singleGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                singleGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            if (bl2 && !singleDiffNode.isVisible()) continue;
            if (singleDiffNode.isSelected()) {
                arrayList2.add(singleDiffNode);
                continue;
            }
            arrayList.add(singleDiffNode);
        } while (true);
    }

    public static void selectAncestorsOfSelection(CombinedGraph combinedGraph) {
        List list = GraphConverters.convert(combinedGraph.getSelectedNodes());
        GraphSelector.selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(list)));
    }

    public static void selectAncestorsOfSelection(SingleGraph singleGraph) {
        List list = GraphConverters.convert(singleGraph.getSelectedNodes());
        GraphSelector.selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(list)));
    }

    public static void selectChildrenOfSelection(CombinedGraph combinedGraph) {
        List list = GraphConverters.convert(combinedGraph.getSelectedNodes());
        GraphSelector.selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(list, 1)));
    }

    public static void selectChildrenOfSelection(SingleGraph singleGraph) {
        List list = GraphConverters.convert(singleGraph.getSelectedNodes());
        GraphSelector.selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(list, 1)));
    }

    public static void selectNeighboursOfSelection(CombinedGraph combinedGraph) {
        List list = GraphConverters.convert(combinedGraph.getSelectedNodes());
        HashSet hashSet = new HashSet();
        hashSet.addAll(GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(list, 1)));
        hashSet.addAll(GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(list, 1)));
        GraphSelector.selectNodes(combinedGraph, hashSet);
    }

    public static void selectNeighboursOfSelection(SingleGraph singleGraph) {
        List list = GraphConverters.convert(singleGraph.getSelectedNodes());
        HashSet hashSet = new HashSet();
        hashSet.addAll(GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(list, 1)));
        hashSet.addAll(GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(list, 1)));
        GraphSelector.selectNodes(singleGraph, hashSet);
    }

    public static void selectParentsOfSelection(CombinedGraph combinedGraph) {
        List list = GraphConverters.convert(combinedGraph.getSelectedNodes());
        GraphSelector.selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(list, 1)));
    }

    public static void selectParentsOfSelection(SingleGraph singleGraph) {
        List list = GraphConverters.convert(singleGraph.getSelectedNodes());
        GraphSelector.selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(list, 1)));
    }

    public static void selectSuccessorsOfSelection(CombinedGraph combinedGraph) {
        List list = GraphConverters.convert(combinedGraph.getSelectedNodes());
        GraphSelector.selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(list)));
    }

    public static void selectSuccessorsOfSelection(SingleGraph singleGraph) {
        List list = GraphConverters.convert(singleGraph.getSelectedNodes());
        GraphSelector.selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(list)));
    }
}

