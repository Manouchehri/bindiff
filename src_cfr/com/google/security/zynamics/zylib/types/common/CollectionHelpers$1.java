/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class CollectionHelpers$1
implements IItemCallback {
    final /* synthetic */ ICollectionFilter val$filter;
    final /* synthetic */ IItemCallback val$callback;

    CollectionHelpers$1(ICollectionFilter iCollectionFilter, IItemCallback iItemCallback) {
        this.val$filter = iCollectionFilter;
        this.val$callback = iItemCallback;
    }

    @Override
    public IterationMode next(Object object) {
        if (!this.val$filter.qualifies(object)) return IterationMode.CONTINUE;
        return this.val$callback.next(object);
    }
}

