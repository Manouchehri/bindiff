package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;

final class MultiEdgeHider$1 implements INodeCallback
{
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        MultiEdgeHider.hideMultipleEdgesInternal(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}
