package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.common.base.*;

public class StandardFilters
{
    public static INodeFilter getDeselectedFilter() {
        return getNegatedFilter(getSelectedFilter());
    }
    
    public static INodeFilter getInfoNodeFilter() {
        return new StandardFilters$1();
    }
    
    public static INodeFilter getNegatedFilter(final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(nodeFilter, (Object)"Error: Filter argument can't be null");
        return new StandardFilters$2(nodeFilter);
    }
    
    public static INodeFilter getSelectedFilter() {
        return new StandardFilters$3();
    }
    
    public static INodeFilter getTrueFilter() {
        return new StandardFilters$4();
    }
}
