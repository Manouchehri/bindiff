package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$5 implements IEdgeCallback
{
    final /* synthetic */ INodeFilter val$filter;
    final /* synthetic */ ArrayList val$nodes;
    
    GraphHelpers$5(final INodeFilter val$filter, final ArrayList val$nodes) {
        this.val$filter = val$filter;
        this.val$nodes = val$nodes;
    }
    
    @Override
    public IterationMode nextEdge(final Object o) {
        if (this.val$filter.qualifies(o)) {
            this.val$nodes.add(o);
        }
        return IterationMode.CONTINUE;
    }
}
