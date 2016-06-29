package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.proximity.*;

final class StandardFilters$1 implements INodeFilter
{
    @Override
    public boolean qualifies(final Object o) {
        return o instanceof CProximityNode;
    }
}
