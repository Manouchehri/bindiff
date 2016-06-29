package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$10 implements INodeCallback
{
    final /* synthetic */ ArrayList val$nodes;
    
    GraphHelpers$10(final ArrayList val$nodes) {
        this.val$nodes = val$nodes;
    }
    
    public IterationMode next(final ISelectableNode selectableNode) {
        if (!selectableNode.isSelected()) {
            this.val$nodes.add(selectableNode);
        }
        return IterationMode.CONTINUE;
    }
}
