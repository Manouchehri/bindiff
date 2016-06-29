/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.util.List;
import y.c.q;

public class ZyProximityNode
extends ZyGraphNode {
    private static final int DEFAULT_DISTANCE = 50;
    private final boolean m_isIncoming;

    public ZyProximityNode(q q2, ZyProximityNodeRealizer zyProximityNodeRealizer, ZyGraphNode zyGraphNode, boolean bl2) {
        super(q2, zyProximityNodeRealizer, new CProximityNode(ZyProximityNode.getRawNode(zyGraphNode)));
        this.m_isIncoming = bl2;
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        double d2 = iZyNodeRealizer.getCenterX();
        double d3 = bl2 ? iZyNodeRealizer.getCenterY() + iZyNodeRealizer.getHeight() / 2.0 + 50.0 : iZyNodeRealizer.getCenterY() - iZyNodeRealizer.getHeight() / 2.0 - 50.0;
        zyProximityNodeRealizer.moveBy(d2 - zyProximityNodeRealizer.getWidth() / 2.0, d3 - zyProximityNodeRealizer.getHeight() / 2.0);
    }

    private static IViewNode getRawNode(ZyGraphNode zyGraphNode) {
        return zyGraphNode.getRawNode();
    }

    @Override
    public List getChildren() {
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public List getParents() {
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public CProximityNode getRawNode() {
        return (CProximityNode)super.getRawNode();
    }

    public boolean isIncoming() {
        return this.m_isIncoming;
    }
}

