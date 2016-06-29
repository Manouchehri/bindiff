package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.awt.*;
import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;

public final class SuperViewEdge extends CViewEdge
{
    private final CombinedViewEdge combinedEdge;
    
    public SuperViewEdge(final CombinedViewEdge combinedViewEdge, final SuperViewNode superViewNode, final SuperViewNode superViewNode2) {
        super(-1, superViewNode, superViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        this.combinedEdge = (CombinedViewEdge)Preconditions.checkNotNull(combinedViewEdge);
        SuperViewNode.link(superViewNode, superViewNode2);
        superViewNode.addOutgoingEdge(this);
        superViewNode2.addIncomingEdge(this);
    }
    
    public CombinedViewEdge getCombinedEdge() {
        return this.combinedEdge;
    }
    
    public SingleViewEdge getSingleEdge(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.combinedEdge.getPrimaryEdge() : this.combinedEdge.getSecondaryEdge();
    }
}
