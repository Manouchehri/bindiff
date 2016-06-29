/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.ArrayList;

final class GraphHelpers$5
implements IEdgeCallback {
    final /* synthetic */ INodeFilter val$filter;
    final /* synthetic */ ArrayList val$nodes;

    GraphHelpers$5(INodeFilter iNodeFilter, ArrayList arrayList) {
        this.val$filter = iNodeFilter;
        this.val$nodes = arrayList;
    }

    @Override
    public IterationMode nextEdge(Object object) {
        if (!this.val$filter.qualifies(object)) return IterationMode.CONTINUE;
        this.val$nodes.add(object);
        return IterationMode.CONTINUE;
    }
}

