/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphEdgeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.util.Collection;
import java.util.Iterator;

public class ProximityBrowserDeactivator
implements ICommand {
    private final BinDiffGraph graph;

    public ProximityBrowserDeactivator(BinDiffGraph binDiffGraph) {
        Preconditions.checkNotNull(binDiffGraph);
        this.graph = binDiffGraph;
    }

    private static boolean hasHiddenNodes(BinDiffGraph binDiffGraph) {
        if (GraphNodeFilter.filterNodesCountOnly(binDiffGraph, GraphNodeFilter$Criterium.INVISIBLE) <= 0) return false;
        return true;
    }

    private static boolean showAllNodesVisibilityWarningDialog(BinDiffGraph binDiffGraph) {
        int n2 = GraphEdgeFilter.filterInvisibleEdges(binDiffGraph).size();
        int n3 = GraphNodeFilter.filterNodesCountOnly(binDiffGraph, GraphNodeFilter$Criterium.INVISIBLE);
        int n4 = binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold();
        if (n2 < n4) return true;
        int n5 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes with %d edges visible. Do you want to continue?", n3, n2));
        if (n5 != 0) return false;
        return true;
    }

    private static void unhideAll(BinDiffGraph binDiffGraph) {
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
        Iterator iterator = binDiffGraph.getSuperGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
                GraphViewUpdater.updateViews(binDiffGraph);
                return;
            }
            SuperDiffNode superDiffNode = (SuperDiffNode)iterator.next();
            superDiffNode.getRawNode().setVisible(true);
            superDiffNode.getCombinedRawNode().setVisible(true);
        } while (true);
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        if (!ProximityBrowserDeactivator.hasHiddenNodes(binDiffGraph)) {
            return;
        }
        if (!ProximityBrowserDeactivator.showAllNodesVisibilityWarningDialog(binDiffGraph)) {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(true);
            return;
        }
        binDiffGraph.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
        binDiffGraph.getSuperGraph().getProximityBrowser().deleteProximityNodes();
        ProximityBrowserDeactivator.unhideAll(binDiffGraph);
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting()) {
            GraphLayoutUpdater.executeStatic(binDiffGraph, true);
        }
        GraphViewUpdater.updateViews(binDiffGraph);
    }

    @Override
    public void execute() {
        ProximityBrowserDeactivator.executeStatic(this.graph);
    }
}

