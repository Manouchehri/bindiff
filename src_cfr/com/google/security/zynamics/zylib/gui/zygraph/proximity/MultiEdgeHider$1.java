/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.MultiEdgeHider;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

final class MultiEdgeHider$1
implements INodeCallback {
    MultiEdgeHider$1() {
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        MultiEdgeHider.hideMultipleEdgesInternal(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}

