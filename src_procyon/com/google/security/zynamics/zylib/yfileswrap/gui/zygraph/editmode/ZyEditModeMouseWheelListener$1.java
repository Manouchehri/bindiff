package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

class ZyEditModeMouseWheelListener$1 implements INodeFilter
{
    final /* synthetic */ ZyEditModeMouseWheelListener this$0;
    
    ZyEditModeMouseWheelListener$1(final ZyEditModeMouseWheelListener this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        return zyGraphNode.isSelected();
    }
}
