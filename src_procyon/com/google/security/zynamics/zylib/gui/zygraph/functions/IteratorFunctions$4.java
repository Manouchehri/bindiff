package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.types.common.*;

final class IteratorFunctions$4 implements IEdgeCallback
{
    final /* synthetic */ IEdgeCallback val$callback;
    
    IteratorFunctions$4(final IEdgeCallback val$callback) {
        this.val$callback = val$callback;
    }
    
    public IterationMode nextEdge(final ZyGraphEdge zyGraphEdge) {
        if (!zyGraphEdge.isVisible()) {
            return IterationMode.CONTINUE;
        }
        return this.val$callback.nextEdge(zyGraphEdge);
    }
}
