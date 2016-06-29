package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;

public class NodeHelpers
{
    public static int countInvisibleIndegree(final IViewNode viewNode) {
        return CollectionHelpers.countIf(viewNode.getIncomingEdges(), new NodeHelpers$1());
    }
    
    public static int countInvisibleIndegreeNeighbours(final IViewNode viewNode) {
        final HashSet<IViewNode> set = new HashSet<IViewNode>();
        final Iterator<IViewEdge> iterator = viewNode.getIncomingEdges().iterator();
        while (iterator.hasNext()) {
            final IViewNode viewNode2 = (IViewNode)iterator.next().getSource();
            if (!viewNode2.isVisible()) {
                set.add(viewNode2);
            }
        }
        return set.size();
    }
    
    public static int countInvisibleOutdegree(final IViewNode viewNode) {
        return CollectionHelpers.countIf(viewNode.getOutgoingEdges(), new NodeHelpers$2());
    }
    
    public static int countInvisibleOutdegreeNeighbours(final IViewNode viewNode) {
        final HashSet<IViewNode> set = new HashSet<IViewNode>();
        final Iterator<IViewEdge> iterator = viewNode.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            final IViewNode viewNode2 = (IViewNode)iterator.next().getTarget();
            if (!viewNode2.isVisible()) {
                set.add(viewNode2);
            }
        }
        return set.size();
    }
    
    public static IViewNode getVisibleNode(final IViewNode viewNode) {
        IViewNode viewNode2 = viewNode;
        for (IGroupNode groupNode = viewNode.getParentGroup(); groupNode != null && groupNode.isCollapsed(); groupNode = groupNode.getParentGroup()) {
            viewNode2 = groupNode;
        }
        return viewNode2;
    }
}
