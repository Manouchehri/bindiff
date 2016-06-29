/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$2
implements INodeFilter {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    ZyDefaultProximityBrowser$2(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isVisible()) return false;
        return true;
    }
}

