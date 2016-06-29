/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityNodeClickedUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.c.q;

public class ProximityBrowserUnhideNode
implements ICommand {
    private final BinDiffGraph graph;
    private final ZyGraphNode nodeToShow;

    public ProximityBrowserUnhideNode(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.nodeToShow = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }

    private static void updateVisibility(BinDiffGraph binDiffGraph, Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            q q2;
            q q3;
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode.isVisible()) continue;
            if (zyGraphNode instanceof SingleDiffNode) {
                q3 = ((SingleDiffNode)zyGraphNode).getCombinedDiffNode().getNode();
                q2 = ((SingleDiffNode)zyGraphNode).getSuperDiffNode().getNode();
                if (!((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(q3)).getRawNode().isVisible()) {
                    ((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(q3)).getRawNode().setVisible(true);
                }
                if (((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(q2)).getRawNode().isVisible()) continue;
                ((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(q2)).getRawNode().setVisible(true);
                continue;
            }
            if (!(zyGraphNode instanceof CombinedDiffNode)) continue;
            q3 = ((CombinedDiffNode)zyGraphNode).getNode();
            q2 = ((CombinedDiffNode)zyGraphNode).getSuperDiffNode().getNode();
            if (!((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(q3)).getRawNode().isVisible()) {
                ((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(q3)).getRawNode().setVisible(true);
            }
            if (((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(q2)).getRawNode().isVisible()) continue;
            ((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(q2)).getRawNode().setVisible(true);
        }
    }

    public static void executeStatic(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        HashSet<ZyGraphNode> hashSet = new HashSet<ZyGraphNode>();
        hashSet.add(zyGraphNode);
        GraphProximityBrowsingSettings graphProximityBrowsingSettings = binDiffGraph.getSettings().getProximitySettings();
        Set set = ProximityRangeCalculator.getNeighbors(binDiffGraph, hashSet, graphProximityBrowsingSettings.getProximityBrowsingChildren(), graphProximityBrowsingSettings.getProximityBrowsingParents());
        ProximityBrowserUnhideNode.updateVisibility(binDiffGraph, set);
        ProximityNodeClickedUpdater.updateProximityNodes(binDiffGraph);
        GraphViewUpdater.updateViews(binDiffGraph);
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (!LayoutCommandHelper.isAutolayout(binDiffGraph)) return;
        GraphLayoutUpdater.executeStatic(binDiffGraph, true);
    }

    @Override
    public void execute() {
        ProximityBrowserUnhideNode.executeStatic(this.graph, this.nodeToShow);
    }
}

