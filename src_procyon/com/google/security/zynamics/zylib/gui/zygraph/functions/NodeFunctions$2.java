package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;

final class NodeFunctions$2 implements INodeCallback
{
    final /* synthetic */ ArrayList val$nodes;
    
    NodeFunctions$2(final ArrayList val$nodes) {
        this.val$nodes = val$nodes;
    }
    
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        this.val$nodes.add(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}
