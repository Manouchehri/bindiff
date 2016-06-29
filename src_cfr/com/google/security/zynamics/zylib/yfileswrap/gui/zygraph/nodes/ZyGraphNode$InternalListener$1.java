/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.SwingInvoker;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener;

class ZyGraphNode$InternalListener$1
extends SwingInvoker {
    final /* synthetic */ IViewNode val$node;
    final /* synthetic */ boolean val$visible;
    final /* synthetic */ ZyGraphNode$InternalListener this$1;

    ZyGraphNode$InternalListener$1(ZyGraphNode$InternalListener internalListener, IViewNode iViewNode, boolean bl2) {
        this.this$1 = internalListener;
        this.val$node = iViewNode;
        this.val$visible = bl2;
    }

    @Override
    protected void operation() {
        ZyGraphNode$InternalListener.access$400(this.this$1, this.val$node, this.val$visible);
    }
}

