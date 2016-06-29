/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.List;

final class GraphHelpers$4
implements INodeCallback {
    final /* synthetic */ ICollectionFilter val$filter;
    final /* synthetic */ List val$items;

    GraphHelpers$4(ICollectionFilter iCollectionFilter, List list) {
        this.val$filter = iCollectionFilter;
        this.val$items = list;
    }

    @Override
    public IterationMode next(Object object) {
        if (!this.val$filter.qualifies(object)) return IterationMode.CONTINUE;
        this.val$items.add(object);
        return IterationMode.CONTINUE;
    }
}

