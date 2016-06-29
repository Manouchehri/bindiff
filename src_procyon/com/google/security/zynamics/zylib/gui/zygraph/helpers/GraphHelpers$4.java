package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$4 implements INodeCallback
{
    final /* synthetic */ ICollectionFilter val$filter;
    final /* synthetic */ List val$items;
    
    GraphHelpers$4(final ICollectionFilter val$filter, final List val$items) {
        this.val$filter = val$filter;
        this.val$items = val$items;
    }
    
    @Override
    public IterationMode next(final Object o) {
        if (this.val$filter.qualifies(o)) {
            this.val$items.add(o);
        }
        return IterationMode.CONTINUE;
    }
}
