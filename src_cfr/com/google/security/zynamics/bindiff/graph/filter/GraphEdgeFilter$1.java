/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.util.Collection;

final class GraphEdgeFilter$1
implements IEdgeCallback {
    final /* synthetic */ Collection val$edges;

    GraphEdgeFilter$1(Collection collection) {
        this.val$edges = collection;
    }

    public IterationMode nextEdge(ZyGraphEdge zyGraphEdge) {
        if (!zyGraphEdge.isVisible()) return IterationMode.CONTINUE;
        this.val$edges.add(zyGraphEdge);
        return IterationMode.CONTINUE;
    }
}

