/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.ArrayList;
import java.util.Collection;

final class GraphHelpers$2
implements INodeCallback {
    final /* synthetic */ ArrayList val$toSelect;
    final /* synthetic */ INodeFilter val$deselectedFilter;

    GraphHelpers$2(ArrayList arrayList, INodeFilter iNodeFilter) {
        this.val$toSelect = arrayList;
        this.val$deselectedFilter = iNodeFilter;
    }

    public IterationMode next(IGraphNode iGraphNode) {
        this.val$toSelect.addAll(GraphAlgorithms.collectChildren(iGraphNode, this.val$deselectedFilter));
        return IterationMode.CONTINUE;
    }
}

