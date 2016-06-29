/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;

final class IteratorFunctions$4
implements IEdgeCallback {
    final /* synthetic */ IEdgeCallback val$callback;

    IteratorFunctions$4(IEdgeCallback iEdgeCallback) {
        this.val$callback = iEdgeCallback;
    }

    public IterationMode nextEdge(ZyGraphEdge zyGraphEdge) {
        if (zyGraphEdge.isVisible()) return this.val$callback.nextEdge(zyGraphEdge);
        return IterationMode.CONTINUE;
    }
}

