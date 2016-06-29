package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.types.common.*;

public interface INodeFilter extends ICollectionFilter
{
    boolean qualifies(final Object p0);
}
