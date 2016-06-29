package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$13 implements INodeCallback
{
    final /* synthetic */ ArrayList val$deselect;
    
    GraphHelpers$13(final ArrayList val$deselect) {
        this.val$deselect = val$deselect;
    }
    
    public IterationMode next(final IGraphNode graphNode) {
        if (GraphHelpers.areAllParentsDeselected(graphNode) && !this.val$deselect.contains(graphNode)) {
            this.val$deselect.add(graphNode);
        }
        return IterationMode.CONTINUE;
    }
}
