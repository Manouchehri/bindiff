package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;

class ZyDefaultProximityBrowser$3 implements INodeCallback
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    ZyDefaultProximityBrowser$3(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        zyGraphNode.getRawNode().setVisible(true);
        return IterationMode.CONTINUE;
    }
}
