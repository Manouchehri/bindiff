package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$7 implements INodeCallback
{
    final /* synthetic */ INodeFilter val$filter;
    final /* synthetic */ ArrayList val$nodes;
    
    GraphHelpers$7(final INodeFilter val$filter, final ArrayList val$nodes) {
        this.val$filter = val$filter;
        this.val$nodes = val$nodes;
    }
    
    @Override
    public IterationMode next(final Object o) {
        if (this.val$filter.qualifies(o)) {
            this.val$nodes.add(o);
        }
        return IterationMode.CONTINUE;
    }
}
