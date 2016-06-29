/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class NodeHelpers$1
implements ICollectionFilter {
    NodeHelpers$1() {
    }

    public boolean qualifies(IViewEdge iViewEdge) {
        if (NodeHelpers.getVisibleNode((IViewNode)iViewEdge.getSource()).isVisible()) return false;
        return true;
    }
}

