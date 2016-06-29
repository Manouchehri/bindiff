package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;

class ZyDefaultProximityBrowser$1 implements ICollectionFilter
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    ZyDefaultProximityBrowser$1(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    private boolean isOpenGroupNode(final ZyGraphNode zyGraphNode) {
        return zyGraphNode.getRawNode() instanceof IGroupNode && !((IGroupNode)zyGraphNode.getRawNode()).isCollapsed();
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        return zyGraphNode == this.this$0.getVisibleNode(zyGraphNode) && !this.isOpenGroupNode(zyGraphNode);
    }
}
