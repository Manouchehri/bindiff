/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

final class MultiEdgeHider$2
implements IEdgeCallback {
    MultiEdgeHider$2() {
    }

    public IterationMode nextEdge(ZyGraphEdge zyGraphEdge) {
        zyGraphEdge.getRawEdge().setVisible(zyGraphEdge.getSource().isVisible() && zyGraphEdge.getTarget().isVisible());
        return IterationMode.CONTINUE;
    }
}

