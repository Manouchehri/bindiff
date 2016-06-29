package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public final class ProximityNodeCreator
{
    public static ZyProximityNode createProximityNode(final bu bu, final ZyGraphNode zyGraphNode, final int n, final boolean b) {
        Preconditions.checkNotNull(bu, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphNode, (Object)"Target node argument can not be null");
        final ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n), new Font("New Courier", 0, 12), null));
        final ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        final ZyProximityNode zyProximityNode = new ZyProximityNode(bu.a(zyProximityNodeRealizer), zyProximityNodeRealizer, zyGraphNode, b);
        zyProximityNodeRealizer.setUserData(new ZyNodeData(zyProximityNode));
        return zyProximityNode;
    }
    
    public static ZyInfoEdge insertProximityEdge(final bu bu, final ZyGraphNode zyGraphNode, final ZyGraphNode zyGraphNode2) {
        Preconditions.checkNotNull(bu, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphNode, (Object)"Source node argument can not be null");
        Preconditions.checkNotNull(zyGraphNode2, (Object)"Target node argument can not be null");
        Preconditions.checkArgument(zyGraphNode instanceof ZyProximityNode || zyGraphNode2 instanceof ZyProximityNode, (Object)"One of the two arguments must be a proximity browsing node");
        final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        final ZyInfoEdge zyInfoEdge = new ZyInfoEdge(zyGraphNode, zyGraphNode2, bu.a(zyGraphNode.getNode(), zyGraphNode2.getNode(), zyEdgeRealizer), zyEdgeRealizer);
        zyEdgeRealizer.setUserData(new ZyEdgeData(zyInfoEdge));
        return zyInfoEdge;
    }
}
