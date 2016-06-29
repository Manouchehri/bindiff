/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserInitializer;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.types.common.ICommand;

public class GraphLayoutInitializer
implements ICommand {
    private final BinDiffGraph graph;

    public GraphLayoutInitializer(BinDiffGraph binDiffGraph) {
        Preconditions.checkNotNull(binDiffGraph);
        this.graph = binDiffGraph;
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        GraphLayoutSettings graphLayoutSettings = binDiffGraph.getSettings().getLayoutSettings();
        boolean bl2 = graphLayoutSettings.getAnimateLayout();
        graphLayoutSettings.setAnimateLayout(false);
        try {
            ProximityBrowserInitializer.executeStatic(binDiffGraph);
            if (!LayoutCommandHelper.isAutolayout(binDiffGraph)) return;
            GraphLayoutUpdater.executeStatic(binDiffGraph, false);
            return;
        }
        finally {
            graphLayoutSettings.setAnimateLayout(bl2);
        }
    }

    @Override
    public void execute() {
        GraphLayoutInitializer.executeStatic(this.graph);
    }
}

