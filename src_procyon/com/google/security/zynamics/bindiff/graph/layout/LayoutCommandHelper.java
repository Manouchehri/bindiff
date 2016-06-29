package com.google.security.zynamics.bindiff.graph.layout;

import com.google.security.zynamics.bindiff.graph.*;

public class LayoutCommandHelper
{
    public static void activateAutoLayout(final BinDiffGraph binDiffGraph, final boolean automaticLayouting) {
        binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(automaticLayouting);
    }
    
    public static boolean deactiveAutoLayout(final BinDiffGraph binDiffGraph) {
        final boolean autolayout = isAutolayout(binDiffGraph);
        binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(false);
        return autolayout;
    }
    
    public static boolean hasSelectedNodes(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            return binDiffGraph.getSuperGraph().getSelectedNodes().size() > 0;
        }
        return binDiffGraph.getSelectedNodes().size() > 0;
    }
    
    public static boolean isAutolayout(final BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting();
    }
    
    public static boolean isProximityBrowsing(final BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getProximitySettings().getProximityBrowsing();
    }
    
    public static boolean isProximityBrowsingFrozen(final BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingFrozen();
    }
    
    public static boolean isSnychron(final BinDiffGraph binDiffGraph) {
        return binDiffGraph.getSettings().isSync();
    }
}
