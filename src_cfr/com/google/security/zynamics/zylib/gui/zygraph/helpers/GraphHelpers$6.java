/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.ArrayList;

final class GraphHelpers$6
implements INodeCallback {
    final /* synthetic */ ArrayList val$nodes;

    GraphHelpers$6(ArrayList arrayList) {
        this.val$nodes = arrayList;
    }

    public IterationMode next(ISelectableNode iSelectableNode) {
        this.val$nodes.add(iSelectableNode);
        return IterationMode.CONTINUE;
    }
}

