package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.awt.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;

public abstract class CombinedViewEdge extends CViewEdge
{
    public CombinedViewEdge(final CombinedViewNode combinedViewNode, final CombinedViewNode combinedViewNode2) {
        super(-1, combinedViewNode, combinedViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        CombinedViewNode.link(combinedViewNode, combinedViewNode2);
        combinedViewNode.addOutgoingEdge(this);
        combinedViewNode2.addIncomingEdge(this);
    }
    
    public abstract EMatchState getMatchState();
    
    public abstract SingleViewEdge getPrimaryEdge();
    
    public abstract SingleViewEdge getSecondaryEdge();
}
