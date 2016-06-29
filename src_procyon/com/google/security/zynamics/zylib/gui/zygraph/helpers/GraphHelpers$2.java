package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.types.graphs.*;

final class GraphHelpers$2 implements INodeCallback
{
    final /* synthetic */ ArrayList val$toSelect;
    final /* synthetic */ INodeFilter val$deselectedFilter;
    
    GraphHelpers$2(final ArrayList val$toSelect, final INodeFilter val$deselectedFilter) {
        this.val$toSelect = val$toSelect;
        this.val$deselectedFilter = val$deselectedFilter;
    }
    
    public IterationMode next(final IGraphNode graphNode) {
        this.val$toSelect.addAll(GraphAlgorithms.collectChildren(graphNode, this.val$deselectedFilter));
        return IterationMode.CONTINUE;
    }
}
