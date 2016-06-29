/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class GraphHelpers$12
implements INodeCallback {
    final /* synthetic */ IFilteredItemCallback val$callback;

    GraphHelpers$12(IFilteredItemCallback iFilteredItemCallback) {
        this.val$callback = iFilteredItemCallback;
    }

    @Override
    public IterationMode next(Object object) {
        if (!this.val$callback.qualifies(object)) return IterationMode.CONTINUE;
        return this.val$callback.next(object);
    }
}

