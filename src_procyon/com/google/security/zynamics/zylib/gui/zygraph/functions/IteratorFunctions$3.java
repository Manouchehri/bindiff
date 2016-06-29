package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;

final class IteratorFunctions$3 implements INodeCallback
{
    final /* synthetic */ INodeCallback val$callback;
    
    IteratorFunctions$3(final INodeCallback val$callback) {
        this.val$callback = val$callback;
    }
    
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        if (!zyGraphNode.isSelected()) {
            return IterationMode.CONTINUE;
        }
        return this.val$callback.next(zyGraphNode);
    }
}
