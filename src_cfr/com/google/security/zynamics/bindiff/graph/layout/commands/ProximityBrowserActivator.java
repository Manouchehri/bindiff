/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.types.common.ICommand;

public class ProximityBrowserActivator
implements ICommand {
    private final BinDiffGraph graph;

    public ProximityBrowserActivator(BinDiffGraph binDiffGraph) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        binDiffGraph.getCombinedGraph().getProximityBrowser().freeProximitySettingsListener();
        binDiffGraph.getSuperGraph().getProximityBrowser().freeProximitySettingsListener();
        try {
            binDiffGraph.getSettings().getProximitySettings().setProximityBrowsing(true);
        }
        finally {
            binDiffGraph.getSuperGraph().getProximityBrowser().blockProximitySettingsListener();
            binDiffGraph.getCombinedGraph().getProximityBrowser().blockProximitySettingsListener();
        }
        if (LayoutCommandHelper.isProximityBrowsingFrozen(binDiffGraph)) return;
        if (LayoutCommandHelper.hasSelectedNodes(binDiffGraph)) {
            ProximityBrowserUpdater.executeStatic(binDiffGraph);
            if (binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting() && !binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
                GraphLayoutUpdater.executeStatic(binDiffGraph, true);
            }
        }
        GraphViewUpdater.updateViews(binDiffGraph);
    }

    @Override
    public void execute() {
        ProximityBrowserActivator.executeStatic(this.graph);
    }
}

