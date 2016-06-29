package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphEdgeFilter$1 implements IEdgeCallback
{
    final /* synthetic */ Collection val$edges;
    
    GraphEdgeFilter$1(final Collection val$edges) {
        this.val$edges = val$edges;
    }
    
    public IterationMode nextEdge(final ZyGraphEdge zyGraphEdge) {
        if (zyGraphEdge.isVisible()) {
            this.val$edges.add(zyGraphEdge);
        }
        return IterationMode.CONTINUE;
    }
}
