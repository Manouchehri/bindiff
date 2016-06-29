package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

public interface INodeFilter extends ICollectionFilter {
   boolean qualifies(Object var1);
}
