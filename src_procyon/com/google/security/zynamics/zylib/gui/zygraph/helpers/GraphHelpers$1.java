package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphHelpers$1 implements INodeCallback
{
    final /* synthetic */ INodeFilter val$filter;
    final /* synthetic */ ArrayList val$lameHack;
    
    GraphHelpers$1(final INodeFilter val$filter, final ArrayList val$lameHack) {
        this.val$filter = val$filter;
        this.val$lameHack = val$lameHack;
    }
    
    @Override
    public IterationMode next(final Object o) {
        if (this.val$filter.qualifies(o)) {
            this.val$lameHack.add(o);
            return IterationMode.STOP;
        }
        return IterationMode.CONTINUE;
    }
}
