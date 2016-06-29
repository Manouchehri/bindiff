/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class CollectionHelpers$2
implements IItemCallback {
    final /* synthetic */ IFilteredItemCallback val$callback;

    CollectionHelpers$2(IFilteredItemCallback iFilteredItemCallback) {
        this.val$callback = iFilteredItemCallback;
    }

    @Override
    public IterationMode next(Object object) {
        if (!this.val$callback.qualifies(object)) return IterationMode.CONTINUE;
        return this.val$callback.next(object);
    }
}

