package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public class ZyInfoEdge extends ZyGraphEdge
{
    public ZyInfoEdge(final ZyGraphNode zyGraphNode, final ZyGraphNode zyGraphNode2, final d d, final ZyEdgeRealizer zyEdgeRealizer) {
        super(zyGraphNode, zyGraphNode2, d, zyEdgeRealizer, new ZyInfoEdge$CInfoEdge(null));
    }
}
