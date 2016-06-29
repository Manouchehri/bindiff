package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.common.base.*;

public class SingleDiffEdge extends ZyGraphEdge
{
    private SingleDiffEdge otherDiffEdge;
    private SuperDiffEdge superDiffEdge;
    private CombinedDiffEdge combinedDiffEdge;
    private final ESide side;
    
    public SingleDiffEdge(final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final d d, final ZyEdgeRealizer zyEdgeRealizer, final SingleViewEdge singleViewEdge, final ESide eSide) {
        super(singleDiffNode, singleDiffNode2, d, zyEdgeRealizer, singleViewEdge);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
    }
    
    public CombinedDiffEdge getCombinedDiffEdge() {
        return this.combinedDiffEdge;
    }
    
    public SingleDiffEdge getOtherSideDiffEdge() {
        return this.otherDiffEdge;
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public SuperDiffEdge getSuperDiffEdge() {
        return this.superDiffEdge;
    }
    
    public void setCombinedDiffEdge(final CombinedDiffEdge combinedDiffEdge) {
        this.combinedDiffEdge = combinedDiffEdge;
        this.superDiffEdge = combinedDiffEdge.getSuperDiffEdge();
        this.otherDiffEdge = ((this.side == ESide.PRIMARY) ? combinedDiffEdge.getSecondaryDiffEdge() : combinedDiffEdge.getPrimaryDiffEdge());
    }
}
