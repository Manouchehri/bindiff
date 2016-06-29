package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.types.lists.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$9 implements INodeCallback
{
    final /* synthetic */ IFilledList val$nodes;
    
    GraphHelpers$9(final IFilledList val$nodes) {
        this.val$nodes = val$nodes;
    }
    
    public IterationMode next(final ISelectableNode selectableNode) {
        this.val$nodes.add(selectableNode);
        return IterationMode.CONTINUE;
    }
}
