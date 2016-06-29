package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

class ZyDefaultProximityBrowser$2 implements INodeFilter
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    ZyDefaultProximityBrowser$2(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        return !zyGraphNode.isVisible();
    }
}
