/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers$1;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers$2;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NodeHelpers {
    public static int countInvisibleIndegree(IViewNode iViewNode) {
        return CollectionHelpers.countIf(iViewNode.getIncomingEdges(), new NodeHelpers$1());
    }

    public static int countInvisibleIndegreeNeighbours(IViewNode iViewNode) {
        HashSet<IViewNode> hashSet = new HashSet<IViewNode>();
        Iterator iterator = iViewNode.getIncomingEdges().iterator();
        while (iterator.hasNext()) {
            IViewEdge iViewEdge = (IViewEdge)iterator.next();
            IViewNode iViewNode2 = (IViewNode)iViewEdge.getSource();
            if (iViewNode2.isVisible()) continue;
            hashSet.add(iViewNode2);
        }
        return hashSet.size();
    }

    public static int countInvisibleOutdegree(IViewNode iViewNode) {
        return CollectionHelpers.countIf(iViewNode.getOutgoingEdges(), new NodeHelpers$2());
    }

    public static int countInvisibleOutdegreeNeighbours(IViewNode iViewNode) {
        HashSet<IViewNode> hashSet = new HashSet<IViewNode>();
        Iterator iterator = iViewNode.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            IViewEdge iViewEdge = (IViewEdge)iterator.next();
            IViewNode iViewNode2 = (IViewNode)iViewEdge.getTarget();
            if (iViewNode2.isVisible()) continue;
            hashSet.add(iViewNode2);
        }
        return hashSet.size();
    }

    public static IViewNode getVisibleNode(IViewNode iViewNode) {
        IViewNode iViewNode2 = iViewNode;
        IGroupNode iGroupNode = iViewNode.getParentGroup();
        while (iGroupNode != null) {
            if (!iGroupNode.isCollapsed()) return iViewNode2;
            iViewNode2 = iGroupNode;
            iGroupNode = iGroupNode.getParentGroup();
        }
        return iViewNode2;
    }
}

