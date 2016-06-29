/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.types.lists.IFilledList;

final class GraphHelpers$9
implements INodeCallback {
    final /* synthetic */ IFilledList val$nodes;

    GraphHelpers$9(IFilledList iFilledList) {
        this.val$nodes = iFilledList;
    }

    public IterationMode next(ISelectableNode iSelectableNode) {
        this.val$nodes.add(iSelectableNode);
        return IterationMode.CONTINUE;
    }
}

