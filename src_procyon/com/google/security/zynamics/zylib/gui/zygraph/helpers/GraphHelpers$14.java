package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$14 implements INodeCallback
{
    final /* synthetic */ ArrayList val$deselect;
    
    GraphHelpers$14(final ArrayList val$deselect) {
        this.val$deselect = val$deselect;
    }
    
    public IterationMode next(final IGraphNode graphNode) {
        if (GraphHelpers.areAllChildrenDeselected(graphNode) && !this.val$deselect.contains(graphNode)) {
            this.val$deselect.add(graphNode);
        }
        return IterationMode.CONTINUE;
    }
}
