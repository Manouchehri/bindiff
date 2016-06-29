package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.common.base.*;

public class CombinedDiffEdge extends ZyGraphEdge
{
    private final SingleDiffEdge primaryDiffEdge;
    private final SingleDiffEdge secondaryDiffEdge;
    private final SuperDiffEdge superDiffEdge;
    
    public CombinedDiffEdge(final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2, final d d, final ZyEdgeRealizer zyEdgeRealizer, final CombinedViewEdge combinedViewEdge, final SuperDiffEdge superDiffEdge) {
        super(combinedDiffNode, combinedDiffNode2, d, zyEdgeRealizer, combinedViewEdge);
        this.superDiffEdge = (SuperDiffEdge)Preconditions.checkNotNull(superDiffEdge);
        this.primaryDiffEdge = superDiffEdge.getPrimaryDiffEdge();
        this.secondaryDiffEdge = superDiffEdge.getSecondaryDiffEdge();
    }
    
    public SingleDiffEdge getPrimaryDiffEdge() {
        return this.primaryDiffEdge;
    }
    
    public SingleDiffEdge getSecondaryDiffEdge() {
        return this.secondaryDiffEdge;
    }
    
    public SuperDiffEdge getSuperDiffEdge() {
        return this.superDiffEdge;
    }
}
