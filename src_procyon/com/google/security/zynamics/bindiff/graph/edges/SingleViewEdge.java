package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.awt.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public abstract class SingleViewEdge extends CViewEdge
{
    public SingleViewEdge(final SingleViewNode singleViewNode, final SingleViewNode singleViewNode2) {
        super(-1, singleViewNode, singleViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        SingleViewNode.link(singleViewNode, singleViewNode2);
        singleViewNode.addOutgoingEdge(this);
        singleViewNode2.addIncomingEdge(this);
    }
}
