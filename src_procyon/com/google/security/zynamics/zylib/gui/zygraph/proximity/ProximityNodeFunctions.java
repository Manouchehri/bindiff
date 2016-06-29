package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.types.graphs.*;

public abstract class ProximityNodeFunctions
{
    private Collection filterVisibleNodes(final Collection collection) {
        return CollectionHelpers.filter(collection, new ProximityNodeFunctions$1(this));
    }
    
    private Collection getNeighborhood(final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final List list = zyProximityNode.isIncoming() ? ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getChildren() : ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getParents();
        final LinkedHashSet<IGroupNode> set = new LinkedHashSet<IGroupNode>();
        for (final IViewNode viewNode : list) {
            if (viewNode.isVisible()) {
                continue;
            }
            if (viewNode.getParentGroup() != null) {
                set.add(viewNode.getParentGroup());
                set.add((IGroupNode)viewNode);
            }
            else {
                set.add((IGroupNode)viewNode);
            }
        }
        for (final IViewNode viewNode2 : new ArrayList<IViewNode>(set)) {
            if (zyProximityNode.isIncoming()) {
                for (final IViewNode viewNode3 : ((IGraphNode)viewNode2).getParents()) {
                    if (viewNode3 instanceof ITextNode) {
                        set.add((IGroupNode)viewNode3);
                    }
                }
            }
            else {
                for (final IViewNode viewNode4 : ((IGraphNode)viewNode2).getChildren()) {
                    if (viewNode4 instanceof ITextNode) {
                        set.add((IGroupNode)viewNode4);
                    }
                }
            }
        }
        return GraphConverters.convert(abstractZyGraph, set);
    }
    
    protected abstract void showNodes(final Window p0, final AbstractZyGraph p1, final List p2, final boolean p3);
    
    public void showHiddenNodes(final Window window, final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final LinkedHashSet set = new LinkedHashSet<Object>();
        set.addAll(this.filterVisibleNodes(GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph))));
        set.addAll(this.filterVisibleNodes(this.getNeighborhood(abstractZyGraph, zyProximityNode)));
        this.showNodes(window, abstractZyGraph, new ArrayList(set), false);
    }
    
    public void unhideAndSelect(final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        abstractZyGraph.selectNodes(this.getNeighborhood(abstractZyGraph, zyProximityNode), true);
    }
    
    public void unhideAndSelectOnly(final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final Collection neighborhood = this.getNeighborhood(abstractZyGraph, zyProximityNode);
        final List nodes = GraphHelpers.getNodes(abstractZyGraph);
        nodes.removeAll(neighborhood);
        abstractZyGraph.selectNodes(neighborhood, nodes);
    }
    
    public void unhideChildren(final Window window, final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final ArrayList list = new ArrayList();
        list.addAll(GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph)));
        list.addAll(GraphConverters.convert(abstractZyGraph, GraphAlgorithms.getSuccessors((IGraphNode)zyProximityNode.getRawNode().getAttachedNode())));
        this.showNodes(window, abstractZyGraph, list, true);
    }
    
    public void unhideParents(final Window window, final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final ArrayList list = new ArrayList();
        list.addAll(GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph)));
        list.addAll(GraphConverters.convert(abstractZyGraph, GraphAlgorithms.getPredecessors((IGraphNode)zyProximityNode.getRawNode().getAttachedNode())));
        this.showNodes(window, abstractZyGraph, list, true);
    }
}
