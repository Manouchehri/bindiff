package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;

public class GraphSelector
{
    private static void deselectNodes(final BinDiffGraph binDiffGraph, final Collection collection) {
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        set.addAll(binDiffGraph.getSelectedNodes());
        final boolean b = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing() && binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        for (final ZyGraphNode zyGraphNode : collection) {
            if (zyGraphNode.isVisible() || !b) {
                set.remove(zyGraphNode);
            }
        }
        set2.addAll(binDiffGraph.getNodes());
        set2.removeAll(set);
        binDiffGraph.selectNodes(set, set2);
    }
    
    private static Set getSelectedLeafNodes(final CombinedGraph combinedGraph) {
        final HashSet<CombinedDiffNode> set = new HashSet<CombinedDiffNode>();
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getSelectedNodes()) {
            boolean b = false;
            final Iterator iterator2 = GraphAlgorithms.getSuccessors(combinedDiffNode.getRawNode(), 1).iterator();
            while (iterator2.hasNext()) {
                if (iterator2.next().isSelected()) {
                    b = true;
                }
            }
            if (!b) {
                set.add(combinedDiffNode);
            }
        }
        return set;
    }
    
    private static Collection getSelectedLeafNodes(final SingleGraph singleGraph) {
        final HashSet<SingleDiffNode> set = new HashSet<SingleDiffNode>();
        for (final SingleDiffNode singleDiffNode : singleGraph.getSelectedNodes()) {
            boolean b = false;
            final Iterator iterator2 = GraphAlgorithms.getSuccessors(singleDiffNode.getRawNode(), 1).iterator();
            while (iterator2.hasNext()) {
                if (iterator2.next().isSelected()) {
                    b = true;
                }
            }
            if (!b) {
                set.add(singleDiffNode);
            }
        }
        return set;
    }
    
    private static Set getSelectedRootNodes(final CombinedGraph combinedGraph) {
        final HashSet<CombinedDiffNode> set = new HashSet<CombinedDiffNode>();
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getSelectedNodes()) {
            boolean b = false;
            final Iterator iterator2 = GraphAlgorithms.getPredecessors(combinedDiffNode.getRawNode(), 1).iterator();
            while (iterator2.hasNext()) {
                if (iterator2.next().isSelected()) {
                    b = true;
                }
            }
            if (!b) {
                set.add(combinedDiffNode);
            }
        }
        return set;
    }
    
    private static Set getSelectedRootNodes(final SingleGraph singleGraph) {
        final HashSet<SingleDiffNode> set = new HashSet<SingleDiffNode>();
        for (final SingleDiffNode singleDiffNode : singleGraph.getSelectedNodes()) {
            boolean b = false;
            final Iterator iterator2 = GraphAlgorithms.getPredecessors(singleDiffNode.getRawNode(), 1).iterator();
            while (iterator2.hasNext()) {
                if (iterator2.next().isSelected()) {
                    b = true;
                }
            }
            if (!b) {
                set.add(singleDiffNode);
            }
        }
        return set;
    }
    
    private static void selectNodes(final BinDiffGraph binDiffGraph, final Collection collection) {
        final HashSet<Object> set = new HashSet<Object>();
        final HashSet set2 = new HashSet();
        set2.addAll(binDiffGraph.getNodes());
        set.addAll(binDiffGraph.getSelectedNodes());
        final boolean b = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing() && binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        for (final ZyGraphNode zyGraphNode : collection) {
            if (zyGraphNode.isVisible() || !b) {
                set.add(zyGraphNode);
            }
        }
        set2.removeAll(set);
        binDiffGraph.selectNodes(set, set2);
    }
    
    public static void deselectLeafs(final CombinedGraph combinedGraph) {
        deselectNodes(combinedGraph, getSelectedLeafNodes(combinedGraph));
    }
    
    public static void deselectLeafs(final SingleGraph singleGraph) {
        deselectNodes(singleGraph, getSelectedLeafNodes(singleGraph));
    }
    
    public static void deselectPeriphery(final CombinedGraph combinedGraph) {
        final Set selectedRootNodes = getSelectedRootNodes(combinedGraph);
        selectedRootNodes.addAll(getSelectedLeafNodes(combinedGraph));
        deselectNodes(combinedGraph, selectedRootNodes);
    }
    
    public static void deselectPeriphery(final SingleGraph singleGraph) {
        final Set selectedRootNodes = getSelectedRootNodes(singleGraph);
        selectedRootNodes.addAll(getSelectedLeafNodes(singleGraph));
        deselectNodes(singleGraph, selectedRootNodes);
    }
    
    public static void deselectRoots(final CombinedGraph combinedGraph) {
        deselectNodes(combinedGraph, getSelectedRootNodes(combinedGraph));
    }
    
    public static void deselectRoots(final SingleGraph singleGraph) {
        deselectNodes(singleGraph, getSelectedRootNodes(singleGraph));
    }
    
    public static void invertSelection(final CombinedGraph combinedGraph) {
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final boolean b = combinedGraph.getSettings().getProximitySettings().getProximityBrowsing() && combinedGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
            if (b && !combinedDiffNode.isVisible()) {
                continue;
            }
            if (combinedDiffNode.isSelected()) {
                list2.add(combinedDiffNode);
            }
            else {
                list.add(combinedDiffNode);
            }
        }
        combinedGraph.selectNodes(list, list2);
    }
    
    public static void invertSelection(final SingleGraph singleGraph) {
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final boolean b = singleGraph.getSettings().getProximitySettings().getProximityBrowsing() && singleGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
        for (final SingleDiffNode singleDiffNode : singleGraph.getNodes()) {
            if (b && !singleDiffNode.isVisible()) {
                continue;
            }
            if (singleDiffNode.isSelected()) {
                list2.add(singleDiffNode);
            }
            else {
                list.add(singleDiffNode);
            }
        }
        singleGraph.selectNodes(list, list2);
    }
    
    public static void selectAncestorsOfSelection(final CombinedGraph combinedGraph) {
        selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(GraphConverters.convert(combinedGraph.getSelectedNodes()))));
    }
    
    public static void selectAncestorsOfSelection(final SingleGraph singleGraph) {
        selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(GraphConverters.convert(singleGraph.getSelectedNodes()))));
    }
    
    public static void selectChildrenOfSelection(final CombinedGraph combinedGraph) {
        selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(GraphConverters.convert(combinedGraph.getSelectedNodes()), 1)));
    }
    
    public static void selectChildrenOfSelection(final SingleGraph singleGraph) {
        selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(GraphConverters.convert(singleGraph.getSelectedNodes()), 1)));
    }
    
    public static void selectNeighboursOfSelection(final CombinedGraph combinedGraph) {
        final List convert = GraphConverters.convert(combinedGraph.getSelectedNodes());
        final HashSet set = new HashSet();
        set.addAll(GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(convert, 1)));
        set.addAll(GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(convert, 1)));
        selectNodes(combinedGraph, set);
    }
    
    public static void selectNeighboursOfSelection(final SingleGraph singleGraph) {
        final List convert = GraphConverters.convert(singleGraph.getSelectedNodes());
        final HashSet set = new HashSet();
        set.addAll(GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(convert, 1)));
        set.addAll(GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(convert, 1)));
        selectNodes(singleGraph, set);
    }
    
    public static void selectParentsOfSelection(final CombinedGraph combinedGraph) {
        selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getPredecessors(GraphConverters.convert(combinedGraph.getSelectedNodes()), 1)));
    }
    
    public static void selectParentsOfSelection(final SingleGraph singleGraph) {
        selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getPredecessors(GraphConverters.convert(singleGraph.getSelectedNodes()), 1)));
    }
    
    public static void selectSuccessorsOfSelection(final CombinedGraph combinedGraph) {
        selectNodes(combinedGraph, GraphConverters.convert(combinedGraph, GraphAlgorithms.getSuccessors(GraphConverters.convert(combinedGraph.getSelectedNodes()))));
    }
    
    public static void selectSuccessorsOfSelection(final SingleGraph singleGraph) {
        selectNodes(singleGraph, GraphConverters.convert(singleGraph, GraphAlgorithms.getSuccessors(GraphConverters.convert(singleGraph.getSelectedNodes()))));
    }
}
