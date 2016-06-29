package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;

final class CGraphSelector$1 implements Function
{
    public q apply(final ZyGraphNode zyGraphNode) {
        return zyGraphNode.getNode();
    }
}
