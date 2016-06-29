package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.types.common.*;

final class MultiEdgeHider$2 implements IEdgeCallback
{
    public IterationMode nextEdge(final ZyGraphEdge zyGraphEdge) {
        zyGraphEdge.getRawEdge().setVisible(zyGraphEdge.getSource().isVisible() && zyGraphEdge.getTarget().isVisible());
        return IterationMode.CONTINUE;
    }
}
