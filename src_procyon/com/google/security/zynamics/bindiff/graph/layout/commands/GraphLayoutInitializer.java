package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

public class GraphLayoutInitializer implements ICommand
{
    private final BinDiffGraph graph;
    
    public GraphLayoutInitializer(final BinDiffGraph graph) {
        Preconditions.checkNotNull(graph);
        this.graph = graph;
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        final GraphLayoutSettings layoutSettings = binDiffGraph.getSettings().getLayoutSettings();
        final boolean animateLayout = layoutSettings.getAnimateLayout();
        layoutSettings.setAnimateLayout(false);
        try {
            ProximityBrowserInitializer.executeStatic(binDiffGraph);
            if (LayoutCommandHelper.isAutolayout(binDiffGraph)) {
                GraphLayoutUpdater.executeStatic(binDiffGraph, false);
            }
        }
        finally {
            layoutSettings.setAnimateLayout(animateLayout);
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.graph);
    }
}
