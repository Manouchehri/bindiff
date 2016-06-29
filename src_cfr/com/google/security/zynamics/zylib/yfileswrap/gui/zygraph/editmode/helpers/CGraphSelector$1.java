/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Function;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import y.c.q;

final class CGraphSelector$1
implements Function {
    CGraphSelector$1() {
    }

    public q apply(ZyGraphNode zyGraphNode) {
        return zyGraphNode.getNode();
    }
}

