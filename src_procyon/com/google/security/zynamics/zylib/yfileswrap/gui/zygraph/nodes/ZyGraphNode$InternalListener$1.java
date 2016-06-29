package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

class ZyGraphNode$InternalListener$1 extends SwingInvoker
{
    final /* synthetic */ IViewNode val$node;
    final /* synthetic */ boolean val$visible;
    final /* synthetic */ ZyGraphNode$InternalListener this$1;
    
    ZyGraphNode$InternalListener$1(final ZyGraphNode$InternalListener this$1, final IViewNode val$node, final boolean val$visible) {
        this.this$1 = this$1;
        this.val$node = val$node;
        this.val$visible = val$visible;
    }
    
    @Override
    protected void operation() {
        this.this$1.showNode(this.val$node, this.val$visible);
    }
}
