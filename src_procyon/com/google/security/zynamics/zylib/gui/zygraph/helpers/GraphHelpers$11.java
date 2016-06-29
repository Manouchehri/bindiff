package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$11 implements INodeCallback
{
    final /* synthetic */ Set val$nodes;
    
    GraphHelpers$11(final Set val$nodes) {
        this.val$nodes = val$nodes;
    }
    
    public IterationMode next(final ISelectableNode selectableNode) {
        this.val$nodes.add(selectableNode);
        return IterationMode.CONTINUE;
    }
}
