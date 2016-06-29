package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.types.common.*;

class ZyDefaultProximityBrowser$4 implements IEdgeCallback
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    ZyDefaultProximityBrowser$4(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    public IterationMode nextEdge(final ZyGraphEdge zyGraphEdge) {
        zyGraphEdge.getRawEdge().setVisible(true);
        return IterationMode.CONTINUE;
    }
}
