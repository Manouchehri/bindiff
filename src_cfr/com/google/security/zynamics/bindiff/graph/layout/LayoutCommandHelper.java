/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import java.util.Set;

public class LayoutCommandHelper {
    public static void activateAutoLayout(BinDiffGraph binDiffGraph, boolean bl2) {
        binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(bl2);
    }

    public static boolean deactiveAutoLayout(BinDiffGraph binDiffGraph) {
        boolean bl2 = LayoutCommandHelper.isAutolayout(binDiffGraph);
        binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(false);
        return bl2;
    }

    public static boolean hasSelectedNodes(BinDiffGraph binDiffGraph) {
        GraphSettings graphSettings = binDiffGraph.getSettings();
        if (graphSettings.isSync()) {
            if (binDiffGraph.getSuperGraph().getSelectedNodes().size() <= 0) return false;
            return true;
        }
        if (binDiffGraph.getSelectedNodes().size() <= 0) return false;
        return true;
    }

    public static boolean isAutolayout(BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting();
    }

    public static boolean isProximityBrowsing(BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing();
    }

    public static boolean isProximityBrowsingFrozen(BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
    }

    public static boolean isSnychron(BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().isSync();
    }
}

