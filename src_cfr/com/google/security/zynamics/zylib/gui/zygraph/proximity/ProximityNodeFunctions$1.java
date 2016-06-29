/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityNodeFunctions;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

class ProximityNodeFunctions$1
implements ICollectionFilter {
    final /* synthetic */ ProximityNodeFunctions this$0;

    ProximityNodeFunctions$1(ProximityNodeFunctions proximityNodeFunctions) {
        this.this$0 = proximityNodeFunctions;
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        if (NodeHelpers.getVisibleNode(zyGraphNode.getRawNode()) != zyGraphNode.getRawNode()) return false;
        return true;
    }
}

