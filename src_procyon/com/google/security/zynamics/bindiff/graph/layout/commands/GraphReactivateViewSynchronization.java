package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.layout.*;

public class GraphReactivateViewSynchronization
{
    private static void synchronizeNodeSelection(final BinDiffGraph binDiffGraph) {
        final HashSet<SuperDiffNode> set = new HashSet<SuperDiffNode>();
        final HashSet<CombinedDiffNode> set2 = new HashSet<CombinedDiffNode>();
        final HashSet<SingleDiffNode> set3 = new HashSet<SingleDiffNode>();
        final HashSet<SingleDiffNode> set4 = new HashSet<SingleDiffNode>();
        final GraphSettings settings = binDiffGraph.getSettings();
        for (final CombinedDiffNode combinedDiffNode : binDiffGraph.getCombinedGraph().getNodes()) {
            final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
            final SingleDiffNode secondaryDiffNode = combinedDiffNode.getSecondaryDiffNode();
            final boolean b = primaryDiffNode != null && primaryDiffNode.isSelected();
            final boolean b2 = secondaryDiffNode != null && secondaryDiffNode.isSelected();
            if ((settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && (b || b2)) || (settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW && combinedDiffNode.isSelected())) {
                if (primaryDiffNode != null) {
                    set3.add(primaryDiffNode);
                }
                if (secondaryDiffNode != null) {
                    set4.add(secondaryDiffNode);
                }
                set.add(combinedDiffNode.getSuperDiffNode());
                set2.add(combinedDiffNode);
            }
        }
        final boolean proximityBrowsingFrozen = settings.getProximitySettings().getProximityBrowsingFrozen();
        try {
            settings.getProximitySettings().setProximityBrowsingFrozen(true);
            final HashSet set5 = new HashSet();
            set5.addAll(binDiffGraph.getCombinedGraph().getNodes());
            set5.removeAll(set2);
            binDiffGraph.getCombinedGraph().selectNodes(set2, set5);
            final HashSet set6 = new HashSet();
            set6.addAll(binDiffGraph.getSuperGraph().getNodes());
            set6.removeAll(set);
            binDiffGraph.getSuperGraph().selectNodes(set, set6);
            final HashSet set7 = new HashSet();
            set7.addAll(binDiffGraph.getPrimaryGraph().getNodes());
            set7.removeAll(set3);
            binDiffGraph.getPrimaryGraph().selectNodes(set3, set7);
            final HashSet set8 = new HashSet();
            set8.addAll(binDiffGraph.getSecondaryGraph().getNodes());
            set8.removeAll(set4);
            binDiffGraph.getSecondaryGraph().selectNodes(set4, set8);
        }
        finally {
            settings.getProximitySettings().setProximityBrowsingFrozen(proximityBrowsingFrozen);
        }
    }
    
    private static void synchronizeNodeVisibility(final BinDiffGraph binDiffGraph) {
        final HashSet<SuperDiffNode> set = new HashSet<SuperDiffNode>();
        final HashSet<SuperDiffNode> set2 = new HashSet<SuperDiffNode>();
        if (binDiffGraph.getSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            for (final CombinedDiffNode combinedDiffNode : binDiffGraph.getCombinedGraph().getNodes()) {
                if (combinedDiffNode.isVisible()) {
                    set.add(combinedDiffNode.getSuperDiffNode());
                }
                else {
                    set2.add(combinedDiffNode.getSuperDiffNode());
                }
            }
        }
        else if (binDiffGraph.getSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            final HashSet<CombinedDiffNode> set3 = new HashSet<CombinedDiffNode>();
            final HashSet<CombinedDiffNode> set4 = new HashSet<CombinedDiffNode>();
            for (final SingleDiffNode singleDiffNode : binDiffGraph.getPrimaryGraph().getNodes()) {
                if (singleDiffNode.isVisible()) {
                    set.add(singleDiffNode.getSuperDiffNode());
                    set3.add(singleDiffNode.getCombinedDiffNode());
                }
                else {
                    set2.add(singleDiffNode.getSuperDiffNode());
                    set4.add(singleDiffNode.getCombinedDiffNode());
                }
            }
            for (final SingleDiffNode singleDiffNode2 : binDiffGraph.getSecondaryGraph().getNodes()) {
                if (singleDiffNode2.isVisible()) {
                    set.add(singleDiffNode2.getSuperDiffNode());
                    set3.add(singleDiffNode2.getCombinedDiffNode());
                    final SingleDiffNode otherSideDiffNode = singleDiffNode2.getOtherSideDiffNode();
                    if (otherSideDiffNode == null || otherSideDiffNode.isVisible()) {
                        continue;
                    }
                    set2.remove(otherSideDiffNode.getSuperDiffNode());
                    set4.remove(singleDiffNode2.getCombinedDiffNode());
                }
                else {
                    if (set.contains(singleDiffNode2.getSuperDiffNode())) {
                        continue;
                    }
                    set2.add(singleDiffNode2.getSuperDiffNode());
                    set4.add(singleDiffNode2.getCombinedDiffNode());
                }
            }
            binDiffGraph.getCombinedGraph().showNodes(set3, set4, false);
        }
        binDiffGraph.getSuperGraph().showNodes(set, set2, false);
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing()) {
            if (binDiffGraph.getSettings().getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) {
                ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getCombinedGraph());
            }
            synchronizeNodeSelection(binDiffGraph);
            synchronizeNodeVisibility(binDiffGraph);
            ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
            ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
        }
        else {
            ProximityBrowserDeactivator.executeStatic(binDiffGraph);
        }
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (LayoutCommandHelper.isAutolayout(binDiffGraph)) {
            GraphLayoutUpdater.executeStatic(binDiffGraph, false);
        }
    }
}
