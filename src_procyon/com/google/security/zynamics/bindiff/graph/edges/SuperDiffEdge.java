package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.common.base.*;

public class SuperDiffEdge extends ZyGraphEdge
{
    private final SingleDiffEdge primaryDiffEdge;
    private final SingleDiffEdge secondaryDiffEdge;
    private CombinedDiffEdge combinedDiffEdge;
    
    public SuperDiffEdge(final SuperDiffNode superDiffNode, final SuperDiffNode superDiffNode2, final d d, final ZyEdgeRealizer zyEdgeRealizer, final SuperViewEdge superViewEdge, final SingleDiffEdge primaryDiffEdge, final SingleDiffEdge secondaryDiffEdge) {
        super(superDiffNode, superDiffNode2, d, zyEdgeRealizer, superViewEdge);
        Preconditions.checkArgument(primaryDiffEdge != null || secondaryDiffEdge != null, (Object)"Primary and secondary edge cannot both be null.");
        this.primaryDiffEdge = primaryDiffEdge;
        this.secondaryDiffEdge = secondaryDiffEdge;
    }
    
    public CombinedDiffEdge getCombinedDiffEdge() {
        return this.combinedDiffEdge;
    }
    
    public SingleDiffEdge getPrimaryDiffEdge() {
        return this.primaryDiffEdge;
    }
    
    @Override
    public SuperViewEdge getRawEdge() {
        return (SuperViewEdge)super.getRawEdge();
    }
    
    public SingleDiffEdge getSecondaryDiffEdge() {
        return this.secondaryDiffEdge;
    }
    
    public void setCombinedDiffEdge(final CombinedDiffEdge combinedDiffEdge) {
        this.combinedDiffEdge = combinedDiffEdge;
    }
}
