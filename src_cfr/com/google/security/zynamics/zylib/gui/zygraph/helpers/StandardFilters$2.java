/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;

final class StandardFilters$2
implements INodeFilter {
    final /* synthetic */ INodeFilter val$filter;

    StandardFilters$2(INodeFilter iNodeFilter) {
        this.val$filter = iNodeFilter;
    }

    @Override
    public boolean qualifies(Object object) {
        if (this.val$filter.qualifies(object)) return false;
        return true;
    }
}

