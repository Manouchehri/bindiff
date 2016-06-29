package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;

public class GraphEdgeFilter
{
    public static Collection filterInvisibleEdges(final AbstractZyGraph abstractZyGraph) {
        final ArrayList list = new ArrayList();
        abstractZyGraph.iterateEdges(new GraphEdgeFilter$1(list));
        return list;
    }
}
