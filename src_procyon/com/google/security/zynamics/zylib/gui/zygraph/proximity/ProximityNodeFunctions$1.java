package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;

class ProximityNodeFunctions$1 implements ICollectionFilter
{
    final /* synthetic */ ProximityNodeFunctions this$0;
    
    ProximityNodeFunctions$1(final ProximityNodeFunctions this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        return NodeHelpers.getVisibleNode(zyGraphNode.getRawNode()) == zyGraphNode.getRawNode();
    }
}
