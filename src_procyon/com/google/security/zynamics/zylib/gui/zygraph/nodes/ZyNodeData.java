package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;

public class ZyNodeData
{
    private final ZyGraphNode m_node;
    
    public ZyNodeData(final ZyGraphNode node) {
        Preconditions.checkNotNull(node, (Object)"Error: Node argument can't be null");
        this.m_node = node;
    }
    
    public ZyGraphNode getNode() {
        return this.m_node;
    }
}
