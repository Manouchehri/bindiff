package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;

public class ProximityBrowserDeactivator implements ICommand
{
    private final BinDiffGraph graph;
    
    public ProximityBrowserDeactivator(final BinDiffGraph graph) {
        Preconditions.checkNotNull(graph);
        this.graph = graph;
    }
    
    private static boolean hasHiddenNodes(final BinDiffGraph binDiffGraph) {
        return GraphNodeFilter.filterNodesCountOnly(binDiffGraph, GraphNodeFilter$Criterium.INVISIBLE) > 0;
    }
    
    private static boolean showAllNodesVisibilityWarningDialog(final BinDiffGraph binDiffGraph) {
        final int size = GraphEdgeFilter.filterInvisibleEdges(binDiffGraph).size();
        final int filterNodesCountOnly = GraphNodeFilter.filterNodesCountOnly(binDiffGraph, GraphNodeFilter$Criterium.INVISIBLE);
        return size < binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold() || CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes with %d edges visible. Do you want to continue?", filterNodesCountOnly, size)) == 0;
    }
    
    private static void unhideAll(final BinDiffGraph binDiffGraph) {
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
        for (final SuperDiffNode superDiffNode : binDiffGraph.getSuperGraph().getNodes()) {
            superDiffNode.getRawNode().setVisible(true);
            superDiffNode.getCombinedRawNode().setVisible(true);
        }
        ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
        GraphViewUpdater.updateViews(binDiffGraph);
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        if (!hasHiddenNodes(binDiffGraph)) {
            return;
        }
        if (showAllNodesVisibilityWarningDialog(binDiffGraph)) {
            binDiffGraph.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
            binDiffGraph.getSuperGraph().getProximityBrowser().deleteProximityNodes();
            unhideAll(binDiffGraph);
            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
            if (binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting()) {
                GraphLayoutUpdater.executeStatic(binDiffGraph, true);
            }
            GraphViewUpdater.updateViews(binDiffGraph);
        }
        else {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(true);
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.graph);
    }
}
