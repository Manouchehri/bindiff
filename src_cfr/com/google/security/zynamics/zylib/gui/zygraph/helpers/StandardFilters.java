/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.StandardFilters$1;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.StandardFilters$2;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.StandardFilters$3;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.StandardFilters$4;

public class StandardFilters {
    public static INodeFilter getDeselectedFilter() {
        INodeFilter iNodeFilter = StandardFilters.getSelectedFilter();
        return StandardFilters.getNegatedFilter(iNodeFilter);
    }

    public static INodeFilter getInfoNodeFilter() {
        return new StandardFilters$1();
    }

    public static INodeFilter getNegatedFilter(INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(iNodeFilter, "Error: Filter argument can't be null");
        return new StandardFilters$2(iNodeFilter);
    }

    public static INodeFilter getSelectedFilter() {
        return new StandardFilters$3();
    }

    public static INodeFilter getTrueFilter() {
        return new StandardFilters$4();
    }
}

