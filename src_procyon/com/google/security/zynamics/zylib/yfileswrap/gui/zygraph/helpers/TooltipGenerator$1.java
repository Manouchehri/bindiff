package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;

final class TooltipGenerator$1 implements ICollectionFilter
{
    @Override
    public boolean qualifies(final Object o) {
        return !((IViewNode)o).isVisible();
    }
}
