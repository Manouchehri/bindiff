package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.layout.*;

public class ProximityBrowserActivator implements ICommand
{
    private final BinDiffGraph graph;
    
    public ProximityBrowserActivator(final BinDiffGraph binDiffGraph) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        binDiffGraph.getCombinedGraph().getProximityBrowser().freeProximitySettingsListener();
        binDiffGraph.getSuperGraph().getProximityBrowser().freeProximitySettingsListener();
        try {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(true);
        }
        finally {
            binDiffGraph.getSuperGraph().getProximityBrowser().blockProximitySettingsListener();
            binDiffGraph.getCombinedGraph().getProximityBrowser().blockProximitySettingsListener();
        }
        if (!LayoutCommandHelper.isProximityBrowsingFrozen(binDiffGraph)) {
            if (LayoutCommandHelper.hasSelectedNodes(binDiffGraph)) {
                ProximityBrowserUpdater.executeStatic(binDiffGraph);
                if (binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting() && !binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
                    GraphLayoutUpdater.executeStatic(binDiffGraph, true);
                }
            }
            GraphViewUpdater.updateViews(binDiffGraph);
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.graph);
    }
}
