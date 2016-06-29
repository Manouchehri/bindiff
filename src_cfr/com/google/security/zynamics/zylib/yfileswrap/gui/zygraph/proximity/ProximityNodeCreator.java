/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.awt.Font;
import y.c.d;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class ProximityNodeCreator {
    public static ZyProximityNode createProximityNode(bu bu2, ZyGraphNode zyGraphNode, int n2, boolean bl2) {
        Preconditions.checkNotNull(bu2, "Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphNode, "Target node argument can not be null");
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n2), new Font("New Courier", 0, 12), null));
        ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        q q2 = bu2.a(zyProximityNodeRealizer);
        ZyProximityNode zyProximityNode = new ZyProximityNode(q2, zyProximityNodeRealizer, zyGraphNode, bl2);
        ZyNodeData zyNodeData = new ZyNodeData(zyProximityNode);
        zyProximityNodeRealizer.setUserData(zyNodeData);
        return zyProximityNode;
    }

    public static ZyInfoEdge insertProximityEdge(bu bu2, ZyGraphNode zyGraphNode, ZyGraphNode zyGraphNode2) {
        Preconditions.checkNotNull(bu2, "Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphNode, "Source node argument can not be null");
        Preconditions.checkNotNull(zyGraphNode2, "Target node argument can not be null");
        Preconditions.checkArgument(zyGraphNode instanceof ZyProximityNode || zyGraphNode2 instanceof ZyProximityNode, "One of the two arguments must be a proximity browsing node");
        ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        d d2 = bu2.a(zyGraphNode.getNode(), zyGraphNode2.getNode(), zyEdgeRealizer);
        ZyInfoEdge zyInfoEdge = new ZyInfoEdge(zyGraphNode, zyGraphNode2, d2, zyEdgeRealizer);
        ZyEdgeData zyEdgeData = new ZyEdgeData(zyInfoEdge);
        zyEdgeRealizer.setUserData(zyEdgeData);
        return zyInfoEdge;
    }
}

