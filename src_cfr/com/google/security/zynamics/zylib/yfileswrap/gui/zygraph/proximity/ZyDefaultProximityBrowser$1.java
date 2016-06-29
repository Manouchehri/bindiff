/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$1
implements ICollectionFilter {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    ZyDefaultProximityBrowser$1(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    private boolean isOpenGroupNode(ZyGraphNode zyGraphNode) {
        if (!(zyGraphNode.getRawNode() instanceof IGroupNode)) return false;
        if (((IGroupNode)zyGraphNode.getRawNode()).isCollapsed()) return false;
        return true;
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        if (zyGraphNode != ZyDefaultProximityBrowser.access$200(this.this$0, zyGraphNode)) return false;
        if (this.isOpenGroupNode(zyGraphNode)) return false;
        return true;
    }
}

