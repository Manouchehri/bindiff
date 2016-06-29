/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

final class IteratorFunctions$5
implements INodeCallback {
    final /* synthetic */ INodeCallback val$callback;

    IteratorFunctions$5(INodeCallback iNodeCallback) {
        this.val$callback = iNodeCallback;
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isVisible()) return this.val$callback.next(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}

