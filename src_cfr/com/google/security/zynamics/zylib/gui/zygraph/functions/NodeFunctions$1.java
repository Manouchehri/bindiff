/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;

final class NodeFunctions$1
implements INodeCallback {
    final /* synthetic */ ArrayList val$nodes;

    NodeFunctions$1(ArrayList arrayList) {
        this.val$nodes = arrayList;
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        this.val$nodes.add(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}

