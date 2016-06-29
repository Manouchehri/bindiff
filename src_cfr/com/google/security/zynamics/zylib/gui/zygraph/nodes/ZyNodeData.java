/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

public class ZyNodeData {
    private final ZyGraphNode m_node;

    public ZyNodeData(ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can't be null");
        this.m_node = zyGraphNode;
    }

    public ZyGraphNode getNode() {
        return this.m_node;
    }
}

