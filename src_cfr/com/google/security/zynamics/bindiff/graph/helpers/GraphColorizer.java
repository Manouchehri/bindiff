/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GraphColorizer {
    private static final LinkedHashSet recentColors = new LinkedHashSet();

    public static void colorizeInvisibleNodes(BinDiffGraph binDiffGraph, Color color) {
        Iterator iterator = binDiffGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode.isVisible()) continue;
            zyGraphNode.getRawNode().setColor(color);
        }
    }

    public static void colorizeSelectedNodes(BinDiffGraph binDiffGraph, Color color) {
        Iterator iterator = binDiffGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            zyGraphNode.getRawNode().setColor(color);
        }
    }

    public static void colorizeUnselectedNodes(BinDiffGraph binDiffGraph, Color color) {
        Iterator iterator = binDiffGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode.isSelected()) continue;
            zyGraphNode.getRawNode().setColor(color);
        }
    }

    public static List getRecentColors() {
        return new ArrayList(recentColors);
    }

    public static void setRecentColors(List list) {
        recentColors.clear();
        recentColors.addAll(list);
    }
}

