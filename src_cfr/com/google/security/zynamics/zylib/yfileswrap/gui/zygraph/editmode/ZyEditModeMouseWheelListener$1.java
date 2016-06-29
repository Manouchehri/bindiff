/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

class ZyEditModeMouseWheelListener$1
implements INodeFilter {
    final /* synthetic */ ZyEditModeMouseWheelListener this$0;

    ZyEditModeMouseWheelListener$1(ZyEditModeMouseWheelListener zyEditModeMouseWheelListener) {
        this.this$0 = zyEditModeMouseWheelListener;
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        return zyGraphNode.isSelected();
    }
}

