package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;

public class GraphColorizer
{
    private static final LinkedHashSet recentColors;
    
    public static void colorizeInvisibleNodes(final BinDiffGraph binDiffGraph, final Color color) {
        for (final ZyGraphNode zyGraphNode : binDiffGraph.getNodes()) {
            if (!zyGraphNode.isVisible()) {
                zyGraphNode.getRawNode().setColor(color);
            }
        }
    }
    
    public static void colorizeSelectedNodes(final BinDiffGraph binDiffGraph, final Color color) {
        final Iterator<ZyGraphNode> iterator = binDiffGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            iterator.next().getRawNode().setColor(color);
        }
    }
    
    public static void colorizeUnselectedNodes(final BinDiffGraph binDiffGraph, final Color color) {
        for (final ZyGraphNode zyGraphNode : binDiffGraph.getNodes()) {
            if (!zyGraphNode.isSelected()) {
                zyGraphNode.getRawNode().setColor(color);
            }
        }
    }
    
    public static List getRecentColors() {
        return new ArrayList(GraphColorizer.recentColors);
    }
    
    public static void setRecentColors(final List list) {
        GraphColorizer.recentColors.clear();
        GraphColorizer.recentColors.addAll(list);
    }
    
    static {
        recentColors = new LinkedHashSet();
    }
}
