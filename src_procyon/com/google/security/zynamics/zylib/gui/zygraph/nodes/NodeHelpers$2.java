package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

final class NodeHelpers$2 implements ICollectionFilter
{
    public boolean qualifies(final IViewEdge viewEdge) {
        return !NodeHelpers.getVisibleNode((IViewNode)viewEdge.getTarget()).isVisible();
    }
}
