package com.google.security.zynamics.zylib.gui.zygraph.helpers;

final class StandardFilters$2 implements INodeFilter
{
    final /* synthetic */ INodeFilter val$filter;
    
    StandardFilters$2(final INodeFilter val$filter) {
        this.val$filter = val$filter;
    }
    
    @Override
    public boolean qualifies(final Object o) {
        return !this.val$filter.qualifies(o);
    }
}
