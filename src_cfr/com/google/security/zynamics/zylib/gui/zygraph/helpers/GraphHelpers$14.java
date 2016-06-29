/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.ArrayList;

final class GraphHelpers$14
implements INodeCallback {
    final /* synthetic */ ArrayList val$deselect;

    GraphHelpers$14(ArrayList arrayList) {
        this.val$deselect = arrayList;
    }

    public IterationMode next(IGraphNode iGraphNode) {
        if (!GraphHelpers.areAllChildrenDeselected(iGraphNode)) return IterationMode.CONTINUE;
        if (this.val$deselect.contains(iGraphNode)) return IterationMode.CONTINUE;
        this.val$deselect.add(iGraphNode);
        return IterationMode.CONTINUE;
    }
}

